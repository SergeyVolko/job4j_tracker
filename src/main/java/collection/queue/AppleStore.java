package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        return getLastCustomer(count);
    }

    public String getLastUpsetCustomer() {
        return getLastCustomer(count + 1);
    }

    private String getLastCustomer(int num) {
        Queue<Customer> curQueue = new LinkedList<>(queue);
        for (int i = 0; i < num - 1; i++) {
            curQueue.poll();
        }
        Customer customer = curQueue.poll();
        return customer == null ? null : customer.name();
    }
}
