import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {


    public static void main(String[] args) {
        HashMap<Integer, String> currencyCode = new HashMap<>();

//  Adding currency codes to recognise certain currency
        currencyCode.put(1, "EUR");
        currencyCode.put(2, "USD");
        currencyCode.put(3, "RUB");
        currencyCode.put(4, "ZLT");
        currencyCode.put(5, "JUAN");


        String fromCode;
        String toCode;
        double amount;

//  Scanner for the inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("CURRENCY CONVERTER");

        System.out.println("What currency are you converting FROM?");
        System.out.println("Enter the number for: ");
        System.out.println("1: euros\n 2: US dollars\n 3: russian rubles\n 4: polish zloty\n 5: chinese juan");
        fromCode = currencyCode.get(sc.nextInt());

        System.out.println("What currency are you converting TO?");
        System.out.println("Enter the number for: ");
        System.out.println("1: euros\n 2: US dollars\n 3: russian rubles\n 4: polish zloty\n 5: chinese juan");
        toCode = currencyCode.get(sc.nextInt());

        System.out.println("What is the amount you wish to convert?");
        amount = sc.nextDouble();

//  getting the exchange rate from API
//        sendHttpRequest (fromCode, toCode, amount);
    }

    private static void sendHttpRequest(String fromCode, String toCode, double amount) {
        String getURL = "https://api.exchangerate.host/latest?base=" + toCode + "&symbols=" + fromCode;

    }


}
