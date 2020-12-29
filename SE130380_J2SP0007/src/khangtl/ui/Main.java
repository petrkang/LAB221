/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangtl.ui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Peter
 */
public class Main extends javax.swing.JFrame {

    int size = 14, style = 0;
    int selectedFontIndex;
    Vector listFontName = new Vector();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] fonts = ge.getAvailableFontFamilyNames();

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        for (String font : fonts) {
            listFontName.add(font);
        }
        listFont.setModel(new DefaultComboBoxModel<>(listFontName));
        selectedFontIndex = listFont.getSelectedIndex();
        secondLbl.setFont(new Font(fonts[selectedFontIndex], style, size));
        secondLbl.setText("The quick brown fox jumps over the lazy dog");
        firstLbl.setFont(new Font(fonts[selectedFontIndex], style, size));
        firstLbl.setText(MessageFormat.format("The text is in {0}", listFontName.get(selectedFontIndex)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        listFont = new javax.swing.JComboBox<>();
        secondLbl = new javax.swing.JLabel();
        firstLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(700, 400));
        setResizable(false);

        jLabel1.setText("Select font family");

        listFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listFontActionPerformed(evt);
            }
        });

        secondLbl.setText("jLabel2");

        firstLbl.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstLbl)
                    .addComponent(secondLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(listFont, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(firstLbl)
                .addGap(31, 31, 31)
                .addComponent(secondLbl)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listFontActionPerformed
        // TODO add your handling code here:
        selectedFontIndex = listFont.getSelectedIndex();
        secondLbl.setFont(new Font(fonts[selectedFontIndex], style, size));
        secondLbl.setText("The quick brown fox jumps over the lazy dog");
        firstLbl.setFont(new Font(fonts[selectedFontIndex], style, size));
        firstLbl.setText(MessageFormat.format("The text is in {0}", listFontName.get(selectedFontIndex)));
    }//GEN-LAST:event_listFontActionPerformed

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
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firstLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> listFont;
    private javax.swing.JLabel secondLbl;
    // End of variables declaration//GEN-END:variables
}