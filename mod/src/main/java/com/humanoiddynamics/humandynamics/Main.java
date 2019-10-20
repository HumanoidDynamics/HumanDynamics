package com.humanoiddynamics.humandynamics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.humanoiddynamics.humandynamics.lists.BlockList;
import com.humanoiddynamics.humandynamics.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("humandynamics")
public class Main {
	
	public static Main instance;
	public final static String MOD_ID = "humandynamics";
	private static final Logger logger = LogManager.getLogger(MOD_ID);
	
	public Main() {
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) {
		
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistyEvents {
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
				ItemList.for_test_purposes = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(new ResourceLocation(MOD_ID, "for_test_purposes")),
				
				ItemList.test_block = new BlockItem(BlockList.test_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.test_block.getRegistryName())
			);
		}
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
				BlockList.test_block = new Block(Block.Properties.create(Material.CLAY).hardnessAndResistance(2.0f, 3.0f).lightValue(12).sound(SoundType.METAL)).setRegistryName(new ResourceLocation(MOD_ID, "test_block"))
			);
		}
	}
}
