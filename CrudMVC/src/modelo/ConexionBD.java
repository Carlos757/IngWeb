package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    Connection conexion;
    
    public Connection getConexion(){
        //RIMC971121
        String url = "jdbc:mysql://localhost:3306/crud-mvc";
        String usuario = "root";
        String contraseña = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        }catch(Exception e){
            System.out.println(e);
        }
        return conexion;
    }
    
}
