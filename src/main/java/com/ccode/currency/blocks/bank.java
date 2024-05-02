package com.ccode.currency.blocks;


import com.ccode.currency.Currency;
import com.ccode.currency.ItemRegistry;
import com.ccode.currency.util.IEntityDataSaver;
import com.ccode.currency.util.MoneyData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class bank extends Block {
    public bank(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world instanceof ServerWorld) {
            Currency.LOGGER.info("Adding money to player");
            IEntityDataSaver playerSave = (IEntityDataSaver) player;
            int amount = MoneyData.getMoney(playerSave);
            Currency.LOGGER.info("Current money in bank: " + amount);




            if (amount > 0) {
                ItemStack coin = new ItemStack(ItemRegistry.COIN);
                MoneyData.removeMoney(playerSave, 1);
                if (!player.giveItemStack(coin)) {
                    player.dropItem(coin, false);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
