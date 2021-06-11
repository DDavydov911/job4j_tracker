package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenManyValidInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "5", "0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        out.println(input.askInt("Enter menu:"));
        out.println(input.askInt("Enter menu:"));
        out.println(input.askInt("Enter menu:"));
        String ls = System.lineSeparator();
        assertThat(out.toString(), is("2" + ls +
                                            "5" + ls +
                                            "0" + ls
        ));
    }

    @Test
    public void whenMinus2() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }


}