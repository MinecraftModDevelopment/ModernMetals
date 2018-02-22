package com.mcmoddev.modernmetals.integration.plugins;

import com.mcmoddev.basemetals.BaseMetals;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.tinkers.TCMaterial;
import com.mcmoddev.lib.integration.plugins.tinkers.TraitLocations;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.modernmetals.ModernMetals;
import com.mcmoddev.modernmetals.data.MaterialNames;
import com.mcmoddev.modernmetals.data.TraitNames;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(addonId = ModernMetals.MODID, pluginId = TinkersConstruct.PLUGIN_MODID, preInitCallback = "preInit", initCallback = "initCallback", postInitCallback = "postInit")
public class TinkersConstruct extends com.mcmoddev.lib.integration.plugins.TinkersConstructBase
		implements IIntegration {

	private static Boolean preInit = false;
	private static Boolean init = false;
	private static Boolean postInit = false;

	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		registerMaterial(Materials.hasMaterial(MaterialNames.ALUMINUM), MaterialNames.ALUMINUM, true, false,
				TraitNames.LIGHTWEIGHT);

		registerMaterial(Materials.hasMaterial(MaterialNames.ALUMINUM_BRASS), MaterialNames.ALUMINUM_BRASS, true,
				false);

		registerMaterial(Materials.hasMaterial(MaterialNames.BERYLLIUM), MaterialNames.BERYLLIUM, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.BORON), MaterialNames.BORON, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.CADMIUM), MaterialNames.CADMIUM, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.CHROMIUM), MaterialNames.CHROMIUM, true, false,
				TraitNames.MAGNETIC, TraitLocations.HEAD, TraitNames.MAGNETIC2);

		registerMaterial(Materials.hasMaterial(MaterialNames.GALVANIZED_STEEL), MaterialNames.GALVANIZED_STEEL, true,
				false, TraitLocations.HEAD, TraitNames.SHARP, TraitNames.STIFF);

		registerMaterial(Materials.hasMaterial(MaterialNames.IRIDIUM), MaterialNames.IRIDIUM, true, false,
				TraitNames.BRITTLE);

		registerMaterial(Materials.hasMaterial(MaterialNames.MAGNESIUM), MaterialNames.MAGNESIUM, true, false,
				TraitNames.REACTIVE);

		registerMaterial(Materials.hasMaterial(MaterialNames.MANGANESE), MaterialNames.MANGANESE, true, false,
				TraitNames.BRITTLE);

		registerMaterial(Materials.hasMaterial(MaterialNames.NICHROME), MaterialNames.NICHROME, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.OSMIUM), MaterialNames.OSMIUM, true, false,
				TraitNames.HEAVY, TraitNames.BRITTLE);

		registerMaterial(Materials.hasMaterial(MaterialNames.PLUTONIUM), MaterialNames.PLUTONIUM, true, false,
				TraitNames.RADIOACTIVE, TraitLocations.HEAD, TraitNames.TOXIC, TraitLocations.PROJECTILE,
				TraitNames.TOXIC);

		registerMaterial(Materials.hasMaterial(MaterialNames.RUTILE), MaterialNames.RUTILE, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.STAINLESS_STEEL), MaterialNames.STAINLESS_STEEL, true,
				false, TraitLocations.HEAD, TraitNames.SHARP, TraitNames.STIFF);

		registerMaterial(Materials.hasMaterial(MaterialNames.TANTALUM), MaterialNames.TANTALUM, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.TITANIUM), MaterialNames.TITANIUM, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.TUNGSTEN), MaterialNames.TUNGSTEN, true, false);

		registerMaterial(Materials.hasMaterial(MaterialNames.URANIUM), MaterialNames.URANIUM, true, false,
				TraitNames.RADIOACTIVE, TraitLocations.HEAD, TraitNames.POISONOUS, TraitLocations.PROJECTILE,
				TraitNames.POISONOUS);

		registerMaterial(Materials.hasMaterial(MaterialNames.ZIRCONIUM), MaterialNames.ZIRCONIUM, true, false);

	}

	public void preInit() {
		if(preInit) return;
		preInit = true;
		preInitSetup();
		setMaterialsVisible(ModernMetals.MODID);
	}

	public void initCallback() {
		if(init) return;
		init = true;
		registerAlloys();
		initSetup(ModernMetals.MODID);
	}

	public void postInit() {
		if(postInit) return;
		postInit = true;
		postInitSetup(ModernMetals.MODID);
	}

	private void registerAlloys() {
		if (Materials.hasMaterial(MaterialNames.GALVANIZED_STEEL)
				&& Materials.hasMaterial(com.mcmoddev.basemetals.data.MaterialNames.STEEL)
				&& Materials.hasMaterial(com.mcmoddev.basemetals.data.MaterialNames.ZINC)) {
			FluidStack output = FluidRegistry.getFluidStack(MaterialNames.GALVANIZED_STEEL, 2);
			FluidStack steel = FluidRegistry.getFluidStack(com.mcmoddev.basemetals.data.MaterialNames.STEEL, 1);
			FluidStack zinc = FluidRegistry.getFluidStack(com.mcmoddev.basemetals.data.MaterialNames.ZINC, 1);
			registry.registerAlloy(MaterialNames.GALVANIZED_STEEL, output, steel, zinc);
		}

		if (Materials.hasMaterial(MaterialNames.NICHROME)
				&& Materials.hasMaterial(com.mcmoddev.basemetals.data.MaterialNames.NICKEL)
				&& Materials.hasMaterial(MaterialNames.CHROMIUM)) {
			FluidStack output = FluidRegistry.getFluidStack(MaterialNames.NICHROME, 2);
			FluidStack nickel = FluidRegistry.getFluidStack(com.mcmoddev.basemetals.data.MaterialNames.NICKEL, 1);
			FluidStack chrome = FluidRegistry.getFluidStack(MaterialNames.CHROMIUM, 1);
			registry.registerAlloy(MaterialNames.NICHROME, output, nickel, chrome);
		}

		if (Materials.hasMaterial(MaterialNames.STAINLESS_STEEL)
				&& Materials.hasMaterial(com.mcmoddev.basemetals.data.MaterialNames.STEEL)
				&& Materials.hasMaterial(MaterialNames.CHROMIUM)) {
			FluidStack output = FluidRegistry.getFluidStack(MaterialNames.STAINLESS_STEEL, 2);
			FluidStack steel = FluidRegistry.getFluidStack(com.mcmoddev.basemetals.data.MaterialNames.STEEL, 1);
			FluidStack chrome = FluidRegistry.getFluidStack(MaterialNames.CHROMIUM, 1);
			registry.registerAlloy(MaterialNames.STAINLESS_STEEL, output, steel, chrome);
		}

		if (Materials.hasMaterial(MaterialNames.TITANIUM) && Materials.hasMaterial(MaterialNames.RUTILE)) {
			FluidStack output = FluidRegistry.getFluidStack(MaterialNames.TITANIUM, 2);
			FluidStack rutile = FluidRegistry.getFluidStack(MaterialNames.RUTILE, 1);
			FluidStack magnesium = FluidRegistry.getFluidStack(MaterialNames.MAGNESIUM, 1);
			registry.registerAlloy(MaterialNames.TITANIUM, output, rutile, magnesium);
		}
	}

	private boolean isTraitLoc(String loc) {
		switch (loc) {
			case TraitLocations.BOW:
			case TraitLocations.BOWSTRING:
			case TraitLocations.EXTRA:
			case TraitLocations.FLETCHING:
			case TraitLocations.HANDLE:
			case TraitLocations.HEAD:
			case TraitLocations.PROJECTILE:
			case TraitLocations.SHAFT:
				return true;
			default:
				return false;
		}
	}

	private void addTraits(TCMaterial mat, String[] traits) {
		int i = 0;
		while (i < traits.length) {
			if (i == (traits.length - 1)) {
				// can only be a "general" trait
				mat.addTrait("general", traits[i]);
			} else {
				String item = traits[i];
				if (isTraitLoc(item)) {
					if (i + 1 >= traits.length) {
						return;
					}
					i++;
					mat.addTrait(item, traits[i]);
				} else {
					mat.addTrait("general", traits[i]);
				}
			}
			i++;
		}
	}

	private void registerMaterial(boolean enabled, String name, boolean castable, boolean craftable, String... traits) {
		if (enabled) {
			registerMaterial(name, castable, craftable, traits);
		}
	}

	private void registerMaterial(String name, boolean castable, boolean craftable, String... traits) {
		final MMDMaterial mmdMat = Materials.getMaterialByName(name);
		final TCMaterial mat = registry.newMaterial(name, mmdMat.getTintColor());

		if (castable)
			mat.setCastable();
		if (craftable)
			mat.setCraftable();

		mat.setSourceMaterial(mmdMat);
		mat.genStatsFromSource();

		if (traits.length > 0) {
			addTraits(mat, traits);
		}

		mat.settle();
	}
}
