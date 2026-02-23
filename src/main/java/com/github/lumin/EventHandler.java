package com.github.lumin;

import com.github.lumin.assets.i18n.LanguageReloadListener;
import com.github.lumin.graphics.LuminRenderPipelines;
import com.github.lumin.managers.impl.ModuleManager;
import com.github.lumin.assets.resources.ResourceLocationUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterRenderPipelinesEvent;

@EventBusSubscriber(modid = Lumin.MODID, value = Dist.CLIENT)
public class EventHandler {

    @SubscribeEvent
    static void onRegisterRenderPipelines(RegisterRenderPipelinesEvent event) {
        LuminRenderPipelines.onRegisterRenderPipelines(event);
    }

    @SubscribeEvent
    static void onKeyPress(InputEvent.Key event) {
        if (event.getAction() != InputConstants.PRESS) return;
        ModuleManager.getInstance().onKeyPress(event.getKey());
    }

    @SubscribeEvent
    public static void onResourcesReload(AddClientReloadListenersEvent event) {
        event.addListener(ResourceLocationUtils.getIdentifier("objects/reload_listener"), new LanguageReloadListener());
    }

}
