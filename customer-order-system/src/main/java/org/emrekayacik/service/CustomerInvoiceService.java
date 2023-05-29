package org.emrekayacik.service;

import org.emrekayacik.domain.Customer;
import org.emrekayacik.domain.Invoice;

import java.util.List;
import java.util.Set;

/**
 * CustomerInvoiceService interface provides methods for managing customers and invoices.
 */
public interface CustomerInvoiceService {

    /**
     * Adds a single customer to the system.
     *
     * @param customer The customer to be added.
     */
    void addCustomer(Customer customer);

    /**
     * Adds a single invoice to the system.
     *
     * @param invoice The invoice to be added.
     */
    void addInvoice(Invoice invoice);

    /**
     * Adds a list of customers to the system.
     *
     * @param customers The list of customers to be added.
     */
    void addCustomer(List<Customer> customers);

    /**
     * Adds a list of invoices to the system.
     *
     * @param invoices The list of invoices to be added.
     */
    void addInvoice(List<Invoice> invoices);

    /**
     * Retrieves all customers from the system.
     *
     * @return A set of all customers.
     */
    Set<Customer> getAllCustomers();

    /**
     * Retrieves customers whose names contain the letter 'C'.
     *
     * @return A list of customers whose names contain the letter 'C'.
     */
    List<Customer> getCustomersWithNameContainingC();

    /**
     * Calculates the total amount of invoices for the month of June.
     *
     * @return The total amount of invoices for June.
     */
    double getTotalInvoicesForJune();

    /**
     * Retrieves all invoices from the system.
     *
     * @return A list of all invoices.
     */
    List<Invoice> getAllInvoices();

    /**
     * Retrieves invoices with amounts over 1500.
     *
     * @return A list of invoices with amounts over 1500.
     */
    List<Invoice> getInvoicesOver1500();

    /**
     * Calculates the average amount of invoices with amounts over 1500.
     *
     * @return The average amount of invoices over 1500.
     */
    double getAverageAmountOver1500();

    /**
     * Retrieves the names of customers with invoices below 500.
     *
     * @return A list of customer names with invoices below 500.
     */
    List<String> getCustomersWithInvoicesBelow500();

    /**
     * Retrieves the names of customers in a sector with an average invoice amount below 750.
     *
     * @return A list of customer names in the sector with an average invoice amount below 750.
     */
    List<String> getCustomersInSectorWithAverageInvoiceBelow750();

}