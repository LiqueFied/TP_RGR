package hobbyclass.model;

import javax.persistence.*;

@Entity
@Table(name = "hobbyclass")
public class Hobbyclass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "formation_date", nullable = false)
    private String formationDate;

    @Basic
    @Column(name = "graduation_date", nullable = true)
    private String graduationDate;

    @Basic
    @Column(name = "amount_students", nullable = false)
    private String amountStudents;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_hobby", referencedColumnName = "id")
    private Hobby hobby;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_teacher", referencedColumnName = "id")
    private Teacher teacher;

    @Override
    public String toString() {
        return "Hobbyclass_" + id +
                ", name='" + name +
                ", formationDate='" + formationDate +
                ", graduationDate='" + graduationDate +
                ", amountStudents='" + amountStudents +
                ", hobby=" + hobby +
                ", student=" + student +
                ", teacher=" + teacher;
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

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getAmountStudents() {
        return amountStudents;
    }

    public void setAmountStudents(String amountStudents) {
        this.amountStudents = amountStudents;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
