package com.sec01;

public class AddressInfo {
    private MyAddress address;
    private int age;

    public void setAddress(MyAddress address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AddressInfo [address=" + address + ", age=" + age + "]";
    }
}
