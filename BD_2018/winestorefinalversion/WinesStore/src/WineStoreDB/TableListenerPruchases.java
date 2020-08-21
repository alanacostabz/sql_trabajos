/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableListenerPruchases implements TableModelListener {

    private final Database db;
    private final HashMap ht1;
    private final HashMap htba;
    private final HashMap htp;

    public TableListenerPruchases(Database d) {
        super();
        db = d;
        ht1 = new HashMap<String, Integer>();
        htba = new HashMap<String, Integer>();
        htp = new HashMap<String, Integer>();
    }

    public void tableChanged(TableModelEvent event) {
        JDBCTableAdapterPurchases modelo = (JDBCTableAdapterPurchases) event.getSource();
        int row = event.getFirstRow();
        int column = event.getColumn();
        int type = event.getType();
        //No se puede modificar una clave primaria
        if (column == 0) {
            return;
        }
        String colName = modelo.getColumnName(column);
        String pre = modelo.getColumnName(1);
        String colSQLName = modelo.getSQLColumnName(column);
        System.out.println(colSQLName);
        String preciow = "";
        String idvino = "";
        final String sqlba = String.format("select wine_store_id from winestore.purchases where purchase_id = %s", modelo.getValueAt(row, 0));
        try {
            ResultSet rs = db.query(sqlba);
            while (rs.next()) {
                int id = rs.getInt(1);
                idvino = rs.getString(1);
                htba.put(preciow, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(idvino);
        final String sql1 = String.format("select price from winestore.wine_store where wine_store_id = " + idvino);
        System.out.println(sql1);
        try {
            ResultSet rs = db.query(sql1);
            while (rs.next()) {
                int id = rs.getInt(1);
                preciow = rs.getString(1);
                htp.put(preciow, id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        double p = Double.parseDouble(preciow);
        String valor = modelo.getValueAt(row, column).toString();
        double can = Double.parseDouble(valor);
        double total = can * p;
        String aggh = Double.toString(total);
        String aux = modelo.getValueAt(row, column).toString();
        Component rootPane = null;
        int input = JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar el cambio realizado en el ID = " + modelo.getValueAt(row, 0) + " en campo " + colName + " por " + aux.toUpperCase() + "?", "Modificar venta", 0);
        if (input == 0) {
        final String sql3 = String.format("UPDATE winestore.purchases SET amount_of_purchase  = \'%s\' WHERE purchase_id = \'%s\' ", aggh, modelo.getValueAt(row, 0));
        //System.out.println(sql3);
        //System.out.println(totalwine);
        
      
        String sql = String.format(
                /*"UPDATE winestore.wine_store SET %s = \'%s\' WHERE wine_store_id = \'%s\'",
                colSQLName,modelo.getValueAt(row, column), modelo.getValueAt(row, 0));*/
                "UPDATE winestore.purchases SET " + colSQLName + " = \'%s\' WHERE purchase_id = \'%s\'",
                /*colSQLName,*/ modelo.getValueAt(row, column), modelo.getValueAt(row, 0));

        try {
            db.update(sql);
            db.update(sql3);
            JOptionPane.showMessageDialog(null, "Se ha realizado una modificación en id= " + modelo.getValueAt(row, 0) + " en el campo " + colName + " a " + modelo.getValueAt(row, column).toString().toUpperCase() + " y ahora el total es "
                    + ": " + aggh, "Modificacion realizada", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }

}
