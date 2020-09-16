/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author carlosrios
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    public VentanaPrincipal() {
        super("Mantenimiento al catalogo de clientes");
        initComponents();
    }
    
    public void arranca(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
        
    public void setControlador(Controlador controlador){
        this.btnRecuperar.addActionListener(controlador);
        this.btnConsularClientes.addActionListener(controlador);
        this.btnBorrar.addActionListener(controlador);
        this.btnGrabar.addActionListener(controlador);
        this.btnModificar.addActionListener(controlador);
    }
    
    public void setNombre(String nombre){
        this.txtNombre.setText(nombre);
    }
    public void setEdad(int edad){
        this.txtEdad.setText(Integer.toString(edad));
    }
    public void setIdCiudad(int idCiudad){
        this.txtIdCiudad.setText(Integer.toString(idCiudad));
    }
    
    public String getRfc(){
        String rfc = txtRfc.getText();
        //Se verifica que el rfc sea Alfanumerico y de 10 caracteres
        if (Pattern.matches("^[A-Za-z][A-Za-z][A-Za-z][A-Za-z][0-9][0-9][0-9][0-9][0-9][0-9]$", rfc) == true && rfc.length() == 10) {
            return rfc;
        }else
            notifica(6);
            return "";
    }
    public String getNombre() {
       if(txtNombre.getText().length()>50){
            notifica(7);
        }else{
            return this.txtNombre.getText();
        }
        return "";
    }

    public int getEdad() {
        
        try{
            int edad = Integer.parseInt(txtEdad.getText());
            if(edad>150 || edad <= 0){
                notifica(3);
                return (-1);
            }else{
                return edad;   
            }
      
        }catch(Exception e){
            System.out.println(e);
            notifica(3);
            return (-1);
        }
    }

    public int getIdCiudad() {
        try{
            int ciudad = Integer.parseInt(txtIdCiudad.getText());
            if(ciudad < 0){
                notifica(4);
                return (-1);
            }else{
                return ciudad;   
            }
      
        }catch(Exception e){
            notifica(4);
            System.out.println(e);
            return (-1);
        }
    }
    
    public void notifica(int codigo) {
        if(codigo == 0){
            JOptionPane.showMessageDialog(this, "Exito");
        }
        if(codigo == 1){
            JOptionPane.showMessageDialog(this, "Verifique la informacion ingresada", "Error",JOptionPane.ERROR_MESSAGE);
        }
        if(codigo == 2){
            JOptionPane.showMessageDialog(this, "El RFC proporcionado no se encuentra en los registros", "Aviso",JOptionPane.WARNING_MESSAGE);
        }
        if(codigo == 3){
            JOptionPane.showMessageDialog(this, "Verifique el campo de edad", "Aviso",JOptionPane.WARNING_MESSAGE);
        }
        if(codigo == 4){
            JOptionPane.showMessageDialog(this, "Verifique el campo IdCiudad", "Aviso",JOptionPane.WARNING_MESSAGE);
        }
        if(codigo == 5){
            JOptionPane.showMessageDialog(this, "El Cliente que desea agregar ya existe en el registro", "Error",JOptionPane.ERROR_MESSAGE);
        }
        if(codigo == 6){
            JOptionPane.showMessageDialog(this, "Verifique el RFC", "Aviso",JOptionPane.WARNING_MESSAGE);
        }
        if(codigo == 7){
            JOptionPane.showMessageDialog(this, "Verifique el Nombre", "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    public int confirma(){
         return JOptionPane.showConfirmDialog(this, "Esta seguro(a)?","Confirmar",JOptionPane.YES_NO_OPTION);  
    }
    
    
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCliente = new javax.swing.JPanel();
        etiquetaRfc = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaEdad = new javax.swing.JLabel();
        etiquetaIdCiudad = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtIdCiudad = new javax.swing.JTextField();
        panelBotonera = new javax.swing.JPanel();
        btnRecuperar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsularClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        etiquetaRfc.setText("RFC");

        etiquetaNombre.setText("Nombre");

        etiquetaEdad.setText("Edad");

        etiquetaIdCiudad.setText("idCiudad");

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaRfc)
                    .addComponent(etiquetaEdad)
                    .addComponent(etiquetaIdCiudad))
                .addGap(24, 24, 24)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCiudad)
                    .addComponent(txtNombre)
                    .addComponent(txtEdad)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaRfc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaIdCiudad))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        panelBotonera.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnRecuperar.setText("Recuperar");

        btnGrabar.setText("Grabar");

        btnBorrar.setText("Borrar");

        btnModificar.setText("Modificar");

        btnConsularClientes.setText("Consular Clientes");

        javax.swing.GroupLayout panelBotoneraLayout = new javax.swing.GroupLayout(panelBotonera);
        panelBotonera.setLayout(panelBotoneraLayout);
        panelBotoneraLayout.setHorizontalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoneraLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsularClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRecuperar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelBotoneraLayout.setVerticalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoneraLayout.createSequentialGroup()
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecuperar)
                    .addComponent(btnGrabar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsularClientes)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnConsularClientes;
    public javax.swing.JButton btnGrabar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRecuperar;
    private javax.swing.JLabel etiquetaEdad;
    private javax.swing.JLabel etiquetaIdCiudad;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaRfc;
    private javax.swing.JPanel panelBotonera;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdCiudad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables

    

    
}
