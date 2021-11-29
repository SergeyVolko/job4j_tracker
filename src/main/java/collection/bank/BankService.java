package collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
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
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод находит счет по заданному пасспорту и реквизитам.
     * @param passport - пасспорт клиента.
     * @param requisite - реквизиты клиента.
     * @return - возвращет счет клиента. Если счет не найден то
     * вернет null.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    result = account;
                    break;
                }
            }
        }
        return result;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcBalance = srcAccount.getBalance();
            double destBalance = destAccount.getBalance();
            if (srcBalance >= amount) {
                srcAccount.setBalance(srcBalance - amount);
                destAccount.setBalance(destBalance + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
