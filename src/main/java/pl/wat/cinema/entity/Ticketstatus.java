/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wat.cinema.entity;

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
@Table(name = "ticketstatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticketstatus.findAll", query = "SELECT t FROM Ticketstatus t")
    , @NamedQuery(name = "Ticketstatus.findByIdTicketStatus", query = "SELECT t FROM Ticketstatus t WHERE t.idTicketStatus = :idTicketStatus")
    , @NamedQuery(name = "Ticketstatus.findByNameTicketStatus", query = "SELECT t FROM Ticketstatus t WHERE t.nameTicketStatus = :nameTicketStatus")})
public class Ticketstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTicketStatus")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idTicketStatus;
    @Basic(optional = false)
    @Column(name = "nameTicketStatus")
    private String nameTicketStatus;
    @OneToMany(mappedBy = "idTicketStatus")
    private Collection<Ticket> ticketCollection;

    public Ticketstatus() {
    }

    public Ticketstatus(Integer idTicketStatus) {
        this.idTicketStatus = idTicketStatus;
    }

    public Ticketstatus(Integer idTicketStatus, String nameTicketStatus) {
        this.idTicketStatus = idTicketStatus;
        this.nameTicketStatus = nameTicketStatus;
    }

    public Integer getIdTicketStatus() {
        return idTicketStatus;
    }

    public void setIdTicketStatus(Integer idTicketStatus) {
        this.idTicketStatus = idTicketStatus;
    }

    public String getNameTicketStatus() {
        return nameTicketStatus;
    }

    public void setNameTicketStatus(String nameTicketStatus) {
        this.nameTicketStatus = nameTicketStatus;
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
        hash += (idTicketStatus != null ? idTicketStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticketstatus)) {
            return false;
        }
        Ticketstatus other = (Ticketstatus) object;
        if ((this.idTicketStatus == null && other.idTicketStatus != null) || (this.idTicketStatus != null && !this.idTicketStatus.equals(other.idTicketStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Ticketstatus[ idTicketStatus=" + idTicketStatus + " ]";
    }
    
}
