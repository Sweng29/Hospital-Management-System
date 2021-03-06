/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ehealthpro.frames;

import ehealthpro.daoimpls.AppointmentDAOImpl;
import ehealthpro.daoimpls.EmployeeDAOImpl;
import ehealthpro.daoimpls.OperationDAOImpl;
import ehealthpro.daoimpls.OperationResultDAOImpl;
import ehealthpro.daoimpls.PatientDAOImpl;
import ehealthpro.daoimpls.UserPermissionDAOImpl;
import ehealthpro.models.AppointmentModel;
import ehealthpro.models.OperationModel;
import ehealthpro.models.OperationResultModel;
import ehealthpro.models.PatientModel;
import ehealthpro.models.PermissionModel;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sweng
 */
public class OperationResultFrame extends javax.swing.JFrame {

    /**
     * Creates new form OperationResult
     */
    Integer operationResultId;
    Timestamp currentDate = new Timestamp(System.currentTimeMillis());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static String patientName = "";
    Integer patientId;
    Integer doctorId;
    Integer appointmentId;
    public OperationResultFrame() {
        initComponents();
        fillOperationResultComboBox();
        fillOperationResultTable();
        this.setTitle("Operation Result || E-Health Pro");
        this.setResizable(false);
        disableComponents();
        checkPermissions();
        fillAppointmentTable();
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

        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearFieldsButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        operationResultTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        operationTypeComboBox = new javax.swing.JComboBox<>();
        resultComboBox = new javax.swing.JComboBox<>();
        statusComboBox = new javax.swing.JComboBox<>();
        operationDateChooser = new com.toedter.calendar.JDateChooser();
        feesStatusComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        appointmentTextfield = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 220, 50));

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
        jPanel3.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 210, 50));

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
        jPanel3.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 220, 50));

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
        jPanel3.add(clearFieldsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, 210, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 1320, 110));

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
        jLabel1.setText("Operation Result");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 360, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Status :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, 70, 27));

        operationResultTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        operationResultTable.setModel(new javax.swing.table.DefaultTableModel(
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
        operationResultTable.setRowHeight(20);
        operationResultTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                operationResultTableMouseMoved(evt);
            }
        });
        operationResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                operationResultTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(operationResultTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1290, 170));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Operation Result Table : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Fees Status :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, -1, 27));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Appointment By :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 27));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText("Operation Date :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 27));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Operation Type :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, 27));

        operationTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        operationTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Operation Type" }));
        jPanel1.add(operationTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 260, 30));

        resultComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resultComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Result", "Successful", "Unsuccessful" }));
        jPanel1.add(resultComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 260, 30));

        statusComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Done", "Pending" }));
        jPanel1.add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 260, 30));

        operationDateChooser.setDateFormatString("yyyy-MM-dd HH:mm:ss");
        jPanel1.add(operationDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 250, 30));

        feesStatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        feesStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Fees Status", "Paid", "Unpaid" }));
        jPanel1.add(feesStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 160, 260, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("Result :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, 27));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setText("Appointments Table :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 30));

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        appointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(appointmentTable);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1290, 180));

        appointmentTextfield.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(appointmentTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 250, 30));

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
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseMoved
        if (updateButton.isEnabled()) {
            updateButton.setForeground(Color.red);
        }
    }//GEN-LAST:event_updateButtonMouseMoved

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String operationResult = resultComboBox.getSelectedItem().toString();
        String feesStatus;
        if (statusComboBox.getSelectedItem().toString().equals("Select Status")) {
            JOptionPane.showMessageDialog(this, "Please fill status field to add record.");
        }else if(operationDateChooser.getDate().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill operation date field to add record.");
        }else if(operationTypeComboBox.getSelectedItem().toString().equals("Select Operation Type"))
        {
            JOptionPane.showMessageDialog(this, "Please select an operation type to add record.");
        }
        else {
        String status = statusComboBox.getSelectedItem().toString();
        Timestamp operationDate = Timestamp.valueOf(sdf.format(operationDateChooser.getDate()));
        if(resultComboBox.getSelectedItem().toString().equals("Select Result"))
        {
                    operationResult = "";
        }else{
            operationResult = resultComboBox.getSelectedItem().toString();
        }
        if(feesStatusComboBox.getSelectedItem().toString().equals("Select Result"))
        {
                    feesStatus = "";
        }else{
            feesStatus = feesStatusComboBox.getSelectedItem().toString();
        }
        String operation = operationTypeComboBox.getSelectedItem().toString();
        OperationModel operationModel = new OperationDAOImpl().getOperationByName(operation);
        currentDate = new Timestamp(System.currentTimeMillis());
        AppointmentModel appointmentModel = new AppointmentDAOImpl().getAppointmentByName(patientName);
        OperationResultModel operationResultModel = new OperationResultModel();
        operationResultModel.setOperationDate(operationDate);
        operationResultModel.setOperationModel(operationModel);
        operationResultModel.setAppointmentModel(appointmentModel);
        operationResultModel.setResult(operationResult);
        operationResultModel.setStatus(status);
        operationResultModel.setFeesStatus(feesStatus);
        operationResultModel.setModifiedBy(2);
        operationResultModel.setModifiedDate(currentDate);
        operationResultModel.setOperationResultId(operationResultId);
        OperationResultDAOImpl operationResultDAOImpl = new OperationResultDAOImpl();
        int result = operationResultDAOImpl.updateOperationResult(operationResultModel);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, result + " record has been successfully updated.");
            fillOperationResultTable();
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
        String operationResult = resultComboBox.getSelectedItem().toString();
        if(operationTypeComboBox.getSelectedItem().toString().equals("Select Operation Type"))
        {
            JOptionPane.showMessageDialog(this, "Please select an operation type to add record.");
        }else if(operationDateChooser.getCalendar().toString().equals(null))
        {
            JOptionPane.showMessageDialog(this, "Please fill operation date field to add record.");
        }else if(appointmentTextfield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select patient name from appointment table to add record.");
        }
        else {
        String status = "";
        Timestamp operationDate = Timestamp.valueOf(sdf.format(operationDateChooser.getDate()));
        operationResult = "";
        String feesStatus = "";
        String operation = operationTypeComboBox.getSelectedItem().toString();
        OperationModel operationModel = new OperationDAOImpl().getOperationByName(operation);
        currentDate = new Timestamp(System.currentTimeMillis());
        AppointmentModel appointmentModel = new AppointmentModel();
        if(appointmentId==null)
        {
            JOptionPane.showMessageDialog(this, "Please select appointment from appointment Table to add record.");
        }else
        {
            appointmentModel = new AppointmentDAOImpl().getAppointmentById(appointmentId);
        }
        OperationResultModel operationResultModel = new OperationResultModel();
        operationResultModel.setOperationDate(operationDate);
        operationResultModel.setOperationModel(operationModel);
        operationResultModel.setAppointmentModel(appointmentModel);
        operationResultModel.setResult(operationResult);
        operationResultModel.setStatus(status);
        operationResultModel.setFeesStatus(feesStatus);
        operationResultModel.setCreatedBy(1);
        operationResultModel.setCreatedDate(currentDate);
        operationResultModel.setModifiedBy(1);
        operationResultModel.setModifiedDate(currentDate);
        OperationResultDAOImpl operationResultDAOImpl = new OperationResultDAOImpl();
        int result = operationResultDAOImpl.addOperationResult(operationResultModel);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, result + " record has been successfully added.");
            fillOperationResultTable();
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
        currentDate = new Timestamp(System.currentTimeMillis());
        OperationResultModel operationResultModel = new OperationResultModel();
        operationResultModel.setOperationResultId(operationResultId);
        operationResultModel.setModifiedBy(2);
        operationResultModel.setModifiedDate(currentDate);
        int result = new OperationResultDAOImpl().deleteOperationResultById(operationResultModel);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, result + " record has been successfully deleted.");
            fillOperationResultTable();
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

    private void operationResultTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_operationResultTableMouseMoved
        addButton.setForeground(resetColor());
        deleteButton.setForeground(resetColor());
        updateButton.setForeground(resetColor());
        clearFieldsButton.setForeground(resetColor());
        backButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_operationResultTableMouseMoved

    private void operationResultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_operationResultTableMouseClicked
        operationResultId = (Integer) operationResultTable.getValueAt(operationResultTable.getSelectedRow(), 0);
        OperationResultModel operationResultModel = new OperationResultDAOImpl().getOperationResultById(operationResultId);
        statusComboBox.setSelectedItem(operationResultModel.getStatus());
        operationDateChooser.setDate(operationResultModel.getOperationDate());
        appointmentTextfield.setText(operationResultModel.getAppointmentModel().getPatientModel().getName());
        if(operationResultModel.getResult().equals(""))
        {
           resultComboBox.setSelectedIndex(0);
        }else{
           resultComboBox.setSelectedItem(operationResultModel.getResult()); 
        }
        statusComboBox.setSelectedItem(operationResultModel.getStatus());
        operationTypeComboBox.setSelectedItem(operationResultModel.getOperationModel().getType());
        if(operationResultModel.getFeesStatus().equals(""))
        {
            feesStatusComboBox.setSelectedIndex(0);
        }else{
           feesStatusComboBox.setSelectedItem(operationResultModel.getFeesStatus()); 
        }
        setButtons();
    }//GEN-LAST:event_operationResultTableMouseClicked

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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new MainMenuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void appointmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTableMouseClicked
        appointmentId = (Integer) appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 0);
        AppointmentModel appointmentModel = new AppointmentDAOImpl().getAppointmentById(appointmentId);
        patientName = appointmentModel.getPatientModel().getName();
        appointmentTextfield.setText(patientName);
    }//GEN-LAST:event_appointmentTableMouseClicked

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
            java.util.logging.Logger.getLogger(OperationResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationResultFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JTextField appointmentTextfield;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> feesStatusComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser operationDateChooser;
    private javax.swing.JTable operationResultTable;
    private javax.swing.JComboBox<String> operationTypeComboBox;
    private javax.swing.JComboBox<String> resultComboBox;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void fillOperationResultComboBox() {
        ResultSet resultSet = new OperationDAOImpl().getAllOperations();
        try{
            while(resultSet.next())
            {
                operationTypeComboBox.addItem(resultSet.getString("Operation Type"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void fillOperationResultTable() {
        ResultSet resultSet = new OperationResultDAOImpl().getOperationResults();
        operationResultTable.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
    
    private void clearAllFields() {
        operationDateChooser.setDate(null);
        resultComboBox.setSelectedIndex(0);
        statusComboBox.setSelectedIndex(0);
        operationTypeComboBox.setSelectedIndex(0);
        feesStatusComboBox.setSelectedIndex(0);
        operationResultTable.clearSelection();
        appointmentTextfield.setText("");
        appointmentTable.clearSelection();
        resetAddButton();
    }

    private Color resetColor() {
        return Color.BLACK;
    }

    private void setButtons() {
        addButton.setEnabled(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
        clearFieldsButton.setEnabled(true);
        resultComboBox.setEnabled(true);
        statusComboBox.setEnabled(true);
        feesStatusComboBox.setEnabled(true);
    }

    private void resetAddButton() {
        addButton.setEnabled(true);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(false);
        resultComboBox.setEnabled(false);
        statusComboBox.setEnabled(false);
        feesStatusComboBox.setEnabled(false);
    }
    
    private void checkPermissions() {
        ResultSet assignedPermissions = new UserPermissionDAOImpl().getAssignedPermissions(LoginFrame.userType); 
        try {
            while(assignedPermissions.next())
            {
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setPermission(assignedPermissions.getString("Permission"));
                
                if(permissionModel.getPermission().equals("ADD_OPERATION_RESULT"))
                {
                    addButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("DELETE_OPERATION_RESULT"))
                {
                    deleteButton.setVisible(true);
                }
                if(permissionModel.getPermission().equals("UPDATE_OPERATION_RESULT"))
                {
                    updateButton.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void fillAppointmentTable() {
        ResultSet resultSet = new AppointmentDAOImpl().getAllAppointments();
        appointmentTable.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void disableComponents() {
        addButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
        resultComboBox.setEnabled(false);
        statusComboBox.setEnabled(false);
        feesStatusComboBox.setEnabled(false);
    }
}
