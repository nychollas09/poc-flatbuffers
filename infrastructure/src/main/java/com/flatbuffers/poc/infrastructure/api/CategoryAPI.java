package com.flatbuffers.poc.infrastructure.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/categories")
public interface CategoryAPI {

    @PostMapping
    ResponseEntity<?> createCategory(@RequestBody byte[] input) throws Exception;

}
