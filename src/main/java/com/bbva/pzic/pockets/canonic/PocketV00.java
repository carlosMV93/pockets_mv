package com.bbva.pzic.pockets.canonic;

import com.bbva.jee.arq.spring.core.servicing.utils.ShortDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "PocketV00", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "PocketV00", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class PocketV00 implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Unique identifier of the pocket.
     */
    private String id;
    /**
     * Name of the pocket.
     */
    private String name;
    /**
     * Short name of the pocket.
     */
    private String shortName;
    /**
     * String based on ISO-8601 date format for specifying the date when the
     * goal is expected to be reached.
     */
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(ShortDateAdapter.class)
    private Date goalDate;
    /**
     * Priority of the pocket.
     */
    private Integer priority;
    /**
     * Indicates whether the amounts saved in the pocket are automatic or not.
     */
    private Boolean isAutomaticAmount;
    /**
     * Amount that is the transferred in the pocket automatically.
     */
    private AutomaticAmount automaticAmount;
    /**
     * Account product associated to the pocket. This attribute refers to
     * theidentifier associated to the contract related to the account in
     * whichthe amounts will be deposited or withdrawn in the pocket.
     */
    private AccountPocket accountPocket;
    /**
     * Amount that is the goal to reach in the pocket.
     */
    private GoalAmount goalAmount;
    /**
     * Amount that is the current saved in the pocket.
     */
    private CurrentAmount currentAmount;
    /**
     * Type of pocket. This type identifies to certain type of pocket.
     */
    private PocketType pocketType;
    /**
     * Status of the pocket.
     */
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getIsAutomaticAmount() {
        return isAutomaticAmount;
    }

    public void setIsAutomaticAmount(Boolean isAutomaticAmount) {
        this.isAutomaticAmount = isAutomaticAmount;
    }

    public AutomaticAmount getAutomaticAmount() {
        return automaticAmount;
    }

    public void setAutomaticAmount(AutomaticAmount automaticAmount) {
        this.automaticAmount = automaticAmount;
    }

    public AccountPocket getAccountPocket() {
        return accountPocket;
    }

    public void setAccountPocket(AccountPocket accountPocket) {
        this.accountPocket = accountPocket;
    }

    public GoalAmount getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(GoalAmount goalAmount) {
        this.goalAmount = goalAmount;
    }

    public CurrentAmount getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(CurrentAmount currentAmount) {
        this.currentAmount = currentAmount;
    }

    public PocketType getPocketType() {
        return pocketType;
    }

    public void setPocketType(PocketType pocketType) {
        this.pocketType = pocketType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}