package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int res = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                res = i;
            }
        }
        if (res == -1) {
            throw new ElementNotFoundException("The element not found");
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            System.out.println(FindEl.indexOf(new String[]{"ma", "pa", "la", "ta"}, "ha"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
