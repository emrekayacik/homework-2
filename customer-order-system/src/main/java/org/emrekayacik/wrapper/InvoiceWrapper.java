package org.emrekayacik.wrapper;

import org.emrekayacik.domain.Invoice;

public class InvoiceWrapper {
    private final Invoice invoice;

    /**
     * Constructs a new InvoiceWrapper object with the given invoice.
     *
     * @param invoice The invoice to be wrapped.
     */
    public InvoiceWrapper(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Unwraps and returns the wrapped invoice.
     *
     * @return The unwrapped invoice.
     */
    public Invoice unwrap() {
        return invoice;
    }

    /**
     * Checks if this InvoiceWrapper is equal to the specified object.
     *
     * @param other The object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof InvoiceWrapper) {
            return ((InvoiceWrapper) other).invoice.getCustomerName().equals(invoice.getCustomerName());
        } else {
            return false;
        }
    }

    /**
     * Returns the hash code value for this InvoiceWrapper.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return invoice.getCustomerName().hashCode();
    }
}
