package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "PAYMENT_TYPES")
public class PaymentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PAYMENT_TYPE_ID")
    private int paymentTypeId;
    @Basic(optional = false)
    @Column(name = "PAYMENT_TYPE_NAME")
    private String paymentTypeName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NOTIF_DELAY_DAYS")
    private short notifDelayDays;
    @Column(name = "NOTIF_DELAY_DAYS2")
    private short notifDelayDays2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentTypeId")
    private Collection<Payment> paymentCollection;

    public PaymentType() {
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getNotifDelayDays() {
        return notifDelayDays;
    }

    public void setNotifDelayDays(short notifDelayDays) {
        this.notifDelayDays = notifDelayDays;
    }

    public short getNotifDelayDays2() {
        return notifDelayDays2;
    }

    public void setNotifDelayDays2(short notifDelayDays2) {
        this.notifDelayDays2 = notifDelayDays2;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

}
