import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Orders {

    private ArrayList<Integer> priceList = new ArrayList<>();
    private ArrayList<String> pizzaList = new ArrayList<>();
    private ArrayList<String> pickupTimeList = new ArrayList<>();
    private ArrayList<Timestamp> timestampList = new ArrayList<>();
    private ArrayList<Boolean> statusList = new ArrayList<>();


    public void removeItem(int index) {
        priceList.remove(index);
        pizzaList.remove(index);
        pickupTimeList.remove(index);
        timestampList.remove(index);
        statusList.remove(index);
    }

    public void addItem(String pizzas, String pickupTime, int price) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        pizzaList.add(pizzas);
        priceList.add(price);
        pickupTimeList.add(pickupTime);
        timestampList.add(timestamp);
        statusList.add(false);
    }

    public void addItem(String pizzas, int price) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        pizzaList.add(pizzas);
        priceList.add(price);
        pickupTimeList.add("Hurtigst muligt");
        timestampList.add(timestamp);
        statusList.add(false);
    }

    public void finish(int index) {
        statusList.set(index, true);
    }

    public void unfinish(int index) {
        statusList.set(index, false);
    }

    public void printAllItems() {
        for(int i = 0; i < pizzaList.size(); i++)
        {
            printItems(i, pickupTimeList.get(i), timestampList.get(i).toString(), pizzaList.get(i), priceList.get(i).toString());
        }
    }

    public void printFinishedItems() {
        for(int i = 0; i < pizzaList.size(); i++)
        {
            if (statusList.get(i)) printItems(i, pickupTimeList.get(i), timestampList.get(i).toString(), pizzaList.get(i), priceList.get(i).toString());
        }
    }

    public void printUnfinishedItems() {
        for(int i = 0; i < pizzaList.size(); i++)
            if (!statusList.get(i)) printItems(i, pickupTimeList.get(i), timestampList.get(i).toString(), pizzaList.get(i), priceList.get(i).toString());
    }

    public void printSales() {
        int sales = 0;
        for(int i = 0; i < priceList.size(); i++)
        {
            if (statusList.get(i)) sales = sales + priceList.get(i);
        }
        System.out.println("Total sales: " + sales + " kr.");
    }

    private void printItems(int index, String pickupTime, String timestamp, String pizzas, String price) {
        System.out.println("#" + index + " | Afhentes: " + pickupTime + " | Oprettet: " + timestamp + " | Pizzaer: " + pizzas + " | Pris: " + price + " kr.");
    }

}
