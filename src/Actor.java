
class Actor {
    private String name;
    private boolean makeOrder;
    private boolean takeOrder;

    public Actor(String name) {
        this.name = name;
        this.makeOrder = false;
        this.takeOrder = false;
    }

    public String getName() {
        return name;
    }

    public boolean isMakeOrder() {
        return makeOrder;
    }

    public void setMakeOrder(boolean makeOrder) {
        this.makeOrder = makeOrder;
    }

    public boolean isTakeOrder() {
        return takeOrder;
    }

    public void setTakeOrder(boolean takeOrder) {
        this.takeOrder = takeOrder;
    }
}