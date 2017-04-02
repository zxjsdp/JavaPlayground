package com.moflying.playground.entities;

import java.io.Serializable;

public class FoodSalesInfo implements Serializable {
    /**
     * 美食 ID
     */
    private Integer foodId;
    /**
     * 美食名称
     */
    private String foodName;
    /**
     * 美食销量
     */
    private Integer totalSalesVolume;

    public FoodSalesInfo(Integer foodId, String foodName, Integer totalSalesVolume) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.totalSalesVolume = totalSalesVolume;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getTotalSalesVolume() {
        return totalSalesVolume;
    }

    public void setTotalSalesVolume(Integer totalSalesVolume) {
        this.totalSalesVolume = totalSalesVolume;
    }

    @Override
    public String toString() {
        return "FoodSalesInfo{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", totalSalesVolume=" + totalSalesVolume +
                '}';
    }
}
