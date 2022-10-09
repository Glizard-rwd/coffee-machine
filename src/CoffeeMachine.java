import java.util.Scanner;

public class CoffeeMachine {
    // data field
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int totalBudget;
    private final static int WATER_ML = 200;
    private final static int MILK_ML = 50;
    private final static int BEAN_G = 15;
    static Scanner scanner = new Scanner(System.in);
    // constructor
    public CoffeeMachine() {
        // At the moment
        // the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.totalBudget = 550;
    }
    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int totalBudget) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.totalBudget = totalBudget;
    }

    // coffee machine displays the information
    public void mainMenu() {
        System.out.println("The coffee machine has: " );
        System.out.println(getWater() + " ml of water");
        System.out.println(getMilk() + " ml of milk");
        System.out.println(getCoffeeBeans() + " g of coffee beans");
        System.out.println(getCups() + " disposable cups");
        System.out.println("$" + getTotalBudget() + " of money");
    }
    // coffee machine choose an action
    public void chooseAction() {
        String userInput;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            userInput = scanner.nextLine();
            switch(userInput) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> remaining();
            }
        } while(!userInput.equals("exit"));

    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String coffeeNo = scanner.nextLine();
        switch (coffeeNo) {
            case "1" -> checkAvailable(new Expresso());
            case "2" -> checkAvailable(new Latte());
            case "3" -> checkAvailable(new Cappuccino());
        }
    }
    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int waterAdd = scanner.nextInt();
        setWater(getWater()+waterAdd);
        System.out.println("Write how many ml of milk you want to add:");
        int milkAdd = scanner.nextInt();
        setMilk(getMilk() + milkAdd);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int cBeansAdd = scanner.nextInt();
        setCoffeeBeans(getCoffeeBeans() + cBeansAdd);
        System.out.println("Write how many disposable cups you want to add:");
        int cupsAdd = scanner.nextInt();
        setCups(getCups() + cupsAdd);
    }
    public void take() {
        System.out.println("I gave you $" + getTotalBudget());
        setTotalBudget(0);
    }

    private void remaining() {
        mainMenu();
    }

    public void checkAvailable(Coffee coffeeType) {
        if (coffeeType.getWater() > getWater()) System.out.println("Sorry, not enough water!");
        else if (coffeeType.getMilk() > getMilk()) System.out.println("Sorry, not enough milk!");
        else if (coffeeType.getCoffeeBeans() > getCoffeeBeans()) System.out.println("Sorry, not enough coffee beans!");
        else if (coffeeType.getCups() > getCups()) System.out.println("Sorry, not enough disposable cups!");
        else {
            System.out.println("I have enough resources, making you a coffee!");
            setWater(getWater() - coffeeType.getWater());
            setMilk(getMilk() - coffeeType.getMilk());
            setCoffeeBeans(getCoffeeBeans() - coffeeType.getCoffeeBeans());
            setCups(getCups() - 1);
            setTotalBudget(getTotalBudget() + coffeeType.getTotalBudget());
        }
    }


    // getter and setter
    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }
}
