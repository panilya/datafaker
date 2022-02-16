package net.datafaker;

import org.junit.Test;

public class CustomFakerTest {
    public static class MyCustomFaker extends Faker {
        public SpaceForce spaceForce() {
            return getProvider(SpaceForce.class, () -> new SpaceForce<>(this));
        }
    }

    public static class SpaceForce<T extends Faker> {
        private static final String[] ROCKET_NAMES = new String[]{"Appollo", "Soyuz", "Vostok", "Voskhod", "Progress", "Falcon", "Gemini", "Mercury"};
        private final T faker;

        public SpaceForce(T faker) {
            this.faker = faker;
        }

        public String nextRocketName() {
            return ROCKET_NAMES[faker.random().nextInt(ROCKET_NAMES.length)];
        }
    }

    @Test
    public void myRocketTest() {
        MyCustomFaker myFaker = new MyCustomFaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(myFaker.spaceForce().nextRocketName());
        }
    }

    @Test
    public void myRocketTest2() {
        MyCustomFaker myFaker = new MyCustomFaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(myFaker.expression("#{SpaceForce.nextRocketName}"));
        }
    }
}
