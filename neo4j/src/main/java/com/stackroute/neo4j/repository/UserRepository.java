package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    Collection<User> getUserByName(String name);

    @Query("MATCH (u:User) WHERE id(u) = {id} SET u.name = {name}, u.age = {age} RETURN u")
    User updateUser(Long id, String name, Integer age);

    @Query("MATCH (a:User),(b:Movie)\n" +
            "WHERE a.name = {name} AND b.title = {title}\n" +
            "CREATE (a)-[r:RATED {rating: {value}}]->(b)\n" +
            "RETURN a,r,b")
    Collection<User> createRelation(String name, String title, Integer value);

    @Query("MATCH (m:Movie)<-[r:RATED]-(u:User {name: {name}}) RETURN u,r,m")
    User getRelationByName(String name);

    @Query("MATCH (m:Movie)<-[r:RATED {rating: {rating}}]-(u:User) RETURN u,r,m")
    Collection<User> getRelationsByRating(Integer rating);

    @Query("MATCH (m:Movie)<-[r:RATED]-(u:User) RETURN u,r,m")
    Collection<User> getAllRelations();

    @Query("MATCH (m:Movie)<-[r:RATED]-(u:User) where u.name={name} AND m.title={title} SET r.rating={rating} RETURN u,r,m")
    User updateRelation(String name, String title, Integer rating);

    @Query("MATCH (m:Movie)<-[r:RATED]-(u:User) where u.name={name} AND m.title={title} DELETE r RETURN u,r,m")
    User deleteRelation(String name, String title);

}
