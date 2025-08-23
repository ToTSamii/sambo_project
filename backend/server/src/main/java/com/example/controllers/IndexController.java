package com.example.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Priem;
import com.example.services.IndexService;

import com.example.Config;


@RestController("/")
public class IndexController {

    private static IndexService service = new IndexService();

    @GetMapping
    @CrossOrigin(origins = Config.cors_origins)
    public List<Priem> get() {
        return service.getIndex();
    }

    @PostMapping
    @CrossOrigin(origins = Config.cors_origins)
    public void post(@RequestBody Priem priem) {
        service.postIndex(priem);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = Config.cors_origins)
    public void delete(@PathVariable("id") int id) {
        service.deleteIndex(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = Config.cors_origins)
    public void put(@PathVariable("id") int id, @RequestBody Priem priem) {
        service.putIndex(id, priem);
    }
}
