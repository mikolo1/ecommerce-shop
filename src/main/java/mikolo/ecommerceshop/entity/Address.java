package mikolo.ecommerceshop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String streetAndPropertyNumber;

    @Column(nullable = false)
    private String zipCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
