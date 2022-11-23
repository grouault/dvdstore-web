package com.mycompany.dvdstore.dvdstoreweb.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie>  displayHome(){
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }

}
