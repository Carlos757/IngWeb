package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo;
import modelo.Cliente;
import vista.VentanaPrincipal;
import vista.VentanaUsuarios;

public class Controlador implements ActionListener{

    private Modelo Modelo;
    private VentanaPrincipal Vista;
    private VentanaUsuarios VistaUsuarios;
        
    public Controlador(VentanaPrincipal Vista,Modelo Modelo){
        this.Vista=Vista;
        this.Modelo=Modelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Vista.btnGrabar){
            String Rfc = Vista.getRfc();
            String Nombre = Vista.getNombre();
            int Edad = Vista.getEdad();
            int IdCiudad = Vista.getIdCiudad();
            if(Rfc == "" || Nombre == "" || Edad==(-1) || IdCiudad == (-1)){
                //Se verifica que ningun campo este incorrecto
            }else {
                if(Vista.confirma()==0){
                    int codigo = Modelo.grabar(Rfc,Nombre,Edad,IdCiudad);
                    Vista.notifica(codigo);
                }  
            }
        }
        if(e.getSource()==Vista.btnRecuperar){
            String rfc = Vista.getRfc(); 
            if(rfc != ""){
                Cliente c = Modelo.recuperar(rfc);
                if(c.getEdad() != 0){               //Se verifica que el cliente no este vacio
                    Vista.setNombre(c.getNombre());
                    Vista.setEdad(c.getEdad());
                    Vista.setIdCiudad(c.getIdCiudad());
                }else{                              //Si no significa que no obtuvo ningun resultado en el Query
                    Vista.notifica(2);
                }
            }
        }
        if(e.getSource()==Vista.btnBorrar){
            String Rfc = Vista.getRfc();
            if(Rfc != "" && Vista.confirma()==0){
                int codigo = Modelo.borrar(Rfc);
                Vista.notifica(codigo);
            }
        }
        if(e.getSource()==Vista.btnModificar){
            String Rfc = Vista.getRfc();
            String Nombre = Vista.getNombre();
            int Edad = Vista.getEdad();
            int IdCiudad = Vista.getIdCiudad();
            
            if(Rfc == "" || Nombre == "" || Edad==1 || IdCiudad == (-1)){
                //Se verifica que ningun campo este incorrecto
            }else{
                if(Vista.confirma()==0){
                    int codigo = Modelo.modificar(Rfc,Nombre,Edad,IdCiudad);
                    Vista.notifica(codigo);
                }
            }
        }
        if(e.getSource()==Vista.btnConsularClientes){
            if (VistaUsuarios != null) {//si existe una ventana, la cierra.
                VistaUsuarios.dispose();
            }
            VistaUsuarios = new VentanaUsuarios();
            VistaUsuarios.arranca();
            VistaUsuarios.mostrarClientes(Modelo.recuperarClientes());
        }
        
    }
    
}
