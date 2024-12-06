package com.chain.springbasic.singleton;

public class StatefulService {

    private int price;

    public void order(String userName, int price) {
        System.out.println("userName: " + userName + ", price: " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
