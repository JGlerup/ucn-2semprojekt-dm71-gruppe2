/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIGetEmployee.java
 *
 * Created on 10-01-2011, 10:24:44
 */
package GUILayer;

import ControlLayer.CtrEmp;
import ControlLayer.CtrLoca;
import ModelLayer.Employee;
import java.util.ArrayList;

/**
 *
 * @author Erik M. Gravesen
 */
public class GUIGetEmployee extends javax.swing.JPanel {

    /** Creates new form GUIGetEmployee */
    public GUIGetEmployee() {
        initComponents();
    }

    public void populateCmbEmployee() {
        CtrEmp ctrEmp = new CtrEmp();
        ArrayList<Employee> employeeList = ctrEmp.getAllEmployee();
        cmbSelectEmployee.removeAllItems();
        cmbSelectEmployee.insertItemAt("Vælg her", 0);
        for (Employee e : employeeList) {
            cmbSelectEmployee.addItem(e);
        }
        cmbSelectEmployee.removeItem("Vælg her");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lblGetEmployee = new javax.swing.JLabel();
        cmbSelectEmployee = new javax.swing.JComboBox();
        lblFirstName = new javax.swing.JLabel();
        txtEmployeeFirstName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtEmployeeAddress = new javax.swing.JTextField();
        lblMiddleName = new javax.swing.JLabel();
        txtEmployeeMiddleName = new javax.swing.JTextField();
        lblZipCode = new javax.swing.JLabel();
        txtEmployeeZipCode = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtEmployeeLastName = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtEmployeeCity = new javax.swing.JTextField();
        lblSsn = new javax.swing.JLabel();
        txtEmployeeJobTitle = new javax.swing.JTextField();
        lblManagerNo = new javax.swing.JLabel();
        txtEmployeeManagerNo = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmployeeEmail = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        txtEmployeeEmployeeNo = new javax.swing.JTextField();
        lblPhoneNo = new javax.swing.JLabel();
        txtEmployeePhoneNo = new javax.swing.JTextField();

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGetEmployee.setText("Hent medarbejder");

        cmbSelectEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectEmployeeItemStateChanged(evt);
            }
        });

        lblFirstName.setText("Fornavn");

        txtEmployeeFirstName.setEditable(false);

        lblAddress.setText("Adresse");

        txtEmployeeAddress.setEditable(false);

        lblMiddleName.setText("Mellemnavn");

        txtEmployeeMiddleName.setEditable(false);

        lblZipCode.setText("Postnummer");

        txtEmployeeZipCode.setEditable(false);

        lblLastName.setText("Efternavn");

        txtEmployeeLastName.setEditable(false);

        lblCity.setText("By");

        txtEmployeeCity.setEditable(false);

        lblSsn.setText("Personnummer");

        txtEmployeeJobTitle.setEditable(false);

        lblManagerNo.setText("Leder nummer");

        txtEmployeeManagerNo.setEditable(false);

        lblEmail.setText("E-mail");

        txtEmployeeEmail.setEditable(false);

        lblUserName.setText("Brugernavn");

        txtEmployeeEmployeeNo.setEditable(false);

        lblPhoneNo.setText("Telefonnummer");

        txtEmployeePhoneNo.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGetEmployee)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmployeeAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(lblAddress))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblZipCode))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeCity, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCity))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeManagerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblManagerNo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeEmployeeNo, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(lblUserName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtEmployeeFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbSelectEmployee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblFirstName))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMiddleName))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLastName))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSsn))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoneNo)
                            .addComponent(txtEmployeePhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(80, 80, 80))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGetEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSelectEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(lblMiddleName)
                    .addComponent(lblLastName)
                    .addComponent(lblSsn)
                    .addComponent(lblEmail)
                    .addComponent(lblPhoneNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeePhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(lblZipCode)
                            .addComponent(lblCity)
                            .addComponent(lblManagerNo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmployeeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmployeeZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmployeeCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmployeeManagerNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmployeeEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(457, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 966, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelectEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectEmployeeItemStateChanged
        // TODO add your handling code here:
        CtrLoca ctrLoca = new CtrLoca();
        Employee emplo = (Employee) cmbSelectEmployee.getSelectedItem();
        if (emplo != null) {
            txtEmployeeFirstName.setText(emplo.getFirstName());
            txtEmployeeMiddleName.setText(emplo.getMiddleName());
            txtEmployeeLastName.setText(emplo.getLastName());
            txtEmployeeEmail.setText(emplo.getEmail());
            txtEmployeePhoneNo.setText(Integer.toString(emplo.getPhoneNo()));
            txtEmployeeAddress.setText(emplo.getAddress());
            txtEmployeeZipCode.setText(Integer.toString(ctrLoca.findLocation(emplo.getLocation().getLocationID()).getZipCode()));
            txtEmployeeCity.setText(ctrLoca.findLocation(emplo.getLocation().getLocationID()).getCity());
            txtEmployeeManagerNo.setText(emplo.getManagerNo());
//            txtEmployeePassword.setText(emplo.getPassword());
            txtEmployeeJobTitle.setText(emplo.getJobTitle());
            txtEmployeeEmployeeNo.setText(emplo.getEmployeeNo());
        } else {
            System.out.println("No employees to select from");
        }
}//GEN-LAST:event_cmbSelectEmployeeItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSelectEmployee;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGetEmployee;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblManagerNo;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblSsn;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JTextField txtEmployeeAddress;
    private javax.swing.JTextField txtEmployeeCity;
    private javax.swing.JTextField txtEmployeeEmail;
    private javax.swing.JTextField txtEmployeeEmployeeNo;
    private javax.swing.JTextField txtEmployeeFirstName;
    private javax.swing.JTextField txtEmployeeJobTitle;
    private javax.swing.JTextField txtEmployeeLastName;
    private javax.swing.JTextField txtEmployeeManagerNo;
    private javax.swing.JTextField txtEmployeeMiddleName;
    private javax.swing.JTextField txtEmployeePhoneNo;
    private javax.swing.JTextField txtEmployeeZipCode;
    // End of variables declaration//GEN-END:variables
}
