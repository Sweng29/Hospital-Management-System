/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.frames;

import ehealthpro.daoimpls.BloodGroupDAOImpl;
import ehealthpro.daoimpls.UserPermissionDAOImpl;
import ehealthpro.models.BloodGroupModel;
import ehealthpro.models.PermissionModel;
import ehealthpro.models.RoomTypeModel;
import ehealthpro.models.WardModel;
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
public class BloodGroupFrame extends javax.swing.JFrame {

    /**
     * Creates new form BloodGroupNewFrame
     */
    Integer bloodGroupId;

    public BloodGroupFrame() {
        initComponents();
        fillBloodGroupTable();
        this.setTitle("Blood Groups || E-Health Pro");
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

        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bloodGroupTextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bloodGroupTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setToolTipText("");
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel6MouseMoved(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 164, 1316, -1));

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/trash.png"))); // NOI18N
        deleteButton.setText("Delete Blood Group");
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
        jPanel6.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 238, -1));

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/update.png"))); // NOI18N
        updateButton.setText("Update Blood Group");
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
        jPanel6.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 240, -1));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ehealthpro/images/add.png"))); // NOI18N
        addButton.setText("Add Blood Group");
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
        jPanel6.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 220, -1));

        clearFieldsButton.setBackground(new java.awt.Color(255, 255, 255));
        clearFieldsButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
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
        jPanel6.add(clearFieldsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 210, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1330, 110));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 255));
        jPanel1.setToolTipText("");
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

        bloodGroupTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bloodGroupTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bloodGroupTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodGroupTextfieldActionPerformed(evt);
            }
        });
        jPanel1.add(bloodGroupTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 306, 34));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Blood Group : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 130, 36));

        bloodGroupTable.setModel(new javax.swing.table.DefaultTableModel(
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
        bloodGroupTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloodGroupTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bloodGroupTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1270, 300));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Blood Group Details ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

        backButton.setBackground(new java.awt.Color(153, 0, 0));
        backButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
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
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 40));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Blood Group Details");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseMoved
        if (addButton.isEnabled()) {
            addButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_addButtonMouseMoved

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (bloodGroupTextfield.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please insert blood group to add record.");
        } else {
            String getBloodGroup = bloodGroupTextfield.getText();
            BloodGroupDAOImpl bloodGroupDAOImpl = new BloodGroupDAOImpl();
            BloodGroupModel bloodGroupModel = new BloodGroupModel();
            bloodGroupModel.setBloodGroup(getBloodGroup);
            bloodGroupModel.setCreatedBy(2);
            bloodGroupModel.setModifiedBy(2);
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            bloodGroupModel.setCreatedDate(currentTime);
            bloodGroupModel.setModifiedDate(currentTime);
            int result = bloodGroupDAOImpl.addBloodGroup(bloodGroupModel);
            if(result>0)
            {
                JOptionPane.showMessageDialog(this, result+" has been added to record.");
            }else{
                JOptionPane.showMessageDialog(this, "Could not add record try again.");
            }
            clearAllFields();
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            clearFieldsButton.setEnabled(false);
            fillBloodGroupTable();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseMoved
        if (updateButton.isEnabled()) {
            updateButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_updateButtonMouseMoved

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (bloodGroupTextfield.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please provide valid information to update.");
        } else {
            String getBloodGroup = bloodGroupTextfield.getText();
            BloodGroupDAOImpl bloodGroupDAOImpl = new BloodGroupDAOImpl();
            BloodGroupModel bloodGroupModel = new BloodGroupModel();
            bloodGroupModel.setBloodGroup(getBloodGroup);
            bloodGroupModel.setBloodGroupId(bloodGroupId);
            bloodGroupModel.setModifiedBy(2);
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            bloodGroupModel.setModifiedDate(currentDate);
            Integer result = bloodGroupDAOImpl.updateBloodGroup(bloodGroupModel);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, result + " record has been updated.");
            } else {
                JOptionPane.showMessageDialog(this, result + " record could not updated.");
            }
            clearAllFields();
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            clearFieldsButton.setEnabled(false);
            addButton.setEnabled(true);
            fillBloodGroupTable();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved
        backButton.setForeground(Color.red);
    }//GEN-LAST:event_backButtonMouseMoved

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new MainMenuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseMoved
        if (deleteButton.isEnabled()) {
            deleteButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_deleteButtonMouseMoved

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
            BloodGroupDAOImpl bloodGroupDAOImpl = new BloodGroupDAOImpl();
            BloodGroupModel bloodGroupModel = new BloodGroupModel();
            bloodGroupModel.setBloodGroupId(bloodGroupId);
            bloodGroupModel.setModifiedBy(2);
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            bloodGroupModel.setModifiedDate(currentDate);
            Integer result = bloodGroupDAOImpl.deleteBloodGroup(bloodGroupModel);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, result + " record has been deleted.");
            } else {
                JOptionPane.showMessageDialog(this, result + " record could not deleted.");
            }
            clearAllFields();
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            clearFieldsButton.setEnabled(false);
            addButton.setEnabled(true);
            fillBloodGroupTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearFieldsButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearFieldsButtonMouseMoved
        if (clearFieldsButton.isEnabled()) {
            clearFieldsButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_clearFieldsButtonMouseMoved

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void bloodGroupTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bloodGroupTableMouseClicked
        bloodGroupId = (Integer) bloodGroupTable.getValueAt(bloodGroupTable.getSelectedRow(), 0);
        BloodGroupDAOImpl bloodGroupDAOImpl = new BloodGroupDAOImpl();
        BloodGroupModel bloodGroupModel = bloodGroupDAOImpl.getBloodGroupById(bloodGroupId);
        if (bloodGroupModel != null) {
            bloodGroupTextfield.setText(bloodGroupModel.getBloodGroup());
        }
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        clearFieldsButton.setEnabled(true);
    }//GEN-LAST:event_bloodGroupTableMouseClicked

    private void bloodGroupTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodGroupTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodGroupTextfieldActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        clearAllFields();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel6MouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
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
            java.util.logging.Logger.getLogger(BloodGroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodGroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodGroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodGroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodGroupFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable bloodGroupTable;
    private javax.swing.JTextField bloodGroupTextfield;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void clearAllFields() {
        bloodGroupTextfield.setText("");
        bloodGroupTable.clearSelection();
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private Color resetColor() {
        return Color.BLACK;
    }

    private void fillBloodGroupTable() {
        BloodGroupDAOImpl bloodGroupDAOImpl = new BloodGroupDAOImpl();
        ResultSet resultSet = bloodGroupDAOImpl.getAllBloodGroups();
        bloodGroupTable.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
    
    private void checkPermissions() {
        ResultSet assignedPermissions = new UserPermissionDAOImpl().getAssignedPermissions(LoginFrame.userType); 
        try {
            while(assignedPermissions.next())
            {
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermission(assignedPermissions.getString("Permission"));
                
                if(permissionModel.getPermission().equals("ADD_BLOOD_GROUP"))
                {
                    addButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("DELETE_BLOOD_GROUP"))
                {
                    deleteButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("UPDATE_BLOOD_GROUP"))
                {
                    updateButton.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setButton() {
        addButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
     private void resetAddButton()
    {
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
}
