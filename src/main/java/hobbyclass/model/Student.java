package hobbyclass.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "dateOfBirth", nullable = false)
    private String dateOfBirth;

    @Basic
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Basic
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(targetEntity= Hobbyclass.class, mappedBy = "student", cascade = {CascadeType.ALL})
    private Collection<Hobbyclass> hobbyclasses;

    @Override
    public String toString() {
        return "Student_" + id +
                ", name=" + name +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Hobbyclass> getHobbyclasses() {
        return hobbyclasses;
    }

    public void setHobbyclasses(Collection<Hobbyclass> hobbyclasses) {
        this.hobbyclasses = hobbyclasses;
    }
}
