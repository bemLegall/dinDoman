package JT.com.br.JT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JT.com.br.JT.Dto.CondominiumDto;
import JT.com.br.JT.Repository.CondominiumRep;
import JT.com.br.JT.places.Apartment;
import JT.com.br.JT.places.Condominium;

@RestController
@RequestMapping("condominio")
public class CondominiumController {

	private CondominiumRep cRep;

	public CondominiumController(CondominiumRep cRep) {
		this.cRep = cRep;
	}

	@GetMapping("/lista")
	public List<CondominiumDto> condominiumList() {
		List<Condominium> condominiums = cRep.findAll();
		return CondominiumDto.convertToList(condominiums);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		return cRep.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Condominium create(@RequestBody Condominium condominium) {
		return cRep.save(condominium);
	}

	@PutMapping(value = "/{updateID}")
	public ResponseEntity update(@PathVariable("updateID") long id, @RequestBody Condominium condominium) {
		return cRep.findById(id).map(record -> {
			record.setDescription(condominium.getDescription());
			record.setMaxCapacity(condominium.getMaxCapacity());
			record.setApartment(condominium.getApartment());
			record.setLocatorCondominium(condominium.getLocatorCondominium());
			record.setStreet(condominium.getStreet());
			Condominium updated = cRep.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "{deleteId}" })
	public ResponseEntity<?> delete(@PathVariable long deleteId) {
		return cRep.findById(deleteId).map(record -> {
			cRep.deleteById(deleteId);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}

//spring.datasource.testWhileIdle=true aplicattion 
//spring.datasource.validationQuery=SELECT 1