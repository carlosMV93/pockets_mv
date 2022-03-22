package com.bbva.pzic.pockets.canonic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * @author Entelgy
 */
@XmlRootElement(name = "pockets", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlType(name = "pockets", namespace = "urn:com:bbva:pzic:pockets:canonic")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pockets implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Pocket Data List
     */
    private List<Pocket> data;
    /**
     * Object related to the pagination
     */
    private Pagination pagination;

    public List<Pocket> getData() {
        return data;
    }

    public void setData(List<Pocket> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}