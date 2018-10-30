package com.app.service;

import com.app.db.MovieShow;
import com.app.db.MovieShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieShowsService {

    private final MovieShowRepository movieShowRepository;

    public MovieShowsService(MovieShowRepository mvr){
        this.movieShowRepository = mvr;
    }

    public void createMovieShow(MovieShow movieShow){
        this.movieShowRepository.save(movieShow);
    }

    public void updateMovieShow(MovieShow movieShow){
        this.movieShowRepository.save(movieShow);
    }

    public void deleteMovieShow(Long id){
        this.movieShowRepository.deleteById(id);
    }

    public MovieShow getMovieShow(Long id){
        return this.movieShowRepository.findById(id).orElse(null);
    }

    public List<MovieShow> getAllMovieShows(){
        return this.movieShowRepository.findAll();
    }

}
