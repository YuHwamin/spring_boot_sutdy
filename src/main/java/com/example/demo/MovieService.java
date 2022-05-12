package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final ResponseMovie.MovieRepository movieRepository;

    public MovieService(ResponseMovie.MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> search(final String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }
}
