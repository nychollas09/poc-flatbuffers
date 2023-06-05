package com.flatbuffers.poc.infrastructure.api.controllers;

import com.flatbuffers.poc.infrastructure.api.CategoryAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryAPI {
    @Override
    public ResponseEntity<?> createCategory(byte[] input) {
        return null;
    }
}
