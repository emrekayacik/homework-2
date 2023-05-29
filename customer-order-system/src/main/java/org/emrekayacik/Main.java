package org.emrekayacik;

import org.emrekayacik.domain.Customer;
import org.emrekayacik.domain.Invoice;
import org.emrekayacik.service.CustomerInvoiceService;
import org.emrekayacik.service.CustomerInvoiceServiceImpl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        CustomerInvoiceService service = new CustomerInvoiceServiceImpl();
        initializeCustomersAndInvoices(service);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your name: ");
        var nameInput = scanner.nextLine();

        System.out.println("Your sector: ");
        var sector = scanner.nextLine();

        System.out.println("Register month: ");
        var registerMonth = scanner.nextLine();

        Customer customer = new Customer(nameInput,sector,registerMonth,LocalDateTime.now(),nameInput,LocalDateTime.now(),nameInput);
        service.addCustomer(customer);
        System.out.println("Registration is successful");

        while (true){
            System.out.println("1- Create Invoice");
            System.out.println("2- Show My Invoices");
            System.out.println("3- Show All Customers");
            System.out.println("4- Show Customers with 'C' in their name");
            System.out.println("5- Show Sum of total amounts of customers who registered in june");
            System.out.println("6- Show All Invoices");
            System.out.println("7- Show Invoices over 1500TL");
            System.out.println("8- Show Average of the invoices over 1500TL");
            System.out.println("9- Show Customers who has invoice below 500TL");
            System.out.println("10- Show Sectors of companies whose invoice average is below 750 in June");
            System.out.println("q- quit");

            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")){
                break;
            }
            int choiceInt;
            try{
                choiceInt = Integer.parseInt(choice);
                if (choiceInt < 1 || choiceInt > 10){
                    throw new Exception();
                }
                switch (choiceInt) {
                    case 1 -> {
                        System.out.println("Amount ot the invoice: ");
                        double amount = scanner.nextDouble();
                        Invoice invoice = new Invoice(customer.getName(), amount, LocalDateTime.now(), customer.getName(), LocalDateTime.now(), customer.getName());
                        service.addInvoice(invoice);
                        System.out.println("Invoice creation is successful");
                    }
                    case 2 -> {
                        System.out.println("\nMy invoices:");
                        List<Invoice> myInvoices = service.getAllInvoices().stream().filter(x -> x.getCustomerName()
                                        .equals(customer.getName()))
                                .collect(Collectors.toList());
                        printListWithFor(myInvoices);
                        System.out.println("*******************************");
                    }
                    case 3 -> {
                        System.out.println("All Customers:");
                        Set<Customer> allCustomers = service.getAllCustomers();
                        printListWithFor(allCustomers);
                        System.out.println("*******************************");
                    }
                    case 4 -> {
                        System.out.println("\nCustomers with 'C' in their name:");
                        List<Customer> customersWithNameContainingC = service.getCustomersWithNameContainingC();
                        printListWithFor(customersWithNameContainingC);
                        System.out.println("*******************************");
                    }
                    case 5 -> {
                        System.out.println("\nSum of total amounts of customers who registered in june: ");
                        double totalInvoicesForJune = service.getTotalInvoicesForJune();
                        System.out.println(totalInvoicesForJune);
                        System.out.println("*******************************");
                    }
                    case 6 -> {
                        System.out.println("\nAll Invoices:");
                        List<Invoice> allInvoices = service.getAllInvoices();
                        printListWithFor(allInvoices);
                        System.out.println("*******************************");
                    }
                    case 7 -> {
                        System.out.println("\nInvoices over 1500TL:");
                        List<Invoice> invoicesOver1500 = service.getInvoicesOver1500();
                        printListWithFor(invoicesOver1500);
                        System.out.println("*******************************");
                    }
                    case 8 ->
                            System.out.println("\nAverage of the invoices over 1500TL: " + service.getAverageAmountOver1500());
                    case 9 -> {
                        System.out.println("\nCustomers who has invoice below 500TL:");
                        List<String> customersWithInvoicesBelow500 = service.getCustomersWithInvoicesBelow500();
                        printListWithFor(customersWithInvoicesBelow500);
                        System.out.println("*******************************");
                    }
                    case 10 -> {
                        System.out.println("\nSectors of companies whose invoice average is below 750 in June:");
                        List<String> sectorsWithAverageInvoiceBelow750 = service.getCustomersInSectorWithAverageInvoiceBelow750();
                        printListWithFor(sectorsWithAverageInvoiceBelow750);
                    }
                }

            }
            catch (Exception e){
                System.out.println("Please enter a valid input between 1-10");
            }

        }

    }

    /**
     * Mock method to initalize some customers and invoices
     *
     * @param service Customer Invoice Service responsible for customer-invoice related operations
     */
    private static void initializeCustomersAndInvoices(CustomerInvoiceService service) {
        service.addCustomer(new Customer("Emre", "IT", "May", LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
        service.addCustomer(new Customer("Ali", "Finance", "June", LocalDateTime.now(),"Ali",LocalDateTime.now(),"Ali"));
        service.addCustomer(new Customer("Mete", "Human Resources", "June", LocalDateTime.now(),"Mete",LocalDateTime.now(),"Mete"));
        service.addCustomer(new Customer("Alpay", "Communication", "July", LocalDateTime.now(),"Alpay",LocalDateTime.now(),"Alpay"));
        service.addCustomer(new Customer("Büşra", "IT", "July", LocalDateTime.now(),"Büşra",LocalDateTime.now(),"Büşra"));
        service.addCustomer(new Customer("Selin", "Finance", "July", LocalDateTime.now(),"Selin",LocalDateTime.now(),"Selin"));
        service.addCustomer(new Customer("Cemre", "Communication", "June", LocalDateTime.now(),"Cemre",LocalDateTime.now(),"Cemre"));
        service.addCustomer(new Customer("Caner", "Human Resources", "May", LocalDateTime.now(),"Caner",LocalDateTime.now(),"Caner"));

        service.addInvoice(new Invoice("Emre", 200.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
        service.addInvoice(new Invoice("Emre", 250.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
        service.addInvoice(new Invoice("Emre", 100.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Ali", 2000.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Mete", 100.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
        service.addInvoice(new Invoice("Mete", 300.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Alpay", 4000.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
        service.addInvoice(new Invoice("Alpay", 400.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Büşra", 100.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Selin", 20.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
        service.addInvoice(new Invoice("Selin", 100.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Cemre", 2000.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));

        service.addInvoice(new Invoice("Caner", 100.0, LocalDateTime.now(),"Emre",LocalDateTime.now(),"Emre"));
    }

    private static  <T> void printListWithFor(Collection<T> list){
        for (T t : list) {
            System.out.println(t);
        }
    }
}