package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vista.VistaVedel;

@WebServlet(name = "ControladorPaginaVedel", urlPatterns = {"/ControladorPaginaVedel"})
public class ControladorPaginaVedel extends HttpServlet {
    //Atributos de la clase
    private final VistaVedel objetoVV = new VistaVedel();//Objeto de la clase VistaVedel
    private String filtro;
    //Fin Atributos

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Ejecuta el metodo que crea la vista de vedelia.jsp
            objetoVV.lecturaDeArchivoJSP();
            filtro = request.getParameter("filtro");
            if("Todos".equals(filtro) || filtro == null){
                filtro = null;
            } else {
                filtro = filtro;
            }
            out.println(objetoVV.creadorDeVista(filtro));
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
    }

}
