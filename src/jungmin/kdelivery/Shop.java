package jungmin.kdelivery;

import java.util.*;

public class Shop {
  private String shopName;
  private List<Menu> menus;
  /**
   * @Shop() : 생성자 정의
   * 매장만 먼저 입력받도록 합니다.
   * 나머지 변수는 initValues() 에서 정의합니다.
   * */
  public Shop(String shopName) {
    this.shopName = shopName;
    initValues();
  }
  /**
   * @initValues() : 메뉴명와 가격정보를 담는 배열 생성 및 초기화
   * EMPTY_FOOD = "", EMPTY_PRICE = 0
   */
  private void initValues() {
    // 음식명을 담을 배열 선언
    this.menus = new ArrayList<>();
  }

  /**
   * @addFood() : 위 코드에서 정의된 변수를 받아 출력과 객체에 저장합니다.
   */
  public boolean addFood(String foodName, int price) {
    if(isNotExistsMenu(foodName)) {
      menus.add(new Menu(foodName, price));
      return true;
    } else {
      System.out.println("[안내] 해당 이름의 메뉴는 이미 존재합니다.");
      return false;
    }
  }

  public boolean isNotExistsMenu(String menuName) {
    for(Menu el: menus) {
      if(el.getMenuName().equals(menuName)) return false;
    }
    return true;
  }

  public String getShopName() {
    return shopName;
  }
}
