package com.controlador;

import com.modelo.Registro;
import com.modelo.RegistroDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validar extends HttpServlet {

    RegistroDAO edao = new RegistroDAO();
    Registro re = new Registro();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String nombre_usuario = request.getParameter("txtuser");
            int contraseña = Integer.parseInt(request.getParameter("txtpass"));
            re = edao.validar(nombre_usuario, contraseña);
            if (re.getNombre_usuario() != null) {
                request.setAttribute("nombre_usuario", re);
                request.getRequestDispatcher("Controlador?menu=principal").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
