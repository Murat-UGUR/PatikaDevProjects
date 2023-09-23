package com.example.sbreactbootcamp.books.controllers;


import com.example.sbreactbootcamp.books.model.Authors;
import com.example.sbreactbootcamp.books.repositories.IAuthorsRepository;
import com.example.sbreactbootcamp.users.model.User;
import com.example.sbreactbootcamp.users.repositories.IUserRepository;
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
@RequestMapping("/api/authors")
@Tag(name = "default")
@CrossOrigin("*")
public class AuthorsController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorsController.class);

    @Autowired
    IAuthorsRepository authorsRepository;

    @Operation(summary = "Find the Author list")
    @GetMapping("")
    @ResponseBody
    public R<List<Authors>> findAuthors() {
        List<Authors> authorsList = null;

        try {
            authorsList = authorsRepository.findAll();
        } catch (Exception e) {
            logger.error("Find the Authors list fails: " + e.getMessage());
        }
        return new R<List<Authors>>().success().data(authorsList);
    }



    @Operation(summary = "Creates a new authors")
    @PostMapping
    public R<Authors> addAuthors(@RequestBody Authors authors) {
        try {
            authorsRepository.save(authors);
        } catch (Exception e) {
            logger.error("Creates a new authors fails:" + e.getMessage());
        }

        return new R<Authors>().success();
    }

    @Operation(summary = "Update an existing authors")
    @PutMapping
    public R<Authors> updateAuthors(@Parameter(description="Update an existing user.") @RequestBody Authors authors){
        try{
            authorsRepository.save(authors);
        }catch (Exception e){
            logger.error("Update an existing authors fails:" +e.getMessage());
        }

        return new R<Authors>().success();
    }
    @Operation(summary = "Retrieve an existing authors")
    @DeleteMapping(value = "/{id}")
    public R<Authors> deleteAuthors(@Parameter(description = "Delete an existing authors.") @PathVariable final String id){

        try{
            authorsRepository.deleteById(id);
        }catch(Exception e){
            logger.error("Delete an existing authors fails:" +e.getMessage());
        }

        return new R<Authors>().success();
    }


}

