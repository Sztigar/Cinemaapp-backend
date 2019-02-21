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
@Table(name = "persontype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persontype.findAll", query = "SELECT p FROM Persontype p")
    , @NamedQuery(name = "Persontype.findByIdPersonType", query = "SELECT p FROM Persontype p WHERE p.idPersonType = :idPersonType")
    , @NamedQuery(name = "Persontype.findByNamePersonType", query = "SELECT p FROM Persontype p WHERE p.namePersonType = :namePersonType")})
public class Persontype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idPersonType")
    private Integer idPersonType;
    @Basic(optional = false)
    @Column(name = "namePersonType")
    private String namePersonType;
    @JsonIgnore
    @OneToMany(mappedBy = "idPersonType")
    private Collection<Person> personCollection;

    public Persontype() {
    }

    public Persontype(Integer idPersonType) {
        this.idPersonType = idPersonType;
    }

    public Persontype(Integer idPersonType, String namePersonType) {
        this.idPersonType = idPersonType;
        this.namePersonType = namePersonType;
    }

    public Integer getIdPersonType() {
        return idPersonType;
    }

    public void setIdPersonType(Integer idPersonType) {
        this.idPersonType = idPersonType;
    }

    public String getNamePersonType() {
        return namePersonType;
    }

    public void setNamePersonType(String namePersonType) {
        this.namePersonType = namePersonType;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonType != null ? idPersonType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persontype)) {
            return false;
        }
        Persontype other = (Persontype) object;
        if ((this.idPersonType == null && other.idPersonType != null) || (this.idPersonType != null && !this.idPersonType.equals(other.idPersonType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Persontype[ idPersonType=" + idPersonType + " ]";
    }
    
}
