import java.util.Scanner;

public class Date {
    Scanner input = new Scanner(System.in);
    private int day;
    private int month;
    private int year;

    public Date() {
        day = 0;
        month = 0;
        year = 0;
    }

    public void setDate() {
        System.out.print("Enter the day: ");
        day = input.nextInt();
        System.out.print("Enter the month: ");
        month = input.nextInt();
        System.out.print("Enter the year: ");
        year = input.nextInt();
    }

    public void displayDate(String user) {
        System.out.printf("%s: %02d/%02d/%04d\n", user, day, month, year);
    }
}
