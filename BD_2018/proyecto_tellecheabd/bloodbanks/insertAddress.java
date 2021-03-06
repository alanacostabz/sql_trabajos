/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbanks;

import static bloodbanks.insertCategory.RET_CANCEL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class insertAddress extends javax.swing.JFrame {

    /**
     * Creates new form insertAddress
     */
    private final HashMap pais;
    private final HashMap estado;
    private final HashMap ciudad;
    public static final int RET_OK = 1;
    private final Database db;

    public insertAddress(java.awt.Frame parent, Database db) {
        initComponents();
        this.db = db;
        pais = new HashMap<String, Integer>();
        estado = new HashMap<String, Integer>();
        ciudad = new HashMap<String, Integer>();
        buildComboPais();
        buildComboEstado();
        //buildComboCiudad();

    }

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
        txtEdificio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextArea();
        comboPais = new javax.swing.JComboBox<>();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboCiudad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("No. Edificio:");

        jLabel2.setText("Calle:");

        jLabel3.setText("Código postal:");

        jLabel4.setText("Ciudad:");

        jLabel6.setText("País:");

        jLabel7.setText("Detalles:");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDetalles.setColumns(20);
        txtDetalles.setLineWrap(true);
        txtDetalles.setRows(5);
        jScrollPane1.setViewportView(txtDetalles);

        comboPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboPais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboPaisFocusLost(evt);
            }
        });

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboEstadoFocusLost(evt);
            }
        });

        jLabel8.setText("Estado:");

        comboCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboCiudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboCiudadFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdificio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String edificio = txtEdificio.getText();
        String cp = txtCP.getText();
        String calle = txtCalle.getText();
        String detalles = txtDetalles.getText();
        String cPais = comboPais.getSelectedItem().toString();
        String cEstado = comboEstado.getSelectedItem().toString();
        String cCiudad = comboCiudad.getSelectedItem().toString();
        if (edificio.isEmpty() || cp.isEmpty() || calle.isEmpty()
                || comboPais.getSelectedItem().toString().equals("Seleccionar") || comboEstado.getSelectedItem().toString().equals("Seleccionar")
                || comboCiudad.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(rootPane, "Todos los campos tienen que llenarse correctamente");
        } else {
            
            if (detalles.equals("") || detalles.equals(" ")) {
                detalles = "N/A";
            }

            try {

                int input = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de agregar la dirección?", "Agregar dirección", 0);
                if (input == 0) {
                    StringBuilder sql
                            = new StringBuilder("INSERT INTO public.address (building_number,street,city,postal_code,state,country,address_details) VALUES (\'");
                    sql.append(edificio.toUpperCase());
                    sql.append("\','");
                    sql.append(calle.toUpperCase());
                    sql.append("\','");
                    sql.append(cCiudad.toUpperCase());
                    sql.append("\','");
                    sql.append(cp.toUpperCase());
                    sql.append("\','");
                    sql.append(cEstado.toUpperCase());
                    sql.append("\','");
                    sql.append(cPais.toUpperCase());
                    sql.append("\','");
                    sql.append(detalles.toUpperCase());
                    sql.append("\');");
                    System.out.println(sql.toString());
                    db.update(sql.toString());

                    JOptionPane.showMessageDialog(this, "La dirección se ha agregado correctamente.");
                    // doClose(returnStatus);

                    txtEdificio.setText("");
                    txtCP.setText("");
                    txtCalle.setText("");
                    txtDetalles.setText("");
                    comboEstado.removeAllItems();
                    comboCiudad.removeAllItems();
                    estado.clear();
                    ciudad.clear();
                    String select = "Seleccionar";
                    comboEstado.addItem(select);
                    comboCiudad.addItem(select);
                    comboPais.addItem(select);

                }
            } catch (SQLException ex) {
                Logger.getLogger(insertCategory.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
   
        doClose(RET_CANCEL);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboPaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboPaisFocusLost
        // TODO add your handling code here:
        if (comboPais.getSelectedItem().toString().equals("Seleccionar")) {
            comboEstado.removeAllItems();
            comboCiudad.removeAllItems();
            estado.clear();
            ciudad.clear();
            String select = "Seleccionar";
            comboEstado.addItem(select);
            comboCiudad.addItem(select);
        } else {
            try {
                Integer Pais = (Integer) pais.get(comboPais.getSelectedItem());
                final String sql = String.format("select state_id, state_name from public.state where state_id = %s order by state_name", Pais.intValue());
                comboEstado.removeAllItems();
                estado.clear();
                ResultSet rs = db.query(sql);
                String select = "Seleccionar";
                comboEstado.addItem("Seleccionar");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    comboEstado.addItem(name);
                    estado.put(name, id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(insertAddress.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_comboPaisFocusLost

    private void comboEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboEstadoFocusLost
        // TODO add your handling code here:
        if (comboEstado.getSelectedItem().toString().equals("Seleccionar")) {
            comboCiudad.removeAllItems();
            ciudad.clear();
            String select = "Seleccionar";
            comboCiudad.addItem(select);
        } else {
            try {
                Integer Estado = (Integer) estado.get(comboEstado.getSelectedItem());
                final String sql = String.format("select city_id, city_name from public.city where state_id = %s order by city_name", Estado.intValue());
                comboCiudad.removeAllItems();
                ciudad.clear();
                ResultSet rs = db.query(sql);
                String select = "Seleccionar";
                comboCiudad.addItem("Seleccionar");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    comboCiudad.addItem(name);
                    ciudad.put(name, id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(insertAddress.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_comboEstadoFocusLost

    private void comboCiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboCiudadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCiudadFocusLost
    private int returnStatus = RET_CANCEL;

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    private void buildComboPais() {
        try {
            final String sql = "SELECT * from public.country order by pais_nombre";

            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboPais.addItem(name);
                pais.put(name, id);

            }
        } catch (SQLException ex) {
            Logger.getLogger(insertAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buildComboEstado() {
        final String sql = "select state_id, public.state.pais_id from public.state inner join public.country on public.state.pais_id = public.country.pais_id order by public.state.state_name";
        int ide = 0;
        int aux = 0;
        try {

            ResultSet rs = db.query(sql);
            int contador = 0;
            while (rs.next()) {
                int id = rs.getInt(2);
                contador++;
                if (contador == 1) {
                    aux = ide;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(insertAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
        final String sql1 = "select state_id, state_name from public.state where pais_id = " + aux + " order by state_name";
        try {

            ResultSet rs = db.query(sql1);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboEstado.addItem(name);
                estado.put(name, id);

            }
        } catch (SQLException ex) {
            Logger.getLogger(insertAddress.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCiudad;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboPais;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextArea txtDetalles;
    private javax.swing.JTextField txtEdificio;
    // End of variables declaration//GEN-END:variables
}
