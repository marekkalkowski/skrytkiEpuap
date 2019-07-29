package pl.gdansk.gci;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Properties properties = new Properties();
        PrintWriter out = null;

        try {
            properties.load(new FileInputStream(AppProperties.APP_CONFIG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //String pathToFile = properties.getProperty("pathToDir") + properties.get("fileName");
        String outFileName = properties.getProperty("pathToDir") + properties.get("outFileName");

        try {
            BufferedInputStream in = new BufferedInputStream(new URL(properties.getProperty("fileOnEpuapUrl")).openStream());



//            for (String key: properties.stringPropertyNames()
//                 ) {
//                System.out.println(key.toString() + ": " + properties.getProperty(key));
//
//            }
//
//            System.out.println("----------");
            //databaseConnection.gettingConnectToDatabase(properties);
            out = new PrintWriter(outFileName);
            Stream<String> lines = new BufferedReader(new InputStreamReader(in)).lines();;

                   // Stream.of(in);
                    //Files.lines(Paths.get(pathToFile));
            lines
                    //.sorted()
                    .distinct()

                    .limit(100)
                    .map(App::clearLine)
                    .filter(str-> !str.equals("NAZWA,REGON,ADRES,KOD_POCZTOWY,MIEJSCOWOSC,URI"))
                    .forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }

    }


    private static String clearLine(String str) {

        String result = str.replace("\"", "").trim();
//       System.out.println(result);
        return result;
    }
}
