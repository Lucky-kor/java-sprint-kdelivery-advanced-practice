package jungmin.kdelivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 클래스를 정의 합니다.
public class KDeliveryMain {

  /**
   * 배열을 담을 수 있는 객체 생성
   * 사용 범위, 객체 타입, 객체 이름
   */
  private List<Shop> shops;
  private List<Order> orders;
  private List<Feedback> feedbacks;

  // 해당 변수를 제어하는 Idx변수를 정의하고 초기화


  private Scanner s; // 사용자의 입력을 받는 객체 생성

  /**
   * @KDeliveryMainV1() : 매장 정보, 주문 정보, 리뷰 정보 초기화
   * initValues() 메서드 사용
   * */
  public KDeliveryMain(Scanner s) {
    this.s = s;
    initValues();
  }

  /**
   * @initValues() : 객체에 저장될 수 있는 크기 지정
   * SHOP_MAX, ORDER_MAX, FEEDBACK_MAX = 5
   * */
  private void initValues() {
    this.shops = new ArrayList<>();
    this.orders = new ArrayList<>();
    this.feedbacks = new ArrayList<>();
  }


  /**
   * @close() : 프로그램 종료를 위해 사용되는 메서드
   * 사용자가 종료를 선언하면 동작합니다.
   * main()에서 활용됩니다.
   * */
  public void close() {
    s.close();
  }


  /**
   * selectMainMenu() : 기능을 나열하며, 사용자가 원하는 기능을 정수로 받습니다.
   * */

  public int selectMainMenu() {
    printWelcomeMessage();
    return Integer.parseInt(s.nextLine());
  }

  /**
   * @selectAddShopMenu() : 음식점의 정보를 등록합니다.
   * @shops   : 가게 정보를 저장합니다.
   * @shopIdx : 가게 정보의 인덱스
   * */
  private void registerShopNameMessage() {
    System.out.println("[안내] 반갑습니다. 가맹주님!");
    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    arrowMessage();
  }
  private void arrowMessage() {
    System.out.println(">>>");
  }
  private void registerMenuNameMessage() {
    System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
    arrowMessage();
  }
  private void registerMenuPriceMessage() {
    System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
    arrowMessage();
  }
  private boolean isNameNotExists(String shopName) {
    for(Shop shop: shops) {
      if(shop.getShopName().equals(shopName)) return false;
    }
    return true;
  }
  public void selectAddShopMenu() {


    /**
     * @Shop.java 의 Shop 클래스를 활용한 객체 생성
     * @public 클래스 : 동일 패키지 및 다른 패키지에서 사용가능
     * @addFood() : Shop.java 의 Shop 클래스의 addFood() 메서드
     * 해당 메서드는 매장명, 음식명, 가격을 입력받아 객체에 저장
     * 값이 저장될 때 마다 shopIdx 값 증가
     */


    // 음식점 정보 입력 받기
    // 음식점명 입력 받기
    registerShopNameMessage();
    String shopName = s.nextLine();
    // 음식점 이름을 가지고 Shop 객체 생성
    // 하지만 이름만 있고, 실제 상품과 가격 배열은 여전히 빈 배열
    Shop currentAddedShop;
    if(isNameNotExists(shopName)) {
      currentAddedShop = new Shop(shopName);
    } else {
      System.out.println("[안내] 이미 등록된 상점입니다.");
      return;
    }

    // 메뉴를 한개 추가함
    // 메뉴명 입력받음
    registerMenuNameMessage();
    String foodName = s.nextLine();

    // 해당 메뉴의 가격을 입력받고
    registerMenuPriceMessage();
    int foodPrice = Integer.parseInt(s.nextLine());

    // 방금 만든 Shop객체에 해당 메뉴를 추가함
    currentAddedShop.addFood(foodName, foodPrice);

    // 추가가 잘 되었으면 주문내역 출력
    System.out.printf("[안내] %s에 음식(%s, %d) 추가되었습니다.", shopName, foodName, foodPrice);
    System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");

    // 다 만들어진 Shop 객체를 배열에 추가
    // 추가해야지만 앞으로 이 가게를 이용할 수 있음 Kdelivery 객체에서 가게 리스트를 배열로 가지고 있어야
    // 앞으로 해당 가게에서 상품을 조회할 수 있기 때문입니다.

    this.shops.add(currentAddedShop);
  }

  /**
   * @selectDashboardMenu() : 해당 메서드는 등록된 가게 정보를 출력합니다.
   * Feedback.java 파일의 클래스 및 메서드를 활용합니다.
   * */
  public void selectDashboardMenu() {
    if(feedbacks.isEmpty()) {
      System.out.println("[안내] 현재 평가된 내역이 없습니다.");
      return;
    }
    for(Feedback feedback: feedbacks) {
      feedback.printInfo();
    }
  }

  /**
   * @selectOrderMenu() : 주문 기능
   * 사용자의 입력을 받아 orders 객체에 저장
   * */
  public void selectOrderMenu() {
    // 주문자 정보 입력 받기
    System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
    System.out.println("[안내] 주문자 이름을 알려주세요!");
    System.out.print(">>>");
    String customerName = s.nextLine();

    // 음식점 이름 받기
    System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
    System.out.print(">>>");
    String shopName = s.nextLine();

    // 존재하는 음식점인지 보고 없으면 실패 메시지 이후 return;
    if(isNameNotExists(shopName)) {
      System.out.println("[안내] 해당 이름의 상점은 존재하지 않습니다. 다시 확인해주세요.");
      return;
    }

    // 상품 이름 입력 받기
    System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
    System.out.print(">>>");
    String foodName = s.nextLine();

    // 존재하는 상품인지 보고 없으면 실패 메시지 이후 return;
    Shop currentSelectedShop = isUsedShop(shopName);
    if(currentSelectedShop.isNotExistsMenu(foodName)) {
      System.out.printf("[안내] %s에는 %s라는 음식을 판매하고 있지 않습니다.%n", shopName, foodName);
      return;
    }

    // 고객명 가게명 상품명을 가지고 Order객체 생성
    Order order = new Order(customerName, shopName, foodName);

    // orders 배열에 현재 만든 주문 객체 추가
    orders.add(order);

    System.out.printf("[안내] %s님!%n", customerName);
    System.out.printf("[안내] %s 매장에 %s 주문이 완료되었습니다.", shopName, foodName);
  }

  /**
   * @selectFeedbackMenu() : 메뉴의 피드백을 입력받는 기능
   * */
  public void selectFeedbackMenu() {
    System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
    System.out.println("[안내] 주문자 이름은 무엇인가요?");
    System.out.println(">>>");
    String customerName = s.nextLine();

    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    String shopName = s.nextLine();

    System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
    System.out.println(">>>");
    String foodName = s.nextLine();

    // 이 시점에서 해당 고객명, 상호명, 메뉴명을 통해
    // 주문내역이 있는지 확인
    // 있다면 별점 입력으로 pass
    // 없다면 주문내역 확인하라고 하고 return;
    boolean isValid = false;
    Order currentSelectedOrder = null;
    for(Order order: orders) {
      if(order.isExistOrder(customerName, shopName, foodName)
              && !order.getIsReviewed()) {
        isValid = true;
//        order.setIsReviewed();
        currentSelectedOrder = order;
      }
    }

    if(!isValid) {
      System.out.println("[안내] 주문내역을 다시 확인해주세요.");
      return;
    }

    System.out.println("[안내] 음식 맛은 어떠셨나요? (1~5) ex) 5");
    System.out.println(">>>");
    int grade = Integer.parseInt(s.nextLine());

    Feedback feedback = new Feedback(customerName, shopName, foodName, grade);
    currentSelectedOrder.setIsReviewed();
    feedbacks.add(feedback);

  }
  private Shop isUsedShop(String shopName) {
    for(Shop shop: shops) {
      if(shop.getShopName().equals(shopName)) {
        return shop;
      }
    }
    return null;
  }

  public void addShopInMenu() {
    registerShopNameMessage();
    String shopName = s.nextLine();
    // 위에 입력받은 상점명으로 해당 상점 객체를 찾아와야 합니다.

    Shop currentSelectedShop = isUsedShop(shopName);

    if(currentSelectedShop == null) {
      System.out.println("[안내] 상점명을 다시 확인해주세요.");
      return;
    }

    // 메뉴명 입력받음
    registerMenuNameMessage();
    String foodName = s.nextLine();

    // 해당 메뉴의 가격을 입력받고
    registerMenuPriceMessage();
    int foodPrice = Integer.parseInt(s.nextLine());

    // 방금 만든 Shop객체에 해당 메뉴를 추가함
    boolean isAdded = currentSelectedShop.addFood(foodName, foodPrice);

    if(isAdded) {
      System.out.printf("[안내] %s에 %s 메뉴가 %d원으로 등록되었습니다.%n", shopName, foodName, foodPrice);
    } else {
      System.out.println("-".repeat(30));
    }
  }

  private void printWelcomeMessage() {
    System.out.println("[치킨의 민족 프로그램 V1]");
    System.out.println("-".repeat(30));
    System.out.println("1) [사장님용] 음식점 등록하기");
    System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
    System.out.println("3) [고객님용] 음식 주문하기");
    System.out.println("4) [고객님용] 별점 등록하기");
    System.out.println("5) [사장님용] 메뉴 추가하기");
    System.out.println("6) 프로그램 종료하기");
    System.out.println("-".repeat(30));
  }

}