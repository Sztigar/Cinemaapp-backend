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
@Table(name = "seat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s")
    , @NamedQuery(name = "Seat.findByIdSeat", query = "SELECT s FROM Seat s WHERE s.idSeat = :idSeat")
    , @NamedQuery(name = "Seat.findByRow", query = "SELECT s FROM Seat s WHERE s.row = :row")
    , @NamedQuery(name = "Seat.findByPlace", query = "SELECT s FROM Seat s WHERE s.place = :place")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idSeat")
    private Integer idSeat;
    @Basic(optional = false)
    @Column(name = "row")
    private int row;
    @Basic(optional = false)
    @Column(name = "place")
    private int place;
    @JoinColumn(name = "idHall", referencedColumnName = "idHall")
    @JsonIgnore
    @ManyToOne
    private Hall idHall;
    @JsonIgnore
    @OneToMany(mappedBy = "idSeat")
    private Collection<Ticket> ticketCollection;

    public Seat() {
    }

    public Seat(Integer idSeat) {
        this.idSeat = idSeat;
    }

    public Seat(Integer idSeat, int row, int place) {
        this.idSeat = idSeat;
        this.row = row;
        this.place = place;
    }

    public Integer getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(Integer idSeat) {
        this.idSeat = idSeat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Hall getIdHall() {
        return idHall;
    }

    public void setIdHall(Hall idHall) {
        this.idHall = idHall;
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
        hash += (idSeat != null ? idSeat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.idSeat == null && other.idSeat != null) || (this.idSeat != null && !this.idSeat.equals(other.idSeat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Seat[ idSeat=" + idSeat + " ]";
    }
    
}
