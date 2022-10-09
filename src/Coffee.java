public class Coffee extends CoffeeMachine {
    private String coffeeName;
    public Coffee(int water, int milk, int coffeeBeans, int cup, int price, String coffeeName) {
        super(water, milk, coffeeBeans, 1, price); // need 1 cup when making coffee
        this.coffeeName = coffeeName;
    }
}