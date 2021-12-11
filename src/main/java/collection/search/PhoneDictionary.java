package collection.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> predicateName = (p -> p.getName().contains(key));
        Predicate<Person> predicateSurname = (p -> p.getName().contains(key));
        Predicate<Person> predicateAddress = (p -> p.getAddress().contains(key));
        Predicate<Person> predicatePhone = (p -> p.getPhone().contains(key));
        Predicate<Person> predicate = predicateName.or(predicateSurname).or(predicateAddress).
                or(predicatePhone);
        for (Person person : persons) {
            if (predicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
