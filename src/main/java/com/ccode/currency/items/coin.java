package com.ccode.currency.items;

import com.ccode.currency.Currency;
import com.ccode.currency.blocks.bank;
import com.ccode.currency.util.IEntityDataSaver;
import com.ccode.currency.util.MoneyData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class coin extends Item {
    public coin(Settings settings) {
        super(settings);
    }


    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        IEntityDataSaver user = (IEntityDataSaver) context.getPlayer();
        if (world instanceof ServerWorld) {
            context.getStack().decrement(1);
            if (world.getBlockState(pos).getBlock() instanceof bank) {
                Currency.LOGGER.info(Integer.toString(MoneyData.addMoney(user, 1)));
            }
        } else {
            Currency.LOGGER.info(world.getBlockState(pos).getBlock().getName().getString());
        }
        return ActionResult.success(world.isClient);
    }
}
