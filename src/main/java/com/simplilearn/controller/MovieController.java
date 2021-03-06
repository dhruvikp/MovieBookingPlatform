package com.simplilearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.exceptions.MovieNotFoundException;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public List<com.simplilearn.model.Movie> getAllMovies() {
		System.out.println("Get all movies");
		return movieService.getAllMovies();
	}

	@GetMapping("/movies/{name}")
	public Movie getAllMovies(@PathVariable("name") String name) throws MovieNotFoundException {
		return movieService.getMovieByName(name);
	}

	@PostMapping("/movies")
	public int saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie.getId();
	}

	@PutMapping("/movies/{id}")
	public void updateMovie(@PathVariable("id") int id, @RequestBody Movie updateMovie) {
		movieService.updateMovie(id, updateMovie);
	}

	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable("id") int id) {
		movieService.deleteMovie(id);
	}

	@GetMapping("/movies/director/{name}")
	public List<com.simplilearn.model.Movie> getMoviesByDirectorName(@PathVariable("name") String name) {
		List<Movie> movies = movieService.getMoviesByDirectorName(name);
		List<com.simplilearn.model.Movie> movieModels = new ArrayList<>();
		if (movies != null && movies.size() > 0) {
			for (Movie movie : movies) {
				com.simplilearn.model.Movie movieModel = new com.simplilearn.model.Movie();
				movieModel.setMovieName(movie.getName());
				movieModel.setGenre(movie.getGenre());
				movieModel.setDirectorName(movie.getDirector().getDirectorName());
				movieModels.add(movieModel);
			}
		}
		return movieModels;
	}
}
