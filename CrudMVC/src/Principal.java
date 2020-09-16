
import controlador.Controlador;
import modelo.Modelo;
import vista.VentanaPrincipal;

public class Principal {

    public static void main(String[] args) {
        VentanaPrincipal vista = new VentanaPrincipal();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
        vista.setControlador(controlador);
        vista.arranca();
    }
    
}
