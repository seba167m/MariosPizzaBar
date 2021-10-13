import java.util.ArrayList;

public class PizzaMenu {

    private ArrayList<Integer> indexList = new ArrayList<>();
    private ArrayList<String> nameList = new ArrayList<>();
    private ArrayList<Integer> priceList = new ArrayList<>();

    public void removeItem(int index) {
        nameList.remove(index);
        priceList.remove(index);
    }

    public void addItem(int index, String name, int price) {
        indexList.add(index);
        nameList.add(name);
        priceList.add(price);
    }

    public void printItems() {
        for(int i = 0; i < nameList.size(); i++)
        {
            System.out.println(indexList.get(i) + " - " + nameList.get(i) + " - " + priceList.get(i) + " kr.");
        }
    }

}
