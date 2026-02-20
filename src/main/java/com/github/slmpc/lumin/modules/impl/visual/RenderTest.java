package com.github.slmpc.lumin.modules.impl.visual;

import com.github.slmpc.lumin.graphics.renderers.RectRenderer;
import com.github.slmpc.lumin.modules.AbstractModule;
import com.github.slmpc.lumin.modules.Category;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class RenderTest extends AbstractModule {

    private static RenderTest INSTANCE;
    private RenderTest() {
        super("render_test", Category.VISUAL);
        keyBind = GLFW.GLFW_KEY_U;
    }

    public static RenderTest getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RenderTest();
        }
        return INSTANCE;
    }

    private final RectRenderer rectRenderer = new RectRenderer();

    @SubscribeEvent
    public void onRenderGui(RenderGuiEvent.Post event) {
        rectRenderer.addRect(10, 10, 200, 200, Color.BLACK);
        rectRenderer.drawAndClear();
    }


}
