package lab1;

import java.util.Arrays;

public class ElectronicShop {

    // find cheapest keyboard
    public static int findCheapestKeyboard(int[] keyboards) {
        int minPrice = Integer.MAX_VALUE;
        for (int price : keyboards)
            if (price < minPrice)
                minPrice = price;
        return minPrice;
    }

    // find the most expensive article
    public static int findMostExpensiveItem(int[] keyboards, int[] usbDrives) {
        int maxPrice = 0;
        for (int price : keyboards)
            if (price > maxPrice)
                maxPrice = price;
        for (int price : usbDrives)
            if (price > maxPrice)
                maxPrice = price;
        return maxPrice;
    }

    // find the most expensive USB markus can buy
    public static int findMostExpensiveUSB(int[] prices, int budget) {
        int max_affordable_price = 0;
        for (int price : prices) {
            if (price <= budget && price > max_affordable_price) {
                max_affordable_price = price;
            }
        }
        return max_affordable_price;
    }

    // Metodă pentru a găsi suma maximă pe care Markus o poate cheltui
    public static int maxSpendableAmount(int budget, int[] keyboards, int[] usbDrives) {
        int maxSpend = -1;
        for (int kb : keyboards) {
            for (int usb : usbDrives) {
                int total = kb + usb;
                if (total <= budget && total > maxSpend) {
                    maxSpend = total; // update max sum
                }
            }
        }
        return maxSpend;
    }

    public static void main(String[] args) {
        int[] keyboards = {60};
        int[] usbDrives = {8, 12};
        int budget = 60;
        System.out.println("Cheapest keyboard: " + findCheapestKeyboard(keyboards));
        System.out.println("Most expensive article: " + findMostExpensiveItem(keyboards, usbDrives));
        System.out.println("Most expensive USB he can buy: " + findMostExpensiveUSB(usbDrives, budget));
        System.out.println("Max sum he can spend: " + maxSpendableAmount(budget, keyboards, usbDrives));
    }
}
