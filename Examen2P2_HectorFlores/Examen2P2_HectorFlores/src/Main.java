
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author hecto
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        generateObject();
    }
    
    PSNUsers users;
    
    public void generateObject() throws IOException{
        users = new PSNUsers();    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addUser = new javax.swing.JButton();
        deactivate = new javax.swing.JButton();
        addTrophy = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jLabel1.setText("Menu de PSN");

        addUser.setBackground(new java.awt.Color(51, 204, 255));
        addUser.setForeground(new java.awt.Color(0, 0, 0));
        addUser.setText("Registrar Usuario");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        deactivate.setBackground(new java.awt.Color(51, 204, 255));
        deactivate.setForeground(new java.awt.Color(0, 0, 0));
        deactivate.setText("Desactivar Usuario");
        deactivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactivateActionPerformed(evt);
            }
        });

        addTrophy.setBackground(new java.awt.Color(51, 204, 255));
        addTrophy.setForeground(new java.awt.Color(0, 0, 0));
        addTrophy.setText("Entregar Trofeo");
        addTrophy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrophyActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 204, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Informacion de Jugador");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(51, 204, 255));
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addUser)
                    .addComponent(jLabel1)
                    .addComponent(deactivate)
                    .addComponent(addTrophy)
                    .addComponent(jButton4)
                    .addComponent(salir))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deactivate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTrophy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salir)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        String username = JOptionPane.showInputDialog("Ingrese el username que desea registrar");
        
        try {
            users.addUser(username);
        } catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_addUserActionPerformed

    private void deactivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactivateActionPerformed
        String username = JOptionPane.showInputDialog("Ingrese el username que desea desactivar");
        
        try {
            users.deactivateUser(username);
        } catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_deactivateActionPerformed

    private void addTrophyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrophyActionPerformed
        String username = JOptionPane.showInputDialog("Ingrese el username que gano un trofeo");
        String trophyGame = JOptionPane.showInputDialog("Ingrese el nombre del juego");
        String trophyName = JOptionPane.showInputDialog("Ingrese el nombre del trofeo");
        String trophyType = JOptionPane.showInputDialog("Ingrese el tipo del trofeo\n"
                + "-Platino\n-Oro\n-Plata\n-Bronce");
        
        while (true){
            if (trophyType.equalsIgnoreCase("platino") || trophyType.equalsIgnoreCase("oro") || trophyType.equalsIgnoreCase("plata") || trophyType.equalsIgnoreCase("bronce")){
                break;
            } else {
                trophyType = JOptionPane.showInputDialog("Ingrese un tipo correcto de trofeo\n"
                    + "-Platino\n-Oro\n-Plata\n-Bronce");
            }
        }
        
        trophyType = trophyType.toUpperCase();
        
        try {
            users.addTrophyTo(username, trophyGame, trophyName, Trophy.valueOf(trophyType));
        } catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_addTrophyActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String username = JOptionPane.showInputDialog("Ingrese el username del que quiere ver la info");
        
        try {
            users.playerInfo(username);
        } catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTrophy;
    private javax.swing.JButton addUser;
    private javax.swing.JButton deactivate;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}