public class CategoryEnum {

    public enum Category {
        MEN, WOMEN, KID, GRANDMA, GRANDPA
    }

    public static void main(String[] args) {
        Category chosenCategory = Category.WOMEN;
        double price = 0.0;

        // Using enhanced switch (JAVA 12 and above only)
        price = switch (chosenCategory) {
            case MEN ->  13.57;
            case WOMEN -> 20.45;
            case KID -> 45.6;
            case GRANDMA -> 56.67;
            case GRANDPA -> 3.56;
            // default -> -1; OPTIONAL, no default value was given
            // by the instructions
        };

        // Using standard switch

//        switch (chosenCategory) {
//            case MEN:
//                price = 13.57;
//                break;
//            case WOMEN:
//                price = 20.45;
//                break;
//            case KID:
//                price = 45.6;
//                break;
//            case GRANDMA:
//                price = 56.67;
//                break;
//            case GRANDPA:
//                price = 3.56;
//                break;
//            default:
//                System.out.println("Invalid category.");
//                break;
//        }

        System.out.println("Price of the chosen category (" + chosenCategory + "): " + price);
    }
}
