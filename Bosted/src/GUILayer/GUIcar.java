/*
 * GUIcar.java
 *
 * Created on 09-12-2010, 10:10:50
 */

package GUILayer;

import ControlLayer.CtrCar;
import ControlLayer.CtrClient;
import ControlLayer.CtrEmp;
import ControlLayer.CtrReservation;
import ExceptionsPack.NullValueException;
import ModelLayer.Car;
import ModelLayer.Client;
import ModelLayer.Employee;
import ModelLayer.Reservation;
import ModelLayer.ToDaysDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Gruppe 2 - DM71
 * December 2010
 */
public class GUIcar extends javax.swing.JPanel
{

    /** Creates new form GUIcar */
    public GUIcar()
    {
        initComponents();
        loggedInEmployee = null;
        tableRow = 0;
        tableColumn = 0;
        date1 = getToDaysDate();
    }

    /**
     * 
     * populate combobox Your Reservations (cmbYourReservations)
     */
    public void populateCmbYourReservations()
    {
        CtrReservation ctrRes = new CtrReservation();
        ArrayList<Reservation> reservationList = ctrRes.getAllReservationsByEmployee(getLoggedInEmployee().getEmployeeID());
        cmbYourReservations.removeAllItems();
        cmbYourReservations.insertItemAt("Ny reservation", 0);
        for (Reservation r : reservationList)
        {
            cmbYourReservations.addItem(r);
            cmbYourReservations.removeItem("Ny reservation");
        }
        
    }

    /**
     *
     * populate combobox Client (cmbClient)
     */
    public void populateCmbClient()
    {
        CtrClient ctrCli = new CtrClient();
        ArrayList<Client> clientList = ctrCli.findEmployeesClient(loggedInEmployee.getEmployeeID());
        cmbClient.removeAllItems();
        cmbClient.insertItemAt("Vælg her", 0);
        for (Client c : clientList)
        {
            cmbClient.addItem(c);
        }
        cmbClient.removeItem("Vælg her");
    }

    /**
     *
     * populate combobox AvailableCars (cmbAvailableCars)
     */
    public void populateCmbAvailableCars(String date)
    {
        CtrReservation ctrRes = new CtrReservation();
        ArrayList<Car> carList = ctrRes.findListOfAvailableCarsByDate(date);
        cmbAvailableCars.removeAllItems();
        cmbAvailableCars.insertItemAt("Vælg her", 0);
        for (Car cr : carList)
        {
            cmbAvailableCars.addItem(cr);
        }
        cmbAvailableCars.removeItem("Vælg her");
    }

    /**
     *
     * populate combobox AvailableCars (cmbAvailableCars)
     */
    public void populateCmbBiler()
    {
         CtrCar ctrCar = new CtrCar();
        ArrayList<Car> carList = new ArrayList<Car>();
        carList = ctrCar.getAllCars();
        cmbbiler.removeAllItems();
        cmbbiler.insertItemAt("Vælg her", 0);
        for (Car c : carList)
        {
            cmbbiler.addItem(c);
        }//end for
        cmbbiler.removeItem("Vælg her");
        
    }
    /**
     * 
     * @param clientID the client id
     * @return the full name of the client
     */
    public Client findClient(int clientID)
    {
        Client c = new Client();
        CtrClient ctrC = new CtrClient();
        c = ctrC.findClientByID(clientID);
        return c;
    }

    /**
     * 
     * @param employeeID the employeeID
     * @return a list of clients of the employee
     */
    public ArrayList<Client> findEmployeesClients()
    {
        CtrEmp ctrE = new CtrEmp();
        return ctrE.findEmployee(loggedInEmployee.getEmployeeNo(), true).getClientList();
    }

    /**
     * 
     * @return a list of all cars
     */
    public ArrayList<Car> getAllCars()
    {
        CtrCar ctrCr = new CtrCar();
        return ctrCr.getAllCars();
    }

    /**
     *
     * @param carID the carID
     * @return a car
     */
    public Car findCarByID(int carID)
    {
        CtrCar ctrCr = new CtrCar();
        return ctrCr.findCarByID(carID);
    }
    
    public String getToDaysDate()
    {
        ToDaysDate tdd = new ToDaysDate();
        String date = tdd.toString();
        return date;
    }

    public void setTblReservations()
    {
        CtrReservation ctrRes = new CtrReservation();
        ArrayList<Reservation> res =  ctrRes.getAllreservationsFromThisDate();
        CtrEmp ctrEmp = new CtrEmp();
        CtrClient ctrCli = new CtrClient();
        CtrCar ctrCar = new CtrCar();
        getTblReservations().removeAll();
        if(!res.isEmpty())
        {
            for(Reservation r : res)
            {
                String date = r.getStartDate();
                String emp = ctrEmp.findEmployeeByID(r.getEmployee().getEmployeeID()).toString();
                String cli = ctrCli.findClientByID(r.getClient().getClientID()).toString();
                String car = ctrCar.findCarByID(r.getCar().getCarID()).toString();
                getTblReservations().setValueAt(date, tableRow, tableColumn);
                tableColumn++;
                getTblReservations().setValueAt(emp, tableRow, tableColumn);
                tableColumn++;
                getTblReservations().setValueAt(cli, tableRow, tableColumn);
                tableColumn++;
                getTblReservations().setValueAt(car, tableRow, tableColumn);
                tableColumn = 0;
                tableRow++;
            }//end for
            setTableColumn(0);
            setTableRow(0);
        }//end if
    }

    public void setTblListOfCars(String date)
    {
        CtrCar ctrCar = new CtrCar();
        ArrayList<Car> carList =  ctrCar.getAllCars();
        CtrReservation ctrRes = new CtrReservation();
        ArrayList<Car> carsAvaList = ctrRes.findListOfAvailableCarsByDate(date);
        getTblListofCars().removeAll();
        if(!carList.isEmpty())
        {
            for(Car c : carList)
            {
                String description = c.getDescription();
                String regNo = c.getRegNo();
                String available = "Nej";
                for(Car ca : carsAvaList)
                {
                    if(c.getCarID() == ca.getCarID())
                    {
                        available = "Ja";
                    }//end if
                }//end while
                getTblListofCars().setValueAt(description, tableRow, tableColumn);
                tableColumn++;
                getTblListofCars().setValueAt(regNo, tableRow, tableColumn);
                tableColumn++;
                getTblListofCars().setValueAt(available, tableRow, tableColumn);
                tableColumn = 0;
                tableRow++;

            }//end for
            setTableColumn(0);
            setTableRow(0);
        }//end if
    }

    public void setTblBiler(String date)
    {
        CtrCar ctrCar = new CtrCar();
        ArrayList<Car> carList =  ctrCar.getAllCars();
        CtrReservation ctrRes = new CtrReservation();
        ArrayList<Car> carsAvaList = ctrRes.findListOfAvailableCarsByDate(date);
        getTblBiler().removeAll();
        if(!carList.isEmpty())
        {
            for(Car c : carList)
            {
                String description = c.getDescription();
                String regNo = c.getRegNo();
                String available = "Nej";
                for(Car ca : carsAvaList)
                {
                    if(c.getCarID() == ca.getCarID())
                    {
                        available = "Ja";
                    }//end if
                }//end while
                getTblBiler().setValueAt(description, tableRow, tableColumn);
                tableColumn++;
                getTblBiler().setValueAt(regNo, tableRow, tableColumn);
                tableColumn++;
                getTblBiler().setValueAt(available, tableRow, tableColumn);
                tableColumn = 0;
                tableRow++;
               
            }//end for
            setTableColumn(0);
            setTableRow(0);
        }//end if
    }

    public JTable getTblBiler()
    {
        return tblBiler;
    }

    public void setTblBiler(JTable tblBiler)
    {
        this.tblBiler = tblBiler;
    }

    public void setTableColumn(int tableColumn)
    {
        this.tableColumn = tableColumn;
    }

    public void setTableRow(int tableRow)
    {
        this.tableRow = tableRow;
    }

    public int getTableColumn()
    {
        return tableColumn;
    }

    public int getTableRow()
    {
        return tableRow;
    }

    public JTable getTblListofCars()
    {
        return tblListofCars;
    }

    public JTable getTblReservations()
    {
        return tblReservations;
    }

    /**
     *
     * @param textAreaList all textAreaList
     */
    public void resetTextAreas(JTextArea[] textAreaList)
    {
        for (JTextArea txtArea : textAreaList)
        {
            txtArea.setText("");
        }//end for
    }

    /**
     *
     * @param textFields all textfields
     */
    public void resetTextFields(JTextField[] textFields)
    {
        for (JTextField txtField : textFields)
        {
            txtField.setText("");
        }//end for
    }

    /**
     *
     * @return the employee who is logged in
     */
    public Employee getLoggedInEmployee()
    {
        return loggedInEmployee;
    }
    

    /**
     *
     * @param loggedInEmployee an object of the employee who is logged in
     */
    public void setLoggedInEmployee(Employee loggedInEmployee)
    {
        this.loggedInEmployee = loggedInEmployee;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCar = new javax.swing.JPanel();
        tpCar = new javax.swing.JTabbedPane();
        pHåndtering = new javax.swing.JPanel();
        pHåndteringIndhold = new javax.swing.JPanel();
        lblHentBil = new javax.swing.JLabel();
        LBLbeskrivelse = new javax.swing.JLabel();
        spBeskrivelse = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        lblListeAfBiler = new javax.swing.JLabel();
        spBiler = new javax.swing.JScrollPane();
        tblBiler = new javax.swing.JTable();
        btnOpret = new javax.swing.JButton();
        btnopdater = new javax.swing.JButton();
        btnSlet = new javax.swing.JButton();
        cmbbiler = new javax.swing.JComboBox();
        LBLregno = new javax.swing.JLabel();
        txtregno = new javax.swing.JTextField();
        pBooking = new javax.swing.JPanel();
        pBookingIndhold = new javax.swing.JPanel();
        lblYourReservation = new javax.swing.JLabel();
        lbldateReservation = new javax.swing.JLabel();
        lblListofCars = new javax.swing.JLabel();
        lblReservations = new javax.swing.JLabel();
        spReservationer = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        btnFindAvailableCars = new javax.swing.JButton();
        btnOpdaterBooking = new javax.swing.JButton();
        btnSletBooking = new javax.swing.JButton();
        spListeAfBiler = new javax.swing.JScrollPane();
        tblListofCars = new javax.swing.JTable();
        cmbYourReservations = new javax.swing.JComboBox();
        lblClient = new javax.swing.JLabel();
        cmbClient = new javax.swing.JComboBox();
        jDateChooserReservation = new com.toedter.calendar.JDateChooser();
        lblAvailableCars = new javax.swing.JLabel();
        cmbAvailableCars = new javax.swing.JComboBox();
        btnOpretBooking = new javax.swing.JButton();
        lblClient1 = new javax.swing.JLabel();

        pCar.setPreferredSize(new java.awt.Dimension(697, 556));

        tpCar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tpCarFocusGained(evt);
            }
        });

        pHåndteringIndhold.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHentBil.setText("Hent bil");

        LBLbeskrivelse.setText("Beskrivelse");

        txtdescription.setColumns(20);
        txtdescription.setLineWrap(true);
        txtdescription.setRows(5);
        spBeskrivelse.setViewportView(txtdescription);

        lblListeAfBiler.setText("Liste af biler");

        tblBiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Beskrivelse", "Registreringsnummer", "Ledig i dag"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBiler.setColumnSelectionAllowed(true);
        spBiler.setViewportView(tblBiler);
        tblBiler.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnOpret.setText("Opret");
        btnOpret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpretActionPerformed(evt);
            }
        });

        btnopdater.setText("Opdater");
        btnopdater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopdaterActionPerformed(evt);
            }
        });

        btnSlet.setText("Slet");
        btnSlet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSletActionPerformed(evt);
            }
        });

        cmbbiler.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbbiler.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbilerItemStateChanged(evt);
            }
        });
        cmbbiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbilerActionPerformed(evt);
            }
        });

        LBLregno.setText("Registreringsnummer");

        txtregno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pHåndteringIndholdLayout = new javax.swing.GroupLayout(pHåndteringIndhold);
        pHåndteringIndhold.setLayout(pHåndteringIndholdLayout);
        pHåndteringIndholdLayout.setHorizontalGroup(
            pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringIndholdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHåndteringIndholdLayout.createSequentialGroup()
                        .addGroup(pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHentBil)
                            .addComponent(LBLregno)
                            .addComponent(LBLbeskrivelse)
                            .addComponent(spBeskrivelse, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtregno)
                            .addComponent(cmbbiler, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListeAfBiler)
                            .addComponent(spBiler, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHåndteringIndholdLayout.createSequentialGroup()
                        .addComponent(btnOpret, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnopdater, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSlet, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pHåndteringIndholdLayout.setVerticalGroup(
            pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringIndholdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHentBil)
                    .addComponent(lblListeAfBiler))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHåndteringIndholdLayout.createSequentialGroup()
                        .addComponent(spBiler, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addGap(68, 68, 68)
                        .addGroup(pHåndteringIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSlet)
                            .addComponent(btnopdater)
                            .addComponent(btnOpret)))
                    .addGroup(pHåndteringIndholdLayout.createSequentialGroup()
                        .addComponent(cmbbiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LBLregno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtregno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LBLbeskrivelse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spBeskrivelse, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pHåndteringLayout = new javax.swing.GroupLayout(pHåndtering);
        pHåndtering.setLayout(pHåndteringLayout);
        pHåndteringLayout.setHorizontalGroup(
            pHåndteringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHåndteringLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pHåndteringIndhold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pHåndteringLayout.setVerticalGroup(
            pHåndteringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHåndteringLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pHåndteringIndhold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpCar.addTab("Håndtering", null, pHåndtering, "Her opretter, opdateres og slettes");

        pBookingIndhold.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblYourReservation.setText("Dine reservationer");

        lbldateReservation.setText("Vælg dato(åååå-mm-dd)");

        lblListofCars.setText("Liste af biler");

        lblReservations.setText("Reservationer");

        tblReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dato", "Medarbejder", "Klient", "Bil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spReservationer.setViewportView(tblReservations);

        btnFindAvailableCars.setText("Find");
        btnFindAvailableCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindAvailableCarsActionPerformed(evt);
            }
        });

        btnOpdaterBooking.setText("Opdater");
        btnOpdaterBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpdaterBookingActionPerformed(evt);
            }
        });

        btnSletBooking.setText("Slet");
        btnSletBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSletBookingActionPerformed(evt);
            }
        });

        tblListofCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Beskrivelse", "Registreringsnummer", "Ledig i dag"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spListeAfBiler.setViewportView(tblListofCars);

        cmbYourReservations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYourReservations.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbYourReservationItemStateChanged(evt);
            }
        });

        lblClient.setText("Vælg klient");

        cmbClient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDateChooserReservation.setDateFormatString("yyyy-MM-dd");
        jDateChooserReservation.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserReservationPropertyChange(evt);
            }
        });
        jDateChooserReservation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserReservationKeyPressed(evt);
            }
        });

        lblAvailableCars.setText("Ledige biler");

        cmbAvailableCars.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAvailableCars.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAvailableCarsItemStatChanged(evt);
            }
        });

        btnOpretBooking.setText("Opret");
        btnOpretBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpretBookingActionPerformed(evt);
            }
        });

        lblClient1.setText("Find ledige biler");

        javax.swing.GroupLayout pBookingIndholdLayout = new javax.swing.GroupLayout(pBookingIndhold);
        pBookingIndhold.setLayout(pBookingIndholdLayout);
        pBookingIndholdLayout.setHorizontalGroup(
            pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookingIndholdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBookingIndholdLayout.createSequentialGroup()
                        .addComponent(btnOpretBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOpdaterBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSletBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pBookingIndholdLayout.createSequentialGroup()
                        .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblYourReservation)
                            .addComponent(cmbYourReservations, 0, 138, Short.MAX_VALUE)
                            .addComponent(lbldateReservation)
                            .addComponent(jDateChooserReservation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(lblClient1)
                            .addComponent(cmbClient, javax.swing.GroupLayout.Alignment.TRAILING, 0, 138, Short.MAX_VALUE)
                            .addComponent(lblClient)
                            .addComponent(lblAvailableCars)
                            .addComponent(cmbAvailableCars, 0, 138, Short.MAX_VALUE)
                            .addComponent(btnFindAvailableCars, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReservations)
                            .addComponent(spReservationer, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListofCars)
                            .addComponent(spListeAfBiler, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );
        pBookingIndholdLayout.setVerticalGroup(
            pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookingIndholdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYourReservation)
                    .addComponent(lblReservations)
                    .addComponent(lblListofCars))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spListeAfBiler, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(spReservationer, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addGroup(pBookingIndholdLayout.createSequentialGroup()
                        .addComponent(cmbYourReservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbldateReservation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblClient1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindAvailableCars)
                        .addGap(18, 18, 18)
                        .addComponent(lblClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAvailableCars)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAvailableCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(pBookingIndholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSletBooking)
                    .addComponent(btnOpdaterBooking)
                    .addComponent(btnOpretBooking))
                .addContainerGap())
        );

        javax.swing.GroupLayout pBookingLayout = new javax.swing.GroupLayout(pBooking);
        pBooking.setLayout(pBookingLayout);
        pBookingLayout.setHorizontalGroup(
            pBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pBookingIndhold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pBookingLayout.setVerticalGroup(
            pBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pBookingIndhold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpCar.addTab("Booking", pBooking);

        javax.swing.GroupLayout pCarLayout = new javax.swing.GroupLayout(pCar);
        pCar.setLayout(pCarLayout);
        pCarLayout.setHorizontalGroup(
            pCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpCar, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCarLayout.setVerticalGroup(
            pCarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpCar, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void cmbbilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbilerActionPerformed

    private void txtregnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregnoActionPerformed

    private void tpCarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tpCarFocusGained
        
        populateCmbBiler();
        setTblBiler(getToDaysDate());

        JTextField[] txtFieldList = {txtregno};
        resetTextFields(txtFieldList);
        JTextArea[] txtAreaList = {txtdescription};
        resetTextAreas(txtAreaList);

        populateCmbYourReservations();
        populateCmbClient();
        cmbAvailableCars.removeAllItems();
        setTblListOfCars(getToDaysDate());
        setTblReservations();
        setTblListOfCars(getToDaysDate());
    
    }//GEN-LAST:event_tpCarFocusGained

    private void cmbbilerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbilerItemStateChanged
        // TODO add your handling code here:
        Car c = (Car) cmbbiler.getSelectedItem();
        if (c != null)
        {
            txtregno.setText(c.getRegNo());
            txtdescription.setText(c.getDescription());
        }//end if
        else
        {
            System.out.println("No cars to select from");
        }//end else
        
    }//GEN-LAST:event_cmbbilerItemStateChanged

    private void btnopdaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopdaterActionPerformed
        // TODO add your handling code here:
        Car cars = (Car) cmbbiler.getSelectedItem();
        String description = txtdescription.getText();
        String regno = txtregno.getText();
        CtrCar ctrCar = new CtrCar();
        try
        {
            ctrCar.updateCar(regno, description);
        }//end try
        catch (Exception c)
        {
            JOptionPane.showMessageDialog(this, c.getMessage());
        }//end catch
    }//GEN-LAST:event_btnopdaterActionPerformed

    private void btnSletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSletActionPerformed
        // TODO add your handling code here:
        Car car = (Car) cmbbiler.getSelectedItem();
        String regNo = txtregno.getText();
        CtrCar ctrCar = new CtrCar();
        ctrCar.deleteCar(regNo);
        int index = cmbbiler.getSelectedIndex();
        cmbbiler.removeItemAt(index);
        txtregno.setText("");
        txtdescription.setText("");
        JOptionPane.showMessageDialog(this, "Du har nu slettet bilen: " + regNo +"");
    
    }//GEN-LAST:event_btnSletActionPerformed

    private void btnOpretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpretActionPerformed
        // TODO add your handling code here:
        String regno = txtregno.getText();
        String description = txtdescription.getText();
        CtrCar ctrCar = new CtrCar();
        try
        {
            ctrCar.insertCar(regno, description);
            Car car = ctrCar.findCarByRegNo(regno);
            cmbbiler.addItem(car);
        }//end try
        catch (Exception c)
        {
            JOptionPane.showMessageDialog(this, c.getMessage());
        }//end catch
    }//GEN-LAST:event_btnOpretActionPerformed

    private void cmbYourReservationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbYourReservationItemStateChanged
        if(cmbYourReservations.getSelectedItem() != "" )
        {
            Reservation r = (Reservation) cmbYourReservations.getSelectedItem();
            if (r != null)
            {
                
            }//end if
            else
            {
                System.out.println("No reservations to select from");
            }//end else
        }//end if
//        if(cmbYourReservations.getSelectedItem() == "Ny reservation")
//        {
//            cmbAvailableCars.removeAllItems();
//        }
        
    }//GEN-LAST:event_cmbYourReservationItemStateChanged

    private void cmbAvailableCarsItemStatChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAvailableCarsItemStatChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAvailableCarsItemStatChanged

    private void btnFindAvailableCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindAvailableCarsActionPerformed

        int answer = JOptionPane.showConfirmDialog(this, "Vil du finde biler, der ledige d. " + date1 , "Find ledige biler", JOptionPane.YES_NO_OPTION);
        if(answer == JOptionPane.YES_OPTION)
        {
            populateCmbAvailableCars(date1);
        }
    }//GEN-LAST:event_btnFindAvailableCarsActionPerformed

    private void btnOpretBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpretBookingActionPerformed

        CtrReservation ctrRes = new CtrReservation();
        Car cr = (Car) cmbAvailableCars.getSelectedItem();
        Client cl = (Client) cmbClient.getSelectedItem();
        Employee e = loggedInEmployee;
        if(cr != null && cl != null && e != null)
        {
            int answer = JOptionPane.showConfirmDialog(this, "Vil du oprette en reservation " + date1 + "\n"
                    + "for " + cl.toString() + " og med denne bil: " + cr.toString(), "Opret reservation", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION)
            {
                try
                {
                    ctrRes.insertReservation(cr, e, cl, date1);
                    JOptionPane.showMessageDialog(this, "Reservationen er oprettet", "Oprettet reservation", JOptionPane.INFORMATION_MESSAGE);
                    jDateChooserReservation.setDate(null);
                    populateCmbYourReservations();
                    cmbAvailableCars.removeAllItems();
                    populateCmbClient();
                    setTblListOfCars(getToDaysDate());
                    setTblReservations();



                }//end try
                catch(NullValueException n)
                {
                    JOptionPane.showMessageDialog(this, n.getMessage(), "Oprettelse mislykkedes", JOptionPane.ERROR_MESSAGE);
                }//end catch
            }//end if
        }//end if
        else
        {
            JOptionPane.showMessageDialog(this, "Du mangler at udfylde nogle oplysning,\nVælg både dato, klient og bil", "Manglende oplysninger", JOptionPane.ERROR_MESSAGE);
        }//end else

    }//GEN-LAST:event_btnOpretBookingActionPerformed

    private void jDateChooserReservationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserReservationKeyPressed
        int answer = JOptionPane.showConfirmDialog(this, "Vil du finde biler, der ledige d. " + date1 , "Find ledige biler", JOptionPane.YES_NO_OPTION);
        if(answer == JOptionPane.YES_OPTION)
        {
            populateCmbAvailableCars(date1);
        }
    }//GEN-LAST:event_jDateChooserReservationKeyPressed

    private void jDateChooserReservationPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserReservationPropertyChange
        if (jDateChooserReservation.getDate() != null)
        {
            Calendar calendar = jDateChooserReservation.getCalendar();
            jDateChooserReservation.getDate();
            String year = Integer.toString(calendar.get(Calendar.YEAR));
            String month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
            if (calendar.get(Calendar.MONTH) + 1 < 10)
            {
                month = "0" + month;
            }
            String day = Integer.toString(calendar.get(Calendar.DATE));
            if (calendar.get(Calendar.DATE) + 1 < 10)
            {
                day = "0" + day;
            }
            date1 = year + "-" + month + "-" + day;
            //txtACreateTodo.setText(date1);
        }
        else
        {
        }
    }//GEN-LAST:event_jDateChooserReservationPropertyChange

    private void btnOpdaterBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpdaterBookingActionPerformed
        CtrReservation ctrRes = new CtrReservation();
        Reservation r = (Reservation) cmbYourReservations.getSelectedItem();
        if(r != null)
        {
            String date = null;
            Client cl = (Client) cmbClient.getSelectedItem();
            Employee e = loggedInEmployee;
            Car c = (Car)cmbAvailableCars.getSelectedItem();
            if(!date1.equals(r.getStartDate()))
            {
            date = date1;
            }
            else
            {
                date = r.getStartDate();
            }
            if(cl == null)
            {
                cl = r.getClient();
            }
            if(c == null)
            {
                c = r.getCar();
            }//end if
            int answer = JOptionPane.showConfirmDialog(this, "Vil du opdatere reservationen til " + date1 + "\n"
                + "for " + cl.toString() + " og med denne bil: " + c.toString(), "Opret reservation", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION)
            {
                ctrRes.updateReservation(r.getReservationID(), c, e, cl, date, date, r.getReservationDate());
                JOptionPane.showMessageDialog(this, "Reservationen er opdateret", "Opdateret reservation", JOptionPane.INFORMATION_MESSAGE);
                jDateChooserReservation.setDate(null);
                populateCmbYourReservations();
                cmbAvailableCars.removeAllItems();
                populateCmbClient();
                setTblListOfCars(getToDaysDate());
                setTblReservations();
            }//end if
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Du har ikke valgt en reservation du vil ændre", "Manglende reservation", JOptionPane.ERROR_MESSAGE);
        }//end else

    }//GEN-LAST:event_btnOpdaterBookingActionPerformed

    private void btnSletBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSletBookingActionPerformed
        CtrReservation ctrRes = new CtrReservation();
        Reservation r = (Reservation) cmbYourReservations.getSelectedItem();
        if(r != null)
        {
            int answer = JOptionPane.showConfirmDialog(this, "Vil du slette denne reservationen: " + r.getStartDate() + "\n"
                + "med " + r.getClient().toString() + " og med denne bil: " + r.getCar().toString(), "Slet reservation", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION)
            {
                ctrRes.deleteReservation(r);
                JOptionPane.showMessageDialog(this, "Reservationen er slettet", "Slettet reservation", JOptionPane.INFORMATION_MESSAGE);
                jDateChooserReservation.setDate(null);
                populateCmbYourReservations();
                cmbAvailableCars.removeAllItems();
                populateCmbClient();
                setTblListOfCars(getToDaysDate());
                setTblReservations();
            }//end if
            else
            {
                jDateChooserReservation.setDate(null);
                populateCmbYourReservations();
                cmbAvailableCars.removeAllItems();
                populateCmbClient();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Du har ikke valgt en reservation du vil ændre", "Manglende reservation", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSletBookingActionPerformed

    public String getDate1()
    {
        return date1;
    }

    public void setDate1(String date1)
    {
        this.date1 = date1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBLbeskrivelse;
    private javax.swing.JLabel LBLregno;
    private javax.swing.JButton btnFindAvailableCars;
    private javax.swing.JButton btnOpdaterBooking;
    private javax.swing.JButton btnOpret;
    private javax.swing.JButton btnOpretBooking;
    private javax.swing.JButton btnSlet;
    private javax.swing.JButton btnSletBooking;
    private javax.swing.JButton btnopdater;
    private javax.swing.JComboBox cmbAvailableCars;
    private javax.swing.JComboBox cmbClient;
    private javax.swing.JComboBox cmbYourReservations;
    private javax.swing.JComboBox cmbbiler;
    private com.toedter.calendar.JDateChooser jDateChooserReservation;
    private javax.swing.JLabel lblAvailableCars;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblClient1;
    private javax.swing.JLabel lblHentBil;
    private javax.swing.JLabel lblListeAfBiler;
    private javax.swing.JLabel lblListofCars;
    private javax.swing.JLabel lblReservations;
    private javax.swing.JLabel lblYourReservation;
    private javax.swing.JLabel lbldateReservation;
    private javax.swing.JPanel pBooking;
    private javax.swing.JPanel pBookingIndhold;
    private javax.swing.JPanel pCar;
    private javax.swing.JPanel pHåndtering;
    private javax.swing.JPanel pHåndteringIndhold;
    private javax.swing.JScrollPane spBeskrivelse;
    private javax.swing.JScrollPane spBiler;
    private javax.swing.JScrollPane spListeAfBiler;
    private javax.swing.JScrollPane spReservationer;
    private javax.swing.JTable tblBiler;
    private javax.swing.JTable tblListofCars;
    private javax.swing.JTable tblReservations;
    private javax.swing.JTabbedPane tpCar;
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JTextField txtregno;
    // End of variables declaration//GEN-END:variables
    private Employee loggedInEmployee;
    private int tableRow;
    private int tableColumn;
    private String date1;
}
