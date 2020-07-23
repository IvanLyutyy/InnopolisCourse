package main.Innopolis.Lyutyy.task20;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Formatter;

/**
 * Класс {@code IndianCityJsonManager} получает и сериализует данные о городах Индии в формате JSON,
 * используя сервис @see <a href="https://indian-cities-api-nocbegfhqg.now.sh/">Indian Cities Rest API</a>
 *
 * @author Lyutyy Ivan
 */
public class IndianCityJsonManager {
    /**
     * Константа хранит имя файла для сериализации и десериализации данных
     */
    private static final String FILE_NAME = "IndianCities.json";

    private IndianCityJsonManager() {}

    /**
     * Метод выполняет запрос к сервису, используя параметр поиска
     * @param searchParameter параметр содержит строку с критерием поиска и значение для поиска:
     *                        - по названию города
     *                        - по названию штата
     *                        - по названию округа
     */
    public static void getIndianCitiesJSON(String searchParameter) {
        searchParameter = searchParameter.replaceAll("(?iu)" + " ","+");

        ObjectMapper mapper = new ObjectMapper();
        try {
            IndianCity[] city = mapper.readValue(new URL("https://indian-cities-api-nocbegfhqg.now.sh/cities" + searchParameter), IndianCity[].class);

            String delimiter = "==========";
            printCatalogString("Город", "Штат", "Округ");
            printCatalogString(delimiter, delimiter, delimiter);

            for (IndianCity c: city) {
                printCatalogString(c.getCity(), c.getState(), c.getDistrict());
            }

            serializeCatalog(city);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод печатает строку с информацией о городе.
     * @param city параметр содержит название города.
     * @param state параметр содержит название штата.
     * @param district параметр содержит название округа.
     */
    public static void printCatalogString(String city, String state, String district) {
        try (Formatter catalogFormatter = new Formatter()) {
            catalogFormatter.format("%-60.60s%-40.40s%-40.40s", city, state, district);
            System.out.println(catalogFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод сериализует данные о городах Индии в формате JSON, полученные от сервиса.
     * @param city параметр содержит массив объектов {@code IndianCity},
     *             полученных от сервиса в формате JSON.
     */
    public static void serializeCatalog(IndianCity[] city) {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(fw, city);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод десериализует данные в формате JSON, сериализованные методом {@link #serializeCatalog},
     * в массив объектов {@code IndianCity}.
     */
    public static void deserializeCatalog() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Файл IndianCities.json не существует");
            return;
        }

        try (FileReader fr = new FileReader(FILE_NAME)) {
            ObjectMapper mapper = new ObjectMapper();
            IndianCity[] city = mapper.readValue(fr, IndianCity[].class);

            String delimiter = "==========";
            printCatalogString("Город", "Штат", "Округ");
            printCatalogString(delimiter, delimiter, delimiter);

            for (IndianCity c: city) {
                printCatalogString(c.getCity(), c.getState(), c.getDistrict());
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
