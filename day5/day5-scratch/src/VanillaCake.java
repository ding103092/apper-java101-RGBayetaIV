public class VanillaCake implements Cake {
    @Override
    public void bake() {
        System.out.println("Baking a moist vanilla cake!");
    }

    @Override
    public void decorate() {
        System.out.println("Decorating the vanilla cake with whipped cream and fruits!");
    }
}