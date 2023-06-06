package com.flatbuffers.poc.infrastructure.api.controllers;

import com.flatbuffers.poc.infrastructure.api.CategoryAPI;
import com.flatbuffers.poc.infrastructure.fbs.Category;
import com.google.flatbuffers.FlatBufferBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;

@RestController
public class CategoryController
        extends FlatbufferController
        implements CategoryAPI {

    @Override
    public ResponseEntity<?> createCategory(byte[] input) throws Exception {
        var category = this.<Category>createFlatbufferInstance(input, Category.class);

        var fbb = new FlatBufferBuilder();

        var categoryResult = Category.createCategory(fbb,
                category.id(),
                fbb.createString(category.name() + " Manipulado DIEGO"),
                fbb.createString(category.description() + " Manipulado")
        );

        fbb.finish(categoryResult);

        var result = Category.getRootAsCategory(fbb.dataBuffer());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(category.id() + "\r" + category.name());
    }
}
