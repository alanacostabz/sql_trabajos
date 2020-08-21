/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import java.awt.Component;
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
public class TableListenerWines implements TableModelListener {

    private final Database db;

    public TableListenerWines(Database d) {
        super();
        db = d;
    }

    @Override
    public void tableChanged(TableModelEvent event) {
        JDBCTableAdpaterWines modelo = (JDBCTableAdpaterWines) event.getSource();

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
     
        Component rootPane = null;
        int input = JOptionPane.showConfirmDialog(rootPane, "¿Desea guardar el cambio realizado en el ID = " + modelo.getValueAt(row, 0) + " en campo " + colName + " por " + aux.toUpperCase() + "?", "Modificar vino", 0);
        if (input == 0) {
            String sql = String.format(
                    /*"UPDATE winestore.wine_store SET %s = \'%s\' WHERE wine_store_id = \'%s\'",
                colSQLName,modelo.getValueAt(row, column), modelo.getValueAt(row, 0));*/
                    "UPDATE winestore.wine_store SET " + colSQLName + " = \'%s\' WHERE wine_store_id = \'%s\'",
                    /*colSQLName,*/ modelo.getValueAt(row, column), modelo.getValueAt(row, 0)).toUpperCase();

            System.out.println(modelo.getValueAt(row, column).toString());
            System.out.println(modelo.getValueAt(row, 0).toString());

            try {
                db.update(sql);
                JOptionPane.showMessageDialog(null, "Se ha realizado una modificación en id= " + modelo.getValueAt(row, 0) + " en el campo " + colName + " a " + modelo.getValueAt(row, column).toString().toUpperCase() + ".", "Modificacion realizada", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(sql);
        }
    }

}
