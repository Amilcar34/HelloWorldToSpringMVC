package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.entity.Saludo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@Autowired
//	Saludo saludo;
	Saludo saludo = new Saludo();
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json")
	public Saludo string(){
		Saludo salu = new Saludo();
		salu.setSaludo("hola desde el /");
		
		return salu;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		saludo.setSaludo("hola desde el /home");
		model.addAttribute("saludo", saludo.getSaludo() );
		
		return "home" ;
	}
	
	@RequestMapping(value = "/house", method = RequestMethod.GET)
	public String publi(Locale locale, Model model) {

		saludo.setSaludo("hola desde el /house");
		model.addAttribute("saludo", saludo.getSaludo() );
		
		return "house";
	}
}
