package br.cefetmg.inf.prodigialis.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresqlJDBCConnection implements JDBCConnectionFactory {

    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://pedrobeta.ddns.net:5432/prodigialis";
    private final static String user = "postgres";
    private final static String pass = "123456";

    public PostgresqlJDBCConnection() {}

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
        
    }
    
    public static void main(String[] args) {
        
        try {
            
            JDBCConnectionFactory cf = new PostgresqlJDBCConnection();            
            cf.getConnection();
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(PostgresqlJDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
}