package net.datafaker;

import net.datafaker.service.LocalePicker;
import net.datafaker.service.RandomService;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class LocaleFaker extends AbstractProvider {

    private final Locale[] availableLocales = DateFormat.getAvailableLocales();

    protected LocaleFaker(Faker faker) {
        super(faker);
    }

    /**
     *
     * @return locale in form: "en_US"
     */
    public String baseLocale() {
        final Locale locale = availableLocales[faker.random().nextInt(availableLocales.length)];
        return locale.toString();
    }

    /**
     *
     * @return locale in form: "English (United States)"
     */
    public String displayName() {
        int randomIndex = new RandomService().nextInt(availableLocales.length - 1);
        Locale locale = Arrays.stream(availableLocales)
            .filter(lcl -> !lcl.getDisplayName().isEmpty())
            .skip(randomIndex).findFirst().get();

        return locale.getDisplayName();
    }
}