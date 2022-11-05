package application;

import java.time.LocalDate;
import java.util.Scanner;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Order order;
        Client client;

        Boolean amountItem = true;

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        String bDate = scan.nextLine();

        client = new Client(name, email, bDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = scan.nextLine();

        order = new Order(LocalDate.now(), OrderStatus.valueOf(orderStatus), client);

        do {
            Integer itemPosition = 1;
            System.out.println("Enter item #" + itemPosition + " data:");
            System.out.print("Product name: ");
            String pName = scan.nextLine();
            System.out.print("Product price: ");
            Double pPrice = Double.parseDouble(scan.nextLine());
            System.out.print("Quantity: ");
            Integer pQuantity = Integer.parseInt(scan.nextLine());

            Product product = new Product(pName, pPrice);
            OrderItem orderItem = new OrderItem(pQuantity, pPrice, product);
            order.addItem(orderItem);

            System.out.println();
            System.out.println("Do you want to add another item? (Y/N)");
            Character result = scan.next().charAt(0);
            scan.nextLine();

            itemPosition++;
            if (result == 'n' || result == 'N')
                amountItem = false;

        } while (amountItem == true);

        System.out.println(order);

        scan.close();
    }
}
