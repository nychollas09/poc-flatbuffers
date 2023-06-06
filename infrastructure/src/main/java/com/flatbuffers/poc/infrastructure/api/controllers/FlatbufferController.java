package com.flatbuffers.poc.infrastructure.api.controllers;

import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;

public abstract class FlatbufferController {
    public <T extends Table> T createFlatbufferInstance(
            byte[] bytes,
            Class<? extends Table> klass)
            throws Exception {
        final var buffer = ByteBuffer.wrap(bytes);
        final var method = klass.getMethod("getRootAs" + klass.getSimpleName(), ByteBuffer.class);
        return (T) method.invoke(klass, buffer);
    }
}
