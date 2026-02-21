package com.github.slmpc.lumin.graphics;

import com.mojang.blaze3d.textures.GpuSampler;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.client.renderer.texture.AbstractTexture;

public class LuminTexture extends AbstractTexture {

    public LuminTexture(GpuTexture texture, GpuTextureView textureView, GpuSampler sampler) {
        this.texture = texture;
        this.textureView = textureView;
        this.sampler = sampler;
    }
}
