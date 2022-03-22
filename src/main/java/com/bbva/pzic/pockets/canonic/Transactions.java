package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 09/05/2017.
 *
 * @author Entelgy
 */
@XmlRootElement(name = "Transactions", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "Transactions", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * List of data.
     */
    private List<Transaction> data;
    /**
     * Pagination.
     */
    private Pagination pagination;

    public List<Transaction> getData() {
        return data;
    }

    public void setData(List<Transaction> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }


}
