package com.example.sbreactbootcamp.books.controllers;

import com.example.sbreactbootcamp.books.model.Books;
import com.example.sbreactbootcamp.books.model.Genres;
import com.example.sbreactbootcamp.books.repositories.IGenresRepository;
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
@RequestMapping("/api/genres")
@Tag(name = "default")
@CrossOrigin("*")
public class GenresController {

    private static final Logger logger= LoggerFactory.getLogger(GenresController.class);

    @Autowired
    IGenresRepository genresRepository;

    @GetMapping("")
    public R<List<Genres>> findGenres(){
        List<Genres> genresList = null;

        try{
            genresList = genresRepository.findAll();
        }catch (Exception e){
            logger.error("Find the genres list fails" + e.getMessage());
        }

        return new R<List<Genres>>().success().data(genresList);
    }
    @Operation(summary = "Creates a new genres")
    @PostMapping
    public R<Genres> addGenres(@RequestBody Genres genres) {
        try {
            genresRepository.save(genres);
        } catch (Exception e) {
            logger.error("Creates a new genres fails:" + e.getMessage());
        }

        return new R<Genres>().success();
    }

    @Operation(summary = "Update an existing genres")
    @PutMapping
    public R<Genres> updateGenres(@Parameter(description = "Update an existing genres.") @RequestBody Genres genres) {
        try {
            genresRepository.save(genres);
        } catch (Exception e) {
            logger.error("Update an existing genres fails:" + e.getMessage());
        }

        return new R<Genres>().success();
    }

    @Operation(summary = "Retrieve an existing genres")
    @DeleteMapping(value = "/{id}")
    public R<Genres> deleteGenres(@Parameter(description = "Delete an existing genres.") @PathVariable final String id) {

        try {
            genresRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Delete an existing genres fails:" + e.getMessage());
        }

        return new R<Genres>().success();
    }
}



