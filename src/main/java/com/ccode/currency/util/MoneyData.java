package com.ccode.currency.util;

import net.minecraft.nbt.NbtCompound;

public class MoneyData {
    public static int addMoney(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int money = nbt.getInt("money");
        money += amount;
        nbt.putInt("money", money);
        return money;
    }

    public static int removeMoney(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int money = nbt.getInt("money");
        money -= amount;
        nbt.putInt("money", money);
        return money;
    }

    public static int getMoney(IEntityDataSaver player) {
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt("money");
    }
}
