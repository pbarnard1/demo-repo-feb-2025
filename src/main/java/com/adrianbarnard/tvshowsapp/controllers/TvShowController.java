package com.adrianbarnard.tvshowsapp.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.adrianbarnard.tvshowsapp.models.TvShow;
import com.adrianbarnard.tvshowsapp.services.TvShowService;

import jakarta.validation.Valid;

@Controller
public class TvShowController {
	@Autowired
	private TvShowService tvShowServ;
	
	@GetMapping("/")
	public String root() {
		return "redirect:/shows";
	}
		
	@GetMapping("/shows/new")
	public String newShowPage(@ModelAttribute("newShow") TvShow newShow) {
		return "newShow.jsp";
	}
	
	@PostMapping("/shows/new")
	public String addShowToDB(@Valid @ModelAttribute("newShow") TvShow newShow,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "newShow.jsp";
		} else {
			tvShowServ.createShow(newShow);
			return "redirect:/shows";
		}
	}

	@GetMapping("/shows")
	public String allShowsPage(Model viewModel) {
		viewModel.addAttribute("allShows", tvShowServ.readAllShows());
		return "allShows.jsp";
	}
	
	@GetMapping("/shows/{id}")
	public String displayOneShowPage(@PathVariable Long id, Model viewModel) {
		viewModel.addAttribute("thisShow", tvShowServ.readOneShow(id));
		return "displayShow.jsp";
	}
	
	@GetMapping("/shows/{id}/edit")
	public String editShowPage(@PathVariable Long id, Model viewModel) {
		viewModel.addAttribute("thisShow", tvShowServ.readOneShow(id));
		ArrayList<String> ratings = new ArrayList<String>();
		ratings.add("Y");
		ratings.add("Y7");
		ratings.add("G");
		ratings.add("PG");
		ratings.add("14");
		ratings.add("MA");
		viewModel.addAttribute("ratings", ratings);
		return "editShow.jsp";
	}
	
	@PutMapping("/shows/{id}/edit")
	public String editShowInDB(@Valid @ModelAttribute("thisShow") TvShow thisShow,
			BindingResult bindingResult, @PathVariable Long id, Model viewModel) {
		if (bindingResult.hasErrors()) {
			ArrayList<String> ratings = new ArrayList<String>();
			ratings.add("Y");
			ratings.add("Y7");
			ratings.add("G");
			ratings.add("PG");
			ratings.add("14");
			ratings.add("MA");
			viewModel.addAttribute("ratings", ratings);
			return "editShow.jsp";
		} else {
			tvShowServ.updateShow(thisShow);
			return "redirect:/shows/"+id;
		}
	}
	
	@DeleteMapping("/shows/{id}/delete")
	public String deleteShowFromDB(@PathVariable Long id) {
		tvShowServ.deleteShowById(id);
		return "redirect:/shows";
	}
}
