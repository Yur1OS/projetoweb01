package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//m�todo para mapear a rota que abrir� a pagina
	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request) {
		
		
		//Define qual jsp ser� aberta na /home
		ModelAndView modelAndView = new ModelAndView("agenda/home");
		
		//Vrf se o usu�rio logou
		if(request.getSession().getAttribute("usuario_autenticado") == null) {
			
			//Redirecionamento / voltar para inicial
			modelAndView.setViewName("redirect:/");
		}
		
		//Abrindo p�gina
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar sess�o
		request.getSession().removeAttribute("usuario_autenticado");
		
		//Redirecionamento
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		return modelAndView;
		
	}
	
}
