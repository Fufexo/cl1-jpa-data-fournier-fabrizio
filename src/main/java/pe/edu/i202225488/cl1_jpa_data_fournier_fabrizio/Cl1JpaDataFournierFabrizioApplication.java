package pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.entity.Country;
import pe.edu.i202225488.cl1_jpa_data_fournier_fabrizio.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataFournierFabrizioApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataFournierFabrizioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Imprimir lenguajes antes de la eliminación
		System.out.println("Consultando lenguajes antes de la eliminación:");
		obtenerLenguajes();

		// Eliminar países "COL" y "ARG"
		countryRepository.deleteAllById(List.of("COL", "ARG"));
		System.out.println("Eliminando COL y ARG...");
		System.out.println("==============================");

		// Imprimir lenguajes después de la eliminación
		System.out.println("Consultando lenguajes después de la eliminación:");
		obtenerLenguajes();
	}

	private void obtenerLenguajes() {
		// Intentar obtener los lenguajes de Argentina (ARG)
		Optional<Country> countryArg = countryRepository.findById("ARG");

		countryArg.ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina:");
					country.getLanguages().forEach(lang -> System.out.println(lang.getId().getLanguage()));
				},
				() -> {
					// Si no se encuentra Argentina, buscar los lenguajes de Perú (PER)
					Optional<Country> countryPeru = countryRepository.findById("PER");
					countryPeru.ifPresentOrElse(
							country -> {
								System.out.println("Lenguajes de Perú:");
								country.getLanguages().forEach(lang -> System.out.println(lang.getId().getLanguage()));
							},
							() -> System.out.println("Error: Datos no encontrados")
					);
				}
		);
		System.out.println("==================================");
	}
}
