package modernmetals.blocks;

import cyano.basemetals.material.IMetalObject;
import cyano.basemetals.material.MetalMaterial;
import cyano.basemetals.registry.IOreDictionaryEntry;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMetalPressurePlate extends BlockPressurePlate implements IOreDictionaryEntry, IMetalObject {

	final MetalMaterial metal;

	public BlockMetalPressurePlate(MetalMaterial metal) {
		super(Material.IRON, BlockPressurePlate.Sensitivity.MOBS);
		this.setSoundType(SoundType.METAL);
		this.metal = metal;
		this.blockHardness = metal.getMetalBlockHardness();
		this.blockResistance = metal.getBlastResistance();
		this.setHarvestLevel("pickaxe", metal.getRequiredHarvestLevel());
	}

	@Override
	public MetalMaterial getMetalMaterial() {
		return metal;
	}

	@Override
	public String getOreDictionaryName() {
		return "pressure" + metal.getCapitalizedName();
	}
}
