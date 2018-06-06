/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.frames;

import ehealthpro.daoimpls.EmployeeTypeDAOImpl;
import ehealthpro.daoimpls.SpecializationDAOImpl;
import ehealthpro.daoimpls.UserPermissionDAOImpl;
import ehealthpro.models.PermissionModel;
import ehealthpro.models.SpecializationModel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sweng
 */
public class SpecializationFrame extends javax.swing.JFrame {

    /**
     * Creates new form SpecializationFrame
     */
    Integer specializationId;
    public SpecializationFrame() {
        initComponents();
        fillSpecializationTable();
        this.setTitle("Specialization || E-Health Pro");
        this.setResizable(false);
        addButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        checkPermissions();
        resetAddButton();
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
        jLabel2 = new javax.swing.JLabel();
        specializationTextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        specializationTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel1.setText("Specialization");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Specialization Name : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, 22));

        specializationTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        specializationTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                specializationTextfieldKeyReleased(evt);
            }
        });
        jPanel1.add(specializationTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 306, 29));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Specialization Record :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        specializationTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        specializationTable.setModel(new javax.swing.table.DefaultTableModel(
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
        specializationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                specializationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(specializationTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1290, 340));

        backButton.setBackground(new java.awt.Color(153, 0, 0));
        backButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/back.png"))); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(null);
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
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 580));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/add.png"))); // NOI18N
        addButton.setText("Add Record");
        addButton.setBorder(null);
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
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 200, 50));

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/update.png"))); // NOI18N
        updateButton.setText("Update Record");
        updateButton.setBorder(null);
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
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 210, 50));

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/trash.png"))); // NOI18N
        deleteButton.setText("Delete Record");
        deleteButton.setBorder(null);
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
        jPanel2.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 210, 50));

        clearFieldsButton.setBackground(new java.awt.Color(255, 255, 255));
        clearFieldsButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        clearFieldsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/clearFields.png"))); // NOI18N
        clearFieldsButton.setText("Clear All Fields");
        clearFieldsButton.setBorder(null);
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
        jPanel2.add(clearFieldsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 210, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 580, 1340, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(specializationTextfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please add specialization name to add.");
        }else{
            String specialization = specializationTextfield.getText();
            SpecializationDAOImpl specializationDAOImpl = new SpecializationDAOImpl();
            SpecializationModel specializationModel = new SpecializationModel();
            specializationModel.setName(specialization);
            int result = specializationDAOImpl.addSpecialization(specializationModel);
            if(result>0)
           {
               JOptionPane.showMessageDialog(this, result+" record has been added successfully.");
           }else{
               JOptionPane.showMessageDialog(this,"Record could not added,try again.");
           }
           fillSpecializationTable();
           clearAllFields();
           addButton.setEnabled(true);
           updateButton.setEnabled(false);
           deleteButton.setEnabled(false);
           clearFieldsButton.setEnabled(false);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String specialization = specializationTextfield.getText();
        SpecializationDAOImpl specializationDAOImpl = new SpecializationDAOImpl();
        SpecializationModel specializationModel = new SpecializationModel();
        specializationModel.setName(specialization);
        int result = specializationDAOImpl.updateSpecialization(specializationModel);
        if(result>0)
        {
           JOptionPane.showMessageDialog(this, result+" record has been updated successfully.");
        }else{
           JOptionPane.showMessageDialog(this,"Record could not be updated,try again.");
        }
        fillSpecializationTable();
        clearAllFields();
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        clearFieldsButton.setEnabled(false);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String specialization = specializationTextfield.getText();
        SpecializationDAOImpl specializationDAOImpl = new SpecializationDAOImpl();
        SpecializationModel specializationModel = new SpecializationModel();
        specializationModel.setName(specialization);
        specializationModel.setSpecializationId(specializationId);
        int result = specializationDAOImpl.deleteSpecialization(specializationModel);
        if(result>0)
        {
           JOptionPane.showMessageDialog(this, result+" record has been deleted successfully.");
        }else{
           JOptionPane.showMessageDialog(this,"Record could not be deleted,try again.");
        }
        fillSpecializationTable();
        clearAllFields();
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        clearFieldsButton.setEnabled(false);       
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void specializationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_specializationTableMouseClicked
        specializationId = (Integer) specializationTable.getValueAt(specializationTable.getSelectedRow(), 0);
        SpecializationModel specializationModel = new SpecializationDAOImpl().getSpecializationById(specializationId);
        specializationTextfield.setText(specializationModel.getName());
        setButtons();
    }//GEN-LAST:event_specializationTableMouseClicked

    private void specializationTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_specializationTextfieldKeyReleased
        if(specializationTextfield.getText().equals(""))
        {
            clearAllFields();
        }
    }//GEN-LAST:event_specializationTextfieldKeyReleased

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new MainMenuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseMoved
        if(addButton.isEnabled())
        {
            addButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_addButtonMouseMoved

    private void updateButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseMoved
        if(updateButton.isEnabled())
        {
            updateButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_updateButtonMouseMoved

    private void deleteButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseMoved
        if(deleteButton.isEnabled())
        {
            deleteButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_deleteButtonMouseMoved

    private void clearFieldsButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearFieldsButtonMouseMoved
        clearFieldsButton.setForeground(Color.red);
    }//GEN-LAST:event_clearFieldsButtonMouseMoved

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved
        backButton.setForeground(Color.red);
    }//GEN-LAST:event_backButtonMouseMoved

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
      addButton.setForeground(resetColor());
      updateButton.setForeground(resetColor());
      deleteButton.setForeground(resetColor());
      clearFieldsButton.setForeground(resetColor());
      backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
      addButton.setForeground(resetColor());
      updateButton.setForeground(resetColor());
      deleteButton.setForeground(resetColor());
      clearFieldsButton.setForeground(resetColor());
      backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel1MouseMoved

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
            java.util.logging.Logger.getLogger(SpecializationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpecializationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpecializationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpecializationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpecializationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable specializationTable;
    private javax.swing.JTextField specializationTextfield;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void fillSpecializationTable() {
        ResultSet resultSet = new SpecializationDAOImpl().getAllSpecializations();
        specializationTable.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void clearAllFields() {
        specializationTextfield.setText("");
        specializationTable.clearSelection();
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
            
    }
    private Color resetColor()
    {
        return Color.BLACK;
    }

    private void setButtons() {
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }
    private void resetAddButton()
    {
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    
    private void checkPermissions() {
        ResultSet assignedPermissions = new UserPermissionDAOImpl().getAssignedPermissions(LoginFrame.userType); 
        try {
            while(assignedPermissions.next())
            {
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermission(assignedPermissions.getString("Permission"));
                
                if(permissionModel.getPermission().equals("ADD_SPECIALIZATION"))
                {
                    addButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("DELETE_SPECIALIZATION"))
                {
                    deleteButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("UPDATE_SPECIALIZATION"))
                {
                    updateButton.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
