package com.github.slmpc.lumin.settings.impl;

import com.github.slmpc.lumin.modules.AbstractModule;
import com.github.slmpc.lumin.settings.AbstractSetting;

import java.awt.*;

public class ColorSetting extends AbstractSetting<Color> {
    public ColorSetting(AbstractModule parent, String name, Color defaultValue, Dependency dependency) {
        super(parent, name, dependency);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    public ColorSetting(AbstractModule parent, String name, Color defaultValue) {
        this(parent, name, defaultValue, () -> true);
    }
}
