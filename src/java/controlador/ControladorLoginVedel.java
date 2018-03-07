package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ModeloLogin;

public class ControladorLoginVedel extends HttpServlet{
    //Atributos de la clase
    private boolean existeUsuario = false;
    private final ModeloLogin objetoML = new ModeloLogin();//Objeto de la clase ModeloLogin
    private String usuario;
    private String password;
    //Fin atributos
    
    //Comienzo de Getters y Setters de las atributos de la clase.
    public boolean isExisteUsuario() {
        return existeUsuario;
    }

    public void setExisteUsuario(boolean existeUsuario) {
        this.existeUsuario = existeUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ModeloLogin getObjetoML() {
        return objetoML;
    }
    //Fin de Getters y Setters de las atributos de la clase.
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {

            //Guarda los datos enviados desde login.jsp
            objetoML.setUsuario(request.getParameter("usuario"));
            objetoML.setPass(request.getParameter("password"));
            boolean respuesta = objetoML.select();
            if(respuesta == true){
                //Si el usuario existe redireccionara a la pagina de vedelia (vedelia.jsp)
                request.getRequestDispatcher("/ControladorPaginaVedel").forward(request, response);
            }else{
                //De lo contrario: enviara una alerta - recargara la pagina
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
