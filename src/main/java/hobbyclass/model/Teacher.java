package hobbyclass.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToMany(targetEntity= Hobbyclass.class, mappedBy = "teacher", cascade = {CascadeType.ALL})
    private Collection<Hobbyclass> hobbyclasses;

    @Override
    public String toString() {
        return "Teacher_" + id +
                ", name=" + name +
                ", phoneNumber=" + phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Hobbyclass> getHobbyclasses() {
        return hobbyclasses;
    }

    public void setHobbyclasses(Collection<Hobbyclass> hobbyclasses) {
        this.hobbyclasses = hobbyclasses;
    }
}
