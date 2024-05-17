package com.bookblog.demo.controller;

import com.bookblog.demo.entity.Scribble;
import com.bookblog.demo.service.ScribbleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scribbles")
public class ScribbleController {

    @Autowired
    private ScribbleService scribbleService;

    @PostMapping
    public ResponseEntity<Scribble> createScribble(@RequestBody Scribble scribble) {
        Scribble createdScribble = scribbleService.createScribble(scribble);
        return new ResponseEntity<>(createdScribble, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scribble> getScribbleById(@PathVariable Long id) {
        Scribble scribble = scribbleService.getScribbleById(id)
                .orElseThrow(() -> new RuntimeException("Scribble not found"));
        return new ResponseEntity<>(scribble, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Scribble>> getAllScribbles() {
        List<Scribble> scribbles = scribbleService.getAllScribbles();
        return new ResponseEntity<>(scribbles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scribble> updateScribble(@PathVariable Long id, @RequestBody Scribble scribbleDetails) {
        Scribble updatedScribble = scribbleService.updateScribble(id, scribbleDetails);
        return new ResponseEntity<>(updatedScribble, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScribble(@PathVariable Long id) {
        scribbleService.deleteScribble(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
