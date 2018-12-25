import java.util.*;
import java.lang.*;
public class Car {
    private String route[];
    private Scanner scan = new Scanner(System.in);
    private int startingPosition[] = new int[2];
    private int currentPosition[] = new int[2];

    protected void takeInput() {
        System.out.println("Enter the starting position");
        takeCurrentPosition();
        System.out.println("Enter the way to go in directions such as N10 or S20 or E10 or W5");
        takeRoute();


    }

    protected void moveThroughRoute() {
        for (int i = 0; i < route.length; i++) {
            try {
                int temp = Integer.parseInt(route[i].substring(1));
                String switchCase = route[i].substring(0, 1).toLowerCase();
                System.out.println(currentPosition[1]);
                System.out.println(temp);
                switch (switchCase) {
                    case "n":
                        currentPosition[1] = currentPosition[1] + temp;
                        break;
                    case "s":
                        currentPosition[1] = currentPosition[1] - temp;
                        break;
                    case "e":
                        currentPosition[0] = currentPosition[0] + temp;
                        break;
                    case "w":
                        currentPosition[0] = currentPosition[0] - temp;
                        break;
                    default:
                        System.out.println("Route values are not proper");
                        System.exit(1);

                }
            } catch (NumberFormatException e) {
                System.out.println("Values are not proper");
                System.exit(1);
            }
        }
        System.out.println(Arrays.toString(currentPosition));
    }

    protected double locationDisplacement() {
        double displacement = Math.sqrt(((currentPosition[0] - startingPosition[0]) * (currentPosition[0] - startingPosition[0])) + ((currentPosition[1] - startingPosition[1]) * (currentPosition[1] - startingPosition[1])));
        return displacement;
    }

    private void takeCurrentPosition() {

            boolean done = false;
            do {
                if (scan.hasNextInt()) {
                    currentPosition[0] = scan.nextInt();
                    scan.nextLine();
                    startingPosition[0] = currentPosition[0];
                    done = true;
                } else {
                    scan.nextLine();
                    System.out.println("Enter a valid Integer value");
                }
            } while (!done);
                done = false;
        do {
            if (scan.hasNextInt()) {
                currentPosition[1] = scan.nextInt();
                scan.nextLine();
                startingPosition[1] = currentPosition[1];
                done = true;
            } else {
                scan.nextLine();
                System.out.println("Enter a valid Integer value");
            }
        } while (!done);

    }

    private void takeRoute(){
        String route=scan.nextLine();
        route=route.replaceAll("\\s","");
        this.route=route.split(",");

    }
}
