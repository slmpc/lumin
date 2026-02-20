package com.github.slmpc.lumin.graphics.renderers;

public interface IRenderer {

    void draw();

    void clear();

    default void drawAndClear() {
        draw();
        clear();
    }

}
