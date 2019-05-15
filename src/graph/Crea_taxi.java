/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import javax.swing.JOptionPane;
import taxi.DAO.TaxiDAO;
import taxi.metier.API_TAXI;
/**
 *
 * @author Allison
 */
public class Crea_taxi extends javax.swing.JPanel {

    TaxiDAO taxiDAO=null;
    
    /**
     * Creates new form Crea_taxi
     */
    public Crea_taxi() {
        initComponents();
    }
    
    public void setTaxiDAO(TaxiDAO taxiDAO){
        this.taxiDAO=taxiDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_id_taxi = new javax.swing.JLabel();
        txt_id_taxi = new javax.swing.JTextField();
        txt_carb = new javax.swing.JTextField();
        txt_imma = new javax.swing.JTextField();
        txt_prixkm = new javax.swing.JTextField();
        txt_desc = new javax.swing.JTextField();
        btn_créer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lvl_imma1 = new javax.swing.JLabel();
        lbl_carb1 = new javax.swing.JLabel();
        lbl_prixkm1 = new javax.swing.JLabel();
        lbl_desc1 = new javax.swing.JLabel();

        lbl_id_taxi.setLabelFor(txt_id_taxi);
        lbl_id_taxi.setText("N° d'identifiant du taxi:");

        txt_id_taxi.setEditable(false);
        txt_id_taxi.setBackground(new java.awt.Color(153, 153, 153));
        txt_id_taxi.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_id_taxi.setPreferredSize(new java.awt.Dimension(150, 30));
        txt_id_taxi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_taxiActionPerformed(evt);
            }
        });

        txt_carb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_carb.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_carb.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_imma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_imma.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_imma.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_prixkm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_prixkm.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_prixkm.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_desc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_desc.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_desc.setPreferredSize(new java.awt.Dimension(150, 30));

        btn_créer.setText("Créer ce taxi");
        btn_créer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_créerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Création d'un taxi");

        lvl_imma1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lvl_imma1.setText("N° d'immatriculation du taxi :");

        lbl_carb1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_carb1.setText("Nom du carburant :");

        lbl_prixkm1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_prixkm1.setText("Prix au km :");

        lbl_desc1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_desc1.setText("Description :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_créer)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_id_taxi)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_carb1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lvl_imma1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_prixkm1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_prixkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_carb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_imma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_taxi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_taxi)
                    .addComponent(txt_id_taxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_imma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lvl_imma1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_carb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_carb1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_prixkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_prixkm1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_desc1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btn_créer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_id_taxiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_taxiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_taxiActionPerformed

    private void btn_créerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_créerActionPerformed
        try{  
       String imma=txt_imma.getText();
       String carb=txt_carb.getText();
       float prixkm=Float.parseFloat(txt_prixkm.getText());
       String desc= txt_desc.getText();
       API_TAXI t1 = new API_TAXI(0,imma,carb,prixkm,desc);
       t1=taxiDAO.create(t1);
       txt_id_taxi.setText(""+t1.getIdtaxi());
       JOptionPane.showMessageDialog(this,"taxi créé","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }

    }//GEN-LAST:event_btn_créerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_créer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_carb1;
    private javax.swing.JLabel lbl_desc1;
    private javax.swing.JLabel lbl_id_taxi;
    private javax.swing.JLabel lbl_prixkm1;
    private javax.swing.JLabel lvl_imma1;
    private javax.swing.JTextField txt_carb;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_id_taxi;
    private javax.swing.JTextField txt_imma;
    private javax.swing.JTextField txt_prixkm;
    // End of variables declaration//GEN-END:variables
}
