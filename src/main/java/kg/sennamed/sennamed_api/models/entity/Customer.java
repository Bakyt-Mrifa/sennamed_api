package kg.sennamed.sennamed_api.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    @Column (name = "customer_id")
    private Long id;
    private String name;
    private String address;
    private String description;

}
