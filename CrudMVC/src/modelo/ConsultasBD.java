
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultasBD {
    private ConexionBD conectar;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Cliente c;
    
    public ConsultasBD() {
        this.conectar = new ConexionBD();
        this.c = new Cliente();
    }
    
    public Cliente getCliente(String rfc){       
        String sql = "select * from clientes where RFC='"+rfc+"'";
        try{
            c=new Cliente();
            con=conectar.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            // Recorremos el resultado, mientras haya registros
            while(rs.next()){ 
                c.setRfc(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setEdad(rs.getInt(3));
                c.setIdCiudad(rs.getInt(4));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return c;
    }

    public int setCliente(String rfc, String nombre, int edad, int idCiudad) {
        String sql = "insert into clientes values ('"+rfc+"','"+nombre+"',"+edad+","+idCiudad+")";
        try{
            con=conectar.getConexion();
            ps=con.prepareStatement(sql);
            int res = ps.executeUpdate();
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return 5;
        }
    }

    public int borraCliente(String rfc) {
        String sql = "delete from clientes where RFC='"+rfc+"'";
        try{
            con=conectar.getConexion();
            ps=con.prepareStatement(sql);
            int res = ps.executeUpdate();
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return 1;
        }
    }

    public int modificaCliente(String rfc, String nombre, int edad, int idCiudad) {
       String sql = "update clientes set Nombre='"+nombre+"',Edad="+edad+",IdCiudad="+idCiudad+" where RFC='"+rfc+"'";
        try{
            con=conectar.getConexion();
            ps=con.prepareStatement(sql);
            int res = ps.executeUpdate();
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return 1;
        }
    }
}
