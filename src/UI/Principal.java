/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Backend.Dato;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Backend.LectorArchivo;
import Backend.Recorrido;
import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Principal extends javax.swing.JFrame {

    ArrayList<Dato> datos;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        Diseño();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargarArchivo = new javax.swing.JMenuItem();
        BuscarRutas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(12, 148, 141));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(1, 1, 1));
        jMenuBar1.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(350, 35));

        jMenu1.setForeground(new java.awt.Color(1, 225, 205));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Imagenes/nuevaRuta.png"))); // NOI18N
        jMenu1.setText("Cargar Rutas");
        jMenu1.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N

        cargarArchivo.setBackground(new java.awt.Color(56, 1, 57));
        cargarArchivo.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        cargarArchivo.setForeground(new java.awt.Color(254, 254, 254));
        cargarArchivo.setText("Arhivo");
        cargarArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cargarArchivoMousePressed(evt);
            }
        });
        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(cargarArchivo);

        jMenuBar1.add(jMenu1);

        BuscarRutas.setBackground(new java.awt.Color(62, 57, 34));
        BuscarRutas.setForeground(new java.awt.Color(1, 225, 205));
        BuscarRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Imagenes/localizar.png"))); // NOI18N
        BuscarRutas.setText("Buscar Ruta");
        BuscarRutas.setFont(new java.awt.Font("URW Bookman L", 1, 24)); // NOI18N
        BuscarRutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarRutasMouseClicked(evt);
            }
        });
        BuscarRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarRutasActionPerformed(evt);
            }
        });
        jMenuBar1.add(BuscarRutas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarArchivoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarArchivoMousePressed

    }//GEN-LAST:event_cargarArchivoMousePressed

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(imgFilter);
        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.CANCEL_OPTION) {
            File fileName = fileChooser.getSelectedFile();
            if ((fileName == null) || (fileName.getName().equals(""))) {
            } else {
                
                LectorArchivo lector = new LectorArchivo();
                try {
                     if(lector.IdentificarDatos(fileName.getAbsolutePath())){
                        
                        datos = lector.getDatos();
                         System.out.println(datos.size()+ "tam datos");
                        JOptionPane.showMessageDialog(null, "Las Rutas se Han Cargado Con Exito ");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error Cargando Rutas ");
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Error Cargando Rutas ");
                }
                // txt.setText(fileName.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_cargarArchivoActionPerformed

    private void BuscarRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarRutasActionPerformed
   
    }//GEN-LAST:event_BuscarRutasActionPerformed

    private void BuscarRutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarRutasMouseClicked
         ElegirMedio elegir = new ElegirMedio(this);
        if(datos!= null){
            elegir.setVisible(true);
            panelPrincipal.removeAll();
            
            if(!elegir.isVisible()){
                System.out.println("entro");
                panelPrincipal.setVisible(false);
                panelPrincipal.setLayout(new GridLayout(1, 1));
                Ventana1 ventana =new Ventana1(datos);
                panelPrincipal.add(ventana);
                panelPrincipal.repaint();
                panelPrincipal.setVisible(true);
                
                this.repaint();
            }  else{
                System.out.println(" nadaaa");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debe Cargar Rutas Primero");
        }
        
    }//GEN-LAST:event_BuscarRutasMouseClicked
     private void Diseño(){
        setTitle("WAZE GUATEMALA");
        setLocation(400,0);
        ImageIcon portada = new ImageIcon("waze.png");
        this.setIconImage(new ImageIcon("waze.png").getImage());
        setLocationRelativeTo(null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BuscarRutas;
    private javax.swing.JMenuItem cargarArchivo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}