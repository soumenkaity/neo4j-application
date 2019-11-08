package com.stackroute.neo4j.service;

import com.stackroute.neo4j.domain.Movie;
import com.stackroute.neo4j.repository.MovieRepository;
import com.stackroute.neo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.neo4j.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Collection<User> getUserByName(String name){
        return userRepository.getUserByName(name);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public Collection<User> getAllUsers(){
        Collection<User> userCollection = new ArrayList<>();
        for(User user: userRepository.findAll())
            userCollection.add(user);
        return userCollection;
    }

    public User updateUser(Long id, String name, Integer age){
        return userRepository.updateUser(id, name, age);
    }

    public User deleteUser(Long id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Collection<Movie> getMovieByTitle(String title){
        return movieRepository.getMovieByTitle(title);
    }

    public Movie getMovieById(Long id){
        return movieRepository.findById(id).get();
    }

    public Collection<Movie> getAllMovies(){
        Collection<Movie> movieCollection = new ArrayList<>();
        for(Movie movie: movieRepository.findAll())
            movieCollection.add(movie);
        return movieCollection;
    }

    public Movie updateMovie(Long id, String title, String director){
        return movieRepository.updateMovie(id, title, director);
    }

    public Movie deleteMovie(Long id){
        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);
        return movie;
    }

    public Collection<User> createRelation(String name, String title, Integer value){
        return userRepository.createRelation(name, title, value);
    }

    public User getRelationByName(String name){
        return userRepository.getRelationByName(name);
    }

    public Collection<User> getRelationsByRating(Integer rating){
        return userRepository.getRelationsByRating(rating);
    }

    public Collection<User> getAllRelations() {
        return userRepository.getAllRelations();
    }

    public User updateRelation(String name, String title, Integer rating){
        return userRepository.updateRelation(name, title, rating);
    }

    public User deleteRelation(String name, String title){
        return userRepository.deleteRelation(name, title);
    }
}
