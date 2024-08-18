package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection{

    private static final String URL = "jdbc:sqlserver://140.136.151.139:1433;"+"databaseName=test_;" +"encrypt=true;trustServerCertificate=true";
    private static final String user="root";
    private static final String password="@candy2023";

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn= DriverManager.getConnection(URL, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}