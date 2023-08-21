package adilet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "department_gen"
    )
    @SequenceGenerator(
            name = "department_gen",
            sequenceName = "department_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Hospital hospital;
    @ManyToMany(mappedBy = "departments",
            cascade = CascadeType.ALL
    )
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "department",
            cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<Appointment> appointments;

    public Department(String name) {
        this.name = name;
    }
}
