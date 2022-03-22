package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "period", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "period", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Period identifier of an automatic amount in the pocket.
     */
    private String id;
    /**
     * Period name of the automatic amount in the pocket.
     */
    private String name;
    /**
     * String based on ISO-8601 date format for specifying the day of the month
     * when the automatic amount is transferred in the pocket. It can be a value
     * between 01 and 31.
     */
    private Integer dayOfMonth;
    /**
     * This represents how often an automatic deposit will be made to the
     * pocket.
     */
    private Frequency frequency;

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

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
