public class Main
{
    public static void main(String[] args) {
        String products[] = {"Хлеб", "Мясо", "Сыр"};
        int prices[] = {20, 150, 100};
        int counts[] = {3, 4, 5};
        Basket basket = new Basket(prices, counts, products, 3);
        basket.printCart();
    }
}