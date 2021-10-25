package com.example.com.market.models;

public class AllEntities {
    private String name;
    private String surname;
    private String Itemname;
    private int sum;
    private int total;

    public AllEntities() {
    }

    public AllEntities(String name, String surname, String itemname, int sum, int total) {
        this.name = name;
        this.surname = surname;
        Itemname = itemname;
        this.sum = sum;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String itemname) {
        Itemname = itemname;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
