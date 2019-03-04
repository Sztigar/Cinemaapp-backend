/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wat.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wiktor
 */
@Entity
@Table(name = "screening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Screening.findAll", query = "SELECT s FROM Screening s")
    , @NamedQuery(name = "Screening.findByIdScreening", query = "SELECT s FROM Screening s WHERE s.idScreening = :idScreening")
    , @NamedQuery(name = "Screening.findByDate", query = "SELECT s FROM Screening s WHERE s.date = :date")
    , @NamedQuery(name = "Screening.findByStatus", query = "SELECT s FROM Screening s WHERE s.status = :status")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idScreening")
    private Integer idScreening;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "idHall", referencedColumnName = "idHall")
    @ManyToOne
    private Hall idHall;
    @JoinColumn(name = "idMovie", referencedColumnName = "idMovie")
    @ManyToOne
    private Movie idMovie;
    @OneToMany(mappedBy = "idScreening")
    @JsonIgnore
    private Collection<Ticket> ticketCollection;

    public Screening() {
    }

    public Screening(Integer idScreening) {
        this.idScreening = idScreening;
    }

    public Screening(Integer idScreening, Date date) {
        this.idScreening = idScreening;
        this.date = date;
    }

    public Integer getIdScreening() {
        return idScreening;
    }

    public void setIdScreening(Integer idScreening) {
        this.idScreening = idScreening;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Hall getIdHall() {
        return idHall;
    }

    public void setIdHall(Hall idHall) {
        this.idHall = idHall;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
        this.idMovie = idMovie;
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
        hash += (idScreening != null ? idScreening.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Screening)) {
            return false;
        }
        Screening other = (Screening) object;
        if ((this.idScreening == null && other.idScreening != null) || (this.idScreening != null && !this.idScreening.equals(other.idScreening))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Screening[ idScreening=" + idScreening + " ]";
    }
    
}
