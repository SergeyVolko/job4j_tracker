package stream.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingMethod {

    public static class User {

        private String name;

        private List<Bill> bills = new ArrayList<>();

        public User(String name, List<Bill> bills) {
            this.name = name;
            this.bills = bills;
        }

        public String getName() {
            return name;
        }

        public List<Bill> getBills() {
            return bills;
        }
    }

    public static class Bill {

        private int balance;

        public Bill(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }
    }

    private static class Pair {
        private User user;
        private Bill bill;

        public Pair(User user, Bill bill) {
            this.user = user;
            this.bill = bill;
        }

        public User getUser() {
            return user;
        }

        public Bill getBill() {
            return bill;
        }
    }

    private static class GroupPair {

        public static List<Pair> getPairs(List<User> users) {
            List<Pair> pairs = new ArrayList<>();
            users.forEach(user -> user.getBills()
                    .forEach(bill -> pairs.add(new Pair(user, bill))));
            return pairs;
        }
    }

    public static Map<String, Integer> summing(List<User> users) {
        List<Pair> pairs = GroupPair.getPairs(users);
        return pairs.stream()
                .collect(Collectors.groupingBy(pair -> pair.getUser().getName(),
                        Collectors.summingInt(pair -> pair.getBill().getBalance())));
    }
}
