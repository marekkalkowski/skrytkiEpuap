package pl.gdansk.gci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private Connection connection;
    public static final Logger LOG = LogManager.getLogger(DatabaseConnection.class);

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

            LOG.info(" properties downloaded succesfull");
            String url = String.format("jdbc:sqlserver://%s:52313;database=%s;user=%s;password=%s;integratedSecurity=true;"
                    , hostName, dbName, dbUser, password);

            System.out.println(url);
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            LOG.info("Successfully connected to database");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


