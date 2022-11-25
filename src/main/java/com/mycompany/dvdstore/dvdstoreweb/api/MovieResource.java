package com.mycompany.dvdstore.dvdstoreweb.api;

import com.mycompany.dvdstore.dvdstoreweb.bean.MovieBean;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public List<Movie> getAll(){
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        return movie;
    }

    @PostMapping("")
    public Movie add(@RequestBody Movie movie){
        return movieService.registerMovie(movie);
    }

}
