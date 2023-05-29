package org.emrekayacik.domain;

import org.emrekayacik.domain.base.BaseAuditableClass;

import java.time.LocalDateTime;

/**
 * Customer class represents a customer entity with audit information.
 */
public class Customer extends BaseAuditableClass {
    private final String name;
    private final String sector;
    private final String registrationMonth;

    /**
     * Constructs a new Customer with the specified attributes and audit information.
     *
     * @param name             The name of the customer.
     * @param sector           The sector of the customer.
     * @param registrationMonth The registration month of the customer.
     * @param createdDate      The date and time when the customer was created.
     * @param createdUser      The ID of the user who created the customer.
     * @param modifiedDate     The date and time when the customer was last modified.
     * @param modifiedUser     The ID of the user who last modified the customer.
     */
    public Customer(String name, String sector, String registrationMonth, LocalDateTime createdDate, String createdUser, LocalDateTime modifiedDate, String modifiedUser) {
        super(createdDate, createdUser, modifiedDate, modifiedUser);
        this.name = name;
        this.sector = sector;
        this.registrationMonth = registrationMonth;
    }

    /**
     * Returns the ID of the customer.
     *
     * @return The ID of the customer.
     */

    /**
     * Returns the name of the customer.
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the sector of the customer.
     *
     */
    public String getSector() {
        return sector;
    }

    /**
     * Returns the registration month of the customer.
     *
     */
    public String getRegistrationMonth() {
        return registrationMonth;
    }

    /**
     * Returns a string representation of the customer.
     *
     */
    @Override
    public String toString() {
        return "---------------------\n" +
                "Name: " + name + "\n" +
                "Sector: " + sector + "\n" +
                "Registration Month: " + registrationMonth +
                "\n---------------------";
    }
}
