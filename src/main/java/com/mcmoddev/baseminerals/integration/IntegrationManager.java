package com.mcmoddev.baseminerals.integration;

import com.google.common.collect.Lists;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.util.AnnotationChecker;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.List;

public enum IntegrationManager {
    INSTANCE;

    private List<IIntegration> integrations = Lists.newArrayList();

    public void preInit(FMLPreInitializationEvent event) {
        AnnotationChecker.getInstances(event.getAsmData(), BaseMineralsPlugin.class, IIntegration.class).stream()
                .forEachOrdered(integration -> {
                    Class<? extends IIntegration> integrationClass = integration.getClass();
                    BaseMineralsPlugin plugin = integrationClass.getAnnotation(BaseMineralsPlugin.class);
                    if (Loader.isModLoaded(plugin.value())) {
                    	FMLLog.severe("BASEMINERALS: Loaded " + plugin.value());
                        integrations.add(integration);
                        integration.init();
                    }
                });
    }
}