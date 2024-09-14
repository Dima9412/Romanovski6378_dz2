import java.util.List;


interface MarketBehaviour {
    void acceptToMarket(Actor actor);
    void takeOrders();
    void giveOrders();
    void releaseFromMarket(List<Actor> actors);
    void update();
}