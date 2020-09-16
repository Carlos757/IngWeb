
package modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Modelo {
    
    private ConsultasCliente BD;
    public Modelo(){
        this.BD = new ConsultasCliente();
    }
    
    public Cliente recuperar(String rfc){
        return BD.obtenerCliente(rfc);
    }
    public int grabar(String rfc, String nombre, int edad, int idCiudad){
        int codigo = BD.grabarCliente(new Cliente(rfc,nombre,edad,idCiudad));
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
    public ArrayList<Cliente> recuperarClientes(){
        return BD.obtenerClientes();
    }
}   
