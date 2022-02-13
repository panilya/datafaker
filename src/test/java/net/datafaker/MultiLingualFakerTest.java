package net.datafaker;

import org.junit.Test;

import java.util.Locale;

public class MultiLingualFakerTest {


    @Test
    public void testMulti() {
        Faker faker = new Faker();
        for(int i = 0; i < 100; i++) {
            System.out.println(faker.name().fullName());
        }
    }
}
