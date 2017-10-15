package regEx_Exe.weather_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by ChaosFire on 15.10.2017 г.
 */
public class Weather {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, City> forecast = new HashMap<>();
        Pattern pattern = Pattern.compile("([A-Z]{2})(\\d+\\.\\d+)([a-zA-Z]+)\\|");
        String input = reader.readLine();
        while (!input.equals("end")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                City city = new City(matcher.group(1), Double.parseDouble(matcher.group(2)), matcher.group(3));
                forecast.put(city.getCityName(), city);
            }
            input = reader.readLine();
        }
        reader.close();
        List<String> result = forecast.values()
                .stream()
                .sorted(Comparator.comparing(City::getTemperature))
                .map(City::toString)
                .collect(Collectors.toList());
        System.out.print(String.join(System.lineSeparator(), result));
    }
}

class City {

    private String cityName;
    private double temperature;
    private String weatherType;

    City(String cityName, double temperature, String weatherType) {
        this.setCityName(cityName);
        this.setTemperature(temperature);
        this.setWeatherType(weatherType);
    }

    @Override
    public String toString() {
        return String.format("%s => %.2f => %s", this.cityName, this.temperature, this.weatherType);
    }

    String getCityName() {
        return this.cityName;
    }

    private void setCityName(String cityName) {
        this.cityName = cityName;
    }

    double getTemperature() {
        return this.temperature;
    }

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    private void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }
}