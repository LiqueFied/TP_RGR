package hobbyclass.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "teacher", nullable = false)
    private String teacher;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private String creationDate;

    @Basic
    @Column(name = "category", nullable = false)
    private String category;

    @Basic
    @Column(name = "price", nullable = false)
    private String price;

    @OneToMany(targetEntity= Hobbyclass.class, mappedBy = "hobby", cascade = {CascadeType.ALL})
    private Collection<Hobbyclass> hobbyclasses;

    @Override
    public String toString() {
        return "Hobby_" + id +
                ", name=" + name +
                ", teacher=" + teacher +
                ", creationDate=" + creationDate +
                ", category=" + category +
                ", price=" + price;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Collection<Hobbyclass> getHobbyclasses() {
        return hobbyclasses;
    }

    public void setHobbyclasses(Collection<Hobbyclass> hobbyclasses) {
        this.hobbyclasses = hobbyclasses;
    }
}
