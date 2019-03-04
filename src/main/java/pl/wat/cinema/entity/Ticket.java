/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wat.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wiktor
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket")
    , @NamedQuery(name = "Ticket.findByPrice", query = "SELECT t FROM Ticket t WHERE t.price = :price")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idTicket")
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @JoinColumn(name = "login", referencedColumnName = "login")
    @ManyToOne
    private Person login;
    @JoinColumn(name = "idSeat", referencedColumnName = "idSeat")
    @ManyToOne
    private Seat idSeat;
    @JoinColumn(name = "idScreening", referencedColumnName = "idScreening")
    @ManyToOne
    private Screening idScreening;
    @JoinColumn(name = "idTicketStatus", referencedColumnName = "idTicketStatus")
    @ManyToOne
    private Ticketstatus idTicketStatus;
    @JoinColumn(name = "idTicketType", referencedColumnName = "idTicketType")
    @ManyToOne
    private Tickettype idTicketType;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, float price) {
        this.idTicket = idTicket;
        this.price = price;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Person getLogin() {
        return login;
    }

    public void setLogin(Person login) {
        this.login = login;
    }

    public Seat getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Seat idSeat) {
        this.idSeat = idSeat;
    }

    public Screening getIdScreening() {
        return idScreening;
    }

    public void setIdScreening(Screening idScreening) {
        this.idScreening = idScreening;
    }

    public Ticketstatus getIdTicketStatus() {
        return idTicketStatus;
    }

    public void setIdTicketStatus(Ticketstatus idTicketStatus) {
        this.idTicketStatus = idTicketStatus;
    }

    public Tickettype getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Tickettype idTicketType) {
        this.idTicketType = idTicketType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
