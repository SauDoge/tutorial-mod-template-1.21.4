package me.saudoge.block;

import me.saudoge.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));

    private static void registerBlockItem(String name, Block block){
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().useBlockPrefixedTranslationKey().registryKey(key);

        Registry.register(Registries.ITEM, id, new BlockItem(block, settings));
    }

    private static Block registerBlock(String name, AbstractBlock.Settings settings){
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        settings.registryKey(key);
        Block block = new Block(settings);

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, id, block);
    }


    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
        });
    }
}
