package encapsulation.assigment_problems;

public class Week7_P5_ShoppingCart {

    static class Cart {
        private final double[] prices;
        private int itemCount;
        private final String cartId;

        Cart(String cartId, int maximumItems) {
            this.cartId = cartId;
            prices = new double[maximumItems];
            itemCount = 0;
        }

        void addItem(double price) {
            if (price >= 0 && itemCount < prices.length) {
                prices[itemCount] = price;
                itemCount++;
            }
        }

        double getTotal() {
            double total = 0;

            for (int i = 0; i < itemCount; i++) {
                total += prices[i];
            }

            return total;
        }

        int getItemCount() {
            return itemCount;
        }
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
