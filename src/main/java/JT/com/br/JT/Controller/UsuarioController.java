package JT.com.br.JT.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import JT.com.br.JT.Repository.ApartmentRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	
	private ApartmentRepository apartment;
	
	public UsuarioController(ApartmentRepository apartment) {
		this.apartment = apartment;
	}
	
	
}
