/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Role.CustomerRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author raunak
 */
public class DeliveryCustomerJPanel extends JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public DeliveryCustomerJPanel(JPanel userProcessContainer, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for(Customer s:business.getCustomerDirectory().getCustomerArrayList()){
            Object[] row = new Object[4];
            for(UserAccount v:business.getUserAccountDirectory().getUserAccountList()){
                if(s.getName().equals(v.getUsername())){
                    row[2]=v.getPassword();
                }
            }
            row[0]=s.getId();
            row[1]=s.getName();
            model.addRow(row);
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
        deleteJButton = new JButton();
        saveJButton = new JButton();
        refreshJButton = new JButton();
        passwordTextfield = new JTextField();
        usernameTextfield = new JTextField();
        addJButton =new JButton();
        passwordLabel = new JLabel();
        usernameLabel = new JLabel();
        backJButton = new JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "username","password"
            }
        ) {
            Class[] types = new Class [] {
                Object.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };


            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        usernameLabel.setText("username");
        add(usernameLabel,new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 308, 375, 44));
        add(usernameTextfield,new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 308, 375, 44));
        passwordLabel.setText("password");
        add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 408, 375, 44));
        add(passwordTextfield,new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 408, 375, 44));
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 58, 375, 96));

        deleteJButton.setText("delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        add(deleteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 215, -1, -1));

        addJButton.setText("add");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 515, -1, -1));

        saveJButton.setText("save changes");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 215, -1, -1));


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

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(usernameTextfield.getText().equals("")||passwordTextfield.getText().equals("")){
            JOptionPane.showMessageDialog(this,"empty input");
            return;
        }
        String userName = usernameTextfield.getText();
        if(!business.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            JOptionPane.showMessageDialog(this,"username exist");
            usernameTextfield.setText("");
            return;
        }
        String passWord = passwordTextfield.getText();
        Role role_2 = new CustomerRole();
        Employee employee_2 = new Employee();
        business.getUserAccountDirectory().createUserAccount(userName,passWord,employee_2,role_2);
        business.getCustomerDirectory().createCustomer(userName);
        usernameTextfield.setText("");
        passwordTextfield.setText("");
        populateTable();
    }
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this,"please select a request");
            return;
        }
        Customer s = business.getCustomerDirectory().getCustomerArrayList().get(selectedRow);
        for(int i = 0;i<business.getUserAccountDirectory().getUserAccountList().size();i++){
            UserAccount v=business.getUserAccountDirectory().getUserAccountList().get(i);
            if(s.getName().equals(v.getUsername())){
                business.getUserAccountDirectory().getUserAccountList().remove(i);
            }
        }
        business.getCustomerDirectory().getCustomerArrayList().remove(selectedRow);
        JOptionPane.showMessageDialog(this,"deleted success");
        populateTable();
        
    }//GEN-LAST:event_assignJButtonActionPerformed

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
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        for(int i = 0; i<model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                if (j == 1) {
                    String temp_name;
                    Object temp = model.getValueAt(i, j);
                    if (temp instanceof Number) {
                        temp_name = Integer.toString((Integer) temp);
                    } else {
                        temp_name = (String) model.getValueAt(i, j);
                    }
                    Customer s = business.getCustomerDirectory().getCustomerArrayList().get(i);
                    for (UserAccount v : business.getUserAccountDirectory().getUserAccountList()) {
                        if (s.getName().equals(v.getUsername())) {
                            business.getUserAccountDirectory().getUserAccountList().get(i).setUsername(temp_name);
                        }
                    }
                    business.getCustomerDirectory().getCustomerArrayList().get(i).setName(temp_name);

                }
                if (j == 1) {
                    Object temp = model.getValueAt(i, j);
                    String password;
                    if (temp instanceof Number) {
                        int password_1 = (Integer) (temp);
                        password = Integer.toString(password_1);
                    } else {
                        password = (String) model.getValueAt(i, j);
                    }
                    Customer s = business.getCustomerDirectory().getCustomerArrayList().get(i);
                    for (UserAccount v : business.getUserAccountDirectory().getUserAccountList()) {
                        if (s.getName().equals(v.getUsername())) {
                            business.getUserAccountDirectory().getUserAccountList().get(i).setPassword(password);
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this,"changing success");
        populateTable();

    }//GEN-LAST:event_processJButtonActionPerformed

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
    private JButton addJButton;
    private JButton backJButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
