package kg.sennamed.sennamed_api.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column (name = "user_id")
    private Long id;

    @Column(length = 100)
    private String name;
    private String address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

}
