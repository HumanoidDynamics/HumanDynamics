package com.humanoiddynamics.humandynamics.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.world.World;

public class Humanoid extends VillagerEntity{

	public Humanoid(EntityType<? extends VillagerEntity> entityType, World world) {
		super(entityType, world);
	}

}
