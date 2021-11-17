package oop.chess;

public class DeskFerz {
    private int[] desk;
    private int count = 0;

    public DeskFerz(int size) {
        desk = new int[size];
        for (int i = 0; i < size; i++) {
            desk[i] = -1;
        }
    }

    public DeskFerz(int[] desk) {
        this.desk = desk;
    }

    boolean isBeats(int current, int check) {
        return current == check || desk[current] == desk[check]
               || current + desk[current] == check + desk[check]
               || current - desk[current] == check - desk[check];
    }

    boolean isPut(int vertical) {
        boolean result = true;
        for (int i = 0; i < vertical; i++) {
            if (isBeats(vertical, i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void add(int vertical) {
        if (vertical == desk.length) {
            count++;
            return;
        }
        int t = desk[vertical];
        for (int i = t + 1; i < desk.length; i++) {
            desk[vertical] = i;
            if (isPut(vertical)) {
                add(vertical + 1);
            }
        }
        desk[vertical] = -1;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        DeskFerz deskFerz;
        for (int i = 1; i <= 10; i++) {
            deskFerz = new DeskFerz(i);
            deskFerz.add(0);
            System.out.println(deskFerz.getCount());
        }
    }
}
