package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenFindBiIdAction() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("My item");
        tracker.add(item);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        FindByIdAction findByIdAction = new FindByIdAction(output);
        boolean result = findByIdAction.execute(input, tracker);
        String ls = System.lineSeparator();
        assertTrue(result);
        assertThat(output.toString().substring(0, 45), is("=== Find item by id ===" + ls
                + "id: 1, name: My item"));
    }
}