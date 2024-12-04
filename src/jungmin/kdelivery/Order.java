package jungmin.kdelivery;

public class Order {
  private String customerName;
  private String shopName;
  private String foodName;
  private boolean isReviewed = false;

  /**
  *@Order():주문 정보를 저장합니다.
  **/
  public Order(String customerName, String shopName, String foodName) {
    this.customerName = customerName;
    this.shopName = shopName;
    this.foodName = foodName;
  }

  public boolean isExistOrder(String customerName, String shopName, String foodName) {
    return this.customerName.equals(customerName) &&
            this.shopName.equals(shopName) &&
            this.foodName.equals(foodName);
  }

  public void setIsReviewed() {
    this.isReviewed = !this.isReviewed;
  }

  public boolean getIsReviewed() {
    return isReviewed;
  }
}
