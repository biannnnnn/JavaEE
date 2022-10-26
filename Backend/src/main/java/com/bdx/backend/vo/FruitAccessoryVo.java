package com.bdx.backend.vo;

/**
 * @PROJECT_NAME: Backend
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/25 22:45
 */
public class FruitAccessoryVo {
    private int fruitId;
    private String locality;
    private int accessoryId;
    private String name;
    private double price;
    private String createTime;

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FruitAccessoryVo{" +
                "fruitId=" + fruitId +
                ", locality='" + locality + '\'' +
                ", accessoryId=" + accessoryId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
