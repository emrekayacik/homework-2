package org.emrekayacik.service;

import org.emrekayacik.domain.Customer;
import org.emrekayacik.domain.Invoice;
import org.emrekayacik.wrapper.InvoiceWrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * CustomerInvoiceServiceImpl is an implementation of the CustomerInvoiceService interface.
 * It provides methods for managing customers and invoices.
 */
public class CustomerInvoiceServiceImpl implements CustomerInvoiceService {
    private final Set<Customer> customers;
    private final List<Invoice> invoices;

    /**
     * Constructs a new CustomerInvoiceServiceImpl object with empty customer and invoice collections.
     */
    public CustomerInvoiceServiceImpl() {
        customers = new HashSet<>();
        invoices = new ArrayList<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void addCustomer(List<Customer> customerList) {
        customers.addAll(customerList);
    }

    @Override
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public void addInvoice(List<Invoice> invoiceList) {
        invoices.addAll(invoiceList);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public List<Customer> getCustomersWithNameContainingC() {
        return customers.stream()
                .filter(customer -> customer.getName().contains("C"))
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalInvoicesForJune() {
        return customers.stream()
                .filter(customer -> customer.getRegistrationMonth().equals("June"))
                .mapToDouble(customer -> invoices.stream()
                        .filter(invoice -> invoice.getCustomerName().equals(customer.getName()))
                        .mapToDouble(Invoice::getTotalAmount)
                        .sum())
                .sum();
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    @Override
    public List<Invoice> getInvoicesOver1500() {
        return invoices.stream()
                .filter(invoice -> invoice.getTotalAmount() > 1500.0)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAmountOver1500() {
        return invoices.stream()
                .filter(invoice -> invoice.getTotalAmount() > 1500.0)
                .mapToDouble(Invoice::getTotalAmount)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<String> getCustomersWithInvoicesBelow500() {
        return invoices.stream()
                .map(InvoiceWrapper::new)
                .distinct()
                .map(InvoiceWrapper::unwrap)
                .filter(invoice -> invoice.getTotalAmount() < 500.0)
                .map(Invoice::getCustomerName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCustomersInSectorWithAverageInvoiceBelow750() {
        return customers.stream()
                .filter(customer -> customer.getRegistrationMonth().equals("June"))
                .filter(customer -> invoices.stream()
                        .filter(invoice -> invoice.getCustomerName().equals(customer.getName()))
                        .mapToDouble(Invoice::getTotalAmount)
                        .average()
                        .orElse(0.0) < 750.0)
                .map(Customer::getSector)
                .collect(Collectors.toList());
    }

    /**
     * Returns a predicate that determines whether an object is distinct based on a key extractor function.
     *
     * @param keyExtractor The key extractor function.
     * @param <T>          The type of the object.
     * @return A predicate that determines object distinctness based on the key.
     */
    public <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
