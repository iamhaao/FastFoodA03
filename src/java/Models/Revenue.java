/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author LENOVO
 */
public class Revenue  {
    private String year;
    private String month;
    private String orderDate;
    private String totalTimesOrder;
    private String totalRevenueMonth;
    private double amountPerEx;

    public Revenue(String year, String month, String orderDate, String totalTimesOrder, String totalRevenueMonth, double amountPerEx) {
        this.year = year;
        this.month = month;
        this.orderDate = orderDate;
        this.totalTimesOrder = totalTimesOrder;
        this.totalRevenueMonth = totalRevenueMonth;
        this.amountPerEx = amountPerEx;
    }

    public Revenue(String year, String totalTimesOrder, String totalRevenueMonth) {
        this.year = year;
        this.totalTimesOrder = totalTimesOrder;
        this.totalRevenueMonth = totalRevenueMonth;
    }



    public Revenue() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTotalTimesOrder() {
        return totalTimesOrder;
    }

    public void setTotalTimesOrder(String totalTimesOrder) {
        this.totalTimesOrder = totalTimesOrder;
    }

    public String getTotalRevenueMonth() {
        return totalRevenueMonth;
    }

    public void setTotalRevenueMonth(String totalRevenueMonth) {
        this.totalRevenueMonth = totalRevenueMonth;
    }

    public double getAmountPerEx() {
        return amountPerEx;
    }

    public void setAmountPerEx(double amountPerEx) {
        this.amountPerEx = amountPerEx;
    }

    @Override
    public String toString() {
        return "Revenue{" + "year=" + year + ", month=" + month + ", orderDate=" + orderDate + ", totalTimesOrder=" + totalTimesOrder + ", totalRevenueMonth=" + totalRevenueMonth + ", amountPerEx=" + amountPerEx + '}';
    }

 
   
    
}
