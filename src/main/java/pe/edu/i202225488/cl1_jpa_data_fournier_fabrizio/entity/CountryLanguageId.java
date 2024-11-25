package pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CountryLanguageId {
    private String countryCode;
    private String language;
}