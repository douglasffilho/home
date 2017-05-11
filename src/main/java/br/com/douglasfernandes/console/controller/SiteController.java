package br.com.douglasfernandes.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {
	
	String mensagem = "";
	
//	XXX Gerenciamento de entrada, login, logout e perfil.
	
	@RequestMapping("/")
	public String home(Model model){
		try{
			model.addAttribute("mensagem",mensagem);
			mensagem = "";
			return "index";
		}
		catch(Exception e){
			e.printStackTrace();
			return "erro/banco";
		}
	}
	
}