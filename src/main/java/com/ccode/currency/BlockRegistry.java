package com.ccode.currency;

import com.ccode.currency.blocks.bank;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class BlockRegistry {
    public static Block BANK = new bank(Block.Settings.create().strength(4.0f));

    public static void RegisterAll() {
        Registry.register(Registries.BLOCK, new Identifier("currency", "bank"), BANK);
        Registry.register(Registries.ITEM, new Identifier("currency", "bank"), new BlockItem(BANK, new Item.Settings()));
    }
}
