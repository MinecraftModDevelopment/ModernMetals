package modernmetals.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cyano.basemetals.init.Achievements;
import cyano.basemetals.init.Materials;
import cyano.basemetals.material.IMetalObject;
import cyano.basemetals.material.MetalMaterial;
import cyano.basemetals.registry.IOreDictionaryEntry;

/**
 * 
 * @author Jasmine Iwanek
 *
 */
public class ItemMetalSmallBlend extends Item implements IOreDictionaryEntry, IMetalObject {

	protected final MetalMaterial metal;
	private final String oreDict;

	/**
	 * 
	 * @param metal
	 */
	public ItemMetalSmallBlend(MetalMaterial metal) {
		this.metal = metal;
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.oreDict = "dustTiny" + metal.getCapitalizedName(); // same oreDict entry as powder
	}

	@Override
	public String getOreDictionaryName() {
		return oreDict;
	}

	@Override
	public void onCreated(final ItemStack item, final World world, final EntityPlayer crafter) {
		super.onCreated(item, world, crafter);
		// achievement
		if(metal == Materials.aquarium || metal == Materials.brass || metal == Materials.bronze
				|| metal == Materials.electrum || metal == Materials.invar || metal == Materials.steel ) {
			crafter.addStat(Achievements.metallurgy, 1);
		}
	}

	@Override
	public MetalMaterial getMetalMaterial() {
		return metal;
	}
}
