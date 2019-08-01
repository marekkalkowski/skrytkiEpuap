package pl.gdansk.gci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class App {
    public static void main(String[] args) {

        final Logger LOG = LogManager.getLogger(DatabaseConnection.class);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Properties properties = new Properties();
        SkrytkiEpuapDatabaseInsertation skrytkiEpuapDatabaseInsertation = new SkrytkiEpuapDatabaseInsertation();
        SkrytkaEpuap skrytkaEpuap = new SkrytkaEpuap();

        try {
            LOG.info("Ładowanie ustawień  .... ");
            properties.load(new FileInputStream(AppProperties.APP_CONFIG_PATH));
            LOG.info("Ustawienia załadowane  .... ");
            LOG.info("Łączenie  do bazy danych  .... ");
            databaseConnection.gettingConnectToDatabase(properties);
            BufferedInputStream in = new BufferedInputStream(new URL(properties.getProperty("fileOnEpuapUrl")).openStream());
            skrytkaEpuap.setListOfSkrytkiEpuap(in);
            skrytkiEpuapDatabaseInsertation.insertSkrytkiIntoDB(skrytkaEpuap, databaseConnection);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
