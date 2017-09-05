package com.kicinger.spring.oauth.resourceserver.controllers;

import com.kicinger.spring.oauth.resourceserver.domain.Foo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/foos/{id}")
    public Foo findById(@PathVariable("id") long id) {
        return new Foo(id, "John");
    }
}
