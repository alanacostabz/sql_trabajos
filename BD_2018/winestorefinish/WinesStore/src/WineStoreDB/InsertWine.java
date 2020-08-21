/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.KeyEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Maestro
 */
public class InsertWine extends javax.swing.JDialog {

    /**
     * Creates new form InsertCoffeesDialog
     */
    private final HashMap color;
    private final HashMap pais;
    private final HashMap region;
    private final HashMap tipoUva;
    private final HashMap viñedo;

    private final Database db;
    String s = "";

    public InsertWine(java.awt.Frame parent, Database db) {
        super(parent, true);
        initComponents();
        this.db = db;

        color = new HashMap<String, Integer>();
        pais = new HashMap<String, Integer>();
        region = new HashMap<String, Integer>();
        tipoUva = new HashMap<String, Integer>();
        viñedo = new HashMap<String, Integer>();
        buildComboColors();
        buildComboViñedo();
        buildComboYear();
        buldComboCountry();
        // buldComboRegion();
        buldCombotipoUva();
        // Construir el combo con el ID y Nombre de proveedor
        // buildCombo(db);

        JTextFieldDateEditor editor = (JTextFieldDateEditor) jfecha.getDateEditor();
        editor.setEditable(false);
        Date date = new Date();
        jfecha.setDate(date);

    }

    private void buildComboColors() {
        final String sql = "SELECT color_code,color_name FROM winestore.ref_colors ORDER BY color_name";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboColor.addItem(name);
                color.put(name, id);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void buldComboCountry() {
        final String sql = "SELECT country_code,country_name FROM winestore.ref_countries order by country_name";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboCountry.addItem(name);
                pais.put(name, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void buldComboRegion() {
        final String sql1 = "select  region_code, winestore.ref_regions.country_code from winestore.ref_regions inner join winestore.ref_countries on \n"
                + "winestore.ref_regions.country_code = winestore.ref_countries.country_code order by winestore.ref_countries.country_name";
        int ide = 0;
        int aux = 0;
        try {

            ResultSet rs = db.query(sql1);
            int contador = 0;

            while (rs.next()) {
                ide = rs.getInt(2);
                contador++;
                if (contador == 1) {
                    aux = ide;
                }

            }

            //System.out.println(aux);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        final String sql = "SELECT region_code,region_name FROM winestore.ref_regions where country_code = " + aux + " order by region_name";

        try {

            ResultSet rs = db.query(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboRegion.addItem(name);
                region.put(name, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void buldCombotipoUva() {
        final String sql = "SELECT grape_variety_code,grape_variety_name FROM winestore.ref_grape_varieties order by grape_variety_name";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboTipoUva.addItem(name);
                tipoUva.put(name, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void buildComboViñedo() {
        final String sql = "SELECT vineyard_Code,vineyard_name FROM winestore.ref_vineyards order by vineyard_name";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                comboViñedo.addItem(name);
                viñedo.put(name, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void buildComboYear() {
        final String sql = "SELECT year_number FROM winestore.year order by  year_number desc";

        try {
            ResultSet rs = db.query(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                // String name = rs.getString(2);
                comboYear.addItem(id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNameWine = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        comboColor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        comboCountry = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboRegion = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboTipoUva = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboViñedo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        comboYear = new javax.swing.JComboBox<>();
        jfecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Vino");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Precio:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Color:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Imagen URL:");

        txtNameWine.setColumns(42);
        txtNameWine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNameWine.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameWineFocusLost(evt);
            }
        });
        txtNameWine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameWineActionPerformed(evt);
            }
        });
        txtNameWine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameWineKeyTyped(evt);
            }
        });

        txtPrice.setColumns(11);
        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrice.setToolTipText("");
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        txtUrl.setColumns(11);
        txtUrl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUrl.setToolTipText("");
        txtUrl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUrlKeyTyped(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setText("Agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        comboColor.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboColor.setToolTipText("");
        comboColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColorActionPerformed(evt);
            }
        });

        txtdes.setColumns(20);
        txtdes.setRows(5);
        txtdes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdesFocusLost(evt);
            }
        });
        txtdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtdes);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("País:");

        comboCountry.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboCountry.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboCountryFocusLost(evt);
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Región:");

        comboRegion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboRegion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboRegionFocusLost(evt);
            }
        });
        comboRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboRegionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboRegionMouseReleased(evt);
            }
        });
        comboRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRegionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Viñedo:");

        comboTipoUva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboTipoUva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Variedad de uva:");

        comboViñedo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboViñedo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboViñedo.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Año:");

        comboYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboYear.setToolTipText("");

        jfecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jfechaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameWine, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboTipoUva, 0, 119, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel9)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(comboViñedo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(comboRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLabel7))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(comboColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(comboCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(addButton)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(cancelButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))))))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNameWine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(comboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboTipoUva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(comboViñedo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(58, 58, 58)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String text = txtNameWine.getText().trim();
        String p = txtPrice.getText();
        String d = txtdes.getText();
        String u = txtUrl.getText();
        String color1 = comboColor.getSelectedItem().toString();
        String pais1 = comboCountry.getSelectedItem().toString();
        String año1 = comboYear.getSelectedItem().toString();
        String v = comboViñedo.getSelectedItem().toString();
        String r = comboRegion.getSelectedItem().toString();
        StringBuilder sql;
        String nombre = txtNameWine.getText();

        String precio = txtPrice.getText();

        String url = txtUrl.getText();
        String descripcion = txtdes.getText().toString();

        if (url.length() > 100) {
            url = url.substring(0, 99);
        }
        Integer Color = (Integer) color.get(comboColor.getSelectedItem());
        Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());
        Integer reg = (Integer) region.get(comboRegion.getSelectedItem());
        Integer VariUva = (Integer) tipoUva.get(comboTipoUva.getSelectedItem());
        Integer Vi = (Integer) viñedo.get(comboViñedo.getSelectedItem());
        String Año = (String) comboYear.getSelectedItem();
        String ash = null;
        String aux = txtNameWine.getText();
        String aux2 = txtPrice.getText();
        String aux3 = txtUrl.getText();
        if (aux.isEmpty() || aux2.isEmpty() || aux3.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Verifique que los campos nombre, precio y url esten completados.");
        } else if (aux.startsWith(" ")) {
            JOptionPane.showMessageDialog(this, "Verifique que el campo nombre este correctamente completado.");
        } else if (aux2.endsWith(".")) {
            JOptionPane.showMessageDialog(this, "Verifique que el campo precio este correctamente completado.");
        } else if (comboCountry.getSelectedItem().toString().equals("Seleccionar")
                || comboColor.getSelectedItem().toString().equals("Seleccionar") || comboTipoUva.getSelectedItem().toString().equals("Seleccionar")
                || comboYear.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Asegurese de llenar correctamente los campos país, color, tipo de uva y año.");
        } else {
            String f = "";
            String dia = "";
            String mes = "";
            String year = "";
            String s = "";
            int input = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de añadir el vino " + aux.toUpperCase() + "?", "Agregar vino", 0);
            if (input == 0) {
                dia = Integer.toString(jfecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                year = Integer.toString(jfecha.getCalendar().get(Calendar.YEAR));
                mes = Integer.toString(jfecha.getCalendar().get(Calendar.MONTH) + 1);
                f = year + "-" + mes + "-" + dia;
                sql
                        = new StringBuilder("INSERT INTO winestore.wine_store (color_code, grape_variety_code,region_code, year_number,wine_name, price, wine_description,url_picture_bottle,country_code,vineyard_code, fecha_registro) VALUES (\'");
                sql.append(Color.intValue());
                sql.append("\','");
                sql.append(VariUva.intValue());

                if (comboRegion.getSelectedItem().toString().equals("Seleccionar")) {
                    sql.append("\',");
                    sql.append(ash);
                    sql.append(",'");
                } else {
                    sql.append("\','");
                    sql.append(reg);
                    sql.append("\','");
                }
                sql.append(Año);
                sql.append("\','");
                sql.append(nombre.toUpperCase());
                sql.append("\','");
                sql.append(precio);

                if (descripcion.equals("") || descripcion.startsWith(" ")) {

                    sql.append("\',");
                    sql.append(ash);
                    sql.append(",'");
                } else {
                    sql.append("\','");
                    sql.append(descripcion);
                    sql.append("\','");
                }
                sql.append(url);
                sql.append("\','");
                sql.append(Pais.intValue());
                if (comboViñedo.getSelectedItem().toString().equals("Seleccionar")) {
                    sql.append("\',");
                    sql.append(ash);
                    sql.append(",'");
                } else {
                    sql.append("\','");
                    sql.append(Vi.intValue());
                    sql.append("\','");
                }
                sql.append(f);
                sql.append("\')");
                System.out.println(sql.toString());

                try {
                    db.update(sql.toString());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al insertar nuevo Vino.");
                    System.out.println(ex.getMessage());
                }
                JOptionPane.showMessageDialog(rootPane, "El vino " + text + " ha sido añadido exitosamente.");
                setVisible(false);
            }
        }

        /*  if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introducir el nombre del vino.");
        } else if (p.length() == 0) {
            JOptionPane.showMessageDialog(this, "Introducir precio del vino.");
        } else if (u.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introducir direccion url de la foto del vino.");
        } else if (color1.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Selecciona color.");
        } else if (pais1.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione país.");
        } else if (año1.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Seleccione año.");
        } else if (r.equals("Seleccionar") || r == null) {
            String nombre = txtNameWine.getText();

            String precio = txtPrice.getText();

            String url = txtUrl.getText();
            String descripcion = jTextDescripcion.getText();

            if (url.length() > 100) {
                url = url.substring(0, 99);
            }
           Integer Color = (Integer) color.get(comboColor.getSelectedItem());
            
            Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());

            Integer VariUva = (Integer) tipoUva.get(comboTipoUva.getSelectedItem());
            Integer Viñedo = (Integer) viñedo.get(comboViñedo.getSelectedItem());
            String Año = (String) comboYear.getSelectedItem();
            StringBuilder sql
                    = new StringBuilder("INSERT INTO winestore.wine_store (wine_name,price,wine_description,url_picture_bottle,country_code,color_code,grape_variety_code,vineyard_code,year_number) VALUES (\'");
            sql.append(nombre.toUpperCase());
            sql.append("\','");
            sql.append(precio);
            sql.append("\','");
            sql.append(descripcion);
            sql.append("\','");
            sql.append(url);
            sql.append("\',");
            sql.append(Pais.intValue());
            sql.append("\','");
            sql.append(Color.intValue());
            sql.append("\','");
            sql.append(VariUva.intValue());
            sql.append("\','");
            sql.append(Viñedo.intValue());
            sql.append("\','");
            sql.append(Año);
            sql.append("\')");

            System.out.println(sql.toString());

        } else if (d.isEmpty()) {

            String nombre = txtNameWine.getText();

            String precio = txtPrice.getText();

            String url = txtUrl.getText();
            String descripcion = jTextDescripcion.getText();

            if (url.length() > 100) {
                url = url.substring(0, 99);
            }
            Integer Color = (Integer) color.get(comboColor.getSelectedItem());
            Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());
            Integer reg = (Integer) region.get(comboRegion.getSelectedItem());
            Integer VariUva = (Integer) tipoUva.get(comboTipoUva.getSelectedItem());
            Integer Viñedo = (Integer) viñedo.get(comboViñedo.getSelectedItem());
            String Año = (String) comboYear.getSelectedItem();
            StringBuilder sql
                    = new StringBuilder("INSERT INTO winestore.wine_store (wine_name,price,region_code,url_picture_bottle,country_code,color_code,grape_variety_code,vineyard_code,year_number) VALUES (\'");
            sql.append(nombre.toUpperCase());
            sql.append("\','");
            sql.append(precio);
            sql.append("\','");
            sql.append(reg);
            sql.append("\','");
            sql.append(url);
            sql.append("\','");
            sql.append(Pais.intValue());
            sql.append("\','");
            sql.append(Color.intValue());
            sql.append("\','");
            sql.append(VariUva.intValue());
            sql.append("\','");
            sql.append(Viñedo.intValue());
            sql.append("\','");
            sql.append(Año);
            sql.append("\')");

            System.out.println(sql.toString());
             try {
                db.update(sql.toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al insertar nuevo Vino.");
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(rootPane, "El vino " + text + " ha sido añadido exitosamente.");
            setVisible(false);

        } else if (d.isEmpty() && (r.isEmpty() || r == null)) {
              String nombre = txtNameWine.getText();

            String precio = txtPrice.getText();

            String url = txtUrl.getText();
            String descripcion = jTextDescripcion.getText();

            if (url.length() > 100) {
                url = url.substring(0, 99);
            }
            Integer Color = (Integer) color.get(comboColor.getSelectedItem());
            Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());
            Integer reg = (Integer) region.get(comboRegion.getSelectedItem());
            Integer VariUva = (Integer) tipoUva.get(comboTipoUva.getSelectedItem());
            Integer Viñedo = (Integer) viñedo.get(comboViñedo.getSelectedItem());
            String Año = (String) comboYear.getSelectedItem();
            StringBuilder sql
                    = new StringBuilder("INSERT INTO winestore.wine_store (wine_name,price,url_picture_bottle,country_code,color_code,grape_variety_code,vineyard_code,year_number) VALUES (\'");
            sql.append(nombre.toUpperCase());
            sql.append("\','");
            sql.append(precio);
             sql.append("\','");
            sql.append(url);
            sql.append("\','");
            sql.append(Pais.intValue());
            sql.append("\','");
            sql.append(Color.intValue());
            sql.append("\','");
            sql.append(VariUva.intValue());
            sql.append("\','");
            sql.append(Viñedo.intValue());
            sql.append("\','");
            sql.append(Año);
            sql.append("\')");

            System.out.println(sql.toString());
             try {
                db.update(sql.toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al insertar nuevo Vino.");
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(rootPane, "El vino " + text + " ha sido añadido exitosamente.");
            setVisible(false);
        }*/
 /* else {

            String nombre = txtNameWine.getText();

            String precio = txtPrice.getText();

            String url = txtUrl.getText();
            String descripcion = jTextDescripcion.getText();

            if (url.length() > 100) {
                url = url.substring(0, 99);
            }
            Integer Color = (Integer) color.get(comboColor.getSelectedItem());
            Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());

            Integer VariUva = (Integer) tipoUva.get(comboTipoUva.getSelectedItem());
            Integer Viñedo = (Integer) viñedo.get(comboViñedo.getSelectedItem());
            String Año = (String) comboYear.getSelectedItem();
            StringBuilder sql
                    = new StringBuilder("INSERT INTO winestore.wine_store (wine_name,price,wine_description,url_picture_bottle,region_code,country_code,color_code,grape_variety_code,vineyard_code,year_number) VALUES (\'");
            sql.append(nombre.toUpperCase());
            sql.append("\','");
            sql.append(precio);
            sql.append("\','");
            sql.append(descripcion);
            sql.append("\','");
            sql.append(url);
            sql.append("\',");
            if (comboRegion.getModel().getSize() < 1) {
                sql.append("null");
            } else {
                Integer Region = (Integer) region.get(comboRegion.getSelectedItem());
                sql.append(Region.intValue());

            }

            sql.append(",'");
            sql.append(Pais.intValue());
            sql.append("\','");
            sql.append(Color.intValue());
            sql.append("\','");
            sql.append(VariUva.intValue());
            sql.append("\','");
            sql.append(Viñedo.intValue());
            sql.append("\','");
            sql.append(Año);
            sql.append("\')");

            System.out.println(sql.toString());

            try {
                db.update(sql.toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al insertar nuevo Vino.");
                System.out.println(ex.getMessage());
            }
            JOptionPane.showMessageDialog(rootPane, "El vino " + text + " ha sido añadido exitosamente.");
            setVisible(false);
        }*/
    }//GEN-LAST:event_addButtonActionPerformed

    private void txtNameWineFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameWineFocusLost

    }//GEN-LAST:event_txtNameWineFocusLost

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        /* String value = txtPrice.getText().trim();
        if (value.isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Introducir el precio del vino.");
        } else {

            try {
                Double.parseDouble(value);
            } catch (NullPointerException np) {
                JOptionPane.showMessageDialog(this, "Introducir valor numerico en precio.");
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(this, "Introducir valor numerico en precio.");
            }
        }*/

    }//GEN-LAST:event_txtPriceFocusLost

    private void comboColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColorActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboColorActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        // TODO add your handling code here:

        /*int limit = 7;
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE && c != '.') {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar números.");
        }
        if (txtPrice.getText().length() == limit) {
            evt.consume();
            getToolkit().beep();
        }*/
        int c = (int) evt.getKeyChar();
        if (c >= 46 && c <= 57) {
            if (c == 46) {
                String dato = txtPrice.getText();
                int t = dato.length();
                for (int i = 0; i <= t; i++) {
                    if (dato.contains(".")) {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                    }

                }
                if (c == 47) {
                    evt.consume();
                }

            }

        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            evt.consume();
        }


    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyTyped
        // TODO add your handling code here:
        if (txtdes.getText().length() == 100) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtdesKeyTyped

    private void txtUrlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUrlKeyTyped
        // TODO add your handling code here:
        if (txtUrl.getText().length() == 100) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtUrlKeyTyped

    private void txtNameWineKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameWineKeyTyped
        // TODO add your handling code here:
        if (txtNameWine.getText().length() == 45) {
            evt.consume();
            getToolkit().beep();
        }
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar letras.");
        }
    }//GEN-LAST:event_txtNameWineKeyTyped

    private void comboCountryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboCountryFocusLost
        // TODO add your handling code here: Usalo en los DELET

        if (comboCountry.getSelectedItem().toString().equals("Seleccionar")) {
            comboRegion.removeAllItems();
            region.clear();
            String selet = "Seleccionar";
            comboRegion.addItem(selet);
        } else {
            Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());
            final String sql = String.format("SELECT region_code,region_name FROM winestore.ref_regions where country_code = %s order by region_name", Pais.intValue());
            System.out.println(sql.toString());
            try {
                comboRegion.removeAllItems();
                region.clear();
                ResultSet rs = db.query(sql);
                String selet = "Seleccionar";
                comboRegion.addItem(selet);
                while (rs.next()) {
                    //comboRegion.addItem("NULL");
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    comboRegion.addItem(name);
                    region.put(name, id);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }//GEN-LAST:event_comboCountryFocusLost

    private void txtNameWineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameWineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameWineActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void comboRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRegionActionPerformed

    private void comboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCountryActionPerformed

    private void comboRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRegionMouseClicked
        /*        Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());
        String pikachu = comboCountry.getSelectedItem().toString();
        Integer r = (Integer) region.get(comboRegion.getSelectedItem());
        String charmander = comboRegion.getSelectedItem().toString();

        if (!pikachu.equals("Seleccionar")) {
            final String sql = String.format("SELECT region_code,region_name FROM winestore.ref_regions where country_code = %s order by region_name", Pais.intValue());
            System.out.println(sql.toString());

            try {
                comboRegion.removeAllItems();
                region.clear();
                ResultSet rs = db.query(sql);
                String selet = "Seleccionar";
                comboRegion.addItem(selet);
                while (rs.next()) {
                    //comboRegion.addItem("NULL");
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    comboRegion.addItem(name);
                    region.put(name, id);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (charmander.equals("Seleccionar")) {
            // comboRegion.removeAllItems();

            region.clear();

        } else if (charmander.equals("Seleccionar") && pikachu.equals("Seleccionar")) {
            region.clear();
        }*/
    }//GEN-LAST:event_comboRegionMouseClicked

    private void comboCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCountryMouseClicked


    }//GEN-LAST:event_comboCountryMouseClicked

    private void comboRegionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboRegionMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRegionMouseReleased

    private void comboCountryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCountryMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCountryMouseReleased

    private void comboRegionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboRegionFocusLost

        /*   Integer Pais = (Integer) pais.get(comboCountry.getSelectedItem());
        Integer Region = (Integer) region.get(comboRegion.getSelectedItem());
        String pikachu = comboCountry.getSelectedItem().toString();
        String charmander = comboRegion.getSelectedItem().toString();

        if (!pikachu.equals("Seleccionar")) {
            final String sql = String.format("SELECT region_code,region_name FROM winestore.ref_regions where country_code = %s order by region_name", Pais.intValue());
            System.out.println(sql.toString());

            try {
                comboRegion.removeAllItems();
                region.clear();
                ResultSet rs = db.query(sql);
                String selet = "Seleccionar";
                comboRegion.addItem(selet);
                while (rs.next()) {
                    //comboRegion.addItem("NULL");
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    comboRegion.addItem(name);
                    region.put(name, id);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (charmander.equals("Seleccionar")) {
            region.clear();
        }*/

    }//GEN-LAST:event_comboRegionFocusLost

    private void txtdesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdesFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtdesFocusLost

    private void jfechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jfechaMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jfechaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JComboBox<String> comboCountry;
    private javax.swing.JComboBox<String> comboRegion;
    private javax.swing.JComboBox<String> comboTipoUva;
    private javax.swing.JComboBox<String> comboViñedo;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JTextField txtNameWine;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextArea txtdes;
    // End of variables declaration//GEN-END:variables
}
//Integer Pais = (Integer) pais.get(comboCountri.getSelectedItem());
//        final String sql =String.format( "SELECT Region_Code,Region_Name FROM ref_regions where Country_Code = %s order by Region_Name",Pais.intValue());
//        System.out.println(sql.toString());
//
//        try {
//            comboRegion.removeAllItems();
//            region.clear();
//            ResultSet rs = db.query(sql);
//            while (rs.next()) {
//                 int id = rs.getInt(1);
//                String name = rs.getString(2);
//                comboRegion.addItem(name);
//                 region.put(name, id);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
