public class App5 {
    public static void main(String[] args) {
        Cake chocolateCake = new ChocolateCake();
        chocolateCake.bake();
        chocolateCake.decorate();

        Cake vanillaCake = new VanillaCake();
        vanillaCake.bake();
        vanillaCake.decorate();
    }
}