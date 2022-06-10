package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//método para mapear a rota que abrirá a pagina
	@RequestMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request) {
		
		
		//Define qual jsp será aberta na /home
		ModelAndView modelAndView = new ModelAndView("agenda/home");
		
		//Vrf se o usuário logou
		if(request.getSession().getAttribute("usuario_autenticado") == null) {
			
			//Redirecionamento / voltar para inicial
			modelAndView.setViewName("redirect:/");
		}
		
		//Abrindo página
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		//apagar sessão
		request.getSession().removeAttribute("usuario_autenticado");
		
		//Redirecionamento
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		return modelAndView;
		
	}
	
}
