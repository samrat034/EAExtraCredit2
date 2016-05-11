package mum.edu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.domain.Movie;

@Controller
public class MovieController {
	
	@RequestMapping(value = "/addMovie", method = RequestMethod.GET)
	public String home(Model model) {
		
		Movie mov = new Movie();
		model.addAttribute("movie",mov);
		
		return "addMovie";
	}
}
