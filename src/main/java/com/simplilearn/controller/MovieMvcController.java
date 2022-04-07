package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.E2e_Rest_App.service.MovieService;
import com.simplilearn.model.Movie;

@Controller
public class MovieMvcController {

	@Autowired
	MovieService movieService;
	
	@GetMapping("/getAllMovies")
	public String greeting(Model model) {
		
		List<Movie> movies  = movieService.getAllMovies();
		model.addAttribute("movies", movies);
		// Business logic can be written here

		return "movielist";
	}

}
