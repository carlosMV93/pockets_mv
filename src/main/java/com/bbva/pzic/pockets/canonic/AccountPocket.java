package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "AccountPocket", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "AccountPocket", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountPocket implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Account number. This number consists in an alpha-numerical sequence to
     * identify an account.
     */
    private String number;
    /**
     * An account family is a classification of an account based on certain
     * distinctive attributes of that financial product.
     */
    private AccountFamily accountFamily;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AccountFamily getAccountFamily() {
        return accountFamily;
    }

    public void setAccountFamily(AccountFamily accountFamily) {
        this.accountFamily = accountFamily;
    }
}