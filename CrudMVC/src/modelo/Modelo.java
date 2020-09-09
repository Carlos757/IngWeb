
package modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Modelo {
    
    ConsultasCliente BD;
    public Modelo(){
        this.BD = new ConsultasCliente();
    }
    
    public Cliente recuperar(String rfc){
        return BD.getCliente(rfc);
    }
    public int grabar(String rfc, String nombre, int edad, int idCiudad){
        int codigo = BD.setCliente(new Cliente(rfc,nombre,edad,idCiudad));
        return codigo;
    }
    public int borrar(String rfc){
        int codigo = BD.borraCliente(rfc);
        return codigo;
    }
    public int modificar(String rfc, String nombre, int edad, int idCiudad){
        int codigo = BD.modificaCliente(new Cliente(rfc,nombre,edad,idCiudad));
        return codigo;
    }
    
//    public ArrayList recuperarTodosLosUsuarios(String rfc){
//        ArrayList<Cliente>datos = new ArrayList<>();
//        String sql = "select * from Clientes where RFC="+rfc;
//        try{
//            con=conectar.getConexion();
//            ps=con.prepareStatement(sql);
//            rs=ps.executeQuery();
//            while(rs.next()){
//                Cliente c = new Cliente();
//                c.setRfc(rfc);
//                c.setNombre(rs.getString(2));
//                c.setEdad(rs.getInt(3));
//                c.setIdCiudad(rs.getInt(4));
//                datos.add(c);
//            }
//        }
//            catch(Exception e){
//                System.out.println(e);
//            }
//        return datos;
//    }
}   
