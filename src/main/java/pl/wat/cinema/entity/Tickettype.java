/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wat.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wiktor
 */
@Entity
@Table(name = "tickettype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickettype.findAll", query = "SELECT t FROM Tickettype t")
    , @NamedQuery(name = "Tickettype.findByIdTicketType", query = "SELECT t FROM Tickettype t WHERE t.idTicketType = :idTicketType")
    , @NamedQuery(name = "Tickettype.findByNameTicketType", query = "SELECT t FROM Tickettype t WHERE t.nameTicketType = :nameTicketType")})
public class Tickettype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTicketType")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idTicketType;
    @Basic(optional = false)
    @Column(name = "nameTicketType")
    private String nameTicketType;
    @OneToMany(mappedBy = "idTicketType")
    @JsonIgnore
    private Collection<Ticket> ticketCollection;

    public Tickettype() {
    }

    public Tickettype(Integer idTicketType) {
        this.idTicketType = idTicketType;
    }

    public Tickettype(Integer idTicketType, String nameTicketType) {
        this.idTicketType = idTicketType;
        this.nameTicketType = nameTicketType;
    }

    public Integer getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Integer idTicketType) {
        this.idTicketType = idTicketType;
    }

    public String getNameTicketType() {
        return nameTicketType;
    }

    public void setNameTicketType(String nameTicketType) {
        this.nameTicketType = nameTicketType;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicketType != null ? idTicketType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickettype)) {
            return false;
        }
        Tickettype other = (Tickettype) object;
        if ((this.idTicketType == null && other.idTicketType != null) || (this.idTicketType != null && !this.idTicketType.equals(other.idTicketType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Tickettype[ idTicketType=" + idTicketType + " ]";
    }
    
}
