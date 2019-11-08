package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Collection<Movie> getMovieByTitle(String title);

    @Query("MATCH (m:Movie) WHERE id(m) = {id} SET m.title = {title}, m.director = {director} RETURN m")
    Movie updateMovie(Long id, String title, String director);
}
