package collection.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }

    @Test
    public void testFindByPassport() {
        BankService bank = new BankService();
        bank.addUser(new User("1111", "Ivan"));
        bank.addAccount("1111", new Account("0000", 100));
        bank.addAccount("1111", new Account("0001", 200));
        bank.addUser(new User("2222", "Petr"));
        bank.addAccount("2222", new Account("0002", 100));
        bank.addAccount("2222", new Account("0003", 200));
        String expected = "2222";
        String result = bank.findByPassport("2222").getPassport();
        assertThat(expected, is(result));
    }

    @Test
    public void testFindByRequisite() {
        BankService bank = new BankService();
        bank.addUser(new User("1111", "Ivan"));
        bank.addAccount("1111", new Account("0000", 100));
        bank.addAccount("1111", new Account("0001", 200));
        bank.addUser(new User("2222", "Petr"));
        bank.addAccount("2222", new Account("0002", 100));
        bank.addAccount("2222", new Account("0003", 200));
        Account expected = new Account("0002", 100);
        Account result = bank.findByRequisite("2222", "0002");
        assertThat(expected, is(result));
    }
}

