package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    Connection conexion;
    
    public Connection conectar(){
        String url = "jdbc:mysql://localhost:3306/crud_mvc";
        //String url = "jdbc:mysql://192.168.64.2:3306/crud_mvc";
        String usuario = "root";
        String contraseña = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion establecida");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Conexion fallida");
        }
        return conexion;
    }
    
    public void desconectar(){
        try {
            conexion.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException ex) {
            System.out.println("Conexion no fue Cerrada");           
        }
    }
    
}
