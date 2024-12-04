package jungmin.kdelivery;

public class Feedback {
  private String customerName;
  private String shopName;
  private String foodName;
  private int grade;

  /**
   * @Feedback() : 정보를 저장합니다
   */
  public Feedback(String customerName, String shopName, String foodName, int grade) {
    this.customerName = customerName;
    this.shopName = shopName;
    this.foodName = foodName;
    this.grade = grade;
  }
  /**
   * @getStars() : 사용자가 입력한 점수가 별점으로 전환
   */
  public String getCustomerName() {
    return customerName;
  }

  public String getShopName() {
    return shopName;
  }

  public String getFoodName() {
    return foodName;
  }

  public String getGrade() {
    String star = "";
    for(int i = 0; i < this.grade; i++) {
      star += "★";
    }
    return star;
  }
  /**
   * @printInfo() : 출력
   */
  public void printInfo() {
    System.out.printf("%s [고객님]%n", this.customerName);
    System.out.println("-".repeat(30));
    System.out.printf("주문 매장 : %s%n", this.shopName);
    System.out.printf("주문 메뉴 : %s%n", this.foodName);
    System.out.printf("별점 : %s%n", this.getGrade());
  }
}
