/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUILayer;

import ModelLayer.Client;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erik M. Gravesen
 */
public class TableClient extends DefaultTableModel {
    private ArrayList<Client> data;

    public TableClient() {
        data = new ArrayList<Client>();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void setData(ArrayList<Client> data) {
        this.data = data;
        fireTableDataChanged();
    }

    public ArrayList<Client> getData() {
        return data;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        if (data == null) {
            return 0;
        } else {
            return data.size();
        }
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "Fornavn";
                break;
            case 1:
                columnName = "Mellemnavn";
                break;
            case 2:
                columnName = "Efternavn";
                break;
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = null;
        switch (column) {
            case 0:
                value = data.get(row).getFirstName();
                break;
            case 1:
                value = data.get(row).getMiddleName();
                break;
            case 2:
                value = data.get(row).getLastName();
                break;
        }

        return value;
    }
}
