package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBD {
    //Atributos de la clase
    private final String BASEDATOS = "inscripcionesonline";
    private final String IP = "localhost";
    private final String URL_BASEDATOS = "jdbc:mysql://"+IP+"/"+BASEDATOS+"";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "";
    private Connection CONEXION;
    //Fin atributos
    
    //Comienzo de Getters y Setters de las atributos de la clase.
    public Connection getCONEXION() {
        return CONEXION;
    }

    public void setCONEXION(Connection CONEXION) {
        this.CONEXION = CONEXION;
    }

    public String getBASEDATOS() {
        return BASEDATOS;
    }

    public String getIP() {
        return IP;
    }

    public String getURL_BASEDATOS() {
        return URL_BASEDATOS;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public String getCONTRASEÑA() {
        return CONTRASEÑA;
    }
    //Fin de Getters y Setters de las atributos de la clase.
    
    //ConectorBD (constructor) hace la conexión a la base de datos.
    public ConectorBD() {
        System.out.println("Entrando al ConectorBD");
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            CONEXION = (Connection) DriverManager.getConnection(URL_BASEDATOS, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa");
        } 
        catch(SQLException ex) {
            System.out.println("Conexión fallada" + ex);
        }
    }
    // Fin de ConectorBD.
}
