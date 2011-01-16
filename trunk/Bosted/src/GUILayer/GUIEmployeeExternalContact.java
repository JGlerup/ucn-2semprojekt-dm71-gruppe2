/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIEmployeeExternalContact.java
 *
 * Created on 13-01-2011, 11:38:03
 */

package GUILayer;

import ControlLayer.CtrExtCon;
import ControlLayer.CtrLoca;
import ModelLayer.ExternalContact;
import ModelLayer.Location;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Glerup
 */
public class GUIEmployeeExternalContact extends javax.swing.JPanel {

    /** Creates new form GUIEmployeeExternalContact */
    public GUIEmployeeExternalContact() {
        initComponents();
    }

    public void populateCmbEmployeeExtCon() {
        CtrExtCon ctrExtCon = new CtrExtCon();
        ArrayList<ExternalContact> employeeExtConList = ctrExtCon.getAllExternalContacts();
        cmbEmployeeExtCon.removeAllItems();
        cmbEmployeeExtCon.insertItemAt("Vælg her", 0);
        for (ExternalContact ec : employeeExtConList) {
            cmbEmployeeExtCon.addItem(ec);
        }
        cmbEmployeeExtCon.removeItem("Vælg her");
    }

    public void resetAllGuiElements() {
        populateCmbEmployeeExtCon();
        JTextField[] txtFieldList = {
            txtEmployeeExtConAddress,
            txtEmployeeExtConCity,
            txtEmployeeExtConEmail,
            txtEmployeeExtConFirstName,
            txtEmployeeExtConOccupation,
            txtEmployeeExtConLastName,
            txtEmployeeExtConMiddleName,
            txtEmployeeExtConPhoneNo,
            txtEmployeeExtConCVR,
            txtEmployeeExtConZipCode,};

        resetTextFields(txtFieldList);

    }

    public void resetTextFields(JTextField[] textFields) {
        for (JTextField txtField : textFields) {
            txtField.setText("");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblGetEmployee = new javax.swing.JLabel();
        cmbEmployeeExtCon = new javax.swing.JComboBox();
        lblFirstname = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblSsn = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        txtEmployeeExtConFirstName = new javax.swing.JTextField();
        txtEmployeeExtConMiddleName = new javax.swing.JTextField();
        txtEmployeeExtConLastName = new javax.swing.JTextField();
        txtEmployeeExtConCVR = new javax.swing.JTextField();
        txtEmployeeExtConEmail = new javax.swing.JTextField();
        txtEmployeeExtConPhoneNo = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblZipCode = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblJobTitle = new javax.swing.JLabel();
        txtEmployeeExtConAddress = new javax.swing.JTextField();
        txtEmployeeExtConZipCode = new javax.swing.JTextField();
        txtEmployeeExtConCity = new javax.swing.JTextField();
        txtEmployeeExtConOccupation = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnResetAllExtCon = new javax.swing.JButton();
        btnCreateEmployeeExtCon = new javax.swing.JButton();
        btnUpdateExtCon = new javax.swing.JButton();
        btnDeleteExtCon = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGetEmployee.setText("Hent ekstern kontakt");

        cmbEmployeeExtCon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmployeeExtConItemStateChanged(evt);
            }
        });

        lblFirstname.setText("Fornavn");

        lblMiddleName.setText("Mellemnavn");

        lblLastName.setText("Efternavn");

        lblSsn.setText("CVR");

        lblEmail.setText("E-mail");

        lblPhoneNo.setText("Telefonnummer");

        lblAddress.setText("Adresse");

        lblZipCode.setText("Postnummer");

        lblCity.setText("By");

        lblJobTitle.setText("Job titel");

        txtEmployeeExtConCity.setEditable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnResetAllExtCon.setText("Nulstil felter");
        btnResetAllExtCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllExtConActionPerformed(evt);
            }
        });

        btnCreateEmployeeExtCon.setText("Opret");
        btnCreateEmployeeExtCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeExtConActionPerformed(evt);
            }
        });

        btnUpdateExtCon.setText("Opdater");
        btnUpdateExtCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateExtConActionPerformed(evt);
            }
        });

        btnDeleteExtCon.setText("Slet");
        btnDeleteExtCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteExtConActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGetEmployee)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmployeeExtConFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbEmployeeExtCon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFirstname))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeExtConMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMiddleName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeExtConLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeExtConCVR, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSsn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeExtConEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoneNo)
                            .addComponent(txtEmployeeExtConPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmployeeExtConAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(lblAddress))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeExtConZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblZipCode))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeExtConCity, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCity))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJobTitle)
                            .addComponent(txtEmployeeExtConOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(503, Short.MAX_VALUE)
                .addComponent(btnResetAllExtCon)
                .addGap(18, 18, 18)
                .addComponent(btnCreateEmployeeExtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateExtCon)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteExtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGetEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEmployeeExtCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstname)
                    .addComponent(lblMiddleName)
                    .addComponent(lblLastName)
                    .addComponent(lblSsn)
                    .addComponent(lblEmail)
                    .addComponent(lblPhoneNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeExtConFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeExtConMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeExtConLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeExtConCVR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeExtConEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeExtConPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(lblZipCode)
                            .addComponent(lblCity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmployeeExtConAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmployeeExtConZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmployeeExtConCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJobTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmployeeExtConOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteExtCon)
                    .addComponent(btnUpdateExtCon)
                    .addComponent(btnCreateEmployeeExtCon)
                    .addComponent(btnResetAllExtCon))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEmployeeExtConItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmployeeExtConItemStateChanged
        // TODO add your handling code here:
        CtrLoca ctrLoca = new CtrLoca();
        ExternalContact ec = (ExternalContact) cmbEmployeeExtCon.getSelectedItem();
        if (ec != null) {
            Location l = ctrLoca.findLocation(ec.getLocation().getLocationID());
            txtEmployeeExtConFirstName.setText(ec.getFirstName());
            txtEmployeeExtConMiddleName.setText(ec.getMiddleName());
            txtEmployeeExtConLastName.setText(ec.getLastName());
            txtEmployeeExtConCVR.setText(ec.getCbr());
            txtEmployeeExtConEmail.setText(ec.getEmail());
            txtEmployeeExtConPhoneNo.setText(Integer.toString(ec.getPhoneNo()));
            txtEmployeeExtConAddress.setText(ec.getAddress());
            txtEmployeeExtConZipCode.setText(Integer.toString(l.getZipCode()));
            txtEmployeeExtConCity.setText(l.getCity());
            txtEmployeeExtConOccupation.setText(ec.getOccupation());
        } else {
            System.out.println("No external contacts to select from");
        }
}//GEN-LAST:event_cmbEmployeeExtConItemStateChanged

    private void btnResetAllExtConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAllExtConActionPerformed
        // TODO add your handling code here:
        resetAllGuiElements();
}//GEN-LAST:event_btnResetAllExtConActionPerformed

    private void btnCreateEmployeeExtConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeExtConActionPerformed
        // TODO add your handling code here:
        String address = txtEmployeeExtConAddress.getText();
        String email = txtEmployeeExtConEmail.getText();
        String firstName = txtEmployeeExtConFirstName.getText();
        String middleName = txtEmployeeExtConMiddleName.getText();
        String lastName = txtEmployeeExtConLastName.getText();
        int phoneNo = Integer.parseInt(txtEmployeeExtConPhoneNo.getText());
        String occupation = txtEmployeeExtConOccupation.getText();
        String cvr = txtEmployeeExtConCVR.getText();
        int zipCode = Integer.parseInt(txtEmployeeExtConZipCode.getText());

        CtrExtCon ctrExtCon = new CtrExtCon();
        CtrLoca ctrLoca = new CtrLoca();
        try {
            Location location = ctrLoca.findLocationByZipCode(zipCode);
            ctrExtCon.insertExternalContact(occupation, cvr, firstName, middleName, lastName, address, location, phoneNo, email);
            JOptionPane.showMessageDialog(this, "Du har nu oprettet den eksterne kontakt med navnet: " + firstName + " " + lastName);
            populateCmbEmployeeExtCon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}//GEN-LAST:event_btnCreateEmployeeExtConActionPerformed

    private void btnUpdateExtConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateExtConActionPerformed
        // TODO add your handling code here:
        ExternalContact extCon = (ExternalContact) cmbEmployeeExtCon.getSelectedItem();
        String address = txtEmployeeExtConAddress.getText();
        String email = txtEmployeeExtConEmail.getText();
        String firstName = txtEmployeeExtConFirstName.getText();
        String middleName = txtEmployeeExtConMiddleName.getText();
        String lastName = txtEmployeeExtConLastName.getText();
        int phoneNo = Integer.parseInt(txtEmployeeExtConPhoneNo.getText());
        String occupation = txtEmployeeExtConOccupation.getText();
        String cvr = txtEmployeeExtConCVR.getText();
        int zipCode = Integer.parseInt(txtEmployeeExtConZipCode.getText());

        CtrExtCon ctrExtCon = new CtrExtCon();
        CtrLoca ctrLoca = new CtrLoca();
        try {
            Location location = ctrLoca.findLocationByZipCode(zipCode);
            ctrExtCon.updateExternalContact(extCon.getExternalContactID(), cvr, occupation, firstName, middleName, lastName, address, location, phoneNo, email);
            JOptionPane.showMessageDialog(this, "Du har nu opdateret den eksterne kontakt med navnet: " + firstName + " " + lastName);
            populateCmbEmployeeExtCon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}//GEN-LAST:event_btnUpdateExtConActionPerformed

    private void btnDeleteExtConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteExtConActionPerformed
        // TODO add your handling code here:
        try {
            ExternalContact extCon = (ExternalContact) cmbEmployeeExtCon.getSelectedItem();
            int extConID = extCon.getExternalContactID();
            CtrExtCon ctrExtCon = new CtrExtCon();
            ExternalContact ec = ctrExtCon.findExternalContact(extConID);
            if (ec == null) {
                JOptionPane.showMessageDialog(this, "Den eksterne kontakt kunne ikke findes");
            } else {
                ctrExtCon.deleteExternalContact(extConID);
                JOptionPane.showMessageDialog(this, "Du har nu slettet den eksterne kontakt med navnet: " + ec.getFirstName() + " " + ec.getLastName());
                populateCmbEmployeeExtCon();
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}//GEN-LAST:event_btnDeleteExtConActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateEmployeeExtCon;
    private javax.swing.JButton btnDeleteExtCon;
    private javax.swing.JButton btnResetAllExtCon;
    private javax.swing.JButton btnUpdateExtCon;
    private javax.swing.JComboBox cmbEmployeeExtCon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblGetEmployee;
    private javax.swing.JLabel lblJobTitle;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblSsn;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JTextField txtEmployeeExtConAddress;
    private javax.swing.JTextField txtEmployeeExtConCVR;
    private javax.swing.JTextField txtEmployeeExtConCity;
    private javax.swing.JTextField txtEmployeeExtConEmail;
    private javax.swing.JTextField txtEmployeeExtConFirstName;
    private javax.swing.JTextField txtEmployeeExtConLastName;
    private javax.swing.JTextField txtEmployeeExtConMiddleName;
    private javax.swing.JTextField txtEmployeeExtConOccupation;
    private javax.swing.JTextField txtEmployeeExtConPhoneNo;
    private javax.swing.JTextField txtEmployeeExtConZipCode;
    // End of variables declaration//GEN-END:variables

}