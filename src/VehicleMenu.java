import java.util.*;

public class VehicleMenu {
    public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public static Scanner str = new Scanner(System.in);
    public static Scanner num = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int choice;
        while (true) {
            System.out.print("""
                    Menu:
                    1. Add a vehicle
                    2. Display a list of vehicle details
                    3. Delete a vehicle
                    4. Sort vehicle list by age
                    5. Quit
                    """);
            System.out.print("Enter your choice: ");
            choice = num.nextInt();


            switch (choice) {
                case 1:
                    addVcl();
                    break;

                case 2:
                    displayList();
                    break;

                case 3:
                    deleteVcl();
                    break;

                case 4:
                    sortList();
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void addVcl(){
        String regNo, make;
        Integer yoManuf;
        double value;

        System.out.print("Enter registration number: ");
        regNo = str.nextLine();

        System.out.print("Enter make: ");
        make = str.nextLine();

        System.out.print("Enter year of manufacture: ");
        yoManuf = num.nextInt();

        System.out.print("Enter value: ");
        value = num.nextDouble();

        Vehicle newVehicle = new Vehicle(regNo, make, yoManuf, value);

        vehicles.add(newVehicle);

        System.out.println("Vehicle added successfully");
    }

    public static void displayList(){
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).toString());
        }
    }

    public static void deleteVcl(){
        System.out.print("Enter the index of the vehicle to delete (1st = 0): ");
        int index = num.nextInt();

        vehicles.remove(index);

        System.out.println("Vehicle deleted successfully!");
        menu();
    }

    public static void sortList(){
        int choice;
        System.out.print("""
                            Sort Menu:
                            1. Sort by age (ascending)
                            2. Sort by age (descending)
                            3. Back to main menu
                            """);
        choice = num.nextInt();

        switch (choice) {
            case 1:
                vehicles.sort(new AscendingComparator());
                System.out.println("List of vehicle details sorted by age (ascending):");
                displayList();
                break;
            case 2:
                vehicles.sort(new DescendingComparator());
                System.out.println("List of vehicle details sorted by age (descending):");
                displayList();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                menu();
                break;
        }
    }

    // Custom Comparators
    public static class AscendingComparator implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            int i = o1.getYoManuf().compareTo(o2.getYoManuf());
            return i;
        }
    }

    public static class DescendingComparator implements Comparator<Vehicle> {
        @Override

        public int compare(Vehicle o1, Vehicle o2) {
            int i = o1.getYoManuf().compareTo(o2.getYoManuf());
            return -i;
        }
    }
}