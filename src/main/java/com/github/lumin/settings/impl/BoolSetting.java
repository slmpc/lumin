package com.github.lumin.settings.impl;

import com.github.lumin.modules.AbstractModule;
import com.github.lumin.settings.AbstractSetting;

public class BoolSetting extends AbstractSetting<Boolean> {

    public BoolSetting(AbstractModule parent, String name, boolean defaultValue, Dependency dependency) {
        super(parent, name, dependency);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    public BoolSetting(AbstractModule parent, String name, boolean defaultValue) {
        this(parent, name, defaultValue, () -> true);
    }

}
