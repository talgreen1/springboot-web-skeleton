package com.app.controller;

import com.app.db.MovieShow;
import com.app.db.MovieShowRepository;
import com.app.service.MovieShowsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("movies")
public class MovieShowController {

	private final MovieShowsService movieShowService;

	public MovieShowController(MovieShowsService mvs){
		this.movieShowService = mvs;
	}

	@GetMapping
	public List<MovieShow> getAllMovies() {
		return this.movieShowService.getAllMovieShows();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createMovieShow(@RequestBody MovieShow movieShow){
		this.movieShowService.createMovieShow(movieShow);
	}

	@DeleteMapping("{id}")
	public void deleteMovieShow(@PathVariable  Long id){
		this.movieShowService.deleteMovieShow(id);
	}

    @PutMapping
    public void updateMovieShow(@RequestBody MovieShow movieShow){
        this.movieShowService.updateMovieShow(movieShow);
    }
}

