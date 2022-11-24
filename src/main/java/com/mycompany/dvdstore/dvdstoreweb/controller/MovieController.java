package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.dvdstoreweb.bean.MovieBean;
import com.mycompany.dvdstore.dvdstoreweb.mapper.MovieMapper;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import java.util.Scanner;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private MovieMapper movieMapper;

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long id, Model model) {
      model.addAttribute("movie", movieService.getMovieById(id));
      return "movie/movie-details";
    }

    @PostMapping("")
    public String addMovie(@Valid @ModelAttribute("movie") MovieBean movie, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "movie/add-movie-form";
        }
        movieService.registerMovie(movieMapper.toMovie(movie));
        return "movie/movie-added";
    }

}
