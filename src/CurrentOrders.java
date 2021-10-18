import org.w3c.dom.ls.LSOutput;

import java.awt.List;
import java.util.*;

public class CurrentOrders {
  static ArrayList<String> fufilledOrders = new ArrayList<>();

  public static String current() {
    TreeMap<Integer, String> afhentningsTid = new TreeMap<Integer, String>();
    for (String findAll : RegisterOrdre.currentOrders) {
      String tidspunkt = findAll.substring(findAll.indexOf("Afhentes kl: ") + 13);
      tidspunkt = tidspunkt.substring(0, tidspunkt.indexOf(" "));
      int tidspunkter = Integer.parseInt(tidspunkt);
      afhentningsTid.put(tidspunkter, findAll);
    }
    RegisterOrdre.currentOrders = new ArrayList<>(afhentningsTid.values());
    for (String find : RegisterOrdre.currentOrders) {
      System.out.println(find);

    }
    return null;
  }

  public static void deleteOrder() {
    Scanner input = new Scanner(System.in);
    System.out.println("Hvilken Order ID vil du slette?");
    int orderID = input.nextInt();
    for (String order : RegisterOrdre.currentOrders) {
      String sub = order.substring(order.indexOf("Order ID: ") + 10);
      sub = sub.substring(0, sub.indexOf(" "));
      if (Integer.parseInt(sub) == orderID) {
        RegisterOrdre.currentOrders.remove(order);
        System.out.println("Den er nu slettet");

      }
      while (true) MenuRun.run();
    }
  }


  public static void fufillOrder(int ordreID) {

    Scanner input = new Scanner(System.in);
    System.out.println("Hvilken order ID vil du fuldføre?");
    ordreID = input.nextInt();
    for (String order : RegisterOrdre.currentOrders) {
      String sub = order.substring(order.indexOf("Order ID: ") + 10);
      sub = sub.substring(0, sub.indexOf(" "));
      if (Integer.parseInt(sub) == ordreID) {
        fufilledOrders.add(order);
        RegisterOrdre.currentOrders.remove(order);
        System.out.println("Den er nu fuldført");
        System.out.println("Nu kan du se den under “Håndtering af ordrer --> Se fuldførte ordrer“");

      }
      while (true) MenuRun.run();
    }

  }

}
