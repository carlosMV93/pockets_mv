package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "withdrawalData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "withdrawalData", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class WithdrawalData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Withdrawal Data
     */
    private Withdrawal data;

    public Withdrawal getData() {
        return data;
    }

    public void setData(Withdrawal data) {
        this.data = data;
    }
}