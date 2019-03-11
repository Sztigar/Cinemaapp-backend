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
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wiktor
 */
@Entity
@Table(name = "hall")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hall.findAll", query = "SELECT h FROM Hall h")
    , @NamedQuery(name = "Hall.findByIdHall", query = "SELECT h FROM Hall h WHERE h.idHall = :idHall")
    , @NamedQuery(name = "Hall.findByNameHall", query = "SELECT h FROM Hall h WHERE h.nameHall = :nameHall")})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idHall")
    private Integer idHall;
    @Column(name = "nameHall")
    private String nameHall;
    @JsonIgnore
    @OneToMany(mappedBy = "idHall")
    private Collection<Seat> seatCollection;
    @JsonIgnore
    @OneToMany(mappedBy = "idHall")
    private Collection<Screening> screeningCollection;

    public Hall() {
    }

    public Hall(Integer idHall) {
        this.idHall = idHall;
    }

    public Integer getIdHall() {
        return idHall;
    }

    public void setIdHall(Integer idHall) {
        this.idHall = idHall;
    }

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    @XmlTransient
    public Collection<Seat> getSeatCollection() {
        return seatCollection;
    }

    public void setSeatCollection(Collection<Seat> seatCollection) {
        this.seatCollection = seatCollection;
    }

    @XmlTransient
    public Collection<Screening> getScreeningCollection() {
        return screeningCollection;
    }

    public void setScreeningCollection(Collection<Screening> screeningCollection) {
        this.screeningCollection = screeningCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHall != null ? idHall.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hall)) {
            return false;
        }
        Hall other = (Hall) object;
        if ((this.idHall == null && other.idHall != null) || (this.idHall != null && !this.idHall.equals(other.idHall))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Hall[ idHall=" + idHall + " ]";
    }
    
}
