package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompromissoConsultaController {
		
	@RequestMapping(value = "/consultar-compromissos")
	public ModelAndView consulta() {
		//web-inf/views/agenda/cadastro.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/consulta");
		return modelAndView;
		
	}

}