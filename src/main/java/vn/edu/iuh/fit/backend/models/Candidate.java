package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", columnDefinition = "bigint(20)", nullable = false)
    private Long id;
    @Column(name = "full_name", columnDefinition = "varchar(255)")
    private String fullName;
    @Column(name = "email", columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "phone", columnDefinition = "varchar(15)")
    private String phone;
    @OneToMany(mappedBy = "candidate",fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public Candidate(long id, String fullName, String email, String phone, List<Experience> experiences) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.experiences = experiences;
    }

    public Candidate(long id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}
