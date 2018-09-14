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

    void setQuantity(String quant2) {
        this.quant = quant2;
    }

    public String toString() {
        return iname + " " + quant + " " + Float.valueOf(price);
    }
}


class Shoppingcart {
    private ArrayList<Item>catalog;
    private ArrayList<Item>cart;
    int discount;
    Shoppingcart() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
        discount = 0;
    }

    void addToCatalog(final Item item) {
        catalog.add(item);
    }

    void addToCart(final Item item) {
        for (Item catalogitem : catalog) {
            if ((catalogitem.getiname()).equals(item.getiname())) {
                for (Item cartitem : cart) {
                    if ((cartitem.getiname().equals(item.getiname()))) {
                        int a = Integer.parseInt(cartitem.getquant());
                        int b = Integer.parseInt(item.getquant());
                        int c = a + b;
                        cartitem.setQuantity(String.valueOf(c));
                        return;
                    }
                }
                cart.add(item);
                return;
            } 
        }
    }

    void removeFromcart(final Item items) {
        for (Item cartitems : cart) {
            if ((cartitems.getiname()).equals(items.getiname())) {
                int a = Integer.parseInt(cartitems.getquant());
                int b = Integer.parseInt(items.getquant());
                int c = a - b;
                if (c == 0) {
                    cart.remove(cartitems);
                    return;
                } else { 
                    cartitems.setQuantity(String.valueOf(c));
                    return;
                }
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

    Double getPayableamount() {
        double payableAmount = 0;
        double amt = getTotalamount();
        double discountval = (discount * amt) / 100;
        double amount = amt - discountval;
        double tax = (15 * amount) / 100;
        payableAmount = amount  + tax;
        return payableAmount;
    }

    void applycoupon(final String coupon) {
        int[] couponvals = new int[] {10, 20, 30, 50};
        String[] num = coupon.split("D");
        int coupondis = Integer.parseInt(num[1]);
        for (int i = 0; i < couponvals.length; i++) {
            if (coupondis == couponvals[i]) {
                discount = coupondis;
                return;
            } else {
                System.out.println("Invalid coupon");
            }
        }
        //System.out.println(discount);
        return;
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
                shc.removeFromcart(new Item(token1[0], token1[1], null));
                break;
                case "totalAmount":
                System.out.println("totalAmount: " + String.valueOf(shc.getTotalamount()));
                break;
                case "coupon":
                shc.applycoupon(input[1]);
                break;
                case "payableAmount":
                System.out.println("Payable amount: " + String.valueOf(shc.getPayableamount()));
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