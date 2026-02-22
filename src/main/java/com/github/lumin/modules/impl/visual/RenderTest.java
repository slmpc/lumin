package com.github.lumin.modules.impl.visual;

import com.github.lumin.graphics.renderers.RectRenderer;
import com.github.lumin.graphics.renderers.TextRenderer;
import com.github.lumin.modules.AbstractModule;
import com.github.lumin.modules.Category;
import com.github.lumin.settings.impl.IntSetting;
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
    private final TextRenderer textRenderer = new TextRenderer();

    private final IntSetting rectX = intSetting("rect_x", 10, 0, 100, 5);
    private final IntSetting rectY = intSetting("rect_y", 10, 0, 100, 5);

    @SubscribeEvent
    public void onRenderGui(RenderGuiEvent.Post event) {
        rectRenderer.addRect(rectX.getValue(), rectY.getValue(), 200, 200, Color.WHITE);
        rectRenderer.drawAndClear();

        textRenderer.addText("hello 你好 我真的很新欢你  我想要草席你手动阀", 10.0f, 100.0f, Color.BLACK, 1.0f);
        textRenderer.drawAndClear();
    }

}
