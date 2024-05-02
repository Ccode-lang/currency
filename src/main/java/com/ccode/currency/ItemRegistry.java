package com.ccode.currency;

import com.ccode.currency.items.coin;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {
    public static final Item COIN = new coin(new Item.Settings());

    public static void RegisterAll() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.add(COIN));
        Registry.register(Registries.ITEM, new Identifier("currency", "coin"), COIN);
    }
}
