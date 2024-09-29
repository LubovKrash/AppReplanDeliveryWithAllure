package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Generator {
    private Generator () {
    }

    public static String enteredCity () {
        String[] cities = new String[]{"Пермь", "Красноярск", "Владикавказ", "Анапа", "Архангельск", "Вологда", "Нижний Тагил",
                "Новочеркасск", "Калининград", "Нетологорск", "Петрозаводск", "Тольятти", "Тамбов", "Волгоград",
                "Кинешма", "Екатеринбург", "Пенза", "Плес", "Сочи", "Ржев", "Рязань", "Москва", "Тверь", "Кызыл", "Владимир"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String enteredDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String enteredName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String enteredPhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static Client enteredClient(String locale) {
            return new Client(enteredCity(), enteredName(locale), enteredPhone(locale));
        }
    }

    @Value
    public static class Client {
        String city;
        String name;
        String phone;
    }
}

