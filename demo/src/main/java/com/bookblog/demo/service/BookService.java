package com.bookblog.demo.service;

import com.bookblog.demo.dto.BookDto;
import com.bookblog.demo.entity.Author;
import com.bookblog.demo.entity.Book;
import com.bookblog.demo.entity.Category;
import com.bookblog.demo.repository.AuthorRepository;
import com.bookblog.demo.repository.BookRepository;
import com.bookblog.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Book> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Optional<Book> getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book;
    }

    public Book saveBook(BookDto bookDto){
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setRating(bookDto.getRating());
        book.setReleaseDate(bookDto.getReleaseDate());
        book.setSummary(bookDto.getSummary());
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElse(null);
        book.setAuthor(author);
        Category category = categoryRepository.findById(bookDto.getCategoryId()).orElse(null);
        book.setCategory(category);

        bookRepository.save(book);
        return book;

    }

    public Optional<Book> updateBook(Long bookId, BookDto bookDto){
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(!optionalBook.isPresent()){
            return Optional.empty();
        }

        Book book = optionalBook.get();
        book.setName(bookDto.getName());
        book.setRating(bookDto.getRating());
        book.setReleaseDate(bookDto.getReleaseDate());
        book.setSummary(bookDto.getSummary());
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElse(null);
        book.setAuthor(author);
        Category category = categoryRepository.findById(bookDto.getCategoryId()).orElse(null);
        book.setCategory(category);

        return Optional.of(bookRepository.save(book));
    }

    public void removeBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public void removeAllBooks(){
        bookRepository.deleteAll();
    }

}
