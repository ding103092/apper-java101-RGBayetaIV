import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Activity1v2 {

    public static void main(String[] args) {
        System.out.println("Welcome to FlamesHope!");

        // Variables
        Scanner myScanner = new Scanner(System.in);
        String name, crushName;

        // Prompts user to enter name and crush name
        do {
            System.out.print("Enter name: ");
            name = myScanner.nextLine().trim();

            System.out.print("Enter your crush name: ");
            crushName = myScanner.nextLine().trim();

            if (name.isEmpty() || !crushName.isEmpty()) {
                System.out.println("Please enter a valid name and crush name!");
            }

        } while (name.isEmpty() || crushName.isEmpty());

        // Close scanner
        myScanner.close();

        // Calculate compatibility
        int result = flames(name, crushName);
        switch (result) {
            case 1:
                System.out.println("You are friends!");
                break;
            case 2:
                System.out.println("You are love!");
                break;
            case 3:
                System.out.println("You are attractive!");
                break;
            case 4:
                System.out.println("You are married!");
                break;
            case 5:
                System.out.println("You are engaged!");
                break;
            case 6:
                System.out.println("You are sweetheart!");
                break;
            default:
                System.out.println("You are not compatible!");
                break;
        }

    }
static int flames(String person1Name, String person2Name) {
    // Flames is the length of the symmetric difference between
    // person1Name and person2Name, then modulo 6
    // 1 - Friends, 2 - Love, 3 - Attraction, 4 - Marriage, 5 - Engaged, 6 - Sweetheart
    // Source: philstar.com/lifestyle/modern-living/2012/06/02/812742/childhood-games

    Set<Character> setA = new HashSet<>(); // person1
    Set<Character> setB = new HashSet<>(); // person2

    // Populate setA with person1Name char, then do the same with setB with person2Name char
    for (char c : person1Name.toCharArray()) setA.add(c);
    for (char c : person2Name.toCharArray()) setB.add(c);

    // Find the symmetric difference (A delta B --> (AunionB)-(AintersectionB))
    Set<Character> symdiff = new HashSet<>(setA);
    symdiff.addAll(setB); // A union B
    Set<Character> intersection = new HashSet<>(setA);
    intersection.retainAll(setB); // A intersection B
    symdiff.removeAll(intersection); // A delta B

    return symdiff.size() % 6;
}
}

