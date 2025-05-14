package com.dauphine.blogger_box_backend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


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
    public String helloByName(@RequestParam String name) {
        return "Hello" + name;
    }


    @PostMapping("/elements")
    public String create(@RequestBody ElementRequest body) {
        // TODO later, implement persistence layer
        // INSERT INTO ...(title, description) VALUES (${title}, ${description})
        return "Create new element with title '%s' and description '%s'"
               .formatted(body.getTitle(), body.getDescription());
    }

    @PutMapping("/elements/{id}")
    public String update(
            @PathVariable Integer id,
            @RequestBody ElementRequest body
    ) {
        // TODO later, implement persistence layer
        // UPDATE elements SET title = ?, description = ? WHERE id = ?
        return "Update element '%d' with title '%s' and description '%s'"
                .formatted(id, body.getTitle(), body.getDescription());
    }

    @PatchMapping("/elements/{id}/description")
    public String patchDescription(
            @PathVariable Integer id,
            @RequestBody String description
    ) {
        // TODO: Implement persistence layer later
        // UPDATE elements SET description = ? WHERE id = ?
        return "Updated description of element '%d' to '%s'"
                .formatted(id, description);
    }

    @DeleteMapping("/elements/{id}")
    public String delete(@PathVariable Integer id) {
        // TODO: Implement persistence layer later
        // DELETE FROM elements WHERE id = ?
        return "Deleted element with id '%d'".formatted(id);
    }
}


