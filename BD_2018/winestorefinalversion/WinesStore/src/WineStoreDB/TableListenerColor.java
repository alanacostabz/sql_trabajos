/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import static WineStoreDB.InsertRefColors.RET_CANCEL;
import java.awt.Component;
import static java.awt.SystemColor.text;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author rnavarro
 */
public class TableListenerColor implements TableModelListener {

    private final Database db;

    public TableListenerColor(Database d) {
        super();
        db = d;
    }

    @Override
    public void tableChanged(TableModelEvent event) {
        JDBCTableAdpater modelo = (JDBCTableAdpater) event.getSource();

        int row = event.getFirstRow();
        int column = event.getColumn();
        int type = event.getType();

        //No se puede modificar una clave primaria
        if (column == 0) {
            return;
        }

        String colName = modelo.getColumnName(column);
        String colSQLName = modelo.getSQLColumnName(column);

        String aux = modelo.getValueAt(row, column).toString();
       
        if (aux.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo no puede quedar vacío.", "Atención", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                if (validacionDatos(aux) > 0) {
                    JOptionPane.showMessageDialog(null, "El color " + aux + " ya se encuentra en la base de datos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    Component rootPane = null;
                    int input = JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar el cambio realizado en el ID = "+modelo.getValueAt(row, 0)+" en campo color por " + aux.toUpperCase() + "?", "Modificar color", 0);
                    if (input == 0) {
                        String sql = String.format(
                                "UPDATE winestore.ref_colors SET color_name = \'%s\' WHERE color_code = \'%s\'",
                                /*colSQLName,*/ modelo.getValueAt(row, column), modelo.getValueAt(row, 0)).toUpperCase();
                        System.out.println(sql.toString());
                        db.update(sql.toString());
                        JOptionPane.showMessageDialog(null, "Se ha realizado una modificación en id= " + modelo.getValueAt(row, 0) + " en el campo " + colName + " a " + modelo.getValueAt(row, column).toString().toUpperCase() + ".", "Modificacion realizada", JOptionPane.WARNING_MESSAGE);
                        doClose(returnStatus);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(InsertRefColors.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /* String sql = String.format(
                "UPDATE winestore.ref_colors SET color_name = \'%s\' WHERE color_code = \'%s\'",
                /*colSQLName,*/ //modelo.getValueAt(row, column), modelo.getValueAt(row, 0)).toUpperCase();

        /*  try {
            int value = db.update(sql);
            if (value == 1) {
                JOptionPane.showMessageDialog(null, "Se ha relizado un update en un color", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(sql);*/
    }

    public int validacionDatos(String vd) throws SQLException {
        StringBuilder sql1 = new StringBuilder("select color_name from winestore.ref_colors");
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

    private void doClose(int retStatus) {
        returnStatus = retStatus;

    }
    private int returnStatus = RET_CANCEL;

}
