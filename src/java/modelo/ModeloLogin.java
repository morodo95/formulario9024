package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloLogin {
    //Atributos de la clase
    private final ConectorBD objetoCBD;//Objeto que llama a la conexion de BD de la clase ConectorBD
    private final Connection conexion;
    private String usuario;
    private String pass;
    private boolean existeUsuario;
    private PreparedStatement SENTENCIA;
    private ResultSet RESULTADO;
    //Fin Atributos
    
    //Comienzo de Getters y Setters de las atributos de la clase.
    public ConectorBD getObjetoCBD() {
        return objetoCBD;
    }

    public Connection getConexion() {
        return conexion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isExisteUsuario() {
        return existeUsuario;
    }

    public void setExisteUsuario(boolean existeUsuario) {
        this.existeUsuario = existeUsuario;
    }

    public PreparedStatement getSENTENCIA() {
        return SENTENCIA;
    }

    public void setSentencia(PreparedStatement SENTENCIA) {
        this.SENTENCIA = SENTENCIA;
    }

    public ResultSet getRESULTADO() {
        return RESULTADO;
    }

    public void setRESULTADO(ResultSet RESULTADO) {
        this.RESULTADO = RESULTADO;
    }
    //Fin de Getters y Setters de las atributos de la clase.
 
    //ModeloLogin (constructor) .
    public ModeloLogin() {
        this.objetoCBD = new ConectorBD();
        this.conexion = objetoCBD.getCONEXION();
    }
    //Fin ModeloLogin
    
    /*select realiza la consulta a la bd, verifica si existe un resultado y 
      devuelve una respuesta*/
    public boolean select() {  
        String consulta = "SELECT * FROM inscripcionesonline.vedeles WHERE usuario=? && pass=?";
        try {     
            SENTENCIA = conexion.prepareStatement(consulta);
            SENTENCIA.setString(1, usuario);
            SENTENCIA.setString(2, pass);
            RESULTADO = SENTENCIA.executeQuery();
            existeUsuario = false;
            while(RESULTADO.next()) {
                existeUsuario = true;
            }
        } 
        catch(SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return existeUsuario;   
    }
    //Fin select
}
