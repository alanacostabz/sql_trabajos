/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import static WineStoreDB.DeleteWinesID.RET_OK;
import static WineStoreDB.InsertRefRegion.RET_CANCEL;
import static WineStoreDB.InsertRefRegion.RET_OK;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.sql.ResultSet;

/**
 *
 * @author Maestro
 */
public class InsertYears extends javax.swing.JDialog {

    /**
     * Creates new form InsertCoffeesDialog
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    private final Database db;

    public InsertYears(java.awt.Frame parent, Database db) {
        super(parent, true);
        initComponents();
        this.db = db;
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
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
        txtaño = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar año");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Año:");

        txtaño.setColumns(42);
        txtaño.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtaño.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtañoFocusLost(evt);
            }
        });
        txtaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtañoActionPerformed(evt);
            }
        });
        txtaño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtañoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtañoKeyTyped(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        okButton.setText("Agregar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                okButtonKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                okButtonKeyTyped(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Agregar año");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(309, 309, 309))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel6)
                    .addContainerGap(521, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(134, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String text = txtaño.getText().trim();

        if (text.isEmpty() || text.equals("") || txtaño.equals("") || txtaño.equals(null)) {
            JOptionPane.showMessageDialog(this, "Campo vacío, Por favor ingrese un año.");
        } else {
            try {
                int y = 0;
                y = Integer.parseInt(text);
                if (validacionDatos(text) > 0) {
                    JOptionPane.showMessageDialog(this, "El año " + text + " ya se encuentra en la base de datos.");

                } else if (y <= 2018 && y >= 1800) {
                    int input = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de agregar el año " + text + "?", "Agregar año", 0);
                    if (input == 0) {
                        String año = txtaño.getText();

                        StringBuilder sql
                                = new StringBuilder("INSERT INTO winestore.year (year_number) VALUES (\'");
                        sql.append(año);
                        sql.append("');");
                        System.out.println(sql.toString());
                        db.update(sql.toString());
                        txtaño.setText("");
                        JOptionPane.showMessageDialog(this, "El año " + text + " ha sido agregado exitosamente.");
                        txtaño.setText("");
                        //doClose(returnStatus);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El año " + text + " no es valido.");
                    //txtaño.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertYears.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            String año = txtaño.getText();
            
            StringBuilder sql
                    = new StringBuilder("INSERT INTO winestore.year (year_number) VALUES (\'");
            sql.append(año);
            sql.append("');");
            System.out.println(sql.toString());

            try {
                db.update(sql.toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al insertar el año.");
             }
            JOptionPane.showMessageDialog(rootPane, "El año ha sido agregado exitosamente.");
        doClose(RET_OK);*/
        }


    }//GEN-LAST:event_okButtonActionPerformed

    private void closeDialog(java.awt.event.WindowEvent evt) {
        doClose(RET_CANCEL);
    }
    private int returnStatus = RET_CANCEL;

    public int getReturnStatus() {
        return returnStatus;
    }
    private void txtañoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtañoFocusLost


    }//GEN-LAST:event_txtañoFocusLost

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void txtañoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtañoKeyTyped
        int limit = 4;
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar números.");
        }
        if (txtaño.getText().length() == limit) {
            evt.consume();
            getToolkit().beep();
        }

    }//GEN-LAST:event_txtañoKeyTyped

    private void okButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okButtonKeyPressed

    }//GEN-LAST:event_okButtonKeyPressed

    private void okButtonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okButtonKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonKeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void txtañoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtañoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtañoKeyReleased

    private void txtañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtañoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtañoActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public int validacionDatos(String vd) throws SQLException {
        StringBuilder sql1 = new StringBuilder("select year_number from winestore.year");
        int x = 0;
        try {
            ResultSet rs = db.query(sql1.toString());
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField txtaño;
    // End of variables declaration//GEN-END:variables
}
