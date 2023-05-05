public class CategoryEnum {

    public enum Category {
        MEN, WOMEN, KID, GRANDMA, GRANDPA
    }

    public static void main(String[] args) {
        Category chosenCategory = Category.MEN;
        double price = 0.0;

        switch (chosenCategory) {
            case MEN:
                price = 13.57;
                break;
            case WOMEN:
                price = 20.45;
                break;
            case KID:
                price = 45.6;
                break;
            case GRANDMA:
                price = 56.67;
                break;
            case GRANDPA:
                price = 3.56;
                break;
            default:
                System.out.println("Invalid category.");
                break;
        }

        System.out.println("Price of the chosen category (" + chosenCategory + "): " + price);
    }
}
