/**
 * ArrayList.
 */
import java.util.ArrayList;
/**
 * Scanner class.
 */
import java.util.Scanner;

/**
 * Class for item.
 */
class Item {
    /**
     * Name of the item.
     */
    private String iname;
    /**
     * Quantity.
     */
    private String quant;
    /**
     * Price.
     */
    private String price;
    /**
     * Constructs the object.
     *
     * @param      iname1  The iname 1
     * @param      quant1  The quant 1
     * @param      price1  The price 1
     */
    Item(final String iname1, final String quant1, final String price1) {
        this.iname = iname1;
        this.quant = quant1;
        this.price = price1;
    }
    /**
     * getting name.
     *
     * @return     { name }
     */
    public String getiname() {
        return iname;
    }
    /**
     * getting quantity.
     *
     * @return     { quantity }
     */
    public String getquant() {
        return quant;
    }
    /**
     * getting price.
     *
     * @return     { price }
     */
    public String getprice() {
        return price;
    }
    /**
     * Sets the quantity.
     *
     * @param      quant2  The quant 2
     */
    public void setQuantity(final String quant2) {
        this.quant = quant2;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return iname + " " + quant + " " + Float.valueOf(price);
    }
}

/**
 * Class for shoppingcart.
 */
class Shoppingcart {
    /**
     * Catalog arraylist.
     */
    private ArrayList<Item> catalog;
    /**
     * cart arraylist.
     */
    private ArrayList<Item> cart;
    /**
     * discount.
     */
    private int discount;
    /**
     * flag.
     */
    private boolean cflag;
    /**
     * Hundred value.
     */
    private int hundred = 100;
    /**
     * Constructs the object.
     */
    Shoppingcart() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
        discount = 0;
        cflag = true;
    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    void addToCatalog(final Item item) {
        catalog.add(item);
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
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
    /**
     * Removes a from cart.
     *
     * @param      items  The items
     */
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
    /**
     * Gets the totalamount.
     *
     * @return     The totalamount.
     */
    Double getTotalamount() {
        double total = 0;
        for (Item cartit : cart) {
            for (Item cat : catalog) {
                if ((cartit.getiname()).equals(cat.getiname())) {
                    double price = Double.valueOf(cat.getprice()) * Double.valueOf(cartit.getquant());
                    //pricearr.add(price);
                    total = total + price;
                }
            }
        }
        return total;
    }
    /**
     * Gets the payableamount.
     *
     * @return     The payableamount.
     */
    Double getPayableamount() {
        double payableAmount = 0;
        double amt = getTotalamount();
        double discountval = (discount * amt) / hundred;
        double amount = amt - discountval;
        double tax = (15 * amount) / hundred;
        payableAmount = amount  + tax;
        return payableAmount;
    }
    /**
     * Applying coupon.
     *
     * @param      coupon  The coupon
     */
    void applycoupon(final String coupon) {
        int[] couponvals = new int[] {10, 20, 30, 50};
        String[] num = coupon.split("D");
        int coupondis = Integer.parseInt(num[1]);
        if (cflag) {
            for (int i = 0; i < couponvals.length; i++) {
            if (coupondis == couponvals[i]) {
                discount = coupondis;
                cflag = false;
                return;
            }
          }
          System.out.println("Invalid coupon");
          return;
        }
    }
    /**
     * Shows the cartesian.
     */
    void showCart() {
        for (Item cartit : cart) {
            System.out.println(cartit.getiname() + " " + cartit.getquant());
        }
    }
    /**
     * Gets the price.
     *
     * @param      name  The name
     *
     * @return     The price.
     */
    public float getPrice(String name) {
        for (Item e : catalog) {
            if (e.getiname().equals(name)) {
                return Float.valueOf(e.getprice());
            }
        }
        return 0.0f;
    }
    /**
     * Shows the catalog.
     */
    void showCatalog() {
        for (Item item : catalog) {
            System.out.println(item.toString());
        }
    }
    /**
     * Printing invoice.
     */
    void printInvoice() {
        System.out.println("Name" + "   " + "quantity" + "   " + "Price");
        for (Item iter : cart) {
            System.out.println(iter.getiname() + " " + iter.getquant() + " " + getPrice(iter.getiname()));
        }
        double totalamount = getTotalamount();
        double discountedval = (discount * totalamount) / hundred;
        double taxval = 0.0;
        if (discountedval == 0.0) {
            taxval = (15 * totalamount) / hundred;
        } else {
            taxval = (15 * (totalamount - discountedval)) / hundred;
        }
        System.out.println("Total:" + String.valueOf(totalamount));
        System.out.println("Disc%:" + String.valueOf(discountedval));
        System.out.println("Tax:" + String.valueOf(taxval));
        System.out.println("Payable amount: " + String.valueOf(getPayableamount()));
    }
}