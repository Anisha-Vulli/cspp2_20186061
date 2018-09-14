/**
 * ArrayList.
 */
import java.util.ArrayList;
/**
 * Scanner class.
 */
import java.util.Scanner;
/**
 * Arrays.
 */
import java.util.Arrays;
import java.util.stream.*;


class Item {
    private String iname;
    private String quant;
    private String price;
    Item(final String iname1, final String quant1, final String price1) {
        this.iname = iname1;
        this.quant = quant1;
        this.price = price1;
    }

    String getiname() {
        return this.iname;
    }

    String getquant() {
        return this.quant;
    }

    String getprice() {
        return this.price;
    }

    void SetQuantity(String quant2) {
        this.quant = quant2;
    }

    public String toString() {
        return iname + " " + quant + " " + Float.valueOf(price);
    }
}


class Shoppingcart {
    private ArrayList<Item>catalog;
    private ArrayList<Item>cart;
    Shoppingcart() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
    }

    void addToCatalog(final Item item) {
        catalog.add(item);
    }

    void addToCart(final Item cartItem) {
        for (Item item : catalog) {
            if ((item.getiname()).equals(cartItem.getiname())) {
                cart.add(cartItem);
            }
        }
    }

    void removeFromcart(final String name, final int quant) {
        int newquant = 0;
        for (Item cartin : cart) {
            if (cartin.getiname().equals(name)) {
                int a = Integer.parseInt(cartin.getquant());
                //int b = quant;
                int c = a - quant;
                cartin.SetQuantity(String.valueOf(c));
            }
        }
    }

    Double getTotalamount() {
        double total = 0;
        for (Item cartit : cart) {
            for (Item cat : catalog) {
                if ((cartit.getiname()).equals(cat.getiname())) {
                    double price = Double.valueOf(cat.getprice()) * Double.valueOf(cartit.getquant());
                    total = total + price;
                }
            }
        }
        return total;
    }
    void showCart() {
        for (Item cartit : cart) {
            System.out.println(cartit.getiname() + " " + cartit.getquant());
        }
    }

    void showCatalog() {
        for (Item item : catalog) {
            System.out.println(item.toString());
        }
    }
}
public final class Solution {
    public static void main(final String[] args) {
        Shoppingcart shc = new Shoppingcart();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            switch(input[0]) {
                case "Item":
                String[] tokens = input[1].split(",");
                shc.addToCatalog(new Item(tokens[0], tokens[1], tokens[2]));
                break;
                case "add":
                String[] token = input[1].split(",");
                shc.addToCart(new Item(token[0], token[1], null));
                break;
                case "remove":
                String[] token1 = input[1].split(",");
                int removequant = Integer.parseInt(token1[1]);
                shc.removeFromcart(token1[0], removequant);
                break;
                case "totalAmount":
                System.out.println("totalAmount: " + String.valueOf(shc.getTotalamount()));
                break;
                case "show":
                shc.showCart();
                break;
                case "catalog":
                shc.showCatalog();
                break;
            }
        }
    }
}