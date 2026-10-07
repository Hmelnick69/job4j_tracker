package ru.job4j.search;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        Person person = new Person("Petr", "Arsentev", "534872", "Bryansk");
        phones.add(person);
        ArrayList<Person> result = phones.find("Petr");
        var expected = new ArrayList<Person>();
        expected.add(person);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> result = phones.find("Tim");
        ArrayList<Person> expected = new ArrayList<>();
        assertThat(result).isEqualTo(expected);
    }
}