package com.codoacodo.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.OradorDAO;

/*HERENCIA*/
//Create Controller es hijo de :
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String email = req.getParameter("email");
		String tema = req.getParameter("tema");
		
		
		//crear instancia
		OradorDAO dao = new OradorDAO();
		
		//ejecutar el metodo crearProducto(parametros...)
		dao.crearOrador(nombre,apellido, email, tema);
		
		//ctrl+shit+o
		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
               
	}
}
