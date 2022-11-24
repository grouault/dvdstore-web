package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.dvdstoreweb.bean.MovieBean;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/dvdstore-home")
    public List<Movie>  displayHome(Model model){
        List<Movie> movies = movieService.getMovieList();
        model.addAttribute("movies", movies);
        return movies;
    }

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute("movie") MovieBean movie){
        return "movie/add-movie-form";
    }

}
