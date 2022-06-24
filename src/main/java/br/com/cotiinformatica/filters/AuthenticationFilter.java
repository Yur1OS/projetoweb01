package br.com.cotiinformatica.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
			
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//Mapear urls do sistema que n�o exigem autentica��o
		List<String> rotasPermitidas = new ArrayList<String>();
		rotasPermitidas.add("/");
		rotasPermitidas.add("/autenticar-usuario");
		rotasPermitidas.add("/register-user");
		rotasPermitidas.add("/cadastrar-usuario");
		rotasPermitidas.add("/password-recover");
		rotasPermitidas.add("/recuperar-senha");
		
		//VRF se o usu�rio � autenticado
		if(!rotasPermitidas.contains(req.getServletPath())) {
			if(req.getSession().getAttribute("usuario_autenticado") == null) {
				//Redirecionamento do usu�rio
				resp.sendRedirect("/projetoweb01/");
			}
		}
		
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
