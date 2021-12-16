package collection.bank;

import java.util.*;

/**
 * Класс описывает работу с клиентами банка.
 * @author SERGEY VOLKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Переменная Map<User, List<Account>> users - хранилище клиентов вместе со списками их счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового клиента с пустым списком счетов.
     * @param user - клиент банка.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет по предъявленному пасспорту.
     * @param passport - пасспорт клиента.
     * @param account - новый счет клиента.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод находит клиента с заданным пасспортом.
     * @param passport - пасспорт искомого клиента
     * @return - возвращает найденного клиента. Если клиент не найден то
     * возвращает null.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит счет по заданному пасспорту и реквизитам.
     * @param passport - пасспорт клиента.
     * @param requisite - реквизиты клиента.
     * @return - возвращет счет клиента. Если счет не найден то
     * вернет null.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод переводит деньги между счетами разных клиентов или
     * между счетами одного клиента.
     * @param srcPassport - пасспорт клиента чьи деньги списываются.
     * @param srcRequisite - реквизиты счета откуда списываются деньги.
     * @param destPassport - пасспорт клиента кому начисляются деньги.
     * @param destRequisite - реквизиты счета куда начислить деньги.
     * @param amount - сумма списания и начисления.
     * @return - возвращает результат перемещения денежных средств.
     * true - если успешно и false - если деньги перевести нельзя.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            double srcBalance = srcAccount.get().getBalance();
            double destBalance = destAccount.get().getBalance();
            if (srcBalance >= amount) {
                srcAccount.get().setBalance(srcBalance - amount);
                destAccount.get().setBalance(destBalance + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
