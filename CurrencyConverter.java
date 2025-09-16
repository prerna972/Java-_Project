import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    
    // Predefined exchange rates (relative to USD)
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    
    static {
        // Initialize exchange rates
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.93);
        exchangeRates.put("GBP", 0.80);
        exchangeRates.put("JPY", 149.50);
        exchangeRates.put("CAD", 1.36);
        exchangeRates.put("AUD", 1.54);
        exchangeRates.put("CHF", 0.90);
        exchangeRates.put("CNY", 7.18);
        exchangeRates.put("INR", 83.25);
        exchangeRates.put("BRL", 5.12);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CURRENCY CONVERTER ===");
        
        // Display available currencies
        System.out.println("\nAvailable currencies:");
        int index = 1;
        for (String currency : exchangeRates.keySet()) {
            System.out.println(index + ". " + currency);
            index++;
        }
        
        // Get base currency
        System.out.print("\nEnter base currency code (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        
        if (!exchangeRates.containsKey(baseCurrency)) {
            System.out.println("Invalid base currency!");
            return;
        }
        
        // Get target currency
        System.out.print("Enter target currency code: ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        
        if (!exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid target currency!");
            return;
        }
        
        // Get amount to convert
        System.out.print("Enter amount to convert: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount!");
            return;
        }
        
        // Perform conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);
        
        // Display result
        System.out.printf("\n%.2f %s = %.2f %s%n", 
                         amount, baseCurrency, convertedAmount, targetCurrency);
        
        scanner.close();
    }
    
    public static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        // Convert to USD first, then to target currency
        double amountInUSD = amount / exchangeRates.get(baseCurrency);
        return amountInUSD * exchangeRates.get(targetCurrency);
    }
    
    public static Map<String, Double> getAvailableCurrencies() {
        return new HashMap<>(exchangeRates);
    }
}