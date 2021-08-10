package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address adr1 = new Address("Moscow", "Pushkina", 14, 5);
        Address adr2 = new Address("Briansk", "Lenina", 9, 16);
        Address adr3 = new Address("Moscow", "Novii Arbat", 27, 8);
        Address adr4 = new Address("Moscow", "Novii Arbat", 27, 8);
        Address adr5 = new Address("Moscow", "Novii Arbat", 27, 8);
        Address adr6 = new Address("Vologda", "Pushkina", 14, 5);
        List<Address> expected = List.of(adr2, adr1, adr3, adr6);
        List<Profile> profileList = Arrays.asList(
                new Profile(adr1),
                new Profile(adr2),
                new Profile(adr3),
                new Profile(adr4),
                new Profile(adr5),
                new Profile(adr6)
        );
        Profiles pfs = new Profiles();
        List<Address> result = pfs.collect(profileList);
        assertThat(result, is(expected));
    }
}