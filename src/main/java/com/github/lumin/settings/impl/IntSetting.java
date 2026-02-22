package com.github.lumin.settings.impl;

import com.github.lumin.modules.AbstractModule;
import com.github.lumin.settings.AbstractSetting;

public class IntSetting extends AbstractSetting<Integer> {

    private final int min;
    private final int max;
    private final int step;

    public IntSetting(AbstractModule parent, String name, int defaultValue, int min, int max, int step, Dependency dependency) {
        super(parent, name, dependency);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public IntSetting(AbstractModule parent, String name, int defaultValue, int min, int max, int step) {
        this(parent, name, defaultValue, min, max, step, () -> true);
    }

    @Override
    public void setValue(Integer value) {
        if (value < min) {
            super.setValue(min);
        } else if (value > max) {
            super.setValue(max);
        } else {
            super.setValue(value);
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getStep() {
        return step;
    }

}
