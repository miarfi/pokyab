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
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "PaymentType.findAll", query = "SELECT p FROM PaymentType p")})
public class PaymentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PAYMENT_TYPE_ID")
    private Long paymentTypeId;
    @Basic(optional = false)
    @Column(name = "PAYMENT_TYPE_NAME")
    private String paymentTypeName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "NOTIF_DELAY_DAYS")
    private Short notifDelayDays;
    @Column(name = "NOTIF_DELAY_DAYS2")
    private Short notifDelayDays2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentTypeId")
    private Collection<Payment> paymentCollection;

    public PaymentType() {
    }

//    public PaymentType(Long paymentTypeId) {
//        this.paymentTypeId = paymentTypeId;
//    }
//
//    public PaymentType(Long paymentTypeId, String paymentTypeName) {
//        this.paymentTypeId = paymentTypeId;
//        this.paymentTypeName = paymentTypeName;
//    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
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

    public Short getNotifDelayDays() {
        return notifDelayDays;
    }

    public void setNotifDelayDays(Short notifDelayDays) {
        this.notifDelayDays = notifDelayDays;
    }

    public Short getNotifDelayDays2() {
        return notifDelayDays2;
    }

    public void setNotifDelayDays2(Short notifDelayDays2) {
        this.notifDelayDays2 = notifDelayDays2;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentTypeId != null ? paymentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentType)) {
            return false;
        }
        PaymentType other = (PaymentType) object;
        if ((this.paymentTypeId == null && other.paymentTypeId != null) || (this.paymentTypeId != null && !this.paymentTypeId.equals(other.paymentTypeId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.PaymentType[ paymentTypeId=" + paymentTypeId + " ]";
//    }
    
}
