import java.util.Scanner;

public class HotelManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numRooms = 10; // Number of rooms 10 just to keep it simple
        Room[] rooms = new Room[numRooms]; // Creates room objects

        // Initialize all rooms
        for (int i = 0; i < numRooms; i++) {
            rooms[i] = new Room();
        }

        System.out.println("    Welcome to Hotel Manager!!!    ");
        System.out.print("Enter username: ");
        scanner.nextLine(); // Enter a username it is just for show
        System.out.print("Enter password: ");
        scanner.nextLine(); // Enter an password also just for show just to simulate the workflow
        
        // This is where the user chooses what they want to do
        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Room Status");
            System.out.println("2. Check In Guest");
            System.out.println("3. Check Out Guest");
            System.out.println("4. Clean Room");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            if (choice.equals("5")) {
                running = false;
                System.out.println("Exiting HotelManager...");
                break;
            }

            // After selecting an action the user now chooses what room they want to do the action on
            System.out.print("Enter room number (1-" + numRooms + "): ");
            int roomNumber;
            try {
                roomNumber = Integer.parseInt(scanner.nextLine()) - 1;
                if (roomNumber < 0 || roomNumber >= numRooms) {
                    System.out.println("Invalid room number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }
            
            // this is where the rooms state is changed,if you want to check room state, and if actions like cleaning, checking in, etc are valid
            Room selectedRoom = rooms[roomNumber];

            switch (choice) {
                case "1":
                    System.out.println("Room " + (roomNumber + 1) + " status: " + selectedRoom.checkStatus());
                    break;
                case "2":
                    selectedRoom.checkIn();
                    break;
                case "3":
                    selectedRoom.checkOut();
                    break;
                case "4":
                    selectedRoom.cleanRoom();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}

