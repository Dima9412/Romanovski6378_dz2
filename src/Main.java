import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();


        Actor Dmitry = new Actor("Дмитрий");
        Actor Vasya = new Actor("Вася");
        Actor Kolya = new Actor("Коля");
        Actor Vlad = new Actor("Влад");


        market.acceptToMarket(Dmitry);
        market.acceptToMarket(Vasya);
        market.acceptToMarket(Kolya);
        market.acceptToMarket(Vlad);


        market.update();


        market.displayQueue();


        System.out.println("Количество клиентов в очереди: " + market.getCustomerCount());


        List<Actor> customersWithOrders = market.getCustomersWhoMadeOrders();
        System.out.println("Клиенты, которые сделали заказы:");
        for (Actor customer : customersWithOrders) {
            System.out.println("- " + customer.getName());
        }


        market.update();


        market.displayQueue();

        List<Actor> customersWithReceivedOrders = market.getCustomersWhoReceivedOrders();
        System.out.println("Клиенты, которые получили заказы:");
        for (Actor customer : customersWithReceivedOrders) {
            System.out.println("- " + customer.getName());
        }
    }
}