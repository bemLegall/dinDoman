package JT.com.br.JT.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import JT.com.br.JT.Repository.ApartmentRepository;
import JT.com.br.JT.Repository.CondominiumRep;
import JT.com.br.JT.STATUS.StatusDoApartamento;
import JT.com.br.JT.places.Apartment;
import JT.com.br.JT.places.Condominium;

@Controller
@RequestMapping("apartment")
public class ApartamentController {

	private ApartmentRepository aRep;
	private CondominiumRep cRep;

	public ApartamentController(ApartmentRepository arep, CondominiumRep cRep) {
		this.aRep = arep;
		this.cRep = cRep;
	}

	@GetMapping("/lista")
	public String apartamentList(Model model) {
		List<Apartment> apartments = aRep.findAll();
		List<Condominium> condominios = cRep.findAll();
		model.addAttribute("apartments", apartments);
		model.addAttribute("condominios", condominios);
		// ApartamentDto.convertToList(apartaments);
		return "apartamento/home";
	}

	@GetMapping(path = { "/{id}" })
	public String findById(@PathVariable long id, Model model) {
		Optional<Apartment> apartment = aRep.findById(id);

		model.addAttribute("apartment", apartment.get());
		return "apartamento/id";
	}

	@PostMapping
	public Apartment create(@RequestBody Apartment apartment) {
		return aRep.save(apartment);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Apartment apartment) {
		return aRep.findById(id).map(record -> {
			record.setDescription(apartment.getDescription());
			record.setNumero(apartment.getNumero());
			record.setCondominium(apartment.getCondominium());
			record.setLocatorApartment(apartment.getLocatorApartment());
			Apartment updated = aRep.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return aRep.findById(id).map(record -> {
			aRep.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("vago")
	public String vagos(Model model) {
		List<Apartment> vagos = aRep.findByStatus(StatusDoApartamento.VAGO);
		model.addAttribute("vagos", vagos);
		return "apartamento/vago";
	}

	@GetMapping("ocupado")
	public String ocupado(Model model) {
		List<Apartment> ocupado = aRep.findByStatus(StatusDoApartamento.OCUPADO);
		model.addAttribute("ocupado", ocupado);
		return "apartamento/ocupado";
	}

	@GetMapping("reformando")
	public String reformando(Model model) {
		List<Apartment> reformando = aRep.findByStatus(StatusDoApartamento.REFORMANDO);
		model.addAttribute("reformando", reformando);
		return "apartamento/reformando";
	}

}
