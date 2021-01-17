package kg.sennamed.sennamed_api.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue
    @Column(name="position_id")
    private Long id;
    private String position;
    private boolean isActive;

}
