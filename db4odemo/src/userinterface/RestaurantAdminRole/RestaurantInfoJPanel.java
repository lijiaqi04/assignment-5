/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author raunak
 */
public class RestaurantInfoJPanel extends JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    UserAccount userAccount;
    
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public RestaurantInfoJPanel(JPanel userProcessContainer, EcoSystem business, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for(WorkRequest s:business.getWorkQueue().getWorkRequestList()){
            if(s.getStatus().equals("wait for accept")){
                Object[] row = new Object[4];
                row[0]=s.getId();
                row[1]=s.getSender();
                row[2]=s.getReceiver();
                row[3]=s.getStatus();
                model.addRow(row);
            }
        }
        }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        workRequestJTable = new JTable();
        saveJButton = new JButton();
        refreshJButton = new JButton();
        backJButton = new JButton();
        refuseJButton=new JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "id", "Sender", "Receiver", "Status"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false,false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }
        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 58, 375, 96));



        saveJButton.setText("accept");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 215, -1, -1));

        refuseJButton.setText("accept");
        refuseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refuseJButtonActionPerformed(evt);
            }
        });
        add(refuseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 215, -1, -1));


        backJButton.setText("back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 215, -1, -1));


        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 26, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt){
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel dwjp = (SystemAdminWorkAreaJPanel) component;
        dwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }


    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this,"please select a request");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        int i = (Integer)model.getValueAt(selectedRow,0);
        for(WorkRequest s:business.getWorkQueue().getWorkRequestList()){
            if(s.getId()==i){
                s.setStatus("available");
            }
        }
        populateTable();
    }//GEN-LAST:accept order

    private void refuseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this,"please select a request");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        int i = (Integer)model.getValueAt(selectedRow,0);
        for(WorkRequest s:business.getWorkQueue().getWorkRequestList()){
            if(s.getId()==i){
                s.setStatus("refused");
            }
        }
        populateTable();

    }//GEN-LAST:refuse order

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton deleteJButton;
    private JScrollPane jScrollPane1;
    private JButton saveJButton;
    private JButton refreshJButton;
    private JTable workRequestJTable;
    private JTextField passwordTextfield;
    private JTextField usernameTextfield;
    private JButton refuseJButton;
    private JButton backJButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
