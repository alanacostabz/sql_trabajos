package WineStoreDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Rene Navarro
 */
public class Database {

    private Connection con;
    
    //URL que identifica a la base de datos que nos queremos conectar
    //private final String DB_URL = "jdbc:mysql://148.225.64.69:3306/db210215739";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/winestoreDB";
    
    //Driver de JDBC que vamos a usar para conectarnos a la base de datos
    private final String DRIVER = "org.postgresql.Driver";
    private static Database DB = null;

    private Database() {
        super();
    }

   
    private Database(String user, String password) {
        super();
        con = null;
        try {
            
            // Cargar el driver
            Class.forName(DRIVER);
            
            // Abrir una conexion a la base de datos
            con = DriverManager.getConnection(DB_URL, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println("Error MySQL: " + ex.getMessage());
            System.out.println("Codigo MySQL: " + ex.getErrorCode());
        }
    }

    // Abrir la conexión y regresar objeto Database
    public static Database getDatabase(String user, String pass) {
        if (DB == null) {
            DB = new Database(user, pass);
        }
        return DB;
    }

    public ResultSet query(String sql) throws SQLException {

        ResultSet rs = null;
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        rs = statement.executeQuery(sql);

        return rs;
    }

    public ResultSet query(String sql, int scroll, int concur) throws SQLException {

        ResultSet rs = null;

        Statement statement = con.createStatement(scroll, concur);
        rs = statement.executeQuery(sql);

        return rs;
    }

    public int update(String sql) throws SQLException {
        int result = -1;

        Statement statement = con.createStatement(ResultSet.CONCUR_UPDATABLE,
                ResultSet.TYPE_FORWARD_ONLY);
        result = statement.executeUpdate(sql);
        return result;
    }
}
