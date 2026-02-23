package com.github.lumin.settings.impl;

import com.github.lumin.modules.AbstractModule;
import com.github.lumin.settings.AbstractSetting;
import com.github.lumin.assets.i18n.TranslateComponent;

import java.util.HashMap;
import java.util.Map;

public class EnumSetting<E extends Enum<E>> extends AbstractSetting<E> {

    private final E[] modes;
    private final Map<E, TranslateComponent> translationCache = new HashMap<>();

    public EnumSetting(AbstractModule parent, String name, E defaultValue, E[] modes, Dependency dependency) {
        super(parent, name, dependency);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.modes = modes;
        prewarmCache();
    }

    public EnumSetting(AbstractModule parent, String name, E defaultValue, E[] modes) {
        this(parent, name, defaultValue, modes, () -> true);
    }

    public boolean is(E mode) {
        return this.getValue() == mode;
    }

    public void setModeByName(String modeName) {
        for (E mode : modes) {
            if (mode.name().equalsIgnoreCase(modeName)) {
                this.setValue(mode);
                return;
            }
        }
    }

    private void prewarmCache() {
        for (E mode : modes) {
            translationCache.put(mode, TranslateComponent.create(
                    name.fullKeyWithoutLumin,
                    mode.name().toLowerCase()
            ));
        }
    }

    public String getValueDisplayName() {
        final var translation = translationCache.get(defaultValue);
        if (translation != null) {
            return translation.getTranslatedName();
        }
        return "ENUM-I18N";
    }

    public E[] getModes() {
        return modes;
    }

    public void next() {
        int nextIndex = (ordinal(getValue()) + 1) % modes.length;
        setValue(modes[nextIndex]);
    }

    private int ordinal(E value) {
        return value.ordinal();
    }
}