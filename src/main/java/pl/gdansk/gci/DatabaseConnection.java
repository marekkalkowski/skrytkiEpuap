package pl.gdansk.gci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    //+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
    public void gettingConnectToDatabase(Properties properties) {

        try {
            String hostName = properties.getProperty("hostName").trim();
            String dbName = properties.getProperty("dbName").trim();
            String dbUser = properties.getProperty("dbUser").trim();
            String password = properties.getProperty("password").trim();

            String url = String.format("jdbc:sqlserver://%s:52313;database=%s;user=%s;password=%s;integratedSecurity=true;"
                    , hostName, dbName, dbUser, password);

            System.out.println(url);
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


