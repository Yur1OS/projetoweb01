package br.com.cotiinformatica.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Compromisso;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.CompromissoRepository;

@Controller
public class CompromissoEdicaoController {
	
	@RequestMapping(value = "/editar-compromissos")
	public ModelAndView edicao(Integer id, HttpServletRequest request) {
		
		//web-info/views/agenda/edica.jsp
		ModelAndView modelAndView = new ModelAndView("agenda/edicao");
		
		try {
			
			//Capturar usuário autentica
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			CompromissoRepository compromissoRepository = new CompromissoRepository();
			Compromisso compromisso = compromissoRepository.obterPorId(id, usuario.getIdUsuario());
			
			// enviar para a página
			modelAndView.addObject("compromisso", compromisso);
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/atualizar-compromisso", method = RequestMethod.POST)
	public ModelAndView atualizarCompromisso(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("agenda/edicao");
		
		try {
			
			//Capturar usuário da sessão
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_autenticado");
			
			//Capturar Campo
			Compromisso compromisso = new Compromisso();
			compromisso.setIdCompromisso(Integer.parseInt(request.getParameter("idCompromisso")));
			compromisso.setNome(request.getParameter("nome"));
			compromisso.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			compromisso.setHora(request.getParameter("hora"));
			compromisso.setDescricao(request.getParameter("descricao"));
			compromisso.setPrioridade(Integer.parseInt(request.getParameter("prioridade")));
			compromisso.setUsuario(usuario);
			
			//atualizando os dados
			CompromissoRepository compromissoRepository = new CompromissoRepository();
			compromissoRepository.atualizar(compromisso);
			
			modelAndView.addObject("mensagem_sucesso", "Compromisso Atualizado com sucesso !!!");
			modelAndView.addObject("compromisso",compromisso);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		return modelAndView;
	}

}
