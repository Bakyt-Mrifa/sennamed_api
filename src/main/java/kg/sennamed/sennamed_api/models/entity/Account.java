package kg.sennamed.sennamed_api.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;
    private String login;
    private String password;
    private boolean isActive;
}
