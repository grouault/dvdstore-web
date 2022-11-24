package com.mycompany.dvdstore.dvdstoreweb.mapper;

import com.mycompany.dvdstore.dvdstoreweb.bean.MovieBean;
import com.mycompany.dvdstore.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toMovie(MovieBean movieBean){
        Movie movie = new Movie();
        movie.setId(movieBean.getId());
        movie.setTitle(movieBean.getTitle());
        movie.setGenre(movieBean.getGenre());
        movie.setDescription(movieBean.getDescription());
        return movie;
    }

}
