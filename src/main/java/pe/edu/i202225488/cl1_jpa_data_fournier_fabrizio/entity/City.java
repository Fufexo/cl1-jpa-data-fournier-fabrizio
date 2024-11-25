package pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "District")
    private String district;
    @Column(name = "Population")
    private Integer population;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "CountryCode")
    private Country country;
}


