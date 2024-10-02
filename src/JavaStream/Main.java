package JavaStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        //-----------primo esercizio---------------
        // Creazione manuale della lista di prodotti
        System.out.println("primo esercizio");
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book A", "Books", 120.0));
        products.add(new Product(2, "Book B", "Books", 90.0));
        products.add(new Product(3, "Gadget", "Electronics", 150.0));
        products.add(new Product(4, "Book C", "Books", 200.0));

        // Filtro i prodotti
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        // Stampo i risultati
        filteredProducts.forEach(p -> System.out.println(p.getName()));
        //-----------Secondo esercizio---------------
        System.out.println("Secondo  esercizio");
        // Creo la lista di ordini
        List<Order> orders = new ArrayList<>();
        // Creo una lista di prodotti
        List<Product> order1Products = new ArrayList<>();
        order1Products.add(new Product(5, "Toy", "Baby", 30.0));
        order1Products.add(new Product(6, "Peluche", "Baby", 200.0));
        order1Products.add(new Product(7, "Motorino", "Moto", 150.0));

        orders.add(new Order(1L, "In Consegna", LocalDate.now(), LocalDate.now().plusDays(2),
                order1Products, new Customer(2L, "Alice", 2)));

        // Filtro gli  ordini con i  prodotti della categoria "Baby"
        List<Order> babyOrders = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals("Baby")))
                .collect(Collectors.toList());

        System.out.println("Ordini con prodotti della categoria Baby:");
        for (Order order : babyOrders) {
            System.out.println("Ordine ID: " + order.getId());
        }

        //-----------3 Esercizio--------
        System.out.println("Esercizio 3");
        // Crea una lista di prodotti
        List<Product> productsBoys = new ArrayList<>();
        productsBoys.add(new Product(1, "Action Figure", "Boys", 20.0));
        productsBoys.add(new Product(2, "Puzzle", "Children", 15.0));
        productsBoys.add(new Product(3, "Toy Car", "Boys", 30.0));
        productsBoys.add(new Product(4, "Building Blocks", "Children", 25.0));

        // Filtra i prodotti della categoria "Boys" e applica uno sconto del 10%
        List<Product> discountedBoysProducts = new ArrayList<>();

        for (Product product : productsBoys) {
            if (product.getCategory().equals("Boys")) {
                double discountedPrice = product.getPrice() * 0.9; // Applica il 10% di sconto
                discountedBoysProducts.add(new Product(
                        product.getId(),
                        product.getName(),
                        product.getCategory(),
                        discountedPrice
                ));
            }
        }

        // Stampa i prodotti scontati
        System.out.println("Prodotti della categoria Boys con sconto del 10%:");
        for (Product product : discountedBoysProducts) {
            System.out.println(product.getName() + ": " + product.getPrice());
        }
    }
}


