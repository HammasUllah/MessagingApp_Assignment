import java.util.Scanner;

public class MessageTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of users: ");
        int userCount = input.nextInt();

        System.out.print("Enter the maximum number of messages per user: ");
        int messageCount = input.nextInt();

        MessageData messagesData = new MessageData(userCount, messageCount);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Send Message (User ID 0-" + (userCount - 1) + ")");
            System.out.println("2. See Message (User ID 0-" + (userCount - 1) + ")");
            System.out.println("3. Read All Messages (User ID 0-" + (userCount - 1) + ")");
            System.out.println("4. Read Specific Message (User ID 0-" + (userCount - 1) + ")");
            System.out.println("5. Delete Message (User ID 0-" + (userCount - 1) + ")");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            if (choice == 0) {
                exit = true;
                System.out.println("Exiting the program.");
            } else {
                System.out.print("Enter user ID (0-" + (userCount - 1) + "): ");
                int userId = input.nextInt();
                input.nextLine();

                if (userId < 0 || userId >= userCount) {
                    System.out.println("Invalid user ID. Please try again.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        messagesData.sendMessage(userId);
                        break;
                    case 2:
                        messagesData.seeMessage(userId);
                        break;
                    case 3:
                        messagesData.readAllMessages(userId);
                        break;
                    case 4:
                        messagesData.readSpecificMessage(userId);
                        break;
                    case 5:
                        messagesData.deleteMessage(userId);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        input.close();
    }
}
