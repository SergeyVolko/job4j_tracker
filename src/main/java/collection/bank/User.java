package collection.bank;

import java.util.Objects;

/**
 * Класс описывает банковского вкладчика.
 * @author SERGEY VOLKOV
 * @version 1.0
 */
public class User {
    /**
     * Переменная String passport - пасспорт вкладчика.
     * Переменная String username - имя вкладчика.
     */
    private String passport;
    private String username;

    /**
     * Конструктор для инициализации полей вкладчика.
     * @param passport - пасспорт.
     * @param username - имя вкладчика.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер. Получение пасспорта.
     * @return - возвращает пасспорт вкладчика.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер. Изменение данных пасспорта.
     * @param passport - принимет реквизит счета.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер. Получение имени вкладчика.
     * @return - возвращает имя вкладчика.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер. Изменение имя вкладчика.
     * @param username - принимет реквизит счета.
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод для определения хэш-кода.
     * @return - возвращает числовое представление объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
