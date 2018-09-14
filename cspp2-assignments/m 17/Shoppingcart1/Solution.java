/**
 * Scanner class.
 */
import java.util.Scanner;

/**
 * Class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Shoppingcart shc = new Shoppingcart();
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
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
                System.out.println("totalAmount: "
                    + String.valueOf(shc.getTotalamount()));
                break;
                case "coupon":
                shc.applycoupon(input[1]);
                break;
                case "payableAmount":
                System.out.println("Payable amount: "
                    + String.valueOf(shc.getPayableamount()));
                break;
                case "print":
                shc.printInvoice();
                break;
                case "show":
                shc.showCart();
                break;
                case "catalog":
                shc.showCatalog();
                break;
                default:
                break;
            }
        }
    }
}


