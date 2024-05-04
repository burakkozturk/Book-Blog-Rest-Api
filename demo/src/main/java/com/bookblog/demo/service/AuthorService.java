package com.bookblog.demo.service;

import com.bookblog.demo.dto.AuthorDto;
import com.bookblog.demo.entity.Author;
import com.bookblog.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthor(){
        List<Author> list = authorRepository.findAll();
        return list;

    }

    public Optional<Author> getAuthorById(Long authorId){
        Optional<Author> author = authorRepository.findById(authorId);
        return author;
    }

    public Author saveAuthor(AuthorDto authorDto){

        Author author = new Author();
        author.setFullName(authorDto.getFullName());
        author.setDescription(authorDto.getDescription());
        return authorRepository.save(author);
    }

    public Optional<Author> updateAuthor(Long authorId,
                                         AuthorDto authorDto){
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(!optionalAuthor.isPresent()){
            return Optional.empty();
        }

        Author author = optionalAuthor.get();
        author.setFullName(authorDto.getFullName());
        author.setDescription(authorDto.getDescription());

        return Optional.of(authorRepository.save(author));

    }

    public void removeAuthor(Long authorId){
        authorRepository.deleteById(authorId);
    }

    public void removeAllAuthor(){
        authorRepository.deleteAll();
    }


}
