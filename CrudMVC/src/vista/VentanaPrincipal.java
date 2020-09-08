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
        if (Pattern.matches("^[A-Za-z0-9]+$", rfc) == true && rfc.length() == 10) {
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
                return 1;
            }else{
                return edad;   
            }
      
        }catch(Exception e){
            System.out.println(e);
            notifica(3);
            return 1;
        }
    }

    public int getIdCiudad() {
        try{
            int ciudad = Integer.parseInt(txtIdCiudad.getText());
            if(ciudad < 0){
                notifica(4);
                return 1;
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
    
    
        
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtIdCiudad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnRecuperar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnConsularClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel1.setText("RFC");

        jLabel2.setText("Nombre");

        jLabel3.setText("Edad");

        jLabel4.setText("idCiudad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCiudad)
                    .addComponent(txtNombre)
                    .addComponent(txtEdad)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnRecuperar.setText("Recuperar");

        btnGrabar.setText("Grabar");

        btnBorrar.setText("Borrar");

        btnModificar.setText("Modificar");

        btnConsularClientes.setText("Consular Clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsularClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRecuperar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecuperar)
                    .addComponent(btnGrabar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtIdCiudad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables

    

    
}
