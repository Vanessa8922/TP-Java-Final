package com.codoacodo.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.OradorDAO;
import com.codoacodo.dto.Orador;
import java.sql.SQLException;




@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
    

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
               String nombre = req.getParameter("nombre");
               String apellido = req.getParameter("apellido");
                String mail = req.getParameter("mail");
                String tema = req.getParameter("tema");

//crear ProductoDAO
        OradorDAO dao = new OradorDAO();
               
                Orador ora = new Orador(nombre, apellido, mail, tema);
               
                
                    //ir a la siguiente pagina
                    resp.sendRedirect(req.getContextPath()+"/api/ListadoController");

           
	}
}
