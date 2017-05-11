package br.com.douglasfernandes.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.douglasfernandes.console.controller.utils.EnviaEmail;
import br.com.douglasfernandes.console.controller.utils.Mensagem;
import br.com.douglasfernandes.console.controller.utils.ValidaEmail;

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
	
	@RequestMapping("enviarEmail")
	public String enviarEmail(String nome, String email, String comentario){
		try{
			if(ValidaEmail.isValido(email)){
				if(EnviaEmail.envia("douglasf.filho@gmail.com", "[Compliance Software] comentário de "+nome, comentario)){
					mensagem = Mensagem.getSuccess("E-mail enviado.");
					return "redirect:/";
				}
				else{
					mensagem = Mensagem.getWarning("E-mail não enviado.");
					return "redirect:/";
				}
			}
			else{
				mensagem = Mensagem.getWarning("E-mail inválido.");
				return "redirect:/";
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
			mensagem = Mensagem.getDanger("Erro ao enviar e-mail.");
			return "redirect:/";
		}
	}
	
	@RequestMapping("inscrever")
	public String inscrever(String email){
		try{
			if(ValidaEmail.isValido(email)){
				if(EnviaEmail.envia("douglasf.filho@gmail.com", "[Compliance Software] novo inscrito: "+email, "Novo inscrito!")){
					mensagem = Mensagem.getSuccess("Inscrito!");
					return "redirect:/";
				}
				else{
					mensagem = Mensagem.getWarning("Erro ao tentar se inscrever.");
					return "redirect:/";
				}
			}
			else{
				mensagem = Mensagem.getWarning("E-mail inválido.");
				return "redirect:/";
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
			mensagem = Mensagem.getDanger("Erro ao tentar se inscrever.");
			return "redirect:/";
		}
	}
}