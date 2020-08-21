/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import static WineStoreDB.editCustomers.RET_CANCEL;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author bryan
 */
public class edtiarRegion extends javax.swing.JDialog {

    /**
     * Creates new form edtiarRegion
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    private HashMap ht1;
    private final Database db;
    String nregion;
    int countryid;
    String p;
    String idreg;

    public edtiarRegion(java.awt.Frame parent, Database db) {
        super(parent, true);
        initComponents();
        this.db = db;
        String cancelName = "cancel";
        ht1 = new HashMap<String, Integer>();

        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    private int returnStatus = RET_CANCEL;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idregion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboCountry = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar región");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Región", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("ID región:");

        idregion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idregionActionPerformed(evt);
            }
        });
        idregion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idregionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idregionKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre de la región:");

        rnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rnombreKeyTyped(evt);
            }
        });

        jLabel3.setText("País:");

        comboCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCountryItemStateChanged(evt);
            }
        });
        comboCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboCountryFocusGained(evt);
            }
        });
        comboCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCountryMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboCountryMouseReleased(evt);
            }
        });
        comboCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCountryActionPerformed(evt);
            }
        });
        comboCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboCountryKeyReleased(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idregion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idregion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idregionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idregionKeyTyped
        // TODO add your handling code here:
          int limit = 7;
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar números.");
        }
        if (idregion.getText().length() == limit) {
            evt.consume();
            getToolkit().beep();
        }



    }//GEN-LAST:event_idregionKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        doClose(returnStatus);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idregionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idregionKeyReleased
        // TODO add your handling code here:
        String idr = idregion.getText().toString();
        jLabel5.setText("");
        rnombre.setEditable(true);

        if (!idr.equals("")) {
            try {
                if (validacionDatosID(idr) != 0) {
                    String sql = "select *  from winestore.ref_regions inner join winestore.ref_countries \n"
                            + "on winestore.ref_regions.country_code = winestore.ref_countries.country_code\n"
                            + "where region_code = " + idr;
                    jLabel5.setText("ID valido.");
                    ResultSet rs = db.query(sql);

                    while (rs.next()) {
                        idreg = rs.getString(1);
                        nregion = rs.getString(2);

                        countryid = rs.getInt(3);
                        p = rs.getString(5);

                        //combocountry.addItem(name);
                        ht1.put(p, countryid);
                        comboCountry.addItem(p);

                    }
                    rnombre.setText(nregion);

                    final String sql1 = "SELECT country_code,country_name FROM winestore.ref_countries order by country_name";

                    ResultSet rs1 = db.query(sql1);
                    //combocountry.addItem(auxs);
                    comboCountry.removeAllItems();
                    comboCountry.addItem(p);
                    while (rs1.next()) {

                        int idp = rs1.getInt(1);

                        String name = rs1.getString(2);
                        if (!name.equals(p)) {
                            comboCountry.addItem(name);

                            ht1.put(name, idp);
                        }

                    }

                } else {

                    jLabel5.setText("ID no existente.");
                    rnombre.setEditable(false);

                    comboCountry.setEditable(false);
                    rnombre.setText("");
                    comboCountry.removeAllItems();

                }
            } catch (SQLException ex) {
                Logger.getLogger(edtiarRegion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_idregionKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String rn = idregion.getText();
        String r = rnombre.getText();
        System.out.println(idregion.getText());
        Integer rp = (Integer) ht1.get(comboCountry.getSelectedItem());
        System.out.println(rp);
        if (rn.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Campo vacío, ingrese ID para editar.");
        } else if (r.isEmpty() || r.startsWith(" ")) {
            JOptionPane.showMessageDialog(rootPane, "Verifique que el ID de regíon sea correcto, y que los comapos esten correctamente completados.");
        } else if (rp == null) {
            JOptionPane.showMessageDialog(rootPane, "Toda región está asociada a un país.");
        } else {
            int input = JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar los cambios a la region " + r.toUpperCase() + " con ID = " + rp + "?", "Editar región", 0);
            if (input == 0) {
                try {
                    String sql = "update winestore.ref_regions set region_name = '" + r + "',country_code = " + rp + " where region_code = " + idreg;
                    db.update(sql.toString());
                    System.out.println(sql);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al editar regíon.");
                    Logger.getLogger(edtiarRegion.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Se han guardado correctamente los cambios.");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCountryActionPerformed

    }//GEN-LAST:event_comboCountryActionPerformed

    private void comboCountryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboCountryKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCountryKeyReleased

    private void comboCountryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCountryMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_comboCountryMouseReleased

    private void comboCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCountryItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_comboCountryItemStateChanged

    private void comboCountryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboCountryFocusGained

    }//GEN-LAST:event_comboCountryFocusGained

    private void comboCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCountryMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_comboCountryMouseClicked

    private void idregionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idregionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idregionActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void rnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rnombreKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rnombreKeyReleased

    private void rnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rnombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar letras.");
        }

        if (rnombre.getText().length() == 30) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_rnombreKeyTyped

    public int validacionDatosID(String vd) throws SQLException {
        String sql1 = "select region_code  from winestore.ref_regions";
        int x = 0;
        try {
            ResultSet rs = db.query(sql1);
            while (rs.next()) {

                String name = rs.getString(1);
                if (name.equalsIgnoreCase(vd)) {
                    x++;
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCountry;
    private javax.swing.JTextField idregion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField rnombre;
    // End of variables declaration//GEN-END:variables

}
