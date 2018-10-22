
package com.xem.py.pokyabmodel.dto;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "MESSAGES")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByMsgId", query = "SELECT m FROM Message m WHERE m.msgId = :msgId")
    , @NamedQuery(name = "Message.findByMsgNum", query = "SELECT m FROM Message m WHERE m.msgNum = :msgNum")
    , @NamedQuery(name = "Message.findByMsgType", query = "SELECT m FROM Message m WHERE m.msgType = :msgType")
    , @NamedQuery(name = "Message.findByCode", query = "SELECT m FROM Message m WHERE m.code = :code")
    , @NamedQuery(name = "Message.findByDescription", query = "SELECT m FROM Message m WHERE m.description = :description")})
*/
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)
    //if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MSG_ID")
    private BigInteger msgId;
    @Basic(optional = false)
    @Column(name = "MSG_NUM")
    private BigInteger msgNum;
    @Column(name = "MSG_TYPE")
    private Character msgType;
    @Column(name = "CODE")
    private String code;
    @Column(name = "DESCRIPTION")
    private String description;

    public Message() {
    }

    public Message(BigInteger msgId) {
        this.msgId = msgId;
    }

//    public Message(BigDecimal msgId, BigInteger msgNum) {
//        this.msgId = msgId;
//        this.msgNum = msgNum;
//    }

    public BigInteger getMsgId() {
        return msgId;
    }

    public void setMsgId(BigInteger msgId) {
        this.msgId = msgId;
    }

    public BigInteger getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(BigInteger msgNum) {
        this.msgNum = msgNum;
    }

    public Character getMsgType() {
        return msgType;
    }

    public void setMsgType(Character msgType) {
        this.msgType = msgType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (msgId != null ? msgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.msgId == null && other.msgId != null) || (this.msgId != null && !this.msgId.equals(other.msgId))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.xem.py.pokyabmodel.dto.Messages[ msgId=" + msgId + " ]";
//    }
    
}
