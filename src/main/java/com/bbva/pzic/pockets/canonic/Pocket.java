package com.bbva.pzic.pockets.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.ShortDateAdapter;
import com.bbva.pzic.routine.commons.utils.CustomCalendarAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "pocket", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "pocket", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pocket implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Pocket identifier.
     */
    private String id;
    /**
     * Target amount that you want to set for the pocket.
     */
    private Import goalAmount;
    /**
     * Short name of the pocket.
     */
    private String alias;
    /**
     * String based on ISO-8601 date format to specify the date expiration of
     * the pocket.
     */
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    private Date expirationDate;

    /**
     * Date of creation of the pocket.
     */
    @XmlJavaTypeAdapter(CustomCalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    private Calendar creationDate;
    /**
     * Category of the pocket.
     */
    private Category category;
    /**
     * Indicates whether the pocket will have automatic contributions periodically
     * (when this field is true, the scheduledDeposit field must be completed).
     */
    private Boolean isScheduled;
    /**
     * Represents the information about scheduled contributions to the pocket.
     */
    private ScheduledDeposit scheduledDeposit;
    /**
     * Status of the pocket.
     */
    private String status;
    /**
     * Contract associated with the pocket.
     */
    private RelatedContract relatedContract;
    /**
     * List of balances associated with the pocket.
     */
    private List<Balance> balances;
    /**
     * Priority of the pocket, represents the order in which the pockets are
     * receiving an amount of money from the associated account.
     */
    private String priority;
    /**
     * Indicates whether the pocket is associated a saving by rounding.
     */
    private Boolean isSavingRounding;
    /**
     * Number of total days from when the goal was created until the day of expiration.
     */
    private Integer totalDays;
    /**
     * Number of days from today until the expiration date of the pocket.
     */
    private Integer remainingDays;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Import getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(Import goalAmount) {
        this.goalAmount = goalAmount;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getIsScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(Boolean scheduled) {
        isScheduled = scheduled;
    }

    public ScheduledDeposit getScheduledDeposit() {
        return scheduledDeposit;
    }

    public void setScheduledDeposit(ScheduledDeposit scheduledDeposit) {
        this.scheduledDeposit = scheduledDeposit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RelatedContract getRelatedContract() {
        return relatedContract;
    }

    public void setRelatedContract(RelatedContract relatedContract) {
        this.relatedContract = relatedContract;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getIsSavingRounding() {
        return isSavingRounding;
    }

    public void setIsSavingRounding(Boolean savingRounding) {
        isSavingRounding = savingRounding;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }
}
