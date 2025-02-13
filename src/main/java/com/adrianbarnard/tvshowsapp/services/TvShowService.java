package com.adrianbarnard.tvshowsapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.tvshowsapp.models.TvShow;
import com.adrianbarnard.tvshowsapp.repositories.TvShowRepository;

@Service
public class TvShowService {
	@Autowired
	private TvShowRepository tvShowRepo;
	
	// Create method
	public TvShow createShow(TvShow newShow) {
		return tvShowRepo.save(newShow);
	}
	
	// Read ALL method
	public List<TvShow> readAllShows() {
		return tvShowRepo.findAll();
	}
	
	// Read ONE method
	public TvShow readOneShow(Long id) {
		Optional<TvShow> possibleShow = tvShowRepo.findById(id);
//		if (possibleShow.isEmpty()) {
//			return null;
//		} else {
//			return possibleShow.get();
//		}
		return possibleShow.isEmpty() ? null : possibleShow.get();
	}
	
	// Update method
	public TvShow updateShow(TvShow newShow) {
		return tvShowRepo.save(newShow);
	}
	
	// Delete method
	public void deleteShowById(Long id) {
		TvShow possibleShow = this.readOneShow(id);
		if (possibleShow != null) {
//			tvShowRepo.delete(possibleShow);
			tvShowRepo.deleteById(id);
		}
	}
	
}
