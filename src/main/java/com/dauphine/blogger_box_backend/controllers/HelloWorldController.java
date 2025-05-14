package com.dauphine.blogger_box_backend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@Tag(
    name = "Hello world API",
    description = "My first hello world endpoint"
)
public class HelloWorldController {

    @GetMapping("hello-world")

    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("hello")
    @Operation(
            summary = "Hello by name endpoint",
            description = "Returns 'Hello {name}' by path variable"

    )
    public String helloByName(@RequestParam String name)
    {
        return "Hello" + name;
    }
}
