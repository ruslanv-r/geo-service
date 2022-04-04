package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplMock {

    @Test
    public void russianIP_test() {

        String ip = "172.0.32.11";

        GeoService geoServiceTest = Mockito.mock(GeoService.class);
        Mockito.when(geoServiceTest.byIp(ip))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));


        LocalizationService localizationServiceTest = Mockito.mock(LocalizationService.class);
        Mockito.when((localizationServiceTest.locale(Country.RUSSIA)))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoServiceTest, localizationServiceTest);


        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected,  messageSender.send(headers));


    }

    @Test
    public void usaIP_test() {

        String ip = "96.44.183.149";

        GeoService geoServiceTest = Mockito.mock(GeoService.class);
        Mockito.when(geoServiceTest.byIp(ip))
                .thenReturn(new Location("New York", Country.USA, null,  0));


        LocalizationService localizationServiceTest = Mockito.mock(LocalizationService.class);
        Mockito.when((localizationServiceTest.locale(Country.USA)))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoServiceTest, localizationServiceTest);


        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        String expected = "Welcome";

        Assertions.assertEquals(expected,  messageSender.send(headers));


    }

}
