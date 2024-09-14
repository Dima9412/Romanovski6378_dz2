import java.util.ArrayList;
import java.util.List;


public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Actor> queue;

    public Market() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        System.out.println(actor.getName() + " встал в очередь");
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queue) {
            if (actor.isMakeOrder() && !actor.isTakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди и готов уходить");
            }
        }
        releaseFromMarket(releasedActors);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    // метод для отображения текущего состояния очереди
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста.");
        } else {
            System.out.println("Текущая очередь:");
            for (Actor actor : queue) {
                System.out.println("- " + actor.getName());
            }
        }
    }

    //  метод для проверки, есть ли в очереди клиенты
    public boolean hasCustomersInQueue() {
        return !queue.isEmpty();
    }

    //  метод для получения количества клиентов в очереди
    public int getCustomerCount() {
        return queue.size();
    }

    // метод для получения списка клиентов, которые сделали заказ
    public List<Actor> getCustomersWhoMadeOrders() {
        List<Actor> customersWithOrders = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                customersWithOrders.add(actor);
            }
        }
        return customersWithOrders;
    }

    // метод для получения списка клиентов, которые получили заказы
    public List<Actor> getCustomersWhoReceivedOrders() {
        List<Actor> customersWithReceivedOrders = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isTakeOrder()) {
                customersWithReceivedOrders.add(actor);
            }
        }
        return customersWithReceivedOrders;
    }
}