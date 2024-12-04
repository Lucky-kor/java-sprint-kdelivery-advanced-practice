package jungmin.kdelivery;

public class Menu {
    private String menuName;
    private int price;

    public Menu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }
}
