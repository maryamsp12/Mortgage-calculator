import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principle = (int) readNumber("Principle:", 1000, 1_000_000);
        float interestRate = (float) readNumber("Interest rate: ", 1, 30);
        byte years = (byte) readNumber("Years", 1, 30);

        double mortgage = calculateMortgage(principle, interestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage: " + mortgageFormatted);

        System.out.println();
        System.out.println("PAYMENT SCHDULE");
        System.out.println("---------------");
        for (short i = 1; i <= years * MONTHS_IN_YEAR; i++) {
            double balance = calculateRemainingMortgageBalance(principle, interestRate, years, i);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {

            System.out.println(prompt);
            value = scanner.nextFloat();

            if ((value >= min && value <= max)) {
                break;
            } else
                System.out.println("enter a value between " + min + "and" + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principle,
            float interestRate,
            byte years) {

        float monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static double calculateRemainingMortgageBalance(
            int principle,
            float interestRate,
            byte years,
            short paymentsMade) {

        float monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double remainingBalance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - (Math.pow(1 + monthlyInterest, paymentsMade)))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return remainingBalance;
    }
}
