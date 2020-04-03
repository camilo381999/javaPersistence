/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_ESTUDIANTE.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Camilo
 */
@Entity
@Table(name = "MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByMatriculaid", query = "SELECT m FROM Matricula m WHERE m.matriculaid = :matriculaid")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MATRICULAID")
    private Integer matriculaid;
    @JoinColumn(name = "COURSEID", referencedColumnName = "COURSEID")
    @ManyToOne(optional = false)
    private Curso courseid;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @ManyToOne(optional = false)
    private Estudiantes studentid;

    public Matricula() {
    }

    public Matricula(Integer matriculaid) {
        this.matriculaid = matriculaid;
    }

    public Integer getMatriculaid() {
        return matriculaid;
    }

    public void setMatriculaid(Integer matriculaid) {
        this.matriculaid = matriculaid;
    }

    public Curso getCourseid() {
        return courseid;
    }

    public void setCourseid(Curso courseid) {
        this.courseid = courseid;
    }

    public Estudiantes getStudentid() {
        return studentid;
    }

    public void setStudentid(Estudiantes studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaid != null ? matriculaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaid == null && other.matriculaid != null) || (this.matriculaid != null && !this.matriculaid.equals(other.matriculaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.CRUD_ESTUDIANTE.entity.Matricula[ matriculaid=" + matriculaid + " ]";
    }
    
}
