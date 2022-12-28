package anime_tijuilote;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Conexion {

    private String Usuario;
    private String Password;
    private String Host;
    private Connection CON;

    public Connection AbrirConeccion() {

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            String Driver = "com.mysql.jdbc.Driver";
            this.Usuario = "I66eN9EkOA";
            this.Password = "eryxH5VrAn";
            String URL = "jdbc:mysql://remotemysql.com:3306/I66eN9EkOA";
            Class.forName(Driver);
            this.CON = DriverManager.getConnection(URL, this.Usuario, this.Password);
            

        } catch (ClassNotFoundException | SQLException E) {
            JOptionPane.showMessageDialog(null, "ERROR: " + E);
        }
        return this.CON;

        
    }

    public void CerrarConexion (){
    
        this.CON = null;
    }
    
    public Connection getCON() {
        return CON;
    }
    
}
        