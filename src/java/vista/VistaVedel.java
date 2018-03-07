package vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloVedel;
import org.apache.commons.io.FileUtils;

public class VistaVedel {
    //Atributos de la clase
    private final File archivoJSP = new File("C:\\Users\\Tomas Camargo\\Documents\\NetBeansProjects\\InscripcionOnline\\web\\vedelia.jsp");
    private String reemplazo = ""; 
    private final ModeloVedel objetoMV = new ModeloVedel();//Objeto de la clase ModeloVedel
    private ArrayList inscriptos = new ArrayList();
    private String archivoConvertido;
    private String filtro;
    //Fin Atributos
    
    //VistaVedel (constructor) lee el archivo JSP en donde se insertara la vista
    public VistaVedel() {
        
    }
    //Fin VistaVedel
    
    //Comienzo de Getters y Setters de las atributos de la clase.
    public String getFiltro() {
        return filtro;
    }
    
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    public File getArchivoHTML() {
        return archivoJSP;
    }

    public ModeloVedel getObjetoMV() {
        return objetoMV;
    }

    public String getReemplazo() {
        return reemplazo;
    }

    public void setReemplazo(String reemplazo) {
        this.reemplazo = reemplazo;
    }

    public ArrayList getAlumnos() {
        return inscriptos;
    }

    public void setAlumnos(ArrayList alumnos) {
        this.inscriptos = alumnos;
    }

    public String getArchivoConvertido() {
        return archivoConvertido;
    }

    public void setArchivoConvertido(String archivoConvertido) {
        this.archivoConvertido = archivoConvertido;
    }
    //Fin de Getters y Setters de las atributos de la clase.
    
    public void lecturaDeArchivoJSP(){
        try {
            this.archivoConvertido = FileUtils.readFileToString(archivoJSP);
        } catch (IOException ex) {
            Logger.getLogger(VistaVedel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*creadorDeVista toma datos que devuelve el metodo "select" de ModeloVedel,
      crea una vista y reemplaza el contenido del archivo JSP por la vista 
      generada*/
    public String creadorDeVista(String filtro) {
        reemplazo = "";
        inscriptos = objetoMV.select(filtro);
        reemplazo += "<table>"
                  +  "<caption>Tabla de inscriptos</caption>"
                  +  "<thead>"
                  +  "<tr>"
                  +  "<th>ID</th>"
                  +  "<th>Nombre</th>"
                  +  "<th>Apellido</th>"
                  +  "<th>DNI</th>"
                  +  "</tr>"
                  +  "</thead>"
                  +  "<tbody>";
        for(int x = 0; x < inscriptos.size(); ++x){
            String [] t = (String[]) inscriptos.get(x);
            reemplazo += "<tr>";
            reemplazo += "<th>  " + t[0] + "  </th>";
            for(int p = 1; p < 4; ++p){
                reemplazo += "<td>  " + t[p] + "  </td>";
            }
            reemplazo += "</tr>";
        }
        reemplazo += "</tbody>";
        reemplazo += "</table>";
        archivoConvertido = archivoConvertido.replace("[ALUMNOS]", reemplazo);
        System.out.println(archivoConvertido);
        return archivoConvertido;
    }
    //Fin creadorDeVista
}
