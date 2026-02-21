package com.github.slmpc.lumin.graphics.renderers;

import com.github.slmpc.lumin.graphics.LuminRenderTypes;
import com.mojang.blaze3d.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.CachedOrthoProjectionMatrixBuffer;

import java.awt.*;

public class RectRenderer implements IRenderer {

    private BufferBuilder bufferBuilder = Tesselator.getInstance()
            .begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

    private CachedOrthoProjectionMatrixBuffer guiProjectionMatrixBuffer = null;

    public void addRect(float x, float y, float width, float height, Color color) {
        // CCW
        bufferBuilder.addVertex(x, y, 0).setColor(color.getRGB());
        bufferBuilder.addVertex(x, y + height, 0).setColor(color.getRGB());
        bufferBuilder.addVertex(x + width, y + height, 0).setColor(color.getRGB());
        bufferBuilder.addVertex(x + width, y, 0).setColor(color.getRGB());
    }

    @Override
    public void draw() {
        final var window = Minecraft.getInstance().getWindow();

        if (guiProjectionMatrixBuffer == null) {
            guiProjectionMatrixBuffer =
                    new CachedOrthoProjectionMatrixBuffer("gui", 1000.0F, 11000.0F, true);
        }

        RenderSystem.setProjectionMatrix(
                guiProjectionMatrixBuffer.getBuffer(
                        (float)window.getWidth() / window.getGuiScale(),
                        (float)window.getHeight() / window.getGuiScale()
                ),
                ProjectionType.ORTHOGRAPHIC);
        MeshData meshData = bufferBuilder.build();
        if (meshData == null) return;

        LuminRenderTypes.RECTANGLE.draw(meshData);
    }

    @Override
    public void clear() {
        bufferBuilder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
    }

}
