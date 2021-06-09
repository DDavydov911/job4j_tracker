package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int res = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                res = i;
                break;
            }
        }
        if (res == -1) {
            throw new ElementNotFoundException("The element not found");
        }
        return res;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String abuse : abuses) {
            if (value.equals(abuse)) {
                throw new ElementAbuseException("Запрещенный элемент");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(FindEl.indexOf(new String[]{"ma", "pa", "la", "ta"}, "ha"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
