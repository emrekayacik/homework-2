package org.emrekayacik.domain;


import org.emrekayacik.domain.base.BaseAuditableClass;

import java.time.LocalDateTime;

/**
 * Invoice class represents an invoice entity.
 */
public class Invoice extends BaseAuditableClass {
    private final String customerName;
    private final double totalAmount;

    /**
     * Constructs a new Invoice with the specified customer name and total amount.
     *
     * @param customerName The name of the customer associated with the invoice.
     * @param totalAmount  The total amount of the invoice.
     */
    public Invoice(String customerName, double totalAmount, LocalDateTime createdDate, String createdUser, LocalDateTime modifiedDate, String modifiedUser) {
        super(createdDate,createdUser,modifiedDate,modifiedUser);
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    /**
     * Returns the name of the customer associated with the invoice.
     *
     * @return The name of the customer.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the total amount of the invoice.
     *
     * @return The total amount of the invoice.
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Returns a string representation of the invoice.
     *
     * @return A string representation of the invoice.
     */
    @Override
    public String toString() {
        return "---------------------\n" +
                "Name: " + customerName + "\n" +
                "Total Amount: " + totalAmount + "\n" +
                "\n---------------------";
    }
}
