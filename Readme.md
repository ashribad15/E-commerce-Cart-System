Mini E-commerce Cart System

This is a command-line-based mini e-commerce cart system implemented in Java. The system allows users to add items to their cart, remove them, view the current cart status, apply discounts automatically, and handle multi-currency conversions during checkout.


Overview

This application is designed to simulate a simple e-commerce system where users can interact with products in a cart via the command-line interface. It follows object-oriented programming (OOP) principles and allows easy scalability, enabling the addition of new features or products with minimal changes to existing code.


 Features
- Add to Cart: Users can add products to the cart, specifying the product ID and quantity.
- Remove from Cart: Users can remove items from the cart by product ID.
- View Cart: Displays the current contents of the cart, including the total cost before discounts.
- List Discounts: Users can view the discounts currently available in the system.
- Checkout: During checkout, discounts are applied automatically, and users can view the final total price in their chosen currency.
- Currency Conversion: Supports conversion of the total price to EUR or GBP during checkout.




Classes and Design


The application follows a modular, object-oriented design with the following classes:

- Product: Represents a product in the system, with attributes such as `productId`, `name`, `price`, and `category`.
- CartItem: Represents an item in the cart, storing the product and its quantity.
- ECommerceCartSystem: The main class that handles cart operations, discount management, and checkout logic.

 Design Approach
1. Modular Design: The system is designed to be easily extensible. New products, categories, and discounts can be added by modifying or extending the existing classes.
2. OOP Principles: Classes and inheritance are used to separate concerns (e.g., product details, cart operations, discounts), making the code easy to maintain and scale.
3. Discount Logic: Discounts are applied automatically during checkout. The system supports:
   - "Buy 1 Get 1 Free" on Fashion items.
   - 10% off on Electronics.
4. Currency Conversion: Users can convert the final total price to EUR or GBP after all discounts are applied. Fixed conversion rates are used for simplicity.




Assumptions

1. Product Catalog: The product catalog is pre-populated with 3 products:
   - Laptop (Electronics) - $1000
   - Phone (Electronics) - $500
   - T-Shirt (Fashion) - $20
2. Discount System: The system assumes two discount types:
   - "Buy 1 Get 1 Free" for Fashion items.
   - 10% off on Electronics items.
   These discounts are applied automatically during checkout, based on cart contents.
3. Currency Conversion Rates:
   - USD to EUR = 0.85
   - USD to GBP = 0.75
   These rates are assumed to be fixed and do not vary dynamically.
4. Command-line Interaction: The user interacts with the system solely through a command-line interface, using commands like `add`, `view`, `checkout`, etc.
5. Quantities and Pricing: The system assumes that:
   - Users can add multiple quantities of the same product to the cart.
   - Discounts are applied only to eligible quantities (e.g., the "Buy 1 Get 1 Free" discount requires at least 2 items).
   - No support for fractional quantities (e.g., partial items) is required.
6. Scalability: Although the system is implemented for a single user, it can be scaled to support multiple users with minimal changes.


How to Run

1. Clone or download the repository.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run the `ECommerceCartSystem` class.
4. Interact with the system using the following commands:
   - `add` - Add items to the cart (e.g., `add P001 1` adds 1 Laptop).
   - `remove` - Remove items from the cart (e.g., `remove P001`).
   - `view` - View the current contents of the cart.
   - `list_discounts` - List available discounts.
   - `checkout` - Apply discounts and view the final total with currency conversion.
   - `exit` - Exit the application.


Example Usage:

```bash
> add P001 1
> add P003 2
> view
> list_discounts
> checkout
> exit
```

---------

