/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import taxi.DAO.LocationDAO;
import taxi.metier.API_LOCATIONTAXI;

/**
 *
 * @author Allison
 */
public class Crea_loc extends javax.swing.JPanel {

    LocationDAO locationDAO = null;

    /**
     * Creates new form Crea_loc
     */
    public Crea_loc() {
        initComponents();
    }

    public void setLocationDAO(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_acompte = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        btn_créer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_dateloc = new javax.swing.JLabel();
        lbl_kmtotaux = new javax.swing.JLabel();
        lbl_acompte = new javax.swing.JLabel();
        lbl_id_loc = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        txt_id_loc = new javax.swing.JTextField();
        txt_kmtotaux = new javax.swing.JTextField();
        txt_dateloc_jour = new javax.swing.JTextField();
        lbl_adrdebut = new javax.swing.JLabel();
        txt_adrdebut = new javax.swing.JTextField();
        lbl_adrfin = new javax.swing.JLabel();
        txt_adrfin = new javax.swing.JTextField();
        lbl_idclient = new javax.swing.JLabel();
        txt_idclient = new javax.swing.JTextField();
        lbl_idtaxi = new javax.swing.JLabel();
        txt_idtaxi = new javax.swing.JTextField();
        txt_dateloc_an = new javax.swing.JTextField();
        txt_dateloc_mois = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        txt_acompte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_acompte.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_acompte.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_total.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_total.setPreferredSize(new java.awt.Dimension(150, 30));

        btn_créer.setText("Créer cette location");
        btn_créer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_créerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Création d'une location");

        lbl_dateloc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_dateloc.setText("Date de la location : ");

        lbl_kmtotaux.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_kmtotaux.setText("Km totaux : ");

        lbl_acompte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_acompte.setText("Acompte : ");

        lbl_id_loc.setText("N° d'identifiant de la location : ");

        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("Total : ");

        txt_id_loc.setEditable(false);
        txt_id_loc.setBackground(new java.awt.Color(153, 153, 153));
        txt_id_loc.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_id_loc.setPreferredSize(new java.awt.Dimension(150, 30));
        txt_id_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_locActionPerformed(evt);
            }
        });

        txt_kmtotaux.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_kmtotaux.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_kmtotaux.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_dateloc_jour.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_dateloc_jour.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_dateloc_jour.setPreferredSize(new java.awt.Dimension(150, 30));

        lbl_adrdebut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_adrdebut.setText("Adresse de début : ");

        txt_adrdebut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_adrdebut.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_adrdebut.setPreferredSize(new java.awt.Dimension(150, 30));

        lbl_adrfin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_adrfin.setText("Adresse de fin : ");

        txt_adrfin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_adrfin.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_adrfin.setPreferredSize(new java.awt.Dimension(150, 30));

        lbl_idclient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_idclient.setText("N° d'identifiant du client : ");

        txt_idclient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idclient.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_idclient.setPreferredSize(new java.awt.Dimension(150, 30));

        lbl_idtaxi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_idtaxi.setText("N° d'identifiant du taxi : ");

        txt_idtaxi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idtaxi.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_idtaxi.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_dateloc_an.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_dateloc_an.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_dateloc_an.setPreferredSize(new java.awt.Dimension(150, 30));

        txt_dateloc_mois.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_dateloc_mois.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_dateloc_mois.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel2.setText("J");

        jLabel3.setText("M");

        jLabel4.setText("A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lbl_id_loc)
                        .addGap(5, 5, 5)
                        .addComponent(txt_id_loc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_adrdebut, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_adrfin, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_dateloc, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbl_kmtotaux, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                        .addComponent(lbl_acompte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_dateloc_jour, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_dateloc_mois, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_dateloc_an, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_kmtotaux, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_acompte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(txt_adrfin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(txt_adrdebut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(txt_total, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lbl_idtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_idtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_idclient, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_idclient, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btn_créer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_loc)
                    .addComponent(txt_id_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dateloc)
                    .addComponent(jLabel2)
                    .addComponent(txt_dateloc_jour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_dateloc_mois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_dateloc_an, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kmtotaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_kmtotaux))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_acompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_acompte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_adrdebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_adrdebut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_adrfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_adrfin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idclient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_idtaxi))
                .addGap(18, 18, 18)
                .addComponent(btn_créer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_créerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_créerActionPerformed
        try {
            //Code de la récupération de date réalisé avec l'aide d'Arnaud Laffineur
            int day = Integer.parseInt(txt_dateloc_jour.getText());
            int month = Integer.parseInt(txt_dateloc_mois.getText());
            int year = Integer.parseInt(txt_dateloc_an.getText());
            //System.out.println("Nous sommes le " + day + " " + month + " " + year);
            LocalDate dt = LocalDate.of(year, month, day);
            //System.out.println(dt);
            
            int prixkm = Integer.parseInt(txt_kmtotaux.getText());
            float acompte = Float.parseFloat(txt_acompte.getText());
            float total = Float.parseFloat(txt_total.getText());
            int adrdebut = Integer.parseInt(txt_adrdebut.getText());
            int adrfin = Integer.parseInt(txt_adrfin.getText());
            int idclient = Integer.parseInt(txt_idclient.getText());
            int idtaxi = Integer.parseInt(txt_idtaxi.getText());

            API_LOCATIONTAXI loc1 = new API_LOCATIONTAXI(0, dt, prixkm, acompte, total, adrdebut, adrfin, idclient, idtaxi);
            loc1 = locationDAO.create(loc1);
            txt_id_loc.setText("" + loc1.getIdloc());
            JOptionPane.showMessageDialog(this, "location créée", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_créerActionPerformed

    private void txt_id_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_locActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_locActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_créer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_acompte;
    private javax.swing.JLabel lbl_adrdebut;
    private javax.swing.JLabel lbl_adrfin;
    private javax.swing.JLabel lbl_dateloc;
    private javax.swing.JLabel lbl_id_loc;
    private javax.swing.JLabel lbl_idclient;
    private javax.swing.JLabel lbl_idtaxi;
    private javax.swing.JLabel lbl_kmtotaux;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTextField txt_acompte;
    private javax.swing.JTextField txt_adrdebut;
    private javax.swing.JTextField txt_adrfin;
    private javax.swing.JTextField txt_dateloc_an;
    private javax.swing.JTextField txt_dateloc_jour;
    private javax.swing.JTextField txt_dateloc_mois;
    private javax.swing.JTextField txt_id_loc;
    private javax.swing.JTextField txt_idclient;
    private javax.swing.JTextField txt_idtaxi;
    private javax.swing.JTextField txt_kmtotaux;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
