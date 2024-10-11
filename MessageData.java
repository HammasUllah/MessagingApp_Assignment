import java.util.Scanner;

public class MessageData {
    private String[][] senders;
    private String[][] messages;
    private int[][] ids;
    private boolean[][] seen;
    private int userCount;
    private int messageCount;

    public MessageData(int userCount, int messageCount) {
        this.userCount = userCount;
        this.messageCount = messageCount;
        senders = new String[userCount][messageCount];
        messages = new String[userCount][messageCount];
        ids = new int[userCount][messageCount];
        seen = new boolean[userCount][messageCount];
    }

    public void sendMessage(int userId) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < messageCount; i++) {
            if (messages[userId][i] == null) {
                System.out.print("Enter sender name: ");
                senders[userId][i] = input.nextLine();
                System.out.print("Enter receiver name: ");
                String receiver = input.nextLine();
                System.out.print("Enter message: ");
                messages[userId][i] = input.nextLine();
                ids[userId][i] = i + 1;
                System.out.println("Message sent with ID: " + ids[userId][i]);
                return;
            }
        }
        System.out.println("No space to send more messages.");
    }

    public void seeMessage(int userId) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sende's name: ");
        String checker = input.nextLine();

        for (int i = 0; i < messageCount; i++) {
            if (messages[userId][i] != null && senders[userId][i].equals(checker)) {
                System.out.println("Message received:");
                displayMessageDetails(userId, i);
                seen[userId][i] = true;
                return;
            }
        }
        System.out.println("No message found for this receiver.");
    }

    public void readAllMessages(int userId) {
        for (int i = 0; i < messageCount; i++) {
            if (messages[userId][i] != null) {
                displayMessageDetails(userId, i);
            }
        }
    }

    public void readSpecificMessage(int userId) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the message ID to read: ");
        int messageId = input.nextInt();

        for (int i = 0; i < messageCount; i++) {
            if (ids[userId][i] == messageId) {
                displayMessageDetails(userId, i);
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    public void deleteMessage(int userId) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the message ID to delete: ");
        int messageId = input.nextInt();

        for (int i = 0; i < messageCount; i++) {
            if (ids[userId][i] == messageId) {
                messages[userId][i] = null;
                senders[userId][i] = null;
                ids[userId][i] = 0;
                seen[userId][i] = false;
                System.out.println("Message ID " + messageId + " deleted.");
                return;
            }
        }
        System.out.println("Message ID not found.");
    }

    private void displayMessageDetails(int userId, int messageIndex) {
        System.out.println("Sender: " + senders[userId][messageIndex]);
        System.out.println("Message: " + messages[userId][messageIndex]);
        System.out.println("Message ID: " + ids[userId][messageIndex]);
        System.out.println("Seen: " + (seen[userId][messageIndex] ? "Yes" : "No"));
        System.out.println("----------------------------");
    }
}
