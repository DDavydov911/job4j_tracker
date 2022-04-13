package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {
    @Test
    public void whenDeleteRight() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("My Item");
        tracker.add(item);
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ls = System.lineSeparator();
        assertThat(output.toString(), is("=== Delete item ====" + ls
                + "Заявка удалена успешно." + ls));
        assertNull(tracker.findById(item.getId()));
    }
}