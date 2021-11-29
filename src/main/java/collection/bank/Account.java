package collection.bank;

import java.util.Objects;

/**
 * Класс описывает счет в банке.
 * @author SERGEY VOLKOV
 * @version 1.0
 */
public class Account {
    /**
     * Переменная String requisite - реквизит счета.
     * Переменная double balance - количество денег на счете.
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор для инициализации полей счета.
     * @param requisite - реквизит.
     * @param balance - количество денег.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер
     * @return - возвращает реквизит счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер
     * @param requisite - принимет реквизит счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер
     * @return - возвращает баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер
     * @param balance - принимет новый баланс счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнивает два объекта.
     * @param o - объект сравниваемый с текущем объектом.
     * @return - возвращает результат сравнения true или false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод для определения хэш-кода.
     * @return - возвращает числовое представление объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
