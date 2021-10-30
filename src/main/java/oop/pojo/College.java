package oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student andrey = new Student();
        andrey.setFio("Андрей Петрович Рыльский");
        andrey.setGroup("Группа 221");
        andrey.setDateReceipt(new Date());
        String text = "Студент:" + andrey.getFio() + System.lineSeparator()
                      + "Поступил в группу: " + andrey.getGroup() + System.lineSeparator()
                      + "Дата: " + andrey.getDateReceipt();
        System.out.println(text);
    }
}
