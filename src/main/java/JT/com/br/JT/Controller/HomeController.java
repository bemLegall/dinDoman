package JT.com.br.JT.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JT.com.br.JT.Repository.ApartmentRepository;
import JT.com.br.JT.Repository.CondominiumRep;
import JT.com.br.JT.places.Apartment;
import JT.com.br.JT.places.Condominium;

@Controller
@RequestMapping("/home")
public class HomeController {

	private CondominiumRep cRep;
	private ApartmentRepository aRep;

	public HomeController(CondominiumRep crep, ApartmentRepository aRep) {
		this.cRep = crep;
		this.aRep = aRep;
	}

	@GetMapping
	public String home(Model model) {
		List<Condominium> condominios = cRep.findAll();
		List<Apartment> apartamentos = aRep.findAll();
		model.addAttribute("condominios", condominios);
		model.addAttribute("apartamentos", apartamentos);

		return "home";
	}

}
