package pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

}