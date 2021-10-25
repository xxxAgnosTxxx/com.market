package com.example.com.market.models;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private int Price;
    private int Sum;

    public Items() {
    }

    public Items(String name, int price, int sum) {
        Name = name;
        Price = price;
        Sum = sum;
    }

    public Items(int id, String name, int price, int sum) {
        this.id = id;
        Name = name;
        Price = price;
        Sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int sum) {
        Sum = sum;
    }
}
