package com.deltavdevs.advancingrocketry.block.entity;

import com.deltavdevs.advancingrocketry.item.ModItems;
import com.deltavdevs.advancingrocketry.screen.FuelDistillerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FuelDistillerBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(FuelDistillerMenu.NUMBER_OF_SLOTS);

    private static final int INPUT_SLOT = 0;
    private static final int FUEL_SLOT = 1;
    private static final int GAS_OUTPUT = 2;
    private static final int PETROL_OUTPUT = 3;
    private static final int JET_OUTPUT = 4;
    private static final int DIESEL_OUTPUT = 5;
    private static final int HEAVY_OUTPUT_SLOT = 6;
    private static final int GREASE_OUTPUT = 7;
    private static final int BITUMEN_OUTPUT = 8;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public FuelDistillerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FUEL_DISTILLER_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> FuelDistillerBlockEntity.this.progress;
                    case 1 -> FuelDistillerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> FuelDistillerBlockEntity.this.progress = pValue;
                    case 1 -> FuelDistillerBlockEntity.this.maxProgress = pValue;
                };
            }

            @Override
            public int getCount() {
                return 0;
            }
        };

    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler =LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.advancingrocketry.fuel_distiller");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FuelDistillerMenu(pContainerId, pPlayerInventory, (BlockEntity) this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("fuel_distiller.progress", progress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("fuel_distiller.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        ItemStack result = new ItemStack(ModItems.ROCKET_FUEL.get(), 2);
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemHandler.extractItem(FUEL_SLOT, 1, false);
        this.itemHandler.setStackInSlot(INPUT_SLOT, new ItemStack(Items.BUCKET, 1));

        this.itemHandler.setStackInSlot(HEAVY_OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemHandler.getStackInSlot(HEAVY_OUTPUT_SLOT).getCount() + result.getCount()));
    }

    private boolean hasRecipe() {
        boolean hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.CRUDE_OIL_BUCKET.get() &&
                this.itemHandler.getStackInSlot(FUEL_SLOT).getItem() == Items.COAL;

        ItemStack result = new ItemStack(ModItems.ROCKET_FUEL.get());

        return hasCraftingItem && canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(HEAVY_OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(HEAVY_OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(HEAVY_OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(HEAVY_OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}
