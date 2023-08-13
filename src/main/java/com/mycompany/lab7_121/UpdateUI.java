package com.mycompany.lab7_121;


import com.mycompany.lab7_121.UserUI;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author qdaon
 */
public class UpdateUI extends javax.swing.JFrame {
    InsurancePolicy policy;
    UserUI userUI;
    /**
     * Creates new form UpdateUI
     */
    public UpdateUI(final InsurancePolicy policy, final UserUI userUI) {
        initComponents();
        this.policy = policy;
        this.userUI = userUI;
        this.policyIDText.setText(policy.getId() + "");
        this.policyNameText.setText(policy.getPolicyHolderName());
        this.modelText.setText(policy.getCar().getModel());
        this.typeComboBox.setSelectedItem(policy.getCar().getCarType().toString());
        this.manufacturingYearText.setText(policy.getCar().getManufacturingYear() + "");
        this.priceText.setText(policy.getCar().getPrice() + "");
        this.claimsText.setText(policy.getNumberOfClaims() + "");
        this.dayText.setText(policy.getExpiryDate().getDay() + "");
        this.monthText.setText(policy.getExpiryDate().getMonth() + "");
        this.yearText.setText(policy.getExpiryDate().getYear() + "");
        if (policy instanceof ThirdPartyPolicy) {
            this.tppButton.setSelected(true);
            this.cpButton.setSelected(false);
            this.commentsAgeLabel.setText("Comments");
            this.commentsAgeText.setText(((ThirdPartyPolicy) policy).comments);
            this.levelLabel.setVisible(false);
            this.levelText.setVisible(false);
            this.levelText.setText("");
        }
        else {
            this.tppButton.setSelected(false);
            this.cpButton.setSelected(true);
            this.commentsAgeLabel.setText("Age");
            this.commentsAgeText.setText(((ComprehensivePolicy) policy).driverAge + "");
            this.levelLabel.setVisible(true);
            this.levelText.setVisible(true);
            this.levelText.setText(((ComprehensivePolicy)policy).level + "");
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

        tppButton = new javax.swing.JRadioButton();
        cpButton = new javax.swing.JRadioButton();
        policyIDLabel = new javax.swing.JLabel();
        policyIDText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        policyNameText = new javax.swing.JTextField();
        modelLabel = new javax.swing.JLabel();
        modelText = new javax.swing.JTextField();
        manufactureYearLabel = new javax.swing.JLabel();
        manufacturingYearText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        claimsText = new javax.swing.JTextField();
        expiryDateLabel = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        dayText = new javax.swing.JTextField();
        monthLabel = new javax.swing.JLabel();
        monthText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        yearText = new javax.swing.JTextField();
        commentsAgeLabel = new javax.swing.JLabel();
        commentsAgeText = new javax.swing.JTextField();
        levelLabel = new javax.swing.JLabel();
        levelText = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        typeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tppButton.setText("Third Party Policy ");
        tppButton.setEnabled(false);
        tppButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tppButtonStateChanged(evt);
            }
        });

        cpButton.setText("Comprehensive Policy");
        cpButton.setEnabled(false);
        cpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpButtonActionPerformed(evt);
            }
        });

        policyIDLabel.setText("Policy ID");

        policyIDText.setEditable(false);
        policyIDText.setEnabled(false);

        jLabel1.setText("Policy Holder Name");

        modelLabel.setText("model");

        manufactureYearLabel.setText("Manufacture Year");

        jLabel2.setText("Price");

        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });

        jLabel3.setText("Number Of Claims");

        claimsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimsTextActionPerformed(evt);
            }
        });

        expiryDateLabel.setText("Expiry Date");

        dayLabel.setText("Day");

        dayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTextActionPerformed(evt);
            }
        });

        monthLabel.setText("Month");

        monthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthTextActionPerformed(evt);
            }
        });

        jLabel4.setText("Year");

        yearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextActionPerformed(evt);
            }
        });

        commentsAgeLabel.setText("Comments");

        commentsAgeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentsAgeTextActionPerformed(evt);
            }
        });

        levelLabel.setText("Level");

        levelText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelTextActionPerformed(evt);
            }
        });

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        typeLabel.setText("Car Type");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SED", "SUV", "LUX", "HATCH" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tppButton)
                                .addGap(19, 19, 19)
                                .addComponent(cpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(policyIDLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(policyIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(237, 237, 237))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(modelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(349, 349, 349)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateButton)
                                    .addComponent(clearButton)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(manufactureYearLabel)
                            .addComponent(jLabel3)
                            .addComponent(expiryDateLabel)
                            .addComponent(typeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(policyNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(typeComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE)
                                .addComponent(claimsText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(priceText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(manufacturingYearText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(modelText, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(monthLabel)
                                            .addComponent(dayLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(commentsAgeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commentsAgeText, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(145, 145, 145)
                        .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tppButton)
                    .addComponent(cpButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(policyIDLabel)
                    .addComponent(policyIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(policyNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton)
                    .addComponent(modelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manufacturingYearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufactureYearLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(claimsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dayLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(expiryDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentsAgeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLabel)
                    .addComponent(commentsAgeLabel))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        policyIDText.setText("");
        policyNameText.setText("");
        modelText.setText("");
        manufacturingYearText.setText("");
        priceText.setText("");
        claimsText.setText("");
        dayText.setText("");
        monthText.setText("");
        yearText.setText("");
        commentsAgeText.setText("");
        levelText.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void tppButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tppButtonStateChanged
        // TODO add your handling code here:
        if (tppButton.isSelected()){
            this.levelLabel.setVisible(false);
            this.levelText.setVisible(false);;
            this.commentsAgeText.setText("Comments");
        }
        else {
            this.levelLabel.setVisible(true);
            this.levelText.setVisible(true);;
            this.commentsAgeText.setText("Age");
        }
    }//GEN-LAST:event_tppButtonStateChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
            final String policyHolderName = policyNameText.getText();
            final String model = modelText.getText();
            final CarType type = CarType.valueOf(typeComboBox.getSelectedItem().toString());
            final int manufacturingYear = Integer.parseInt(manufacturingYearText.getText());
            final double price = Double.parseDouble(priceText.getText());
            final int numberOfClaims = Integer.parseInt(claimsText.getText());
            final int day = Integer.parseInt(dayText.getText());
            final int month = Integer.parseInt(monthText.getText());
            final int year = Integer.parseInt(yearText.getText());
            Car car = new Car(model, type, manufacturingYear, price);
            MyDate expiryDate = new MyDate(day, month, year);
            
            this.policy.policyHolderName = policyHolderName;
            this.policy.car = car;
            this.policy.numberOfClaims = numberOfClaims;
            this.policy.expiryDate = expiryDate;
            
            if (tppButton.isSelected()){
                final String comments = commentsAgeText.getText();
                ((ThirdPartyPolicy)this.policy).comments =comments;
               
            }
            else {
                final int age = Integer.parseInt(commentsAgeText.getText());
                final int level = Integer.parseInt(levelText.getText());
                ((ComprehensivePolicy)this.policy).driverAge = age;
                ((ComprehensivePolicy)this.policy).level = level;
            }
            JOptionPane.showMessageDialog(this, "Policy has been updated");
            this.userUI.fillTable();
            this.dispose();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void claimsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimsTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_claimsTextActionPerformed

    private void dayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayTextActionPerformed

    private void monthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthTextActionPerformed

    private void yearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTextActionPerformed

    private void commentsAgeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentsAgeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commentsAgeTextActionPerformed

    private void levelTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelTextActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField claimsText;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel commentsAgeLabel;
    private javax.swing.JTextField commentsAgeText;
    private javax.swing.JRadioButton cpButton;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTextField dayText;
    private javax.swing.JLabel expiryDateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextField levelText;
    private javax.swing.JLabel manufactureYearLabel;
    private javax.swing.JTextField manufacturingYearText;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField modelText;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JTextField monthText;
    private javax.swing.JLabel policyIDLabel;
    private javax.swing.JTextField policyIDText;
    private javax.swing.JTextField policyNameText;
    private javax.swing.JTextField priceText;
    private javax.swing.JRadioButton tppButton;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField yearText;
    // End of variables declaration//GEN-END:variables
}