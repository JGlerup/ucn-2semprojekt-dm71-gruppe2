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

import ControlLayer.CtrLoca;
import ControlLayer.CtrClient;
import ControlLayer.CtrEmp;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.Location;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Glerup
 */
public class GUIclient extends javax.swing.JPanel {

    private Employee loggedInEmployee;

    /** Creates new form GUIclient */
    public GUIclient() {
        initComponents();
        loggedInEmployee = null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpKlient = new javax.swing.JTabbedPane();
        pHåndteringKlient = new javax.swing.JPanel();
        pHåndteringKlientIndhold = new javax.swing.JPanel();
        lblFornavnKlient = new javax.swing.JLabel();
        lblMellemnavnKlient = new javax.swing.JLabel();
        lblEfternavnKlient = new javax.swing.JLabel();
        lblBeskrivelseKlient = new javax.swing.JLabel();
        txtClientFirstName = new javax.swing.JTextField();
        txtClientMiddleName = new javax.swing.JTextField();
        txtClientLastName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtClientDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtClientHealth = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtClientAddress = new javax.swing.JTextField();
        txtClientZipCode = new javax.swing.JTextField();
        txtClientCity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtClientInterests = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientPhoneNo = new javax.swing.JTextField();
        txtClientEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDeleteClient = new javax.swing.JButton();
        btnUpdateClient = new javax.swing.JButton();
        btnCreateClient = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbClientInUse = new javax.swing.JCheckBox();
        cmbClient = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtClientUserName = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(697, 556));

        tpKlient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpKlientFocusGained(evt);
            }
        });

        pHåndteringKlientIndhold.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFornavnKlient.setText("Fornavn");

        lblMellemnavnKlient.setText("Mellemnavn");

        lblEfternavnKlient.setText("Efternavn");

        lblBeskrivelseKlient.setText("Beskrivelse");

        txtClientFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientFirstNameActionPerformed(evt);
            }
        });

        txtClientDescription.setColumns(20);
        txtClientDescription.setRows(5);
        jScrollPane1.setViewportView(txtClientDescription);

        jLabel5.setText("Helbred");

        txtClientHealth.setColumns(20);
        txtClientHealth.setRows(5);
        jScrollPane2.setViewportView(txtClientHealth);

        jLabel11.setText("Adresse");

        jLabel12.setText("Postnummer");

        jLabel13.setText("By");

        txtClientZipCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClientZipCodeFocusLost(evt);
            }
        });

        txtClientCity.setEditable(false);

        jLabel14.setText("Interesser");

        txtClientInterests.setColumns(20);
        txtClientInterests.setRows(5);
        jScrollPane3.setViewportView(txtClientInterests);

        jLabel15.setText("Personnummer");

        jLabel16.setText("Telefonnummer");

        jLabel17.setText("E-mail");

        jLabel6.setText("Hent klient");

        btnDeleteClient.setText("Slet");
        btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClientActionPerformed(evt);
            }
        });

        btnUpdateClient.setText("Opdater");
        btnUpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClientActionPerformed(evt);
            }
        });

        btnCreateClient.setText("Opret");
        btnCreateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateClientActionPerformed(evt);
            }
        });

        jLabel7.setText("Er klient nu");

        cbClientInUse.setText("(Sæt kryds hvis ja)");
        cbClientInUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientInUseActionPerformed(evt);
            }
        });

        cmbClient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbClient.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClientItemStateChanged(evt);
            }
        });

        jLabel8.setText("Brugernavn");

        javax.swing.GroupLayout pHåndteringKlientIndholdLayout = new javax.swing.GroupLayout(pHåndteringKlientIndhold);
        pHåndteringKlientIndhold.setLayout(pHåndteringKlientIndholdLayout);
        pHåndteringKlientIndholdLayout.setHorizontalGroup(
            pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addComponent(btnCreateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteClient, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbClient, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFornavnKlient, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientSsn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientUserName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMellemnavnKlient)
                                    .addComponent(txtClientMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtClientPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtClientZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEfternavnKlient)
                                    .addComponent(txtClientLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtClientEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))
                                    .addComponent(jLabel13)
                                    .addComponent(txtClientCity, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbClientInUse)
                            .addComponent(jLabel7))
                        .addGap(19, 19, 19)
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(lblBeskrivelseKlient)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jLabel5))))
                .addContainerGap())
        );
        pHåndteringKlientIndholdLayout.setVerticalGroup(
            pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addComponent(lblFornavnKlient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addComponent(lblMellemnavnKlient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEfternavnKlient)
                            .addComponent(lblBeskrivelseKlient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClientEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93)
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteClient)
                            .addComponent(btnUpdateClient)
                            .addComponent(btnCreateClient)))
                    .addGroup(pHåndteringKlientIndholdLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClientPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(pHåndteringKlientIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pHåndteringKlientIndholdLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClientUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pHåndteringKlientIndholdLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbClientInUse)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pHåndteringKlientLayout = new javax.swing.GroupLayout(pHåndteringKlient);
        pHåndteringKlient.setLayout(pHåndteringKlientLayout);
        pHåndteringKlientLayout.setHorizontalGroup(
            pHåndteringKlientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringKlientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pHåndteringKlientIndhold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pHåndteringKlientLayout.setVerticalGroup(
            pHåndteringKlientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringKlientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pHåndteringKlientIndhold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpKlient.addTab("Håndtering", null, pHåndteringKlient, "Her opretter, opdateres og slettes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpKlient, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpKlient, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void resetTextFields(JTextField[] textFields) {
        for (JTextField txtField : textFields) {
            txtField.setText("");
        }
    }

    public void resetTextAreas(JTextArea[] textAreaList) {
        for (JTextArea txtArea : textAreaList) {
            txtArea.setText("");
        }
    }

    public void resetCheckBoxes(JCheckBox[] cbList) {
        for (JCheckBox cb : cbList) {
            cb.setSelected(false);
        }
    }

    public void resetTabs(){
        int index = 1; //Vi ønsker ikke at fjerne fanebladet "Håndtering" ergo er index altså 1
        while(index < tpKlient.getTabCount()){
            tpKlient.remove(index);
        }
    }

    public void setEmployee(Employee emp) {
        loggedInEmployee = emp;
    }

    public void addEmployeesClients() {
        resetTabs();
        CtrEmp ctrEmp = new CtrEmp();
        int employeeID = loggedInEmployee.getEmployeeID();
        ArrayList<Client> clientList = ctrEmp.findEmployeesClient(employeeID);
        for (Client c : clientList) {
            GUIClientNewTab guiClientNewTab = new GUIClientNewTab();
            tpKlient.addTab(c.getFirstName() + c.getLastName(), guiClientNewTab);
            guiClientNewTab.setClient(c);
            guiClientNewTab.setupClientInformation();
        }
    }

    private void btnCreateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateClientActionPerformed
        // TODO add your handling code here:
        String description = txtClientDescription.getText();
        String interests = txtClientInterests.getText();
        String health = txtClientHealth.getText();
        String ssn = txtClientSsn.getText();
        String firstName = txtClientFirstName.getText();
        String middleName = txtClientMiddleName.getText();
        String lastName = txtClientLastName.getText();
        String address = txtClientAddress.getText();
        int zipCode = Integer.parseInt(txtClientZipCode.getText());
        int phoneNo = Integer.parseInt(txtClientPhoneNo.getText());
        String email = txtClientEmail.getText();

        String inUse = "No";
        if (cbClientInUse.isSelected()) {
            inUse = "Yes";
        }
        CtrClient ctrCli = new CtrClient();
        CtrLoca ctrLoca = new CtrLoca();
        try {
            int locationID = ctrLoca.findLocationByZipCode(zipCode).getLocationID();
            ctrCli.insertClient(description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, inUse);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnCreateClientActionPerformed

    private void txtClientFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientFirstNameActionPerformed

    private void cbClientInUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientInUseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClientInUseActionPerformed

    private void txtClientZipCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClientZipCodeFocusLost
        // TODO add your handling code here:
        CtrLoca ctrLoca = new CtrLoca();
        int zipCode = Integer.parseInt(txtClientZipCode.getText());
        try {
            txtClientCity.setText(ctrLoca.findLocationByZipCode(zipCode).getCity());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtClientZipCodeFocusLost

    private void btnUpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClientActionPerformed
        // TODO add your handling code here:
        String clientNoCurrent = null;
        String clientNoNew = null;
        String description = txtClientDescription.getText();
        String interests = txtClientInterests.getText();
        String health = txtClientHealth.getText();
        String ssn = txtClientSsn.getText();
        String firstName = txtClientFirstName.getText();
        String middleName = txtClientMiddleName.getText();
        String lastName = txtClientLastName.getText();
        String address = txtClientAddress.getText();
        int zipCode = Integer.parseInt(txtClientZipCode.getText());
        int phoneNo = Integer.parseInt(txtClientPhoneNo.getText());
        String email = txtClientEmail.getText();

        String inUse = "No";
        if (cbClientInUse.isSelected()) {
            inUse = "Yes";
        }
        CtrClient ctrCli = new CtrClient();
        CtrLoca ctrLoca = new CtrLoca();
        try {
            int locationID = ctrLoca.findLocationByZipCode(zipCode).getLocationID();
            ctrCli.updateClient(clientNoCurrent, clientNoNew, description, interests, health, ssn, firstName, middleName, lastName, address, locationID, phoneNo, email, inUse);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateClientActionPerformed

    private void btnDeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClientActionPerformed
        // TODO add your handling code here:
        String clientNo = null;
        CtrClient ctrCli = new CtrClient();
        ctrCli.deleteClient(clientNo);
    }//GEN-LAST:event_btnDeleteClientActionPerformed

    private void tpKlientFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpKlientFocusGained
        // TODO add your handling code here:
        CtrClient ctrClient = new CtrClient();
        ArrayList<Client> clientList = ctrClient.getAllClients();
        cmbClient.removeAllItems();
        cmbClient.insertItemAt("", 0);
        for (Client c : clientList) {
            cmbClient.addItem(c);
        }
        cmbClient.removeItemAt(0);
        JTextField[] txtFieldList = {
            txtClientAddress,
            txtClientUserName,
            txtClientFirstName,
            txtClientSsn,
            txtClientMiddleName,
            txtClientLastName,
            txtClientAddress,
            txtClientZipCode,
            txtClientCity,
            txtClientPhoneNo,
            txtClientEmail
        };

        JTextArea[] txtAreaList = {
            txtClientDescription,
            txtClientInterests,
            txtClientHealth,};

        JCheckBox[] checkBoxList = {
            cbClientInUse
        };

        resetTextFields(txtFieldList);
        resetTextAreas(txtAreaList);
        resetCheckBoxes(checkBoxList);

        System.out.println(loggedInEmployee.getCrudEmployee());
        addEmployeesClients();
    }//GEN-LAST:event_tpKlientFocusGained

    private void cmbClientItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClientItemStateChanged
        // TODO add your handling code here:
        if (cmbClient.getSelectedItem() != "") {
            Client c = (Client) cmbClient.getSelectedItem();
            if (c != null) {
                String clientNo = c.getClientNo();
                String address = c.getAddress();
                String description = c.getDescription();
                String interests = c.getInterests();
                String health = c.getHealth();
                String firstName = c.getFirstName();
                String middleName = c.getMiddleName();
                String lastName = c.getLastName();
                String phoneNo = Integer.toString(c.getPhoneNo());
                String email = c.getEmail();
                String ssn = c.getSsn();
                String inUse = c.getInUse();
                String zipCode = null;
                String city = null;
                int locationID = c.getLocationID();

                CtrLoca ctrLoca = new CtrLoca();
                try {
                    Location l = ctrLoca.findLocation(locationID);
                    zipCode = Integer.toString(l.getZipCode());
                    city = l.getCity();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }

                txtClientAddress.setText(address);
                txtClientUserName.setText(clientNo);
                txtClientFirstName.setText(firstName);
                txtClientDescription.setText(description);
                txtClientInterests.setText(interests);
                txtClientHealth.setText(health);
                txtClientSsn.setText(ssn);
                txtClientMiddleName.setText(middleName);
                txtClientLastName.setText(lastName);
                txtClientAddress.setText(address);
                txtClientZipCode.setText(zipCode);
                txtClientCity.setText(city);
                txtClientPhoneNo.setText(phoneNo);
                txtClientEmail.setText(email);

                if (cbClientInUse.equals("Yes")) {
                    cbClientInUse.setSelected(true);
                } else {
                    cbClientInUse.setSelected(false);
                }
            } else {
                System.out.println("No clients to select from");
            }
        } else {
            cmbClient.removeItemAt(0);
        }
    }//GEN-LAST:event_cmbClientItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateClient;
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.JButton btnUpdateClient;
    private javax.swing.JCheckBox cbClientInUse;
    private javax.swing.JComboBox cmbClient;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBeskrivelseKlient;
    private javax.swing.JLabel lblEfternavnKlient;
    private javax.swing.JLabel lblFornavnKlient;
    private javax.swing.JLabel lblMellemnavnKlient;
    private javax.swing.JPanel pHåndteringKlient;
    private javax.swing.JPanel pHåndteringKlientIndhold;
    private javax.swing.JTabbedPane tpKlient;
    private javax.swing.JTextField txtClientAddress;
    private javax.swing.JTextField txtClientCity;
    private javax.swing.JTextArea txtClientDescription;
    private javax.swing.JTextField txtClientEmail;
    private javax.swing.JTextField txtClientFirstName;
    private javax.swing.JTextArea txtClientHealth;
    private javax.swing.JTextArea txtClientInterests;
    private javax.swing.JTextField txtClientLastName;
    private javax.swing.JTextField txtClientMiddleName;
    private javax.swing.JTextField txtClientPhoneNo;
    private javax.swing.JTextField txtClientSsn;
    private javax.swing.JTextField txtClientUserName;
    private javax.swing.JTextField txtClientZipCode;
    // End of variables declaration//GEN-END:variables
}
