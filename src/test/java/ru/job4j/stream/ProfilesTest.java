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
        Address adr2 = new Address("Moscow", "Novii Arbat", 27, 8);
        List<Address> expected = List.of(adr1, adr2);
        List<Profile> profileList = Arrays.asList(
                new Profile(adr1),
                new Profile(adr2)
        );
        Profiles pfs = new Profiles();
        List<Address> result = pfs.collect(profileList);
        assertThat(result, is(expected));
    }
}