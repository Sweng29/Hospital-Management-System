/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.frames;

import ehealthpro.daoimpls.EmployeeTypeDAOImpl;
import ehealthpro.daoimpls.UserPermissionDAOImpl;
import ehealthpro.models.EmployeeTypeModel;
import ehealthpro.models.PermissionModel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
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
public class EmployeeTypeFrame extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeTypeNewFrame
     */
    Integer employeeId;
    public EmployeeTypeFrame() {
        initComponents();
        fillEmployeeTypeTable();
        this.setTitle("Employee Type Frame || E-Pro Health care");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTypeTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        employeeTypeTextfield = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 255));
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

        employeeTypeTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeTypeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        employeeTypeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        employeeTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTypeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTypeTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1300, 340));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Employee Type");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setText("Employee Type Details");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        employeeTypeTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeTypeTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeTypeTextfieldActionPerformed(evt);
            }
        });
        employeeTypeTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employeeTypeTextfieldKeyReleased(evt);
            }
        });
        jPanel1.add(employeeTypeTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 290, 30));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("Employee Type :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, 30));

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
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 590));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setToolTipText("");
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

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, 1320, -1));

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
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 270, -1));

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
        jPanel2.add(clearFieldsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, 270, -1));

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
        jPanel2.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 270, -1));

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
        jPanel2.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 270, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1330, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeTypeTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeTypeTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeTypeTextfieldActionPerformed

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

    private void employeeTypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTypeTableMouseClicked
        employeeId = (Integer) employeeTypeTable.getValueAt(employeeTypeTable.getSelectedRow(), 0);
        EmployeeTypeDAOImpl employeeTypeDAOImpl = new EmployeeTypeDAOImpl();
        EmployeeTypeModel employeeTypeModel = employeeTypeDAOImpl.getEmployeeTypeById(employeeId);
        employeeTypeTextfield.setText(employeeTypeModel.getEmployeeType());
        setButtons();
    }//GEN-LAST:event_employeeTypeTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       if(employeeTypeTextfield.getText().equals(""))
       {
           JOptionPane.showMessageDialog(this, "Insert employee type to add record.");
       }else{
           String employeeType = employeeTypeTextfield.getText();
           EmployeeTypeDAOImpl employeeTypeDAOImpl = new EmployeeTypeDAOImpl();
           EmployeeTypeModel employeeTypeModel = new EmployeeTypeModel();
           employeeTypeModel.setEmployeeType(employeeType);
           Timestamp currentDate = new Timestamp(System.currentTimeMillis());
           employeeTypeModel.setCreatedDate(currentDate);
           employeeTypeModel.setModifiedDate(currentDate);
           Integer result = employeeTypeDAOImpl.addEmployeeType(employeeTypeModel);
           if(result>0)
           {
               JOptionPane.showMessageDialog(this, result+" record has been added successfully.");
           }else{
               JOptionPane.showMessageDialog(this,"Record could not added,try again.");
           }
           fillEmployeeTypeTable();
           clearAllFields();
       }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if(employeeTypeTextfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please insert employee type to update record.");
        }else{
            String employeeType = employeeTypeTextfield.getText();
            EmployeeTypeDAOImpl employeeTypeDAOImpl = new EmployeeTypeDAOImpl();
            EmployeeTypeModel employeeTypeModel = new EmployeeTypeModel();
            employeeTypeModel.setEmployeeTypeId(employeeId);
            employeeTypeModel.setEmployeeType(employeeType);
            int result = employeeTypeDAOImpl.updateEmployeeType(employeeTypeModel);
            if(result>0)
            {
                JOptionPane.showMessageDialog(this, result+" record has been updated.");
            }else{
                JOptionPane.showMessageDialog(this, "Could not update record,try again.");
            }
            fillEmployeeTypeTable();
            clearAllFields();
            resetAddButton();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new MainMenuFrame().setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_backButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(employeeTypeTextfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please insert employee type to update record.");
        }else{
            String employeeType = employeeTypeTextfield.getText();
            EmployeeTypeDAOImpl employeeTypeDAOImpl = new EmployeeTypeDAOImpl();
            EmployeeTypeModel employeeTypeModel = new EmployeeTypeModel();
            employeeTypeModel.setEmployeeTypeId(employeeId);
            employeeTypeModel.setEmployeeType(employeeType);
            int result = employeeTypeDAOImpl.deleteEmployeeType(employeeTypeModel);
            if(result>0)
            {
                JOptionPane.showMessageDialog(this, result+" record has been deleted.");
            }else{
                JOptionPane.showMessageDialog(this, "Could not delete record,try again.");
            }
            fillEmployeeTypeTable();
            clearAllFields();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        clearAllFields();
        resetAddButton();
        employeeTypeTable.clearSelection();
        addButton.setForeground(resetColor());
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        clearAllFields();
        employeeTypeTable.clearSelection();
        addButton.setForeground(resetColor());
    }//GEN-LAST:event_jPanel2MouseClicked

    private void employeeTypeTextfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeTypeTextfieldKeyReleased
        if(employeeTypeTextfield.getText().equals(""))
        {
            resetAddButton();
            employeeTypeTable.clearSelection();
        }
    }//GEN-LAST:event_employeeTypeTextfieldKeyReleased

    private void addButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseMoved
        if(addButton.isEnabled()){
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
        if(clearFieldsButton.isEnabled())
        {
           clearFieldsButton.setForeground(Color.red); 
        }
    }//GEN-LAST:event_clearFieldsButtonMouseMoved

    private void backButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseMoved
       backButton.setForeground(Color.red); 
    }//GEN-LAST:event_backButtonMouseMoved

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
            java.util.logging.Logger.getLogger(EmployeeTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeTypeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeTypeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable employeeTypeTable;
    private javax.swing.JTextField employeeTypeTextfield;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void fillEmployeeTypeTable() {
        ResultSet resultSet = new EmployeeTypeDAOImpl().getAllEmployeeTypes();
        employeeTypeTable.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void clearAllFields() {
        employeeTypeTextfield.setText("");
        employeeTypeTable.clearSelection();
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        resetAddButton();
    }
    private Color resetColor()
    {
        return Color.BLACK;
    }
    
    public void setButtons() {
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
                
                if(permissionModel.getPermission().equals("ADD_EMPLOYEE_TYPE"))
                {
                    addButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("DELETE_EMPLOYEE_TYPE"))
                {
                    deleteButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("UPDATE_EMPLOYEE_TYPE"))
                {
                    updateButton.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
