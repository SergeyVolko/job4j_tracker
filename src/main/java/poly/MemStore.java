package poly;

public class MemStore implements Store {
    private String[] mem = new String[100];
    private int size = 0;

    @Override
    public void save(String data) {
        mem[size++] = data;
    }

    @Override
    public String read() {
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < size; i++) {
            buff.append(mem[i]);
        }
        return buff.toString();
    }
}
