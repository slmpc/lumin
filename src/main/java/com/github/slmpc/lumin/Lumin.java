package com.github.slmpc.lumin;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(value = Lumin.MODID, dist =  Dist.CLIENT)
@EventBusSubscriber(modid = Lumin.MODID, value = Dist.CLIENT)
public class Lumin {
    public static final String MODID = "lumin";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Lumin(IEventBus modEventBus, ModContainer modContainer) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        Lumin.LOGGER.info("HELLO FROM CLIENT SETUP");
        Lumin.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

}
