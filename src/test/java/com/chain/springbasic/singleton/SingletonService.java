package com.chain.springbasic.singleton;

public class SingletonService {

    private static SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // new로 객체 생성하는 것 방지
    private SingletonService() {

    }

    public void logic() {
        System.out.println("테스트용 로직");
    }

}
