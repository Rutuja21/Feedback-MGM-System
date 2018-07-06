/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedbackmgm;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author shiv
 */
@Entity
@Table(name = "FACULTY_REGISTRATION", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "FacultyRegistration.findAll", query = "SELECT f FROM FacultyRegistration f"),
    @NamedQuery(name = "FacultyRegistration.findByFacultyName", query = "SELECT f FROM FacultyRegistration f WHERE f.facultyName = :facultyName"),
    @NamedQuery(name = "FacultyRegistration.findBySubjectAllocated", query = "SELECT f FROM FacultyRegistration f WHERE f.subjectAllocated = :subjectAllocated"),
    @NamedQuery(name = "FacultyRegistration.findBySemester", query = "SELECT f FROM FacultyRegistration f WHERE f.semester = :semester")})
public class FacultyRegistration implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FACULTY_NAME")
    private String facultyName;
    @Basic(optional = false)
    @Column(name = "SUBJECT_ALLOCATED")
    private String subjectAllocated;
    @Basic(optional = false)
    @Column(name = "SEMESTER")
    private BigInteger semester;

    public FacultyRegistration() {
    }

    public FacultyRegistration(String facultyName) {
        this.facultyName = facultyName;
    }

    public FacultyRegistration(String facultyName, String subjectAllocated, BigInteger semester) {
        this.facultyName = facultyName;
        this.subjectAllocated = subjectAllocated;
        this.semester = semester;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        String oldFacultyName = this.facultyName;
        this.facultyName = facultyName;
        changeSupport.firePropertyChange("facultyName", oldFacultyName, facultyName);
    }

    public String getSubjectAllocated() {
        return subjectAllocated;
    }

    public void setSubjectAllocated(String subjectAllocated) {
        String oldSubjectAllocated = this.subjectAllocated;
        this.subjectAllocated = subjectAllocated;
        changeSupport.firePropertyChange("subjectAllocated", oldSubjectAllocated, subjectAllocated);
    }

    public BigInteger getSemester() {
        return semester;
    }

    public void setSemester(BigInteger semester) {
        BigInteger oldSemester = this.semester;
        this.semester = semester;
        changeSupport.firePropertyChange("semester", oldSemester, semester);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyName != null ? facultyName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacultyRegistration)) {
            return false;
        }
        FacultyRegistration other = (FacultyRegistration) object;
        if ((this.facultyName == null && other.facultyName != null) || (this.facultyName != null && !this.facultyName.equals(other.facultyName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "feedbackmgm.FacultyRegistration[ facultyName=" + facultyName + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
