/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangtl.ui;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import khangtl.daos.BooksDAO;
import khangtl.dtos.BooksDTO;

/**
 *
 * @author Peter
 */
public class Main extends javax.swing.JFrame {

    DefaultListModel listModel;
    ArrayList checkBookCode = new ArrayList();
    ArrayList<BooksDTO> bookList = new ArrayList<>();
    Vector publisherYearList = new Vector();
    int bookIndex = -1;

    /**
     * Creates new form Main
     */
    public Main() throws Exception {
        initComponents();
        // Popup confirm dialog before exit program
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int close = JOptionPane.showConfirmDialog(null, "Do you want to close program?", "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (close == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                }
            }
        });

        updateData();
    }

    public void updateData() throws Exception {
        BooksDAO dao = new BooksDAO();
        bookList = dao.fetchBooks();
        listModel = new DefaultListModel();

        for (int i = 0; i < bookList.size(); i++) {
            checkBookCode.add(bookList.get(i).getCode());
            listModel.addElement(bookList.get(i).getName());
            listModel.getElementAt(i);
        }

        listBook.setModel(listModel);

        for (int j = 1900; j < 2021; j++) {
            publisherYearList.add(j);
        }
        comboBox.setModel(new DefaultComboBoxModel<>(publisherYearList));

        resetData();

        // None of data
        if (bookList == null) {
            JOptionPane.showMessageDialog(this, "Your data is empty");
        }
    }

    private void getSelectedComboBox(BooksDTO dto) {
        // Get selected combo box
        int index = -1;
        for (int i = 0; i < publisherYearList.size(); i++) {
            if (dto.getPublisherYear() == (int) publisherYearList.get(i)) {
                index = i;
            }
        }
        comboBox.setSelectedIndex(index);
    }

    private void resetData() {
        // Reset display data in text field
        txtCode.setText("");
        txtName.setText("");
        txtAuthor.setText("");
        txtPublisher.setText("");
        comboBox.setSelectedIndex(0);
        checkBox.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBook = new javax.swing.JList<>();
        codeLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        authorLbl = new javax.swing.JLabel();
        publisherLbl = new javax.swing.JLabel();
        publisherYearLbl = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        checkBox = new javax.swing.JCheckBox();
        saveBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(750, 250));

        listLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        listLbl.setText("Book list");
        listLbl.setToolTipText("");

        listBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listBook);

        codeLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        codeLbl.setText("Book code");

        nameLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nameLbl.setText("Book name");

        authorLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        authorLbl.setText("Author");

        publisherLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        publisherLbl.setText("Publisher");

        publisherYearLbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        publisherYearLbl.setText("Publisher year");

        checkBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        checkBox.setText("For rent");

        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        removeBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeLbl)
                                    .addComponent(nameLbl)
                                    .addComponent(authorLbl)
                                    .addComponent(publisherLbl))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(txtAuthor)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(publisherYearLbl)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkBox)
                                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(saveBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(removeBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(exitBtn)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codeLbl)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameLbl)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(authorLbl)
                                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(publisherLbl))
                            .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publisherYearLbl)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(checkBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBtn)
                            .addComponent(removeBtn)
                            .addComponent(exitBtn))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        String code = txtCode.getText();
        String name = txtName.getText();
        String author = txtAuthor.getText();
        String publisher = txtPublisher.getText();
        if (code.isEmpty() || name.isEmpty() || author.isEmpty() || publisher.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your input is empty, try again");
            return;
        }
        int publisherYear = (int) comboBox.getSelectedItem();
        boolean forRent = checkBox.isSelected();
        BooksDAO dao = new BooksDAO();
        // Insert when book's new code is detected
        if (!checkBookCode.contains(code)) {
            try {
                boolean checkInsert = dao.insertNewBook(code, name, author, publisher, publisherYear, forRent);
                if (checkInsert) {
                    JOptionPane.showMessageDialog(this, "New book added succesful");
                    // Update new data
                    updateData();
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // Update when book's old code is detected
        else {
            try {
                boolean checkUpdate = dao.updateNewBook(code, name, author, publisher, publisherYear, forRent);
                if (checkUpdate) {
                    // Remove element in list model
                    listModel.removeElementAt(bookIndex);
                    listModel.add(bookIndex, name);
                    listBook.setModel(listModel);
                    JOptionPane.showMessageDialog(this, "Updated book successful");
                    // Update new data
                    updateData();
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void listBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBookMouseClicked
        // TODO add your handling code here:
        // Display text when select book in JList
        bookIndex = listBook.getSelectedIndex();
        BooksDTO dto = bookList.get(bookIndex);
        txtCode.setText(dto.getCode());
        txtName.setText(dto.getName());
        txtAuthor.setText(dto.getAuthor());
        txtPublisher.setText(dto.getPublisher());
        checkBox.setSelected(dto.isForRent());
        getSelectedComboBox(dto);
    }//GEN-LAST:event_listBookMouseClicked

    // Action event after remove one book
    private void listBookMouseClicked(ActionEvent evt) {
        bookIndex = listBook.getSelectedIndex();
        BooksDTO dto = bookList.get(bookIndex);
        txtCode.setText(dto.getCode());
        txtName.setText(dto.getName());
        txtAuthor.setText(dto.getAuthor());
        txtPublisher.setText(dto.getPublisher());
        checkBox.setSelected(dto.isForRent());
        getSelectedComboBox(dto);
    }

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        if (listBook.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Please choose book you want to delete");
        } else {
            BooksDAO dao = new BooksDAO();
            // Show dialog to confirm delete item
            int confirmDelete = JOptionPane.showConfirmDialog(null, "Do you want to delete this item?", "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (confirmDelete == JOptionPane.YES_OPTION) {
                // Execute delete item
                boolean checkDelete;
                try {
                    String code = txtCode.getText();
                    checkDelete = dao.deleteBook(code);
                    if (checkDelete) {
                        JOptionPane.showMessageDialog(this, "Book deleted succesful");
                        updateData();
                        listBook.setSelectedIndex(0);
                        listBookMouseClicked(evt);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_removeBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        int close = JOptionPane.showConfirmDialog(null, "Do you want to close program?", "", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (close == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_exitBtnActionPerformed

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
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLbl;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JLabel codeLbl;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton exitBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listBook;
    private javax.swing.JLabel listLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel publisherLbl;
    private javax.swing.JLabel publisherYearLbl;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPublisher;
    // End of variables declaration//GEN-END:variables

}
