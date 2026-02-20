package com.github.slmpc.lumin.graphics;

import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;

public class LuminRenderTypes {

    public static RenderType RECTANGLE = RenderType.create(
            "lumin-rectangle", RenderSetup.builder(LuminRenderPipelines.RECTANGLE).createRenderSetup()
    );

}
