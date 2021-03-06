package pl.gdansk.gci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SkrytkiEpuapDatabaseInsertation {

    public static final Logger LOG = LogManager.getLogger(SkrytkiEpuapDatabaseInsertation.class);

    public void insertSkrytkiIntoDB(SkrytkaEpuap skrytkaEpuap, DatabaseConnection databaseConnection) {
        Connection connection = databaseConnection.getConnection();
        List<String> splitedOneRecord = new ArrayList<>();
        List<String> fullListOfEpuapAdresses = skrytkaEpuap.getListOfSkrytkiEpuap();
        int recordNumber = 0;


        try {
            Statement statement = connection.createStatement();
            String sqlCheckIfTableExist = "exec UMG_checkIfExistTableUmgSkrytkiEpuap";
            statement.execute(sqlCheckIfTableExist);

            for (String str : fullListOfEpuapAdresses
            ) {
                splitedOneRecord = Arrays.asList(str.replace("'", "").split(","));
                String sqlWithAdresess = String.format("exec UMG_InsertSskrytkiEpuap @Nazwa=\'%s\', @Regon=\'%s\', @Adres=\'%s\', @KodPocztowy=\'%s\', @Miejscowosc=\'%s\', @Uri=\'%s\'"
                        , splitedOneRecord.get(0)
                        , splitedOneRecord.get(1)
                        , splitedOneRecord.get(2)
                        , splitedOneRecord.get(3)
                        , splitedOneRecord.get(4)
                        , splitedOneRecord.get(5));

                statement.execute(sqlWithAdresess);
                recordNumber++;
                LOG.debug("{} Record inserted for: {}", recordNumber, splitedOneRecord);
            }
        } catch (Exception e) {
            LOG.warn("{} Error Record not inserted for: {}", recordNumber, splitedOneRecord);
            e.printStackTrace();
        }
    }
}

