package pl.gdansk.gci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

//    String hostName = "DB-EZD-EDU\\EZD_EDU"; // update me
//    String dbName = "ezdEduUmg"; // update me
//    String user = "UMG\\ezd-edu-proces"; // update me
//    String password = "Mgh56@AqFz"; // update me



    //+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
    public void gettingConnectToDatabase(Properties properties) {
        try {
            Connection connection;

            String hostName = properties.getProperty("hostName");
            String dbName = properties.getProperty("dbName");
            String dbUser = properties.getProperty("dbUser");
            String password = properties.getProperty("password");

            String url = String.format("jdbc:sqlserver://%s:52313;database=%s;user=%s;password=%s;encrypt=true;"
                    , hostName.replace("\"","").trim(), dbName, dbUser, password);

            System.out.println(url);
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            //+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
//            String selectSql = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName "
//                    + "FROM [SalesLT].[ProductCategory] pc "
//                    + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";

//            try (Statement statement = connection.createStatement();
//                 ResultSet resultSet = statement.executeQuery(selectSql)) {
//
//                // Print results from select statement
//                System.out.println("Top 20 categories:");
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString(1) + " "
//                            + resultSet.getString(2));
//                }
//                connection.close();

            }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
}


