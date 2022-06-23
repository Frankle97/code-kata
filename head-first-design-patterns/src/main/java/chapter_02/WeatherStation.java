package chapter_02;

public class WeatherStation {
    public static void main(String[] args) {
        final WeatherData weatherData = new WeatherData();
        weatherData.registerObserver(new CurrentConditionDisplay());

        weatherData.renewalMeasurements(80, 65, 30.4f);
        weatherData.renewalMeasurements(82, 61, 39.4f);
    }
}
