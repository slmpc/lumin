package com.github.slmpc.lumin.utils.resources;

import net.minecraft.resources.Identifier;

public class ResourceLocationUtils {

    public static Identifier getIdentifier(String path) {
        return Identifier.fromNamespaceAndPath("lumin", path);
    }

}
