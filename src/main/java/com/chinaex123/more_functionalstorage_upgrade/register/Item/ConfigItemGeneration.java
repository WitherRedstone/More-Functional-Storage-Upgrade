package com.chinaex123.more_functionalstorage_upgrade.register.Item;

import com.buuz135.functionalstorage.block.tile.ControllableDrawerTile;
import com.buuz135.functionalstorage.item.component.FunctionalUpgradeBehavior;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.ItemHandlerHelper;

import java.util.List;

public record ConfigItemGeneration(ItemStack item, int amountPerTick, int interval)
        implements FunctionalUpgradeBehavior {

    public static final MapCodec<ConfigItemGeneration> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ItemStack.CODEC.fieldOf("item").forGetter(ConfigItemGeneration::item),
                    Codec.INT.fieldOf("amountPerTick").orElse(1).forGetter(ConfigItemGeneration::amountPerTick),
                    Codec.INT.fieldOf("interval").orElse(20).forGetter(ConfigItemGeneration::interval)
            ).apply(instance, ConfigItemGeneration::new));

    @Override
    public void work(Level level, BlockPos pos, ControllableDrawerTile<?> drawer,
                     ItemStack upgradeStack, int upgradeSlot) {
        // 只在服务器端工作，并且按间隔执行
        if (level.isClientSide || level.getGameTime() % interval != 0) {
            return;
        }

        // 准备要生成的物品堆栈
        ItemStack itemToGenerate = item.copy();
        if (amountPerTick > 1 && itemToGenerate.getMaxStackSize() > 1) {
            itemToGenerate.setCount(Math.min(amountPerTick, itemToGenerate.getMaxStackSize()));
        }

        // 首先检查抽屉本身是否有物品处理能力
        var drawerCapability = level.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
        if (drawerCapability != null) {
            ItemHandlerHelper.insertItem(drawerCapability, itemToGenerate, false);
            return;
        }

        // 否则检查上方的方块
        var aboveCapability = level.getCapability(Capabilities.ItemHandler.BLOCK, pos, Direction.UP);
        if (aboveCapability != null) {
            ItemHandlerHelper.insertItem(aboveCapability, itemToGenerate, false);
            return;
        }

        // 还可以检查其他方向
        for (Direction direction : Direction.values()) {
            if (direction == Direction.UP) continue; // 已经检查过了

            var sideCapability = level.getCapability(Capabilities.ItemHandler.BLOCK,
                    pos.relative(direction), direction.getOpposite());
            if (sideCapability != null) {
                ItemHandlerHelper.insertItem(sideCapability, itemToGenerate, false);
                break;
            }
        }
    }

    @Override
    public MapCodec<? extends FunctionalUpgradeBehavior> codec() {
        return CODEC;
    }

    @Override
    public List<Component> getTooltip() {
        var list = FunctionalUpgradeBehavior.super.getTooltip();
        list.add(Component.translatable("moreupgrade.desc.item_generation",
                amountPerTick,
                Component.translatable(item.getDescriptionId()).getString()));
        return list;
    }
}