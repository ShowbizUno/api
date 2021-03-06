/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;




import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi.DAO.TaxiDAO;
import taxi.metier.API_TAXI;
/**
 *
 * @author Allison
 */
public class Recherche_taxi_descri extends javax.swing.JPanel {

    /**
     * Creates new form Recherche_taxi_descri
     */
     TaxiDAO taxiDAO = null;
     DefaultTableModel dft1 = new DefaultTableModel();

     
    
    public Recherche_taxi_descri() {
        initComponents();
        dft1.addColumn("Id_taxi");
        dft1.addColumn("Immatriculation");
        dft1.addColumn("Carburant");
        dft1.addColumn("Prix au km");
        dft1.addColumn("Description");
        tbl_rech.setModel(dft1);
        
        
    }
    
    public void setTaxiDAO(TaxiDAO taxiDAO) {
        this.taxiDAO = taxiDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_rech = new javax.swing.JTable();
        txt_desc = new javax.swing.JTextField();
        lbl_desc = new javax.swing.JLabel();

        lbl_titre.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        lbl_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titre.setText("Recherche de taxi(s) sur base d'une description");

        tbl_rech.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_rech);

        txt_desc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_desc.setMinimumSize(new java.awt.Dimension(50, 20));
        txt_desc.setPreferredSize(new java.awt.Dimension(150, 30));
        txt_desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descActionPerformed(evt);
            }
        });

        lbl_desc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_desc.setText("Description recherchée :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_titre, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_titre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_desc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descActionPerformed
        try{ 
        String nomRech=txt_desc.getText();
        List<API_TAXI> alc= taxiDAO.rechDesc(nomRech);
        int nr = dft1.getRowCount();
        for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
        for(API_TAXI ta:alc){
            Vector v = new Vector();
            v.add(ta.getIdtaxi());
            v.add(ta.getImmatriculation());
            v.add(ta.getCarburant());
            v.add(ta.getPrixkm());
            v.add(ta.getDescription());
            
            dft1.addRow(v);
           
        }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txt_descActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_desc;
    private javax.swing.JLabel lbl_titre;
    private javax.swing.JTable tbl_rech;
    private javax.swing.JTextField txt_desc;
    // End of variables declaration//GEN-END:variables
}
