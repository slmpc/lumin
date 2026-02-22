package com.github.lumin.settings.impl;

import com.github.lumin.modules.AbstractModule;
import com.github.lumin.settings.AbstractSetting;

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
