/*
 * Author: Doaa Shaikh, 991588387
 * Assignment 2
 */

package ca.sheridancollege.shaikhdo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.shaikhdo.beans.MovieReview;
import ca.sheridancollege.shaikhdo.database.DatabaseAccess;

@Controller

public class MovieReviewController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("movrev", new MovieReview());

		model.addAttribute("movieReviewList", da.getMovieReviewList());
		return "index";
	}

	@PostMapping("/insertReview")
	public String insertReview(Model model, @ModelAttribute MovieReview movrev) {
		da.insertReview(movrev);
		model.addAttribute("movrev", new MovieReview());
		model.addAttribute("movieReviewList", da.getMovieReviewList());
		return "index";
	}

}
