
package com.controlador;
import com.modelo.AnuncioDAO;
import com.modelo.Anuncio;
import com.modelo.Registro;
import com.modelo.RegistroDAO;
import com.modelo.Usuario;
import com.modelo.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet{
     Anuncio a = new Anuncio();
     AnuncioDAO adao = new AnuncioDAO();
     Usuario us = new Usuario();
     UsuarioDAO udao = new UsuarioDAO();
     Registro re = new Registro();
     RegistroDAO rdao = new RegistroDAO();
    int ida;
    int idu;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
    
   
    if (menu.equals("Anuncio")) {
            switch (accion) {
                case "Listar":
                    List lista = adao.listar();
                    request.setAttribute("anuncio", lista);
                    break;
                case "Agregar":
                    String titulo = request.getParameter("txtTitulo");
                    String contenido = request.getParameter("txtContenido");
                    int precio = Integer.parseInt(request.getParameter("txtPrecio"));
                    
                    a.setTitulo(titulo);
                    a.setContenido(contenido);
                    a.setPrecio(precio);
                 
                    adao.agregar(a);
                    break;
                case "Editar":
                    ida = Integer.parseInt(request.getParameter("id"));
                    Anuncio an = adao.listarId(ida);
                    request.setAttribute("anuncio", an);
                    request.getRequestDispatcher("Controlador?menu=Anuncio&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String titulo1 = request.getParameter("txtTitulo");
                    String contenido1 = request.getParameter("txtContenido");
                    int precio1 = Integer.parseInt(request.getParameter("txtPrecio"));
                    
                    a.setTitulo(titulo1);
                    a.setContenido(contenido1);
                    a.setPrecio(precio1);
                   
                    a.setId(ida);
                    adao.actualizar(a);
                    request.getRequestDispatcher("Controlador?menu=Anuncio&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ida = Integer.parseInt(request.getParameter("id"));
                    adao.delete(ida);
                    request.getRequestDispatcher("Controlador?menu=Anuncio&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Anuncio.jsp").forward(request, response);
        }

    if (menu.equals("Usuario")) {
            switch (accion) {
                case "Listar":
                    List lista = udao.listar();
                    request.setAttribute("usuario", lista);
                    break;
                case "Agregar":
                    int ci = Integer.parseInt(request.getParameter("txtCi"));
                    String nombre = request.getParameter("txtNombre");
                    String ape_pat = request.getParameter("txtPaterno");
                    String ape_mat = request.getParameter("txtMaterno");
                    String celular = request.getParameter("txtCelular");
                    String correo = request.getParameter("txtCorreo");
                    us.setCi(ci);
                    us.setNombre(nombre);
                    us.setApe_pat(ape_pat);
                    us.setApe_mat(ape_mat);
                    us.setCelular(celular);
                    us.setCorreo(correo);
                    udao.agregar(us);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idu = Integer.parseInt(request.getParameter("id"));
                    Usuario u = udao.listarId(idu);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
              
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        }
}
}
