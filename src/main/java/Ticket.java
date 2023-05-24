import java.util.Scanner;

public class Ticket {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int km = 0;
        int age = 0;
        int journeyType = 0;

        String busNo = "06 QA 06";

        System.out.println("Please enter your journey distance -km-");
        km = input.nextInt();


        System.out.println("Please enter your age");
        age = input.nextInt();

        System.out.println("please enter journey type");
        journeyType = input.nextInt();

        double ticketWage=0;

        if (km > 0 && age > 0 && (journeyType == 1 && journeyType == 2)) {
             ticketWage = km * 0.1;
            System.out.println("Non-Discount ticket wages" + ticketWage);

            double ageDiscountRate = 0;
            if (age < 12) {
                ageDiscountRate = 0.5;
            } else if (age < 24) {
                ageDiscountRate = 0.1;
            } else if (age > 65) {
                ageDiscountRate = 0.3;
            }
            ticketWage -= ticketWage * ageDiscountRate;
            if (journeyType == 2) {
                ticketWage -= ticketWage * 0.2;
                ticketWage *= 2;
            }ticketInfo(busNo, km, journeyType, ticketWage);
            System.out.println("Ticket Wage : " + ticketWage);

        }else {
            System.out.println("Invalid data");
        }


    }

    private static void ticketInfo(String busNo, int km, int journeyType, double ticketWage) {
        System.out.println("******************Ticket Info *******************");
        System.out.println("Bus No : " + busNo);
        System.out.println("Distance : " + km + "KM");
        System.out.println("Journey Type " + (journeyType == 1 ? "One Way" : "Two Way"));
        System.out.println("Ticket Wage : " + ticketWage);

        slowPrint("Have A Goog Journey", 50);
    }

    public static void slowPrint(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
