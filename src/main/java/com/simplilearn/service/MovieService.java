package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Director;
import com.simplilearn.entity.Movie;
import com.simplilearn.exceptions.MovieNotFoundException;
import com.simplilearn.repository.DirectorRepository;
import com.simplilearn.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	DirectorRepository directorRepository;

	public List<com.simplilearn.model.Movie> getAllMovies() {
		List<com.simplilearn.model.Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movie -> {
			com.simplilearn.model.Movie model = new com.simplilearn.model.Movie();
			model.setDirectorName(movie.getDirector().getDirectorName());
			model.setMovieName(movie.getName());
			model.setGenre(movie.getGenre());
			movies.add(model);
		});
		return movies;
	}

	public Movie getMovieByName(String movieName) throws MovieNotFoundException {
		Optional<Movie> optMovie = movieRepository.findByName(movieName);
		if(!optMovie.isPresent()) {
			throw new MovieNotFoundException();
		}
		return optMovie.get();
	}

	public void saveMovie(Movie movie) {
		String directorName = movie.getDirector().getDirectorName();
		Optional<Director> optioalDirector = directorRepository.findByDirectorName(directorName);
		if (optioalDirector.isPresent()) {
			Director d = optioalDirector.get();
			movie.setDirector(d);
		}
		movieRepository.save(movie);
	}
	
	public void updateMovie(int id, Movie updateMovie) {
		
		Optional<Movie> optMovie = movieRepository.findById(id);
		Movie movie = optMovie.get();
		movie.setName(updateMovie.getName());
		movie.setGenre(updateMovie.getGenre());
		movie.setDirector(updateMovie.getDirector());
		movieRepository.save(movie);
	}

	public void deleteMovie(int id) {
		movieRepository.deleteById(id);
	}

	public List<Movie> getMoviesByDirectorName(String directorName) {
		return movieRepository.findByDirectorName(directorName);
	}
}
