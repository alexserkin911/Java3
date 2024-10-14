package lesson2;


import java.time.LocalDate;
import java.util.Objects;


public class Student {
    private int id;
    private String name;
    private String surName;
    private LocalDate birthDate;
    private int group;

    public Student(int id, String name, String surName, LocalDate birthDate, int group) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", surname=" + surName +
                ", birthDate=" + birthDate + ", groupId=" + group + "]";
    }
}
