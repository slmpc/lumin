package com.github.slmpc.lumin.settings.impl;

import com.github.slmpc.lumin.modules.AbstractModule;
import com.github.slmpc.lumin.settings.AbstractSetting;
import com.github.slmpc.lumin.utils.i18n.TranslateComponent;
import net.minecraft.client.resources.language.I18n;

public class EnumSetting<E extends Enum<E>> extends AbstractSetting<E> {

    private final E[] modes;

    public EnumSetting(AbstractModule parent, String name, E defaultValue, E[] modes, Dependency dependency) {
        super(parent, name, dependency);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.modes = modes;
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

    public String getValueDisplayName() {
        final var translation = new TranslateComponent(name.getFullKeyWithoutPrefix(), getValue().name().toLowerCase());
        return I18n.get(translation.getFullKey());
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