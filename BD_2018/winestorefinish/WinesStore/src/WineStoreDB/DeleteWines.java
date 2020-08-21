/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import static WineStoreDB.DeleteRefVineyards.RET_OK;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author rnavarro
 */
public class DeleteWines extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    public final Database db;
    private final HashMap ht1;
    String nombrew;
    String preciow;
    String descripcionw;
    String urlw;
    String colorw;
    String paisw;
    String tipow;
    String regionw;
    String viñedow;
    String añow;
    Date fechaw;

    /**
     * Creates new form DeleteCoffeeDialog
     */
    public DeleteWines(java.awt.Frame parent, Database db) {
        super(parent, true);
        this.db = db;

        initComponents();
        ht1 = new HashMap<String, Integer>();

        buildCombo();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();

        actionMap.put(cancelName, new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        }
        );

    }

    private void buildCombo() {
        final String sql = "SELECT wine_store_id,wine_name FROM winestore.wine_store order by wine_name";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboName.addItem(name);
                ht1.put(name, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jid = new javax.swing.JLabel();
        comboName = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jprecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcolor = new javax.swing.JTextField();
        descripcion = new javax.swing.JLabel();
        jdescripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpais = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jregion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        juva = new javax.swing.JTextField();
        Vi = new javax.swing.JLabel();
        jviñedo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jurl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jaño = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jfecha = new javax.swing.JTextField();

        setTitle("Eliminar vino por nombre");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okButton.setText("Eliminar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar vino", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID:");

        jid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        comboName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jid)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jid)
                    .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel3.setText("Precio:");

        jprecio.setEditable(false);

        jLabel2.setText("Color:");

        jcolor.setEditable(false);

        descripcion.setText("Descripcion:");

        jdescripcion.setEditable(false);

        jLabel4.setText("País:");

        jpais.setEditable(false);

        jLabel5.setText("Región:");

        jregion.setEditable(false);

        jLabel6.setText("Uva:");

        juva.setEditable(false);

        Vi.setText("Viñedo:");

        jviñedo.setEditable(false);

        jLabel7.setText("URL:");

        jurl.setEditable(false);

        jLabel8.setText("Año:");

        jaño.setEditable(false);

        jLabel9.setText("Fecha:");

        jfecha.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(descripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdescripcion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcolor))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(juva))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpais, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jregion))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Vi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jviñedo))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jurl))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jaño, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jfecha)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion)
                    .addComponent(jdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jregion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(juva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Vi)
                    .addComponent(jviñedo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jurl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String combo = comboName.getSelectedItem().toString();

        if (combo.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un vino.");
        } else {
//String item = (String) comboName.getSelectedItem();
            Integer id = (Integer) ht1.get(comboName.getSelectedItem());
            //String id = item.substring(0, item.indexOf(' '));
            int input = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de borrar el vino " + combo + " con ID = " + id + "?", "Borrar vino", 0);
            if (input == 0) {
                String sql = String.format("delete from winestore.wine_store where wine_store_id = %s", id.intValue());
                System.out.println(sql);

                try {
                    db.update(sql);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                JOptionPane.showMessageDialog(rootPane, "El vino " + combo + " ha sido eliminado exitosamente.");

                final String sql1 = String.format("SELECT wine_store_id,wine_name FROM winestore.wine_store order by wine_name");
                System.out.println(sql1.toString());

                try {
                    comboName.removeAllItems();
                    ht1.clear();
                    ResultSet rs = db.query(sql1);
                    String selet = "Seleccionar";
                    comboName.addItem(selet);
                    while (rs.next()) {
                        //comboRegion.addItem("NULL");
                        int id1 = rs.getInt(1);
                        String name = rs.getString(2);
                        comboName.addItem(name);
                        ht1.put(name, id1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                //doClose(RET_OK);
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_CancelarActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void comboNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNameActionPerformed
        // TODO add your handling code here:
        Integer aggghh = (Integer) ht1.get(comboName.getSelectedItem());
        ;

        jid.setText("");
        jprecio.setText("");
        jdescripcion.setText("");
        jurl.setText("");
        jcolor.setText("");
        jpais.setText("");
        jregion.setText("");
        juva.setText("");
        jviñedo.setText("");
        jaño.setText("");
        jfecha.setText("");

        final String sql1 = String.format("select wine_store_id, price, wine_description, url_picture_bottle, color_name, country_name, region_name, grape_variety_name,\n"
                + "winestore.ref_vineyards.vineyard_name,winestore.year.year_number,fecha_registro from winestore.wine_store \n"
                + "inner join winestore.ref_colors  on winestore.ref_colors.color_code = winestore.wine_store.color_code inner join winestore.ref_countries on\n"
                + "winestore.ref_countries.country_code = winestore.wine_store.country_code left join winestore.ref_regions on winestore.ref_regions.region_code\n"
                + "= winestore.wine_store.region_code inner join winestore.ref_grape_varieties on winestore.ref_grape_varieties.grape_variety_code \n"
                + "= winestore.wine_store.grape_variety_code left join winestore.ref_vineyards on winestore.ref_vineyards.vineyard_code \n"
                + "= winestore.wine_store.vineyard_code left join winestore.year on winestore.year.year_number = winestore.wine_store.year_number where wine_store_id = " + aggghh);
        try {

            ResultSet rs = db.query(sql1);

            while (rs.next()) {
                //comboRegion.addItem("NULL");
                nombrew = rs.getString(1);
                preciow = rs.getString(2);
                descripcionw = rs.getString(3);
                urlw = rs.getString(4);
                colorw = rs.getString(5);
                paisw = rs.getString(6);
                regionw = rs.getString(7);
                tipow = rs.getString(8);
                viñedow = rs.getString(9);
                añow = rs.getString(10);
                fechaw = rs.getDate(11);
                jid.setText(nombrew);
                jprecio.setText(preciow);
                jdescripcion.setText(descripcionw);
                jurl.setText(urlw);
                jcolor.setText(colorw);
                jpais.setText(paisw);
                jregion.setText(regionw);
                juva.setText(tipow);
                jviñedo.setText(viñedow);
                jaño.setText(añow);
                jfecha.setText(fechaw.toString());
            }
        } catch (SQLException ex) {
            System.out.println("entra");
            System.out.println(ex.getMessage());

        }
    }//GEN-LAST:event_comboNameActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Vi;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jaño;
    private javax.swing.JTextField jcolor;
    private javax.swing.JTextField jdescripcion;
    private javax.swing.JTextField jfecha;
    private javax.swing.JLabel jid;
    private javax.swing.JTextField jpais;
    private javax.swing.JTextField jprecio;
    private javax.swing.JTextField jregion;
    private javax.swing.JTextField jurl;
    private javax.swing.JTextField juva;
    private javax.swing.JTextField jviñedo;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
