package com.example.com.market.models;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Iditem")
    private int ItemId;
    @Column(name="Iduser")
    private int UserId;
    private int Sum;

    public Orders(){}

    public Orders(int itemId, int userId, int sum) {
        ItemId = itemId;
        UserId = userId;
        Sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int sum) {
        Sum = sum;
    }
}
