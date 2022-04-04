package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = {"172.0.0.1", "172.0.32.11", "172.44.183.149"})
    public void byIpTest(String argument) {
        GeoService geoServiceTest = new GeoServiceImpl();

        Location location = geoServiceTest.byIp(argument);

        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);


        Assertions.assertEquals(expected.getCountry(), location.getCountry());
    }

    @Test
    public void byIpTest_local() {
        String ip = "172.0.0.1";
        GeoService geoServiceTest = new GeoServiceImpl();

        Location location = geoServiceTest.byIp(ip);
        System.out.println(location);

        Location expected = new Location(null, null, null, 0);

        Assertions.assertEquals(expected, location);
    }

    @Test
    public void byIpTest_Moscow() {
        String ip = "172.0.32.11";
        GeoService geoServiceTest = new GeoServiceImpl();

        Location location = geoServiceTest.byIp(ip);

        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Assertions.assertEquals(expected, location);
    }

    @Test
    public void byIpTest_NewYork() {
        String ip = "96.44.183.149";
        GeoService geoServiceTest = new GeoServiceImpl();

        Location location = geoServiceTest.byIp(ip);

        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);

        Assertions.assertEquals(expected, location);
    }

}
