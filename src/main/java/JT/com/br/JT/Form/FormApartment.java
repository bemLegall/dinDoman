package JT.com.br.JT.Form;

import javax.validation.constraints.NotNull;

import JT.com.br.JT.Repository.CondominiumRep;
import JT.com.br.JT.places.Apartment;
import JT.com.br.JT.places.Condominium;

public class FormApartment {

	@NotNull
	private int numero;
	private String nomeDoCondominio;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNomeDoCondominio() {
		return nomeDoCondominio;
	}
	public void setNomeDoCondominio(String nomeDoCondominio) {
		this.nomeDoCondominio = nomeDoCondominio;
	}
	
	public Apartment converter (CondominiumRep condominiumRepository) {
		Condominium condominium = condominiumRepository.findByName(nomeDoCondominio);
		return new Apartment(numero, condominium);
	}
	
}
