package com.stackroute.neo4j.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stackroute.neo4j.domain.Movie;
import com.stackroute.neo4j.domain.User;
import com.stackroute.neo4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/username")
    public Collection<User> getUserByName(@RequestParam String name){
        return  userService.getUserByName(name);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return  userService.getUserById(id);
    }

    @GetMapping("/user")
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user.getId(), user.getName(), user.getAge());
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Movie movie){
        return userService.createMovie(movie);
    }

    @GetMapping("/moviename")
    public Collection<Movie> getMovieByTitle(@RequestParam String title){
        return  userService.getMovieByTitle(title);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable Long id){
        return  userService.getMovieById(id);
    }

    @GetMapping("/movie")
    public Collection<Movie> getAllMovies(){
        return userService.getAllMovies();
    }

    @PutMapping("/movie/update")
    public Movie updateMovie(@RequestBody Movie movie){
        return userService.updateMovie(movie.getId(), movie.getTitle(), movie.getDirector());
    }

    @DeleteMapping("/movie/{id}")
    public Movie deleteMovie(@PathVariable Long id){
        return userService.deleteMovie(id);
    }

    @PostMapping("/relations")
    public Collection<User> createRelation(@RequestBody ObjectNode jsonNodes){
        return userService.createRelation(jsonNodes.get("name").asText(), jsonNodes.get("title").asText(), jsonNodes.get("value").asInt());
    }

    @GetMapping("/relations/{name}")
    public User getRelationByName(@PathVariable String name){
        return userService.getRelationByName(name);
    }

    @GetMapping("/relations-ratings")
    public Collection<User> getRelationsByRating(@RequestParam Integer rating){
        return userService.getRelationsByRating(rating);
    }

    @GetMapping("/relations")
    public Collection<User> getAllRelations(){
        return userService.getAllRelations();
    }

    @PutMapping("/relations/update")
    public User updateRelation(@RequestBody ObjectNode jsonNodes){
        return userService.updateRelation(jsonNodes.get("name").asText(), jsonNodes.get("title").asText(), jsonNodes.get("rating").asInt());
    }

    @DeleteMapping("/relations")
    public User deleteRelation(@RequestBody ObjectNode jsonNodes){
        return userService.deleteRelation(jsonNodes.get("name").asText(),jsonNodes.get("title").asText());
    }
}
