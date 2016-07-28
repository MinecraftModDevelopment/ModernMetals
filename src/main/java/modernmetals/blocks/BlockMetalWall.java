package modernmetals.blocks;

import cyano.basemetals.material.IMetalObject;
import cyano.basemetals.material.MetalMaterial;
import cyano.basemetals.registry.IOreDictionaryEntry;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;

public class BlockMetalWall extends BlockWall implements IOreDictionaryEntry, IMetalObject {

	final MetalMaterial metal;

	public BlockMetalWall(MetalMaterial metal) {
		super(modernmetals.init.Blocks.getBlockByName(metal.getName() + "_block"));
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
		return "wall" + metal.getCapitalizedName();
	}
}
