package com.github.slmpc.lumin.graphics.text;

import com.github.slmpc.lumin.graphics.text.ttf.TtfGlyphAtlas;

public record GlyphDescriptor(
        TtfGlyphAtlas atlas,
        TtfGlyphAtlas.GlyphUV uv,
        int width,
        int height,
        int xOffset,
        int yOffset
) {
}