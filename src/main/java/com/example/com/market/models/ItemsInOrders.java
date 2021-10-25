package com.example.com.market.models;

public class ItemsInOrders {
    private String Itemname;
    private int Username;
    private int sum;
    private int price;
    private int total;

    public ItemsInOrders() {
    }

    public ItemsInOrders(String itemname, int Username, int sum, int price, int total) {
        Itemname = itemname;
        this.Username=Username;
        this.sum = sum;
        this.price = price;
        this.total = total;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUsername() {
        return Username;
    }

    public void setUsername(int username) {
        Username = username;
    }
}
