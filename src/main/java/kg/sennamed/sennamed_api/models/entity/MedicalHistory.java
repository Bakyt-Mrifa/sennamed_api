package kg.sennamed.sennamed_api.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "histories")
public class MedicalHistory {

    @Id
    @GeneratedValue
    @Column(name = "history_id")
    private Long id;
    @Column(length = 100)
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date addDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date dateOfAappointment;

/*    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User createdUser;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User doctor;

}
