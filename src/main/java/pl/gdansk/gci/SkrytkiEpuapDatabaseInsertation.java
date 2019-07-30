package pl.gdansk.gci;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SkrytkiEpuapDatabaseInsertation {


    public void insertSkrytkiIntoDB(SkrytkaEpuap skrytkaEpuap, DatabaseConnection databaseConnection) {
        Connection connection = databaseConnection.getConnection();
        List<String> splitedOneRecord = new ArrayList<>();
        List<String> fullListOfEpuapAdresses = skrytkaEpuap.getListOfSkrytkiEpuap();



        try {
            Statement statement = connection.createStatement();
            String sqlCheckIfTableExist = "exec UMG_checkIfExistTableUmgSkrytkiEpuap";
            statement.execute(sqlCheckIfTableExist);

            for ( String str:fullListOfEpuapAdresses
            ) {

                splitedOneRecord = Arrays.asList(str.split(","));
                String sqlWithAdresess = String.format("exec UMG_InsertSskrytkiEpuap @Nazwa=\'%s\', @Regon=\'%s\', @Adres=\'%s\', @KodPocztowy=\'%s\', @Miejscowosc=\'%s\', @Uri=\'%s\'"
                        , splitedOneRecord.get(0)
                        , splitedOneRecord.get(1)
                        , splitedOneRecord.get(2)
                        , splitedOneRecord.get(3)
                        , splitedOneRecord.get(4)
                        , splitedOneRecord.get(5));

                statement.execute(sqlWithAdresess);
            }

            System.out.println("Record inserted for: " + splitedOneRecord);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

