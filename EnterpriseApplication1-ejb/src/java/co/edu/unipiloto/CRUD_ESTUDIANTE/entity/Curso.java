/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_ESTUDIANTE.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Camilo
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCourseid", query = "SELECT c FROM Curso c WHERE c.courseid = :courseid"),
    @NamedQuery(name = "Curso.findByCoursename", query = "SELECT c FROM Curso c WHERE c.coursename = :coursename"),
    @NamedQuery(name = "Curso.findByCredits", query = "SELECT c FROM Curso c WHERE c.credits = :credits"),
    @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByCupos", query = "SELECT c FROM Curso c WHERE c.cupos = :cupos")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COURSEID")
    private Integer courseid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COURSENAME")
    private String coursename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITS")
    private int credits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEMESTRE")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUPOS")
    private int cupos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseid")
    private Collection<Matricula> matriculaCollection;

    public Curso() {
    }

    public Curso(Integer courseid) {
        this.courseid = courseid;
    }

    public Curso(Integer courseid, String coursename, int credits, int semestre, int cupos) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.credits = credits;
        this.semestre = semestre;
        this.cupos = cupos;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.CRUD_ESTUDIANTE.entity.Curso[ courseid=" + courseid + " ]";
    }
    
}
