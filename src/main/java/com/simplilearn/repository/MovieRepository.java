package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

	
	public Movie findByName(String name);
	
	@Query("select movie from Movie movie left join Director director on movie.director.id = director.id where director.directorName = :directorName")
	public List<Movie> findByDirectorName(@Param("directorName") String directorName) ;
}