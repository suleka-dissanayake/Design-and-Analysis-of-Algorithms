import java.util.*;

class Item {
    int weight, profit;
    double ratio;
    
    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

class FractionalKnapsack { 
    
    static double solveKnapsack(int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], profits[i]);
        }
        
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        double totalProfit = 0;
        int remaining = capacity;
        double[] fraction = new double[n];

        for (int i = 0; i < n; i++) {
            if (remaining == 0) break;
            
            if (items[i].weight <= remaining) {
                fraction[i] = 1;
                remaining -= items[i].weight;
                totalProfit += items[i].profit;
            } else {
                fraction[i] = (double) remaining / items[i].weight;
                totalProfit += items[i].profit * fraction[i];
                remaining = 0;
                break;
            }
        }

        System.out.println("Fractions taken:");
        for (int i = 0; i < n; i++) {
            if (fraction[i] == 1) {
                System.out.println("Item " + (i+1) + ": 1 (full)");
            } else if (fraction[i] > 0) {
                System.out.println("Item " + (i+1) + ": " + String.format("%.2f", fraction[i]) + " (partial)");
            } else {
                System.out.println("Item " + (i+1) + ": 0 (not taken)");
            }
        }

        System.out.println("Total Profit: " + totalProfit);
        
        return totalProfit;
    }
    
    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] profits = {60, 100, 120};
        int capacity = 50;
        
        solveKnapsack(weights, profits, capacity);
    }
}