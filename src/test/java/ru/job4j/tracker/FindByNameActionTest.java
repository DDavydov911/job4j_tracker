package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("My item");
        tracker.add(item);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("My item");
        FindByNameAction findByNameAction = new FindByNameAction(output);
        boolean result = findByNameAction.execute(input, tracker);
        String ls = System.lineSeparator();
        assertTrue(result);
        assertThat(tracker.findByName("My item").get(0).getName(),
                is("My item"));
        /*
        assertThat(output.toString().substring(0, 49),
                is("=== Find items by name ====" + ls
                + "id: 1, name: My item"));
         */
    }

}