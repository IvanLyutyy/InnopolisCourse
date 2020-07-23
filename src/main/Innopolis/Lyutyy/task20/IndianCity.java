package main.Innopolis.Lyutyy.task20;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Объект класса {@code IndianCity} хранит данные о городе в Индии:
 * - название города
 * - название штата, в котором находится город
 * - название округа штата, в котором находится город
 *
 * @author Savin Vladimir
 */
public class IndianCity {
    private String city;
    private String state;
    private String district;

    /**
     * Медод возвращает хранимое название города.
     * @return название города.
     */
    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    /**
     * Метод записывает новое название города.
     * @param city параметр содержит новое название города.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Метод возвращает хранимое название штата.
     * @return название штата.
     */
    @JsonProperty("State")
    public String getState() {
        return state;
    }

    /**
     * Метод записывает новое название штата.
     * @param state параметр содержит новое название штата.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Метод возвращает хранимое название округа.
     * @return название округа.
     */
    @JsonProperty("District")
    public String getDistrict() {
        return district;
    }

    /**
     * Метод записывает новое название округа.
     * @param district параметр содержит новое название округа.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Метод возвращает состояние класса {@code IndianCity} в виде строки,
     * хранящей название города, название штата и название округа.
     * @return строка, с названием города, названием штата и названием округа.
     */
    @Override
    public String toString() {
        return "Город: '" + city + '\'' + ", Штат: '" + state + '\'' + ", Округ: '" + district + '\'';
    }
}
