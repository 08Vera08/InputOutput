import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

class Basket {
    private static int prices[];
    private static int counts[];
    private static String products[];
    private static int amount;

    Basket(int prices[], int counts[], String products[], int n) {
        this.prices = new int[n];
        this.products = new String[n];
        this.counts = new int[n];
        this.amount = n;
        for (int i = 0; i < n; ++i) {
            this.products[i] = products[i];
            this.prices[i] = prices[i];
            this.counts[i] = counts[i];
        }
    }

    String getProduct(int num) {
        return products[num];
    }

    static void setProduct(int num, String product) {
        products[num] = product;
    }

    static void setPrice(int num, int price) {
        prices[num] = price;
    }

    static void setCount(int num, int count) {
        counts[num] = count;
    }

    int getCount(int num) {
        return counts[num];
    }

    int getPrice(int num) {
        return prices[num];
    }

    void addToCart(int productNum, int amount) {
        counts[productNum] += amount;
    }

    void printCart() {
        for (int i = 0; i < amount; ++i) {
            System.out.println(products[i] + " : " + counts[i] + "шт. по цене " + prices[i] + " за штуку.");
        }
    }

    static Basket loadFromTxtFile(File textFile) {
        try {
            Scanner myReader = new Scanner(textFile);
            int prices[];
            int counts[];
            String products[];
            int amount;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String arr[] = data.split(" ");
                products = new String[arr.length];
                amount = arr.length;
                for (int i = 0; i < arr.length; i++) {
                    products[i] = arr[i];
                }
                data = myReader.nextLine();
                arr = data.split(" ");
                counts = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    counts[i] = Integer.valueOf(arr[i]);
                }
                data = myReader.nextLine();
                arr = data.split(" ");
                prices = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    prices[i] = Integer.valueOf(arr[i]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new Basket(prices, counts, products, amount);
    }

    void saveTxt(File textFile) {
        try {
            PrintWriter out = new PrintWriter(textFile);
            for (int i = 0; i < amount; ++i) {
                out.print(products[i] + " ");
            }
            out.println();
            for (int i = 0; i < amount; ++i) {
                out.print(counts[i] + " ");
            }
            out.println();
            for (int i = 0; i < amount; ++i) {
                out.print(prices[i] + " ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}