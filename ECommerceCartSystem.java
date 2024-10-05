import java.util.*;

class Product 
{
    String productId;
    String name;
    double price;
    String category;

    public Product(String productId, String name, double price, String category)
     {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() 
    {
        return name + " - $" + price + " (" + category + ")";
    }
}


class CartItem 
{
    Product product;
    int quantity;

    public CartItem(Product product, int quantity)
     {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() 
    {
        return product.price * quantity;
    }

    @Override
    public String toString()
     {
        return product.name + " - Quantity: " + quantity + ", Price: $" + product.price + ", Total: $" + getTotalPrice();
    }
}

public class ECommerceCartSystem 
{
    private static Map<String, Product> productCatalog = new HashMap<>();
    private static List<CartItem> cart = new ArrayList<>();

    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.75;

    public static void main(String[] args) 
    {
        initializeProductCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\nCommands: add, remove, view, list_discounts, checkout, exit");
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();

            switch (command) 
            {
                case "add":
                    addItemToCart(scanner);
                    break;
                case "remove":
                    removeItemFromCart(scanner);
                    break;
                case "view":
                    viewCart();
                    break;
                case "list_discounts":
                    listAvailableDiscounts();
                    break;
                case "checkout":
                    checkout(scanner);
                    break;
                case "exit":
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }

    private static void initializeProductCatalog() 
    {
        productCatalog.put("P001", new Product("P001", "Laptop", 1000.00, "Electronics"));
        productCatalog.put("P002", new Product("P002", "Phone", 500.00, "Electronics"));
        productCatalog.put("P003", new Product("P003", "T-Shirt", 20.00, "Fashion"));
    }

    private static void addItemToCart(Scanner scanner) 
    {
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        Product product = productCatalog.get(productId);

        if (product != null) 
        {
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            cart.add(new CartItem(product, quantity));
            System.out.println("Added " + quantity + " " + product.name + "(s) to cart.");
        }
         else 
         {
            System.out.println("Product not found!");
        }
    }

    private static void removeItemFromCart(Scanner scanner) 
    {
        System.out.print("Enter product ID to remove: ");
        String productId = scanner.nextLine();
        cart.removeIf(item -> item.product.productId.equals(productId));
        System.out.println("Item removed from cart.");
    }

    private static void viewCart() 
    {
        System.out.println("Your Cart:");
        double totalBeforeDiscounts = 0;
        for (CartItem item : cart) 
        {
            System.out.println(item);
            totalBeforeDiscounts += item.getTotalPrice();
        }

        System.out.println("Total (before discounts): $" + totalBeforeDiscounts);
    }

    private static void listAvailableDiscounts() 
    {
        System.out.println("Available Discounts:");
        System.out.println("1. Buy 1 Get 1 Free on Fashion items");
        System.out.println("2. 10% Off on Electronics");
    }

    private static void checkout(Scanner scanner) 
    {
        double totalPrice = applyDiscounts();
        System.out.println("Final Total in USD: $" + totalPrice);
        
        System.out.print("Would you like to view it in a different currency? (yes/no): ");
        String choice = scanner.nextLine();
        
        if ("yes".equalsIgnoreCase(choice)) 
        {
            System.out.println("Available Currencies: EUR, GBP");
            System.out.print("Enter currency: ");
            String currency = scanner.nextLine();

            switch (currency.toLowerCase()) {
                case "eur":
                    System.out.println("Final Total in EUR: €" + totalPrice * USD_TO_EUR);
                    break;
                case "gbp":
                    System.out.println("Final Total in GBP: £" + totalPrice * USD_TO_GBP);
                    break;
                default:
                    System.out.println("Currency not supported.");
            }
        }
    }

    private static double applyDiscounts() 
    {
        double totalPrice = 0;
        for (CartItem item : cart) {
            if (item.product.category.equals("Fashion") && item.quantity >= 2) 
            {
                item.quantity -= item.quantity / 2;
            }
            totalPrice += item.getTotalPrice();
        }
        
        
        for (CartItem item : cart) 
        {
            if (item.product.category.equals("Electronics"))
             {
                totalPrice -= item.getTotalPrice() * 0.1;
            }
        }

        return totalPrice;
    }
}
