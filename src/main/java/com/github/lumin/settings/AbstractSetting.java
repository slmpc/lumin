package com.github.lumin.settings;

import com.github.lumin.modules.AbstractModule;
import com.github.lumin.assets.i18n.TranslateComponent;
import net.minecraft.client.resources.language.I18n;

public abstract class AbstractSetting<V> {

    protected final String nameKey;

    public final TranslateComponent name;

    protected V value;
    protected V defaultValue;

    protected final Dependency dependency;

    public AbstractSetting(AbstractModule parent, String nameKey, Dependency dependency) {
        this.nameKey = nameKey;
        this.dependency = dependency;

        name = TranslateComponent.create(parent.name.fullKeyWithoutLumin, nameKey);
    }

    public AbstractSetting(AbstractModule parent, String nameKey) {
        this(parent, nameKey, () -> true);
    }

    public String getDisplayName() {
        return I18n.get(name.fullKey);
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void reset() {
        this.value = this.defaultValue;
    }

    public V getDefaultValue() {
        return defaultValue;
    }

    public boolean isAvailable() {
        return dependency != null && this.dependency.check();
    }

    @FunctionalInterface
    public interface Dependency {
        boolean check();
    }

    public Dependency getDependency() {
        return dependency;
    }

}
