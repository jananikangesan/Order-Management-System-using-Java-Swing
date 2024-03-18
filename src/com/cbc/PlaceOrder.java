/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cbc;

import com.cbc.model.OrderItem;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 * 
 */
public class PlaceOrder extends javax.swing.JFrame {

    /**
     * Creates new form PlaceOrder
     */
    Connection con;
    PreparedStatement psCustData,psItemData ;
    
   // generate order id 
   private String generateOrderID() {
    try {
        
        String sql = "SELECT MAX(order_id) AS max_order_id FROM new_order";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        
        if (rs.next()) {
            
            String latestOrderID = rs.getString("max_order_id");

            String numericPart = latestOrderID.substring(3); 

            int orderIDCounter = Integer.parseInt(numericPart) + 1;

            return String.format("ORD%03d", orderIDCounter);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return "ORD001";
}
    //constructor
    public PlaceOrder() {
        initComponents();
        connect();
        initBackButton();
        AddComboBoxData();
        
         // Generate the order ID when the form is initialized
        txtorderId.setText(generateOrderID());
        
        CustIdCombo.addActionListener(this::ComboActionPerformed);
        itemIdCombo.addActionListener(this::ComboActionPerformed);
        
    // Add key listener to txtqty   
    txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                String selectedItem = (String) itemIdCombo.getSelectedItem();
                String description = txtdescription.getText();
                double unitPrice = Double.parseDouble(txtUnitPrice.getText());
                int quantity = Integer.parseInt(txtqty.getText());

                double totalPrice = unitPrice * quantity;

                Object[] rowData = {selectedItem, description, quantity, unitPrice, totalPrice};

                DefaultTableModel model = (DefaultTableModel) showItem.getModel();
                model.addRow(rowData);

                updateTotalAmount();
            }
        }
    });
    
    // Set current date and time in order date field
    setCurrentDateTime();
                    
    }
    
    // set the current date and time to the order date field
    private void setCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        txtorderDate.setText(formattedDateTime);
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcustName = new javax.swing.JTextField();
        CustIdCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtorderId = new javax.swing.JTextField();
        txtorderDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        itemIdCombo = new javax.swing.JComboBox<>();
        txtdescription = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        txtQtyOnHand = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        showItem = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Place New Order");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Customer Id");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customer Name");

        CustIdCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Order Id");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Order Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Item Code");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Description");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Qty");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Unit Price");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Qty On Hand");

        itemIdCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        showItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Description", "Qty", "Unit Price", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(showItem);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Total Amount");

        removeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removeButton.setText("Remove Item");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setText("Save & Print");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("<<Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcustName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtorderId, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtorderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(26, 26, 26)
                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(125, 125, 125)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtorderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtorderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(removeButton)
                    .addComponent(backButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //operation of remove button
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
     
        DefaultTableModel model = (DefaultTableModel) showItem.getModel();
        int selectedRow = showItem.getSelectedRow();

        if (selectedRow != -1) { 
            
             int dialogResult=JOptionPane.showConfirmDialog(null, "Do you want to delete this item","Warning",JOptionPane.YES_NO_OPTION);
            
             if(dialogResult==JOptionPane.YES_OPTION){
                
                model.removeRow(selectedRow);

                updateTotalAmount();
             }
            
        } else {
           
            System.out.println("Please select a row to remove.");
        }
        
    }//GEN-LAST:event_removeButtonActionPerformed

    // Clear the fields
    private void clearAllFields() {
        
    // Clear combo boxes
    CustIdCombo.setSelectedIndex(0);
    itemIdCombo.setSelectedIndex(0);
    
    // Clear text fields
    txtorderId.setText(generateOrderID());
    txtcustName.setText("");
    txtqty.setText("");
    txtdescription.setText("");
    txtUnitPrice.setText("");
    txtQtyOnHand.setText("");
    txtTotalAmount.setText("");
    
    setCurrentDateTime();
    
    // Clear JTable
    DefaultTableModel model = (DefaultTableModel) showItem.getModel();
    model.setRowCount(0);
   }

    // save the order into the database
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
         try {
        
        String orderId = txtorderId.getText(); 
        String customerId = (String) CustIdCombo.getSelectedItem(); 
        
        String orderDate = txtorderDate.getText();
        double totalAmount = Double.parseDouble(txtTotalAmount.getText()); 

        DefaultTableModel model = (DefaultTableModel) showItem.getModel();
        int rowCount = model.getRowCount();
        List<OrderItem> itemsList = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            String itemId = (String) model.getValueAt(i, 0);
            String description = (String) model.getValueAt(i, 1);
            int quantity = (int) model.getValueAt(i, 2);
            double unitPrice = (double) model.getValueAt(i, 3);
            double amount = (double) model.getValueAt(i, 4);
            
            OrderItem item = new OrderItem(itemId, description, quantity, unitPrice, amount);
            itemsList.add(item);
        }

        // Serialize itemsList to JSON using Gson
        Gson gson = new Gson();
        String itemsJson = gson.toJson(itemsList);

        
        String sql = "INSERT INTO new_order (order_id, cust_id, items, total_amount, order_date) VALUES (?, ?, ?, ?, ?)";

        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, orderId);
        ps.setString(2, customerId);
        ps.setString(3, itemsJson); 
        ps.setDouble(4, totalAmount);
        ps.setString(5, orderDate);

        
        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Data saved successfully.");
            JOptionPane.showMessageDialog(this, "Order placed successfully.");

            for (OrderItem item : itemsList) {
                updateQtyOnHand(item.getItemId(), item.getQuantity());
            }
            
            clearAllFields();
        } else {
            System.out.println("Failed to save data.");
            JOptionPane.showMessageDialog(this, "Failed to place order.");
        }
    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
    }
         
    }//GEN-LAST:event_saveButtonActionPerformed
   
    //updating qty on hand
    private void updateQtyOnHand(String itemId, int quantityOrdered) throws SQLException {
        
        String sql = "UPDATE item SET qty_on_hand = qty_on_hand - ? WHERE item_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, quantityOrdered);
        ps.setString(2, itemId);

        ps.executeUpdate();
    }
    
    //updating total amount 
    private void updateTotalAmount() {
        double totalAmount = 0;
        DefaultTableModel model = (DefaultTableModel) showItem.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object totalPriceObj = model.getValueAt(i, 4); 
            if (totalPriceObj != null) {
                double totalPrice = (double) totalPriceObj;
                totalAmount += totalPrice;
            }
        }
        txtTotalAmount.setText(String.valueOf(totalAmount));
}

    // connecting the application to the Database
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/order_management","root","");
            System.out.println("Connected to the database");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }
    //operation of back button
    private void initBackButton() {
       
        backButton.addActionListener(e -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            dispose(); 
        });
        add(backButton);
        backButton.setBounds(20, 485, 100, 30); 
    }
    
    // add/display the data into the combo box
    public void AddComboBoxData() {
            try {
                psCustData = con.prepareStatement("select * from customer");
                ResultSet rsCust = psCustData.executeQuery();
                
                  while (rsCust.next()) {
                   
                    String customerId = rsCust.getString(1);
                    CustIdCombo.addItem(customerId);
                }


                psItemData = con.prepareStatement("select * from item"); 
                ResultSet rsItem = psItemData.executeQuery(); // 

              
                while (rsItem.next()) {
                    String itemId = rsItem.getString(1);
                    itemIdCombo.addItem(itemId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

     // combo box actions
    private void ComboActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        String selectedCustomer = (String) CustIdCombo.getSelectedItem();
        
        txtcustName.setText(getCustomerName(selectedCustomer));

        String selectedItem = (String) itemIdCombo.getSelectedItem();
        System.out.println("Selected item: " + selectedItem); 
        
        ResultSet itemDetails = getItem(selectedItem);
        try {
            
            if (itemDetails != null && itemDetails.next()) {
                
                txtdescription.setText(itemDetails.getString("item_name"));
                txtUnitPrice.setText(itemDetails.getString("unit_price"));
                txtQtyOnHand.setText(itemDetails.getString("qty_on_hand"));
            } else {
                System.out.println("No item details found for item code: " + selectedItem); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    // Method to retrieve customer name based on customer ID                                     
    private String getCustomerName(String customerId) {
        String customerName = "";
        try {
            PreparedStatement ps = con.prepareStatement("SELECT cust_name FROM customer WHERE cust_id = ?");
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customerName = rs.getString("cust_name");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerName;
    }
    
    // Method to retrieve item's details based on item ID
     private ResultSet getItem(String itemId) {
       
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM item WHERE item_id = ?");
            ps.setString(1, itemId);
             rs = ps.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return rs;
    }
     
     
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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CustIdCombo;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> itemIdCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable showItem;
    private javax.swing.JTextField txtQtyOnHand;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtcustName;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtorderDate;
    private javax.swing.JTextField txtorderId;
    private javax.swing.JTextField txtqty;
    // End of variables declaration//GEN-END:variables
}
