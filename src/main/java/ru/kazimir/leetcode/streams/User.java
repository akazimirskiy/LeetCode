package ru.kazimir.leetcode.streams;

public class User {
    private int id;
    private int phone;
    private String name;
    private int age;
    private Sex sex;
    private boolean winner;

    public User(int id, int phone, String name, int age, Sex sex) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public boolean isWinner() {
        return winner;
    }
}
