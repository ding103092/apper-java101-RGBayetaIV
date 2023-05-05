public class SwitchStatements {
    // Sample enum
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        // Animals
        String animal = "dog";
        switch(animal) {
            case "dog":
                System.out.println("Woof!");
                break;
            case "cat":
                System.out.println("Meow!");
                break;
            case "cow":
                System.out.println("Moo!");
                break;
            case "sheep":
                System.out.println("Baa!");
                break;
            default:
                System.out.println("Unknown animal!");
                break;
        }

        Day day = Day.MONDAY;
        // switch case usage
        switch (day) {
            case MONDAY:
                System.out.println("Today is Monday");
                break;
            case TUESDAY:
                System.out.println("Today is Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Today is Wednesday");
                break;
            case THURSDAY:
                System.out.println("Today is Thursday");
                break;
            case FRIDAY:
                System.out.println("Today is Friday");
                break;
            case SATURDAY:
                System.out.println("Today is Saturday");
                break;
            case SUNDAY:
                System.out.println("Today is Sunday");
                break;
        }


        // We can stack case so it shares the same output
        int dayOfWeek = 5;
        String dayType;

        switch(dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Weekday";
                break;
            case 6:
            case 7:
                dayType = "Weekend";
                break;
            default:
                dayType = "Invalid day";
                break;
        }

        System.out.println("The day is a " + dayType);


    }
}
