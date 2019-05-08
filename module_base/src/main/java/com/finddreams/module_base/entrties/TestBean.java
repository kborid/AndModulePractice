package com.finddreams.module_base.entrties;

import java.io.Serializable;

public class TestBean implements Serializable {
    private String name;
    private String detail;
    private int price;

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
