package com.bookblog.demo.controller;

import com.bookblog.demo.dto.AuthorDto;
import com.bookblog.demo.entity.Author;
import com.bookblog.demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> list = authorService.getAllAuthor();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long authorId){
        Optional<Author> author = authorService.getAuthorById(authorId);
        return ResponseEntity.ok(author);
    }

    @PostMapping("")
    public ResponseEntity<Author> saveAuthor(@RequestBody AuthorDto authorDto){
        Author author = authorService.saveAuthor(authorDto);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping("/{authorId}")
    public Optional<ResponseEntity<Optional<Author>>> updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDto authorDto){
        Optional<Author> updatedAuthor = authorService.updateAuthor(authorId, authorDto);
        return updatedAuthor.map(value -> new ResponseEntity<>(updatedAuthor,HttpStatus.OK));
    }

    @DeleteMapping("/{authorId}")
    public void removeAuthor(@PathVariable Long authorId){
        authorService.removeAuthor(authorId);
    }

    @DeleteMapping("/all")
    public void removeAllAuthor(){
        authorService.removeAllAuthor();
    }



}
