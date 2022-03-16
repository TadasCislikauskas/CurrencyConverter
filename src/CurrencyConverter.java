import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    private static void sendHttpRequest(String fromCode, String toCode, double amount) throws IOException {
        String getURL = "https://api.exchangerate.host/latest?base=" + toCode + "&symbols=" + fromCode;
        URL url = new URL(getURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();


//            need to add JSON library
            JSONObject jsonObject = new JSONObject(response.toString());
            Double exchangeRate = jsonObject.getJSONObject("rates").getDouble(fromCode);


        }


    }


}
