package com.codoacodo.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.dao.OradorDAO;
import com.codoacodo.dto.Orador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
	
        @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
            try {
                //crear la instancia de OradorDAO
                OradorDAO dao = new OradorDAO();
                
                //invocar al metodo listarOrador()
                List<Orador> listado = dao.listarOrador();
                
                //grabar el listado en el request para que lo vea la siguiente pagina
                req.setAttribute("listado", listado);
                
                //ir a la siguiente pagina
                getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}

