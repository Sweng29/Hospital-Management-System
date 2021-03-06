/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.frames;

import ehealthpro.daoimpls.PatientDAOImpl;
import ehealthpro.daoimpls.PermissionDAOImpl;
import ehealthpro.daoimpls.ScreenViewDAOImpl;
import ehealthpro.daoimpls.UserPermissionDAOImpl;
import ehealthpro.models.PermissionModel;
import ehealthpro.models.ScreenViewModel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sweng
 */
public class PermissionFrame extends javax.swing.JFrame {

    /**
     * Creates new form PermissionFrame
     */
    Integer permissionId;
    Timestamp currentDate = new Timestamp(System.currentTimeMillis());
    public PermissionFrame() {
        initComponents();
        fillPermissionTable();
        fillScreenViewComboBox();
        this.setTitle("Permission || E-Health Pro");
        this.setResizable(false);
        addButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        checkPermissions();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        permissionTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        permissionTextfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        screenViewComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Permission");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 230, 50));

        permissionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        permissionTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                permissionTableMouseMoved(evt);
            }
        });
        permissionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permissionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(permissionTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1280, 390));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Permissions Record : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        permissionTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(permissionTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 290, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Permission :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, 27));

        screenViewComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Screen View" }));
        jPanel1.add(screenViewComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 290, 30));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Screen View : ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, 27));

        backButton.setBackground(new java.awt.Color(153, 0, 0));
        backButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        backButton.setContentAreaFilled(false);
        backButton.setOpaque(true);
        backButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                backButtonMouseMoved(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 630));

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/add.png"))); // NOI18N
        addButton.setText("Add Record");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addButton.setContentAreaFilled(false);
        addButton.setOpaque(true);
        addButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                addButtonMouseMoved(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 220, 50));

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/update.png"))); // NOI18N
        updateButton.setText("Update Record");
        updateButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        updateButton.setContentAreaFilled(false);
        updateButton.setOpaque(true);
        updateButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                updateButtonMouseMoved(evt);
            }
        });
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 210, 50));

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/trash.png"))); // NOI18N
        deleteButton.setText("Delete Record");
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        deleteButton.setContentAreaFilled(false);
        deleteButton.setOpaque(true);
        deleteButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                deleteButtonMouseMoved(evt);
            }
        });
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 230, 50));

        clearFieldsButton.setBackground(new java.awt.Color(255, 255, 255));
        clearFieldsButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        clearFieldsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/clearFields.png"))); // NOI18N
        clearFieldsButton.setText("Clear All Fields");
        clearFieldsButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        clearFieldsButton.setContentAreaFilled(false);
        clearFieldsButton.setOpaque(true);
        clearFieldsButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                clearFieldsButtonMouseMoved(evt);
            }
        });
        clearFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsButtonActionPerformed(evt);
            }
        });
        jPanel3.add(clearFieldsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 220, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1320, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void permissionTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permissionTableMouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_permissionTableMouseMoved

    private void permissionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permissionTableMouseClicked
        permissionId = (Integer) permissionTable.getValueAt(permissionTable.getSelectedRow(), 0);
        PermissionModel permissionModel = new PermissionDAOImpl().getPermissionById(permissionId);
        permissionTextfield.setText(permissionModel.getPermission());
        screenViewComboBox.setSelectedItem(permissionModel.getScreenViewModel().getName());
        setButtons();
    }//GEN-LAST:event_permissionTableMouseClicked

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void updateButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseMoved
        if (updateButton.isEnabled()) {
            updateButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_updateButtonMouseMoved

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (permissionTextfield.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill permission field to update record.");
        } else if (screenViewComboBox.getSelectedItem().toString().equals("Select Screen View")) {
            JOptionPane.showMessageDialog(this, "Please select screen view field to update record.");
        } else {
            String screenView = screenViewComboBox.getSelectedItem().toString();
            String permission = permissionTextfield.getText();
            currentDate = new Timestamp(System.currentTimeMillis());
            ScreenViewModel screenViewModel = new ScreenViewDAOImpl().getScreenViewByName(screenView);
            PermissionModel permissionModel = new PermissionModel();
            permissionModel.setPermission(permission);
            permissionModel.setScreenViewModel(screenViewModel);
            permissionModel.setPermissionId(permissionId);
            permissionModel.setModifiedBy(2);
            permissionModel.setModifiedDate(currentDate);
            PermissionDAOImpl permissionDAOImpl = new PermissionDAOImpl();
            int result = permissionDAOImpl.updatePermission(permissionModel);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, result + " record has been successfully updated.");
                fillPermissionTable();
            } else {
                JOptionPane.showMessageDialog(this, " record could not be updated,try again.");
            }
            clearAllFields();
            resetAddButton();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseMoved
        if (addButton.isEnabled()) {
            addButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_addButtonMouseMoved

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (screenViewComboBox.getSelectedItem().toString().equals("Select Screen View")) {
            JOptionPane.showMessageDialog(this, "Please select Screen View to add record.");
        } else if (permissionTextfield.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill permission field to add record.");
        } else {
            String screenView = screenViewComboBox.getSelectedItem().toString();
            String permission = permissionTextfield.getText();
            currentDate = new Timestamp(System.currentTimeMillis());
            ScreenViewModel screenViewModel = new ScreenViewDAOImpl().getScreenViewByName(screenView);
            PermissionModel permissionModel = new PermissionModel();
            permissionModel.setPermission(permission);
            permissionModel.setScreenViewModel(screenViewModel);
            permissionModel.setCreatedBy(1);
            permissionModel.setCreatedDate(currentDate);
            permissionModel.setModifiedBy(1);
            permissionModel.setModifiedDate(currentDate);
            PermissionDAOImpl permissionDAOImpl = new PermissionDAOImpl();
            int result = permissionDAOImpl.addPermission(permissionModel);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, result + " record has been successfully added.");
                fillPermissionTable();
            } else {
                JOptionPane.showMessageDialog(this, " record could not be added,try again.");
            }
            clearAllFields();
            resetAddButton();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearFieldsButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearFieldsButtonMouseMoved
        if (clearFieldsButton.isEnabled()) {
            clearFieldsButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_clearFieldsButtonMouseMoved

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved
        if (backButton.isEnabled()) {
            backButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_backButtonMouseMoved

    private void deleteButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseMoved
        if (deleteButton.isEnabled()) {
            deleteButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_deleteButtonMouseMoved

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        PermissionModel permissionModel = new PermissionModel();
        permissionModel.setModifiedBy(2);
        permissionModel.setModifiedDate(currentDate);
        permissionModel.setPermissionId(permissionId);
        PermissionDAOImpl permissionDAOImpl = new PermissionDAOImpl();
        int result = permissionDAOImpl.deletePermissionById(permissionModel);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, result + " record has been successfully deleted.");
            fillPermissionTable();
        } else {
            JOptionPane.showMessageDialog(this, " record could not be deleted,try again.");
        }
        clearAllFields();
        resetAddButton();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new MainMenuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PermissionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PermissionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable permissionTable;
    private javax.swing.JTextField permissionTextfield;
    private javax.swing.JComboBox<String> screenViewComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void fillPermissionTable() {
        ResultSet resultSet = new PermissionDAOImpl().getAllPermissions();
        permissionTable.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
    
    private void clearAllFields() {
        permissionTextfield.setText("");
        screenViewComboBox.setSelectedIndex(0);
        permissionTable.clearSelection();
        resetAddButton();
    }

    private Color resetColor() {
        return Color.BLACK;
    }

    public void setButtons() {
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        clearFieldsButton.setEnabled(true);
    }

    private void resetAddButton() {
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        clearFieldsButton.setEnabled(false);
    }

    private void fillScreenViewComboBox() {
        ResultSet resultSet = new ScreenViewDAOImpl().getScreenViews();
        try{
            while(resultSet.next())
            {
                screenViewComboBox.addItem(resultSet.getString("Screen View"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void checkPermissions() {
        ResultSet assignedPermissions = new UserPermissionDAOImpl().getAssignedPermissions(LoginFrame.userType); 
        try {
            while(assignedPermissions.next())
            {
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermission(assignedPermissions.getString("Permission"));
                
                if(permissionModel.getPermission().equals("ADD_PERMISSION"))
                {
                    addButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("DELETE_PERMISSION"))
                {
                    deleteButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("UPDATE_PERMISSION"))
                {
                    updateButton.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
