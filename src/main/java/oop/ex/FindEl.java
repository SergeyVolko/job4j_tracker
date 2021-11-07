package oop.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key != null && key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element " + key + " not found.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"aaa", "bbb", "ccc"}, "fff");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
