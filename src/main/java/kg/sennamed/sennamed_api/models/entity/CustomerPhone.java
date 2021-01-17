package kg.sennamed.sennamed_api.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers_phone")
public class CustomerPhone {

    @Id
    @GeneratedValue
    @Column(name = "customer_phone_id")
    private Long id;
    private String phoneNum;
    private boolean isActive;

    @ManyToOne
    @JoinColumn (name="customer_id")
    private Customer customer;
}
