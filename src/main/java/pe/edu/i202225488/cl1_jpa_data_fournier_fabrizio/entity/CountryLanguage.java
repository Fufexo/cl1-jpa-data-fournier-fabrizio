package pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countryLanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "CountryCode", updatable = false, insertable = false)
    private Country country;
    @Column(name = "IsOfficial")
    private String isOfficial;
    @Column(name = "Percentage")
    private Double percentage;
}
