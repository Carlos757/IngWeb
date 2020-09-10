
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultasCliente {
    
    private ConexionBD con;
    
    public ConsultasCliente() {
        this.con = new ConexionBD();
    }
    
    public Cliente obtenerCliente(String rfc){          
        Cliente c = new Cliente();
        try{
            String sql = "select * from clientes where rfc=?";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setString(1, rfc);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() ){ 
                c.setRfc(rs.getString("rfc"));
                c.setNombre(rs.getString("nombre"));
                c.setEdad(rs.getInt("edad"));
                c.setIdCiudad(rs.getInt("idCiudad"));
            }
            ps.close();
            con.desconectar();

        }
        catch(SQLException ex){
            System.out.println(ex);
            con.desconectar();
        }
        return c;
    }

    public int grabarCliente(Cliente c) {
        try{
            String sql = "insert into clientes values (?,?,?,?)";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            
            ps.setString(1, c.getRfc());
            ps.setString(2, c.getNombre());
            ps.setInt(3, c.getEdad());
            ps.setInt(4, c.getIdCiudad());
            
            int res = ps.executeUpdate();
            ps.close();
            con.desconectar();
            
            if(res==1)
                return 0;
            else 
                return 5;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return 5;
        }
    }

    public int borraCliente(String rfc) {
        String sql = "delete from clientes where rfc='"+rfc+"'";
        try{
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            
            int res = ps.executeUpdate();
            ps.close();
            con.desconectar();
            
            if(res==1)
                return 0;
            else 
                return 1;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return 1;
        }
    }

    public int modificaCliente(Cliente c) {
       String sql = "update clientes set nombre=?,edad=?,idCiudad=? where rfc=?";
        try{
            PreparedStatement ps = con.conectar().prepareStatement(sql);
                 
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getEdad());
            ps.setInt(3, c.getIdCiudad());
            ps.setString(4, c.getRfc());
            
            int res = ps.executeUpdate();
            ps.close();
            con.desconectar();
            
            if(res==1)
                return 0;
            else 
                return 1;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return 1;
        }
    }
    
    public ArrayList<Cliente> obtenerClientes(){
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "select * from clientes";
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next() ){ 
                Cliente c = new Cliente();
                c.setRfc(rs.getString("rfc"));
                c.setNombre(rs.getString("nombre"));
                c.setEdad(rs.getInt("edad"));
                c.setIdCiudad(rs.getInt("idCiudad"));
                clientes.add(c);
            }
            
            ps.close();
            con.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }
}
