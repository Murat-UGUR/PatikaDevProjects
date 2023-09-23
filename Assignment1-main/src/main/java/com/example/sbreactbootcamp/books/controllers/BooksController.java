package com.example.sbreactbootcamp.books.controllers;

import com.example.sbreactbootcamp.books.model.Authors;
import com.example.sbreactbootcamp.books.model.Books;
import com.example.sbreactbootcamp.books.repositories.IBooksRepository;
import com.example.sbreactbootcamp.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "default")
@CrossOrigin("*")
public class BooksController {

    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

    @Autowired
    IBooksRepository booksRepository;

    @Operation(summary = "Find the Book list")
    @GetMapping("")
    @ResponseBody
    public R<List<Books>> findBooks() {
        List<Books> booksList = null;

        try {
            booksList = booksRepository.findAll();
        } catch (Exception e) {
            logger.error("Find the Book list fails: " + e.getMessage());
        }

        return new R<List<Books>>().success().data(booksList);
    }

    @Operation(summary = "Creates a new authors")
    @PostMapping
    public R<Books> addBooks(@RequestBody Books books) {
        try {
            booksRepository.save(books);
        } catch (Exception e) {
            logger.error("Creates a new books fails:" + e.getMessage());
        }

        return new R<Books>().success();
    }

    @Operation(summary = "Update an existing books")
    @PutMapping
    public R<Books> updateBooks(@Parameter(description = "Update an existing books.") @RequestBody Books books) {
        try {
            booksRepository.save(books);
        } catch (Exception e) {
            logger.error("Update an existing books fails:" + e.getMessage());
        }

        return new R<Books>().success();
    }

    @Operation(summary = "Retrieve an existing books")
    @DeleteMapping(value = "/{id}")
    public R<Books> deleteBooks(@Parameter(description = "Delete an existing books.") @PathVariable final String id) {

        try {
            booksRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Delete an existing books fails:" + e.getMessage());
        }

        return new R<Books>().success();
    }
}

