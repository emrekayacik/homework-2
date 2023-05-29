package org.emrekayacik.domain.base;

import java.time.LocalDateTime;

/**
 * BaseAuditableClass is a base class that provides audit information for other classes.
 * It includes fields for created and modified dates, as well as user IDs who created and modified the instance.
 */
public class BaseAuditableClass {
    private LocalDateTime createdDate;
    private String createdUser;
    private LocalDateTime modifiedDate;
    private String modifiedUser;

    /**
     * Constructs a new BaseAuditableClass with the specified audit information.
     *
     * @param createdDate   The date and time when the instance was created.
     * @param createdUser   The ID of the user who created the instance.
     * @param modifiedDate  The date and time when the instance was last modified.
     * @param modifiedUser  The ID of the user who last modified the instance.
     */
    public BaseAuditableClass(LocalDateTime createdDate, String createdUser, LocalDateTime modifiedDate, String modifiedUser) {
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.modifiedDate = modifiedDate;
        this.modifiedUser = modifiedUser;
    }

    /**
     * Sets the date and time when the instance was created.
     *
     * @param createdDate The date and time when the instance was created.
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Sets the ID of the user who created the instance.
     *
     * @param createdUser The ID of the user who created the instance.
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * Sets the date and time when the instance was last modified.
     *
     * @param modifiedDate The date and time when the instance was last modified.
     */
    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Sets the ID of the user who last modified the instance.
     *
     * @param modifiedUser The ID of the user who last modified the instance.
     */
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    /**
     * Returns the date and time when the instance was created.
     *
     * @return The date and time when the instance was created.
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Returns the ID of the user who created the instance.
     *
     * @return The ID of the user who created the instance.
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * Returns the date and time when the instance was last modified.
     *
     * @return The date and time when the instance was last modified.
     */
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Returns the ID of the user who last modified the instance.
     *
     * @return The ID of the user who last modified the instance.
     */
    public String getModifiedUser() {
        return modifiedUser;
    }
}
