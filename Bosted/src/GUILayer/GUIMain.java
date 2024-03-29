/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on 19-10-2010, 10:05:03
 */
package GUILayer;

import ControlLayer.CtrEmp;
import ModelLayer.Employee;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Anita
 */
public class GUIMain extends javax.swing.JFrame {

    private Employee loggedInEmployee;

    /** Creates new form GUI */
    public GUIMain() {
        initComponents();
        for (int i = 1; i < tpGUI.getTabCount(); i++) {
            tpGUI.setEnabledAt(i, false);
        }
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

        tpGUI = new javax.swing.JTabbedPane();
        pLogin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBrugernavn = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnNulstilLogin = new javax.swing.JButton();
        lblBrugernavn = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        pKlienter = new javax.swing.JPanel();
        gUIclient1 = new GUILayer.GUIclient();
        pBiler = new javax.swing.JPanel();
        gUIcar1 = new GUILayer.GUIcar();
        pMedarbejdere = new javax.swing.JPanel();
        gUIemployee1 = new GUILayer.GUIEmployee();
        jPanel1 = new javax.swing.JPanel();
        gUImedicin1 = new GUILayer.GUImedicin();
        pHjælp = new javax.swing.JPanel();
        spHjælp = new javax.swing.JScrollPane();
        txtaHjælp = new javax.swing.JTextArea();
        txtIndtastHjælp = new javax.swing.JTextField();
        btnSøg = new javax.swing.JButton();
        gUITodo1 = new GUILayer.GUITodo();
        pLogud = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblLogud = new javax.swing.JLabel();
        btnLogud = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpGUI.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpGUI.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tpGUI.setMinimumSize(new java.awt.Dimension(0, 0));
        tpGUI.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUILayer/login_welcome.jpg"))); // NOI18N

        txtBrugernavn.setToolTipText("Skriv dit brugernavn her");
        txtBrugernavn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBrugernavnKeyPressed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Bookshelf Symbol 7", 0, 11));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnNulstilLogin.setText("Nulstil");
        btnNulstilLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNulstilLoginActionPerformed(evt);
            }
        });

        lblBrugernavn.setText("Brugernavn");

        lblPassword.setText("Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBrugernavn, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBrugernavn, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(btnLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNulstilLogin))
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(lblBrugernavn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBrugernavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addGap(4, 4, 4)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnNulstilLogin))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pLoginLayout = new javax.swing.GroupLayout(pLogin);
        pLogin.setLayout(pLoginLayout);
        pLoginLayout.setHorizontalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLoginLayout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        pLoginLayout.setVerticalGroup(
            pLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLoginLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        tpGUI.addTab("Login", null, pLogin, "Her logger du ind");

        javax.swing.GroupLayout pKlienterLayout = new javax.swing.GroupLayout(pKlienter);
        pKlienter.setLayout(pKlienterLayout);
        pKlienterLayout.setHorizontalGroup(
            pKlienterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUIclient1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
        pKlienterLayout.setVerticalGroup(
            pKlienterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUIclient1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        tpGUI.addTab("Klienter", null, pKlienter, "Her ser du dine klienter");

        pBiler.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout pBilerLayout = new javax.swing.GroupLayout(pBiler);
        pBiler.setLayout(pBilerLayout);
        pBilerLayout.setHorizontalGroup(
            pBilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUIcar1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
        pBilerLayout.setVerticalGroup(
            pBilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUIcar1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        tpGUI.addTab("Biler", null, pBiler, "Her reserverer du biler");

        gUIemployee1.setMinimumSize(new java.awt.Dimension(0, 0));
        gUIemployee1.setPreferredSize(new java.awt.Dimension(700, 500));

        javax.swing.GroupLayout pMedarbejdereLayout = new javax.swing.GroupLayout(pMedarbejdere);
        pMedarbejdere.setLayout(pMedarbejdereLayout);
        pMedarbejdereLayout.setHorizontalGroup(
            pMedarbejdereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUIemployee1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
        pMedarbejdereLayout.setVerticalGroup(
            pMedarbejdereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUIemployee1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        tpGUI.addTab("Medarbejdere", null, pMedarbejdere, "Her håndterer du medarbejdere");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUImedicin1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gUImedicin1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 612, Short.MAX_VALUE)
        );

        tpGUI.addTab("Medicin", jPanel1);

        txtaHjælp.setColumns(20);
        txtaHjælp.setFont(new java.awt.Font("Verdana", 0, 14));
        txtaHjælp.setLineWrap(true);
        txtaHjælp.setRows(5);
        txtaHjælp.setText("Det første vindue man ser er login vinduet.\nI dette vindue kan man logge ind ved hjælp af et kendt Brugernavn og Password.\nHvis man succesfuldt logger ind, får man adgang til de 6 andre faner som er placeret ude i \nvenstre side af vinduet.\nDe 7 faner er som følge:\n\t-Login\n\t-Klienter\n\t-Biler\n\t-Medarbejdere\n\t-Medicin\n\t-Hjælp\n\t-Logud\n\nI fanen \"Klienter\" under \"Håndtering\", kan man oprette, opdatere og slette klienter hvis man \nhar rettigheder til det. Det er også i denne fane at man kan se de klienter, som er blevet tilknyttet til\nden medarbejder man er logget ind som.\nUnder hver klient, kan man se dennes generelle oplysninger, klientens nyeste dagsrapport, klientens 4 \nnyeste delmål og hvorfor noget medicin denne klient tager.\nDer er også en masse andre funktioner i dette vindue. Man kan hente, oprette og opdatere andre\ndagsrapporter og delmål. Nederst på siden kan man opskrive lageret af medicin hvis man har\nrettigheden til dette. Man kan angive at man har givet noget medicin til denne klient og man kan\nrapportere en utilsigtet hændelse.\nAlle funktionerne åbner et nyt vindue hvor man har nogle valgmuligheder alt efter hvad for en funktion\nman har valgt.\n");
        spHjælp.setViewportView(txtaHjælp);

        txtIndtastHjælp.setText("Indtast søgeord her");
        txtIndtastHjælp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIndtastHjælpFocusGained(evt);
            }
        });

        btnSøg.setText("Søg");
        btnSøg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSøgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pHjælpLayout = new javax.swing.GroupLayout(pHjælp);
        pHjælp.setLayout(pHjælpLayout);
        pHjælpLayout.setHorizontalGroup(
            pHjælpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHjælpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pHjælpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHjælpLayout.createSequentialGroup()
                        .addComponent(txtIndtastHjælp, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSøg)
                        .addContainerGap())
                    .addComponent(spHjælp, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)))
        );
        pHjælpLayout.setVerticalGroup(
            pHjælpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHjælpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pHjælpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSøg)
                    .addComponent(txtIndtastHjælp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spHjælp, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpGUI.addTab("Hjælp", null, pHjælp, "Her kan du se efter hjælp til brug af systemet");
        tpGUI.addTab("Todo", gUITodo1);

        lblLogud.setText("Er du sikker på du vil logge ud");

        btnLogud.setText("Logud");
        btnLogud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogudActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogud, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLogud)
                        .addGap(43, 43, 43)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(lblLogud)
                .addGap(18, 18, 18)
                .addComponent(btnLogud)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout pLogudLayout = new javax.swing.GroupLayout(pLogud);
        pLogud.setLayout(pLogudLayout);
        pLogudLayout.setHorizontalGroup(
            pLogudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLogudLayout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        pLogudLayout.setVerticalGroup(
            pLogudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLogudLayout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        tpGUI.addTab("Logud", null, pLogud, "Her logger du ud");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpGUI, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpGUI, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void userPermissions() {
        if (loggedInEmployee.getCrudClient().equals("No")) {
            gUIclient1.disableClientManagement();
        } else {
            if (loggedInEmployee.getCrudClient().equals("Yes")) {
                gUIclient1.enableClientMangement();
            }
        }
        if (loggedInEmployee.getCrudEmployee().equals("No")) {
            gUIemployee1.disableEmployeeManagement();
        } else {
            if (loggedInEmployee.getCrudEmployee().equals("Yes")) {
                gUIemployee1.enableEmployeeMangement();
            }
        }
//        if (loggedInEmployee.getCrudCar().equals("No")) {
//        }
//        if (loggedInEmployee.getCrudMedicine().equals("No")) {
//        }
    }

    private void txtIndtastHjælpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIndtastHjælpFocusGained
        // TODO add your handling code here:
        txtIndtastHjælp.setText("");
    }//GEN-LAST:event_txtIndtastHjælpFocusGained

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        CtrEmp ctrEmp = new CtrEmp();
        String user = txtBrugernavn.getText();
        String pass = txtPassword.getText();
        Employee emp = ctrEmp.findEmployee(user, false);
        String empUser = emp.getEmployeeNo();
        String empPassword = emp.getPassword();
        String empInUse = emp.getInUse();
        System.out.println(empInUse);
        if (user.equals(empUser) && pass.equals(empPassword) && empInUse.equals("yes")) {
            for (int i = 1; i < tpGUI.getTabCount(); i++) {
                tpGUI.setEnabledAt(i, true);

            }
            JOptionPane.showMessageDialog(pLogin, "Du er nu logget ind");
            loggedInEmployee = emp;
            gUIclient1.setEmployee(loggedInEmployee);
            gUITodo1.setLoggedInEmployee(loggedInEmployee);
            gUIemployee1.setLoggedInEmployee(loggedInEmployee);
            gUIcar1.setLoggedInEmployee(loggedInEmployee);
            userPermissions();
        } else {
            JOptionPane.showMessageDialog(pLogin, "Du har indtastet brugernavnet eller passwordet forkert");
        }
        txtPassword.setText(null);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnNulstilLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNulstilLoginActionPerformed
        // TODO add your handling code here:
        txtBrugernavn.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnNulstilLoginActionPerformed

    private void btnLogudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogudActionPerformed
        // TODO add your handling code here:
        for (int i = 1; i < tpGUI.getTabCount(); i++) {
            tpGUI.setEnabledAt(i, false);
        }
        loggedInEmployee = null;
    }//GEN-LAST:event_btnLogudActionPerformed

    private void btnSøgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSøgActionPerformed
        // TODO add your handling code here:
        String s = txtaHjælp.getText();
        String searchstr = txtIndtastHjælp.getText();
        int index = s.indexOf(searchstr);
        if (index != -1) {
            txtaHjælp.setSelectionStart(index);
            txtaHjælp.setSelectionEnd(index + searchstr.length());
        }

    }//GEN-LAST:event_btnSøgActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtBrugernavnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrugernavnKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtBrugernavnKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }

                new GUIMain().setVisible(true);


            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogud;
    private javax.swing.JButton btnNulstilLogin;
    private javax.swing.JButton btnSøg;
    private GUILayer.GUITodo gUITodo1;
    private GUILayer.GUIcar gUIcar1;
    private GUILayer.GUIclient gUIclient1;
    private GUILayer.GUIEmployee gUIemployee1;
    private GUILayer.GUImedicin gUImedicin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBrugernavn;
    private javax.swing.JLabel lblLogud;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pBiler;
    private javax.swing.JPanel pHjælp;
    private javax.swing.JPanel pKlienter;
    private javax.swing.JPanel pLogin;
    private javax.swing.JPanel pLogud;
    private javax.swing.JPanel pMedarbejdere;
    private javax.swing.JScrollPane spHjælp;
    private javax.swing.JTabbedPane tpGUI;
    private javax.swing.JTextField txtBrugernavn;
    private javax.swing.JTextField txtIndtastHjælp;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextArea txtaHjælp;
    // End of variables declaration//GEN-END:variables
}
