/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form customer
     */
    public Customer() {
        initComponents();
        customerTable_update();
        //initBackButton();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcustId = new javax.swing.JTextField();
        txtcustName = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Customer Management");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Customer Id");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mobile");

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcustId)
                            .addComponent(txtcustName)
                            .addComponent(txtmobile)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(28, 28, 28)
                        .addComponent(deleteButton)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcustId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        customerTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Customer Id", "Customer Name", "Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("<<Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(backButton)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(backButton)
                .addContainerGap(336, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Connection con;
    PreparedStatement ps;
    private void customerTable_update(){
        
        int c;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/order_management","root","");
            ps=con.prepareStatement("select * from customer");
           
            ResultSet rs=ps.executeQuery();
            ResultSetMetaData Rss=rs.getMetaData();
            c=Rss.getColumnCount();
            
            DefaultTableModel Df=(DefaultTableModel) customerTable.getModel();
            Df.setRowCount(0);
            
            while(rs.next()){
                Vector v2=new Vector();
                
                for(int a=1;a<=c;a++){
                    v2.add(rs.getString("cust_id"));
                    v2.add(rs.getString("cust_name"));
                    v2.add(rs.getString("mobile"));
                }
                Df.addRow(v2);
            }   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String cust_id=txtcustId.getText();
        String cust_name=txtcustName.getText();
        String mobile=txtmobile.getText();
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/order_management","root","");
            ps=con.prepareStatement("insert into customer(cust_id,cust_name,mobile) values(?,?,?)");
            ps.setString(1,cust_id);
            ps.setString(2,cust_name);
            ps.setString(3,mobile);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Customer is Added");
            customerTable_update();
            
            txtcustId.setText("");
            txtmobile.setText("");
            txtcustName.setText("");
            
            txtcustId.requestFocus();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        // TODO add your handling code here:
         DefaultTableModel Df=(DefaultTableModel) customerTable.getModel();
         int selectedIndex=customerTable.getSelectedRow();
         
         txtcustId.setText(Df.getValueAt(selectedIndex, 0).toString());
         txtcustName.setText(Df.getValueAt(selectedIndex, 1).toString());
         txtmobile.setText(Df.getValueAt(selectedIndex, 2).toString());
         
    }//GEN-LAST:event_customerTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel Df=(DefaultTableModel) customerTable.getModel();
         int selectedIndex=customerTable.getSelectedRow();
         
         try {
             
             String id=Df.getValueAt(selectedIndex,0).toString();
             
            String cust_id=txtcustId.getText();
            String cust_name=txtcustName.getText();
            String mobile=txtmobile.getText();
                
        
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/order_management","root","");
            ps=con.prepareStatement("update customer set cust_id=?,cust_name=?,mobile=? where cust_id=?");
            ps.setString(1,cust_id);
            ps.setString(2,cust_name);
            ps.setString(3,mobile);
            ps.setString(4,id);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Customer is Updated");
            
            customerTable_update();
            
            txtcustId.setText("");
            txtmobile.setText("");
            txtcustName.setText("");
            
            txtcustId.requestFocus();
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel Df=(DefaultTableModel) customerTable.getModel();
         int selectedIndex=customerTable.getSelectedRow();
         
         try {
             
             String id=Df.getValueAt(selectedIndex,0).toString();
             
             int dialogResult=JOptionPane.showConfirmDialog(null, "Do you want to delete this customer record","Warning",JOptionPane.YES_NO_OPTION);
             
             if(dialogResult==JOptionPane.YES_OPTION){
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost/order_management","root","");
                ps=con.prepareStatement("delete from customer where cust_id=?");
                ps.setString(1,id);
                ps.executeUpdate();
            
                JOptionPane.showMessageDialog(this, "Customer is Deleted");
                 customerTable_update();
            
                txtcustId.setText("");
                txtmobile.setText("");
                txtcustName.setText("");

                txtcustId.requestFocus();
           
             }        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcustId;
    private javax.swing.JTextField txtcustName;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
