/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIToDo.java
 *
 * Created on 04-01-2011, 11:44:17
 */

package GUILayer;

/**
 *
 * @author Erik M. Gravesen
 */
public class GUITodo extends javax.swing.JPanel {

    /** Creates new form GUIToDo */
    public GUITodo() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAToDo = new javax.swing.JTextArea();
        cmbSelectDate = new javax.swing.JComboBox();

        txtAToDo.setColumns(20);
        txtAToDo.setRows(5);
        jScrollPane1.setViewportView(txtAToDo);

        cmbSelectDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSelectDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectDateItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(cmbSelectDate, 0, 717, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbSelectDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelectDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectDateItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSelectDateItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbSelectDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAToDo;
    // End of variables declaration//GEN-END:variables

}