package com.moflying.playground.entities;

public class FoodSalesInfo {
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
    private Integer totalSalesVolumn;

    public FoodSalesInfo(Integer foodId, String foodName, Integer totalSalesVolumn) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.totalSalesVolumn = totalSalesVolumn;
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

    public Integer getTotalSalesVolumn() {
        return totalSalesVolumn;
    }

    public void setTotalSalesVolumn(Integer totalSalesVolumn) {
        this.totalSalesVolumn = totalSalesVolumn;
    }
}
