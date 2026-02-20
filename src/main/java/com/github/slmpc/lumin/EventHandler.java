package com.github.slmpc.lumin;

import com.github.slmpc.lumin.graphics.LuminRenderPipelines;
import com.github.slmpc.lumin.managers.impl.ModuleManager;
import com.mojang.blaze3d.platform.InputConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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

}
