package com.mcmoddev.baseminerals.integration.plugins;

import com.mcmoddev.baseminerals.integration.BaseMineralsPlugin;
import com.mcmoddev.lib.integration.IIntegration;

/**
 * VeinMiner Integration Plugin
 *
 * @author Jasmine Iwanek
 *
 */
@BaseMineralsPlugin(VeinMiner.PLUGIN_MODID)
public class VeinMiner extends com.mcmoddev.lib.integration.plugins.VeinMiner implements IIntegration {

	private static boolean initDone = false;

	@Override
	public void init() {
		if (initDone || !com.mcmoddev.basemetals.util.Config.Options.enableVeinminer) {
			return;
		}


		initDone = true;
	}
}
