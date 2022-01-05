package JT.com.br.JT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JT.com.br.JT.STATUS.StatusDoApartamento;
import JT.com.br.JT.places.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

	
	List<Apartment> findByStatus(StatusDoApartamento status);

}
