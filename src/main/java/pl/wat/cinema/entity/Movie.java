/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.wat.cinema.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 * @author Wiktor
 */
@Entity
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
        , @NamedQuery(name = "Movie.findByIdMovie", query = "SELECT m FROM Movie m WHERE m.idMovie = :idMovie")
        , @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title")
        , @NamedQuery(name = "Movie.findByDescription", query = "SELECT m FROM Movie m WHERE m.description = :description")
        , @NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.genre = :genre")
        , @NamedQuery(name = "Movie.findByLength", query = "SELECT m FROM Movie m WHERE m.length = :length")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMovie")
    private Integer idMovie;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "genre")
    private String genre;
    @Column(name = "image")
    private String image;
    @Column(name = "length")
    private Integer length;
    @OneToMany(mappedBy = "idMovie")
    private Collection<Screening> screeningCollection;

    public Movie() {
    }

    public Movie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Movie(Integer idMovie, String title) {
        this.idMovie = idMovie;
        this.title = title;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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
        hash += (idMovie != null ? idMovie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.idMovie == null && other.idMovie != null) || (this.idMovie != null && !this.idMovie.equals(other.idMovie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Movie[ idMovie=" + idMovie + " ]";
    }

}
