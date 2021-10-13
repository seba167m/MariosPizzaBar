public class Application {

    public static void main(String[] args) {

        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addItem(1, "Pizza et", 53);
        pizzaMenu.addItem(2, "Pizza to", 25);
        pizzaMenu.addItem(3, "Pizza tre", 88);
        pizzaMenu.printItems();

        Orders orders = new Orders();
        orders.addItem("2, 1", "1 time efter", 200);
        orders.addItem("3, 2", "30 min efter", 300);
        orders.addItem("3, 1", 200);
        orders.printAllItems();
        orders.finish(2);
        orders.finish(1);
        orders.printSales();
    }

}
