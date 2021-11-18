package nl.novi.hello.controller;

import nl.novi.hello.model.Book;
import nl.novi.hello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks( @RequestParam(name = "title", defaultValue = "") String title){
        return ResponseEntity.ok(bookService.getBooks(title)); // Jackson package - object => json
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") int id){
        return ResponseEntity.ok(bookService.getBook(id)); // Jackson package - object => json
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        int newId = bookService.addBook(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable int id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/books/{id}")
    public ResponseEntity<Object> partialBook(@PathVariable("id") int id, @RequestBody Book book){
        bookService.partialBook(id, book);
        return ResponseEntity.noContent().build();
    }



}
