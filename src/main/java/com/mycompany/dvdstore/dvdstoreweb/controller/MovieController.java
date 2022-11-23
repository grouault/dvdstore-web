package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long id, Model model) {
      model.addAttribute("movie", movieService.getMovieById(id));
      return "movie-details";
    }

    @PostMapping("")
    public String addMovie(@ModelAttribute Movie movie){
        movieService.registerMovie(movie);
        return "movie-added";
    }

}
