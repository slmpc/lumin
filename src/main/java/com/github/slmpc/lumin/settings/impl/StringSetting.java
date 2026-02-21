package com.github.slmpc.lumin.settings.impl;

import com.github.slmpc.lumin.modules.AbstractModule;
import com.github.slmpc.lumin.settings.AbstractSetting;

public class StringSetting extends AbstractSetting<String> {

    public StringSetting(AbstractModule parent, String name, String defaultValue, Dependency dependency) {
        super(parent, name, dependency);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    public StringSetting(AbstractModule parent, String name, String defaultValue) {
        this(parent, name, defaultValue, () -> true);
    }

}
