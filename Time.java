import java.util.Scanner;

public class Time {
    Scanner input = new Scanner(System.in);
    private int seconds;
    private int minutes;
    private int hours;

    public Time() {
        seconds = 0;
        minutes = 0;
        hours = 0;
    }

    public void setTime() {
        System.out.print("Enter the seconds: ");
        seconds = input.nextInt();
        System.out.print("Enter the minutes: ");
        minutes = input.nextInt();
        System.out.print("Enter the hours: ");
        hours = input.nextInt();
    }

    public void displayTime(String user) {
        System.out.printf("%s: %02d:%02d:%02d\n", user, hours, minutes, seconds);
    }
}
