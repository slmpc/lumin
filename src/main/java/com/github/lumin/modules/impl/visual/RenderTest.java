package com.github.lumin.modules.impl.visual;

import com.github.lumin.graphics.renderers.RectRenderer;
import com.github.lumin.graphics.renderers.RoundRectRenderer;
import com.github.lumin.graphics.renderers.TextRenderer;
import com.github.lumin.modules.AbstractModule;
import com.github.lumin.modules.Category;
import com.github.lumin.settings.impl.IntSetting;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
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

    private final Supplier<RectRenderer> rectRenderer = Suppliers.memoize(RectRenderer::new);
    private final Supplier<TextRenderer> textRenderer = Suppliers.memoize(TextRenderer::new);
    private final Supplier<RoundRectRenderer> roundRectRenderer = Suppliers.memoize(RoundRectRenderer::new);

    private final IntSetting rectX = intSetting("rect_x", 10, 0, 100, 5);
    private final IntSetting rectY = intSetting("rect_y", 10, 0, 100, 5);

    @SubscribeEvent
    public void onRenderGui(RenderGuiEvent.Post event) {
        rectRenderer.get().addRect(rectX.getValue(), rectY.getValue(), 200, 200, Color.WHITE);
        rectRenderer.get().drawAndClear();

        textRenderer.get().addText("Minecraft 原神 启动！", 10.0f, 10.0f, Color.BLACK, 1.0f);
        textRenderer.get().drawAndClear();

        roundRectRenderer.get().addRoundRect(100, 100, 100, 100, 10.0f, Color.BLUE);
        roundRectRenderer.get().drawAndClear();

    }

}
