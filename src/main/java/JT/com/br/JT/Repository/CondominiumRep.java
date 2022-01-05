package JT.com.br.JT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JT.com.br.JT.places.Condominium;

@Repository
public interface CondominiumRep extends JpaRepository<Condominium, Long>  {

	
	
	

}

