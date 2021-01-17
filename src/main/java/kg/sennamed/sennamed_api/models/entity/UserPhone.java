package kg.sennamed.sennamed_api.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserPhone {

    @Id
    @GeneratedValue
    @Column(name = "user_phone_id")
    private Long id;
    private String phoneNum;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;
}
