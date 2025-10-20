import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principle: ");
        int principle = 0;

        while (true) {
            principle = scanner.nextInt();

            if ((principle >= 1000 && principle <= 1000000)) {
                break;
            } else
                System.out.println("enter principle between 1000 to 100,000");
        }

        System.out.print("Enter annual interest rate: ");
        float interestRate = 0;

        while (true) {
            interestRate = scanner.nextFloat();

            if ((interestRate >= 1 && interestRate <= 30)) {
                break;
            } else
                System.out.println("enter interestRate between 1 to 30");
        }

        float monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Enter period(in years):");
        byte years = 0;

        while (true) {
            years = scanner.nextByte();

            if ((years >= 1 && years <= 30)) {
                break;
            } else
                System.out.println("enter years between 1 to 30");
        }


         int numberOfPayments = years * MONTHS_IN_YEAR;

        double a = monthlyInterest * (Math.pow((1 + monthlyInterest), monthlyInterest));
        double b = (Math.pow((1 + monthlyInterest), monthlyInterest)) - 1;
        double c = (a) / (b);
        long mortgage = (long) (principle * c);
        System.out.println("Mortgage:" + mortgage);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);

        /*
         * Scanner scanner = new Scanner(System.in);
         * int numEntered = scanner.nextInt();
         * 
         * if (numEntered % 5 == 0 && numEntered % 3 == 0){
         * System.out.println("FIZZBUZZ");
         * } else if (numEntered % 3 == 0){
         * System.out.println("BUZZ");
         * } else if (numEntered % 5 == 0){
         * System.out.println("FIZZ");
         * } else {
         * System.out.println(numEntered);
         * }
         */

    }
}