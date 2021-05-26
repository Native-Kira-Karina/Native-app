package com.example.myapplication;

public class Model {

    String nam, age, inform, help;

    public Model(String nam, String age, String inform, String help) {
        this.nam = nam;
        this.age = age;
        this.inform = inform;
        this.help = help;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

}