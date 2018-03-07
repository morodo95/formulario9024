package modelo;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloVedel {
    //Atributos de la clase
    private final ConectorBD objetoCBD = new ConectorBD();//Objeto que llama a la conexion de BD de la clase ConectorBD
    private final Connection conexion;
    private ResultSet RESULTADO;
    private Statement SENTENCIA;
    private PreparedStatement PREPARED_SENTENCIA;
    private ArrayList inscripciones = new ArrayList();
    private String filtro;
    //Fin atributos
    
    //Comienzo de Getters y Setters de las atributos de la clase.
    public ConectorBD getObjetoCBD() {
        return objetoCBD;
    }

    public Connection getConexion() {
        return conexion;
    }

    public ArrayList getInscripciones() {
        return inscripciones;
    }

    public ResultSet getRESULTADO() {
        return RESULTADO;
    }

    public void setResultado(ResultSet RESULTADO) {
        this.RESULTADO = RESULTADO;
    }

    public Statement getSENTENCIA() {
        return SENTENCIA;
    }

    public void setSENTENCIA(Statement SENTENCIA) {
        this.SENTENCIA = SENTENCIA;
    }
    
    public ModeloVedel() {
        this.conexion = objetoCBD.getCONEXION();
    }
    
    public PreparedStatement getPREPARED_SENTENCIA() {
        return PREPARED_SENTENCIA;
    }

    public void setPREPARED_SENTENCIA(PreparedStatement PREPARED_SENTENCIA) {
        this.PREPARED_SENTENCIA = PREPARED_SENTENCIA;
    }
    //Fin de Getters y Setters de las atributos de la clase.
    
    //select realiza la consulta a la bd y guarda los valores recibidos
    public ArrayList select(String parametro) {
        filtro = parametro;
        System.out.println("****"+filtro);
        inscripciones.clear();
        if(filtro == null) {
            String sql = "SELECT * FROM inscripcionesonline.tabla_de_prueba;";
            System.out.println(sql);
            try {
                SENTENCIA = conexion.createStatement();
                RESULTADO = SENTENCIA.executeQuery(sql);
                while(RESULTADO.next()){
                String[] vectorTemporal = new String[4];  
                vectorTemporal[0] = RESULTADO.getString("id");
                vectorTemporal[1] = RESULTADO.getString("nombre");
                vectorTemporal[2] = RESULTADO.getString("apellido");
                vectorTemporal[3] = RESULTADO.getString("dni");
                inscripciones.add(vectorTemporal);
                }
            }
            catch(SQLException sqle) {
                System.out.println(sqle);
            }
        } 
        else {
            String sql = "SELECT * FROM inscripcionesonline.tabla_de_prueba where apellido= '"+filtro+"'";
            System.out.println(sql);
            try {
                SENTENCIA = conexion.createStatement();
                RESULTADO = SENTENCIA.executeQuery(sql);
                while(RESULTADO.next()){
                String[] vectorTemporal = new String[4];  
                vectorTemporal[0] = RESULTADO.getString("id");
                vectorTemporal[1] = RESULTADO.getString("nombre");
                vectorTemporal[2] = RESULTADO.getString("apellido");
                vectorTemporal[3] = RESULTADO.getString("dni");
                inscripciones.add(vectorTemporal);
                }
            }
            catch(SQLException sqle) {
                System.out.println(sqle);
            }
        }
        return inscripciones;
    }
    //Fin select
}
