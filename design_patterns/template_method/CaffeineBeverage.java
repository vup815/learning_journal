package template_method;

public abstract class CaffeineBeverage {

    // template method
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // primitive operation
    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    // concrete operation
    void pourInCup() {
        System.out.println("pouring in cup");
    }

    // hook method
    boolean customerWantsCondiments() {
        return false;
    }
}
