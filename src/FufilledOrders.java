import java.util.*;

public class FufilledOrders {
  static ArrayList<String> fufilled = new ArrayList<>();

  public static void doneOrders() {
    System.out.println("\nFuldførte Ordre");
    for (String find : CurrentOrders.fufilledOrders) {
      System.out.println(find);
      fufilled.add(find);
    }
  }

  public static int revenue() {
    int sum = 0;
    for (String findAll : CurrentOrders.fufilledOrders) {
      String dkk = findAll.substring(findAll.indexOf("DKK ") + 4);
      dkk = dkk.substring(0, dkk.indexOf(" "));
      int dkks = Integer.parseInt(dkk);
      sum = sum + dkks;
    }
    return sum;
  }


  public static String popularOrder() {
    TreeMap<Integer, String> sorterEfterPizza = new TreeMap<Integer, String>();
    for (String findAll : fufilled) {
      String pizza = findAll.substring(findAll.indexOf("Pizza: ") + 7);
      pizza = pizza.substring(0, pizza.indexOf(" "));
      String order = findAll.substring(findAll.indexOf("Order ID: ") + 10);
      order = order.substring(0, order.indexOf(" "));
      int orders = Integer.parseInt(order);
      int pizzaer = Integer.parseInt(pizza);
      sorterEfterPizza.put(orders+pizzaer, findAll);
    }

      fufilled = new ArrayList<>(sorterEfterPizza.values());
      for (String find : fufilled) {
        System.out.println(find);

      }
      return null;
  }

}

