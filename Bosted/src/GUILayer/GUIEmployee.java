/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIclient.java
 *
 * Created on 09-12-2010, 09:43:32
 */
package GUILayer;

import ControlLayer.CtrEmp;
import ControlLayer.CtrLoca;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.Location;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Glerup
 */
public class GUIEmployee extends javax.swing.JPanel {

    private Employee loggedInEmployee;

    /** Creates new form GUIclient */
    public GUIEmployee() {
        initComponents();

    }

    public Employee getLoggedInEmployee() {
        return loggedInEmployee;
    }

    public void setLoggedInEmployee(Employee loggedInEmployee) {
        this.loggedInEmployee = loggedInEmployee;
    }

    public void disableEmployeeManagement() {
        try {

            tPEmployee.removeAll();
            tPEmployee.addTab("Medarbejderer", gUIGetEmployee1);
        } catch (Exception e) {
        }
    }

    public void enableEmployeeMangement() {
        try {
            tPEmployee.removeAll();
            tPEmployee.addTab("Håndtering", null, jPanel1, "Her opretter, opdateres og slettes");
            tPEmployee.addTab("Medarbejderer", gUIGetEmployee1);
            tPEmployee.addTab("Medarbejdernes klienter", gUIClientAssociateEmployee1);

        } catch (Exception e) {
        }
    }

    public void populateCmbEmployee() {
        CtrEmp ctrEmp = new CtrEmp();
        ArrayList<Employee> employeeList = ctrEmp.getAllEmployee();
        cmbEmployee.removeAllItems();
        cmbEmployee.insertItemAt("Vælg her", 0);
        for (Employee e : employeeList) {
            cmbEmployee.addItem(e);
        }
        cmbEmployee.removeItem("Vælg her");
    }

    public void populateTblAssociatedClients() {
        TableClient tblClient = new TableClient();
        CtrEmp ctrEmp = new CtrEmp();
        Employee e = (Employee) cmbEmployee.getSelectedItem();
        String employeeNo = e.getEmployeeNo();
        ArrayList<Client> clientList = ctrEmp.findEmployee(employeeNo, true).getClientList();
        tblClient.setData(clientList);
        tblAssociatedClients.setModel(tblClient);
        tblAssociatedClients.setAutoCreateRowSorter(true);
    }

    public void clearTblAssociatedClients() {
        TableClient tblClient = new TableClient();
        tblAssociatedClients.setModel(tblClient); //Metoden får en tom tabel som input/parameter
    }

    public void resetAllGuiElements() {
        populateCmbEmployee();
        JTextField[] txtFieldList = {
            txtEmployeeAddress,
            txtEmployeeCity,
            txtEmployeeEmail,
            txtEmployeeEmployeeNo,
            txtEmployeeFirstName,
            txtEmployeeJobTitle,
            txtEmployeeLastName,
            txtEmployeeManagerNo,
            txtEmployeeMiddleName,
            txtEmployeePassword,
            txtEmployeePhoneNo,
            txtEmployeeSsn,
            txtEmployeeZipCode,};
        JCheckBox[] checkBoxList = {
            cbCrudCar,
            cbCrudClient,
            cbCrudEmployee,
            cbCrudMedicine,
            cbInUse};

        resetTextFields(txtFieldList);
        resetCheckBoxes(checkBoxList);

    }

    public void resetTextFields(JTextField[] textFields) {
        for (JTextField txtField : textFields) {
            txtField.setText("");
        }
    }

    public void resetCheckBoxes(JCheckBox[] cbList) {
        for (JCheckBox cb : cbList) {
            cb.setSelected(false);
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

        tPEmployee = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblGetEmployee = new javax.swing.JLabel();
        cmbEmployee = new javax.swing.JComboBox();
        lblFirstname = new javax.swing.JLabel();
        txtEmployeeFirstName = new javax.swing.JTextField();
        txtEmployeeLastName = new javax.swing.JTextField();
        txtEmployeeMiddleName = new javax.swing.JTextField();
        txtEmployeeSsn = new javax.swing.JTextField();
        txtEmployeeEmail = new javax.swing.JTextField();
        txtEmployeeAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtEmployeeZipCode = new javax.swing.JTextField();
        txtEmployeeCity = new javax.swing.JTextField();
        txtEmployeeManagerNo = new javax.swing.JTextField();
        txtEmployeePassword = new javax.swing.JTextField();
        lblMiddleName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblSsn = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblZipCode = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblManagerNo = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtEmployeePhoneNo = new javax.swing.JTextField();
        txtEmployeeJobTitle = new javax.swing.JTextField();
        lblPhoneNo = new javax.swing.JLabel();
        lblJobTitle = new javax.swing.JLabel();
        lblUserPermissions = new javax.swing.JLabel();
        cbCrudClient = new javax.swing.JCheckBox();
        cbCrudMedicine = new javax.swing.JCheckBox();
        cbCrudCar = new javax.swing.JCheckBox();
        cbCrudEmployee = new javax.swing.JCheckBox();
        lblEmployeed = new javax.swing.JLabel();
        cbInUse = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAssociatedClients = new javax.swing.JTable();
        btnCreateEmployee = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        txtEmployeeEmployeeNo = new javax.swing.JTextField();
        btnResetAll = new javax.swing.JButton();
        gUIGetEmployee1 = new GUILayer.GUIGetEmployee();
        gUIClientAssociateEmployee1 = new GUILayer.GUIClientAssociateEmployee();

        tPEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tPEmployeeFocusGained(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblGetEmployee.setText("Hent medarbejder");

        cmbEmployee.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmployeeItemStateChanged(evt);
            }
        });

        lblFirstname.setText("Fornavn");

        lblAddress.setText("Adresse");

        lblMiddleName.setText("Mellemnavn");

        lblLastName.setText("Efternavn");

        lblSsn.setText("Personnummer");

        lblEmail.setText("E-mail");

        lblZipCode.setText("Postnummer");

        lblCity.setText("By");

        lblManagerNo.setText("Leder nummer");

        lblPassword.setText("Password");

        lblPhoneNo.setText("Telefonnummer");

        lblJobTitle.setText("Job titel");

        lblUserPermissions.setText("Tilladelse til (håndtering):");

        cbCrudClient.setText("Klient");

        cbCrudMedicine.setText("Medicin");

        cbCrudCar.setText("Bil");

        cbCrudEmployee.setText("Medarbejder");

        lblEmployeed.setText("Er ansat nu");

        cbInUse.setText("(sæt kryds hvis ja)");

        tblAssociatedClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fornavn", "Mellemnavn", "Efternavn"
            }
        ));
        jScrollPane1.setViewportView(tblAssociatedClients);

        btnCreateEmployee.setText("Opret");
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });

        btnDelete.setText("Slet");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Opdater");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblUsername.setText("Brugernavn");

        btnResetAll.setText("Nulstil felter");
        btnResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGetEmployee)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmployeeFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbEmployee, javax.swing.GroupLayout.Alignment.LEADING, 0, 127, Short.MAX_VALUE))
                            .addComponent(lblFirstname))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMiddleName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSsn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoneNo)
                            .addComponent(txtEmployeePhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmployeeAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(lblAddress)
                            .addComponent(lblUsername)
                            .addComponent(txtEmployeeEmployeeNo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblZipCode)
                                    .addComponent(cbCrudClient, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeCity, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCity)
                                    .addComponent(cbCrudMedicine))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeeManagerNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblManagerNo)
                                    .addComponent(cbCrudCar))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword)
                                    .addComponent(cbCrudEmployee)))
                            .addComponent(lblUserPermissions))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbInUse)
                            .addComponent(lblJobTitle)
                            .addComponent(txtEmployeeJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmployeed)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnResetAll)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCreateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdate)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGetEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstname)
                    .addComponent(lblMiddleName)
                    .addComponent(lblLastName)
                    .addComponent(lblSsn)
                    .addComponent(lblEmail)
                    .addComponent(lblPhoneNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeePhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(lblZipCode)
                    .addComponent(lblCity)
                    .addComponent(lblManagerNo)
                    .addComponent(lblPassword)
                    .addComponent(lblJobTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeManagerNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmployeeJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeed)
                    .addComponent(lblUserPermissions)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbInUse)
                    .addComponent(cbCrudEmployee)
                    .addComponent(cbCrudCar)
                    .addComponent(cbCrudMedicine)
                    .addComponent(cbCrudClient)
                    .addComponent(txtEmployeeEmployeeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnCreateEmployee)
                    .addComponent(btnResetAll))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tPEmployee.addTab("Håndtering", null, jPanel1, "Her opretter, opdateres og slettes");
        tPEmployee.addTab("Medarbejder", gUIGetEmployee1);
        tPEmployee.addTab("Medarbejdernes klienter", gUIClientAssociateEmployee1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tPEmployee)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tPEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tPEmployeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tPEmployeeFocusGained
        // TODO add your handling code here:

        populateCmbEmployee();
        JTextField[] txtFieldList = {txtEmployeeAddress, txtEmployeeCity, txtEmployeeEmail, txtEmployeeEmployeeNo, txtEmployeeFirstName, txtEmployeeMiddleName, txtEmployeeLastName, txtEmployeeJobTitle, txtEmployeeManagerNo, txtEmployeePassword, txtEmployeePhoneNo, txtEmployeeSsn, txtEmployeeZipCode};
        resetTextFields(txtFieldList);
        JCheckBox[] cbList = {cbCrudCar, cbCrudClient, cbCrudEmployee, cbCrudMedicine, cbInUse};
        resetCheckBoxes(cbList);
        gUIClientAssociateEmployee1.populateCmbClient();
        gUIClientAssociateEmployee1.populateCmbEmployee();
        gUIGetEmployee1.populateCmbEmployee();
        clearTblAssociatedClients();
    }//GEN-LAST:event_tPEmployeeFocusGained

    private void btnResetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetAllActionPerformed
        // TODO add your handling code here:
        resetAllGuiElements();
        clearTblAssociatedClients();
}//GEN-LAST:event_btnResetAllActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Employee emp = (Employee) cmbEmployee.getSelectedItem();
        String employeeNoCurrent = emp.getEmployeeNo();
        String employeeNoNew = txtEmployeeEmployeeNo.getText();
        String password = txtEmployeePassword.getText();
        String managerNo = txtEmployeeManagerNo.getText();
        String address = txtEmployeeAddress.getText();
        String city = txtEmployeeCity.getText();
        String email = txtEmployeeEmail.getText();
        String firstName = txtEmployeeFirstName.getText();
        String middleName = txtEmployeeMiddleName.getText();
        String lastName = txtEmployeeLastName.getText();
        int phoneNo = Integer.parseInt(txtEmployeePhoneNo.getText());
        String jobTitle = txtEmployeeJobTitle.getText();
        String ssn = txtEmployeeSsn.getText();
        int zipCode = Integer.parseInt(txtEmployeeZipCode.getText());
        String crudEmployee = "no";
        if (cbCrudEmployee.isSelected()) {
            crudEmployee = "yes";
        }
        String crudClient = "no";
        if (cbCrudClient.isSelected()) {
            crudClient = "yes";
        }
        String crudMedicine = "no";
        if (cbCrudMedicine.isSelected()) {
            crudMedicine = "yes";
        }
        String crudCar = "no";
        if (cbCrudCar.isSelected()) {
            crudCar = "yes";
        }
        String inUse = "no";
        if (cbInUse.isSelected()) {
            inUse = "yes";
        }
        CtrEmp ctrEmp = new CtrEmp();
        CtrLoca ctrLoca = new CtrLoca();
        try {
            Location location = ctrLoca.findLocationByZipCode(zipCode);
            ctrEmp.updateEmp(employeeNoCurrent, employeeNoNew, managerNo, jobTitle, crudClient, crudEmployee, crudMedicine, crudCar, ssn, firstName, middleName, lastName, address, location, phoneNo, email, password, inUse);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String employeeNo = txtEmployeeEmployeeNo.getText();
        CtrEmp ctrEmp = new CtrEmp();
        Employee e = ctrEmp.findEmployee(employeeNo, false);
        if (e.getEmployeeNo() == null) {
            JOptionPane.showMessageDialog(this, "Medarbejderen med brugernavnet " + employeeNo + " kunne ikke findes");
        } else {
            ctrEmp.deleteEmp(employeeNo);
            JOptionPane.showMessageDialog(this, "Du har nu slettet medarbejderen med brugernavn: " + employeeNo);
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed
        // TODO add your handling code here:
        String password = txtEmployeePassword.getText();
        String managerNo = txtEmployeeManagerNo.getText();
        String address = txtEmployeeAddress.getText();
        String city = txtEmployeeCity.getText();
        String email = txtEmployeeEmail.getText();
        String firstName = txtEmployeeFirstName.getText();
        String middleName = txtEmployeeMiddleName.getText();
        String lastName = txtEmployeeLastName.getText();
        int phoneNo = Integer.parseInt(txtEmployeePhoneNo.getText());
        String jobTitle = txtEmployeeJobTitle.getText();
        String ssn = txtEmployeeSsn.getText();
        int zipCode = Integer.parseInt(txtEmployeeZipCode.getText());
        String crudEmployee = "no";
        if (cbCrudEmployee.isSelected()) {
            crudEmployee = "yes";
        }
        String crudClient = "no";
        if (cbCrudClient.isSelected()) {
            crudClient = "yes";
        }
        String crudMedicine = "no";
        if (cbCrudMedicine.isSelected()) {
            crudMedicine = "yes";
        }
        String crudCar = "no";
        if (cbCrudCar.isSelected()) {
            crudCar = "yes";
        }
        String inUse = "no";
        if (cbInUse.isSelected()) {
            inUse = "yes";
        }
        CtrEmp ctrEmp = new CtrEmp();
        CtrLoca ctrLoca = new CtrLoca();
        try {
            Location location = ctrLoca.findLocationByZipCode(zipCode);
            ctrEmp.insert(managerNo, jobTitle, crudClient, crudEmployee, crudMedicine, crudCar, ssn, firstName, middleName, lastName, address, location, phoneNo, email, password, inUse);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void cmbEmployeeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmployeeItemStateChanged
        // TODO add your handling code here:
        CtrLoca ctrLoca = new CtrLoca();
        Employee em = (Employee) cmbEmployee.getSelectedItem();
        if (em != null) {
            txtEmployeeFirstName.setText(em.getFirstName());
            txtEmployeeMiddleName.setText(em.getMiddleName());
            txtEmployeeLastName.setText(em.getLastName());
            txtEmployeeSsn.setText(em.getSsn());
            txtEmployeeEmail.setText(em.getEmail());
            txtEmployeePhoneNo.setText(Integer.toString(em.getPhoneNo()));
            txtEmployeeAddress.setText(em.getAddress());
            txtEmployeeZipCode.setText(Integer.toString(ctrLoca.findLocation(em.getLocation().getLocationID()).getZipCode()));
            txtEmployeeCity.setText(ctrLoca.findLocation(em.getLocation().getLocationID()).getCity());
            txtEmployeeManagerNo.setText(em.getManagerNo());
            txtEmployeePassword.setText(em.getPassword());
            txtEmployeeJobTitle.setText(em.getJobTitle());
            txtEmployeeEmployeeNo.setText(em.getEmployeeNo());
            if (em.getCrudClient().matches("yes")) {
                cbCrudClient.setSelected(true);
            } else {
                cbCrudClient.setSelected(false);
            }
            if (em.getCrudEmployee().matches("yes")) {
                cbCrudEmployee.setSelected(true);
            } else {
                cbCrudEmployee.setSelected(false);
            }
            if (em.getCrudMedicine().matches("yes")) {
                cbCrudMedicine.setSelected(true);
            } else {
                cbCrudMedicine.setSelected(false);
            }
            if (em.getCrudCar().matches("yes")) {
                cbCrudCar.setSelected(true);
            } else {
                cbCrudCar.setSelected(false);
            }
            if (em.getInUse().matches("yes")) {
                cbInUse.setSelected(true);
            } else {
                cbInUse.setSelected(false);
            }
            populateTblAssociatedClients();
        } else {
            System.out.println("No employees to select from");
        }
    }//GEN-LAST:event_cmbEmployeeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnResetAll;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbCrudCar;
    private javax.swing.JCheckBox cbCrudClient;
    private javax.swing.JCheckBox cbCrudEmployee;
    private javax.swing.JCheckBox cbCrudMedicine;
    private javax.swing.JCheckBox cbInUse;
    private javax.swing.JComboBox cmbEmployee;
    private GUILayer.GUIClientAssociateEmployee gUIClientAssociateEmployee1;
    private GUILayer.GUIGetEmployee gUIGetEmployee1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmployeed;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblGetEmployee;
    private javax.swing.JLabel lblJobTitle;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblManagerNo;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblSsn;
    private javax.swing.JLabel lblUserPermissions;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JTabbedPane tPEmployee;
    private javax.swing.JTable tblAssociatedClients;
    private javax.swing.JTextField txtEmployeeAddress;
    private javax.swing.JTextField txtEmployeeCity;
    private javax.swing.JTextField txtEmployeeEmail;
    private javax.swing.JTextField txtEmployeeEmployeeNo;
    private javax.swing.JTextField txtEmployeeFirstName;
    private javax.swing.JTextField txtEmployeeJobTitle;
    private javax.swing.JTextField txtEmployeeLastName;
    private javax.swing.JTextField txtEmployeeManagerNo;
    private javax.swing.JTextField txtEmployeeMiddleName;
    private javax.swing.JTextField txtEmployeePassword;
    private javax.swing.JTextField txtEmployeePhoneNo;
    private javax.swing.JTextField txtEmployeeSsn;
    private javax.swing.JTextField txtEmployeeZipCode;
    // End of variables declaration//GEN-END:variables
}
