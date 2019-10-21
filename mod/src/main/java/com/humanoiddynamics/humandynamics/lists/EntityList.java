package com.humanoiddynamics.humandynamics.lists;

import com.humanoiddynamics.humandynamics.HumanDynamicsItemGroup;
import com.humanoiddynamics.humandynamics.Main;
import com.humanoiddynamics.humandynamics.entities.Humanoid;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.IFactory;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class EntityList {
	public static EntityType humanoid = createEntity((IFactory)(Humanoid::new), EntityClassification.MISC, "humanoid");
	
	private static EntityType createEntity(IFactory<?> entityClass, EntityClassification classification, String name) {
		return EntityType.Builder.create(entityClass, classification).build(Main.MOD_ID + ":" + name).setRegistryName(new ResourceLocation(Main.MOD_ID, name));
	}
	
	public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
			ItemList.humanoid_spawn_egg = registerSpawnEgg(humanoid, 0x4010, 0, "humanoid_spawn_egg")
		);
	}
	
	public static Item registerSpawnEgg(EntityType<?> type, int baseColor, int accentColor, String name) {
		return new SpawnEggItem(type, baseColor, accentColor, new Item.Properties().group(Main.humandynamics)).setRegistryName(new ResourceLocation(Main.MOD_ID, name));
	}
}
