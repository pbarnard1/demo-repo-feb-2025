package com.adrianbarnard.tvshowsapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianbarnard.tvshowsapp.models.TvShow;

@Repository
public interface TvShowRepository extends CrudRepository<TvShow, Long> {
	List<TvShow> findAll(); // Grab all of our TV shows from the database
	List<TvShow> findByAirer(String airer);
}
