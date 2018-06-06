/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.frames;

import ehealthpro.daoimpls.EquipmentTypeDAOImpl;
import ehealthpro.daoimpls.UserPermissionDAOImpl;
import ehealthpro.models.EquipmentTypeModel;
import ehealthpro.models.PermissionModel;
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
public class EquipmentTypeFrame extends javax.swing.JFrame {

    /**
     * Creates new form EquipmentTypeFrame
     */
    Integer equipmentId = null;
    Timestamp currentDate = new Timestamp(System.currentTimeMillis());

    public EquipmentTypeFrame() {
        initComponents();
        fillEquipmentTypeTable();
        addButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        resetAddButton();
        this.setTitle("Equipment Type Frame || E-Health Pro");
        this.setResizable(false);
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
        jLabel2 = new javax.swing.JLabel();
        equipmentNameTextfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        equipmentTypeTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel1.setText("Equipment Type");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Equipment Name : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, 27));

        equipmentNameTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(equipmentNameTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 290, 30));

        equipmentTypeTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        equipmentTypeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        equipmentTypeTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                equipmentTypeTableMouseMoved(evt);
            }
        });
        equipmentTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipmentTypeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(equipmentTypeTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1220, 300));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Equipment Type Table : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

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
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 510));

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
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 230, 50));

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
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 210, 50));

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
        jPanel2.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 220, 50));

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
        jPanel2.add(clearFieldsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 220, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1270, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (equipmentNameTextfield.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please insert equipment Type to add record.");
        } else {
            String equipmentName = equipmentNameTextfield.getText();
            currentDate = new Timestamp(System.currentTimeMillis());
            EquipmentTypeModel equipmentTypeModel = new EquipmentTypeModel();
            equipmentTypeModel.setName(equipmentName);
            equipmentTypeModel.setCreatedBy(1);
            equipmentTypeModel.setCreatedDate(currentDate);
            equipmentTypeModel.setModifiedBy(1);
            equipmentTypeModel.setModifiedDate(currentDate);
            EquipmentTypeDAOImpl equipmentTypeDAOImpl = new EquipmentTypeDAOImpl();
            int result = equipmentTypeDAOImpl.addEquipmentType(equipmentTypeModel);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, result + " record has been successfully added.");
                fillEquipmentTypeTable();
            } else {
                JOptionPane.showMessageDialog(this, result + " record could not be added,try again.");
            }
            clearAllFields();
            resetAddButton();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String equipmentName = equipmentNameTextfield.getText();
        currentDate = new Timestamp(System.currentTimeMillis());
        EquipmentTypeModel equipmentTypeModel = new EquipmentTypeModel();
        equipmentTypeModel.setName(equipmentName);
        equipmentTypeModel.setModifiedBy(2);
        equipmentTypeModel.setModifiedDate(currentDate);
        equipmentTypeModel.setEquipmentTypeId(equipmentId);
        EquipmentTypeDAOImpl equipmentTypeDAOImpl = new EquipmentTypeDAOImpl();
        int result = equipmentTypeDAOImpl.updateEquipmentType(equipmentTypeModel);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, result + " record has been successfully updated.");
            fillEquipmentTypeTable();
        } else {
            JOptionPane.showMessageDialog(this, result + " record could not be updated,try again.");
        }
        clearAllFields();
        resetAddButton();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        currentDate = new Timestamp(System.currentTimeMillis());
        EquipmentTypeModel equipmentTypeModel = new EquipmentTypeModel();
        equipmentTypeModel.setModifiedBy(2);
        equipmentTypeModel.setModifiedDate(currentDate);
        equipmentTypeModel.setEquipmentTypeId(equipmentId);
        EquipmentTypeDAOImpl equipmentTypeDAOImpl = new EquipmentTypeDAOImpl();
        int result = equipmentTypeDAOImpl.deleteEquipmentTypeById(equipmentTypeModel);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, result + " record has been successfully deleted.");
            fillEquipmentTypeTable();
        } else {
            JOptionPane.showMessageDialog(this, result + " record could not be deleted,try again.");
        }
        clearAllFields();
        resetAddButton();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void equipmentTypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTypeTableMouseClicked
        equipmentId = (Integer) equipmentTypeTable.getValueAt(equipmentTypeTable.getSelectedRow(), 0);
        EquipmentTypeModel equipmentTypeModel = new EquipmentTypeDAOImpl().getEquipmentTypeById(equipmentId);
        equipmentNameTextfield.setText(equipmentTypeModel.getName());
        setButtons();
    }//GEN-LAST:event_equipmentTypeTableMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void addButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseMoved
        if (addButton.isEnabled()) {
            addButton.setForeground(Color.red);
        }       
    }//GEN-LAST:event_addButtonMouseMoved

    private void updateButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseMoved
        if (updateButton.isEnabled()) {
            updateButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_updateButtonMouseMoved

    private void deleteButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseMoved
        if (deleteButton.isEnabled()) {
            deleteButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_deleteButtonMouseMoved

    private void clearFieldsButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearFieldsButtonMouseMoved
        if (clearFieldsButton.isEnabled()) {
            clearFieldsButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_clearFieldsButtonMouseMoved

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved
        if (backButton.isEnabled()) {
            backButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_backButtonMouseMoved

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel2MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void equipmentTypeTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTypeTableMouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_equipmentTypeTableMouseMoved

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
            java.util.logging.Logger.getLogger(EquipmentTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipmentTypeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField equipmentNameTextfield;
    private javax.swing.JTable equipmentTypeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void manufacturerTableMouseClicked(java.awt.event.MouseEvent evt) {
        equipmentId = (Integer) equipmentTypeTable.getValueAt(equipmentTypeTable.getSelectedRow(), 0);
        EquipmentTypeModel equipmentTypeModel = new EquipmentTypeDAOImpl().getEquipmentTypeById(equipmentId);
        equipmentNameTextfield.setText(equipmentTypeModel.getName());
        setButtons();
    }

    private void fillEquipmentTypeTable() {
        ResultSet resultset = new EquipmentTypeDAOImpl().getAllEquipmentType();
        equipmentTypeTable.setModel(DbUtils.resultSetToTableModel(resultset));
    }

    private void clearAllFields() {
        equipmentNameTextfield.setText("");
        equipmentTypeTable.clearSelection();
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private Color resetColor() {
        return Color.BLACK;
    }

    private void setButtons() {
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    private void resetAddButton() {
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
                
                if(permissionModel.getPermission().equals("ADD_EQUIPMENT_TYPE"))
                {
                    addButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("DELETE_EQUIPMENT_TYPE"))
                {
                    deleteButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("UPDATE_EQUIPMENT_TYPE"))
                {
                    updateButton.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
