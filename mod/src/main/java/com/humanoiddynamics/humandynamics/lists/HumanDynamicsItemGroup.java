package com.humanoiddynamics.humandynamics.lists;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HumanDynamicsItemGroup extends ItemGroup {

	public HumanDynamicsItemGroup() {
		super("Human Dynamics"); //Creative Tab name
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.for_test_purposes); //or  new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.test_block))
	}
	
}
