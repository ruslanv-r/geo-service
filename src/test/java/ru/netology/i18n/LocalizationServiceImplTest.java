package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {

    @Test
    public void locaRus_leTest(){

        LocalizationService localizationService = new LocalizationServiceImpl();

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, localizationService.locale(Country.RUSSIA));


    }

    @Test
    public void localeUsa_Test(){

        LocalizationService localizationService = new LocalizationServiceImpl();

        String expected = "Welcome";

        Assertions.assertEquals(expected, localizationService.locale(Country.USA));


    }
}
