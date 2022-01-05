package JT.com.br.JT.Dto;

import java.util.List;
import java.util.stream.Collectors;

import JT.com.br.JT.Locator.LocatorApartment;
import JT.com.br.JT.STATUS.StatusDoApartamento;
import JT.com.br.JT.places.Apartment;
import JT.com.br.JT.places.Condominium;

public class ApartamentDto {

	private long id;
	private int numero;
	private String Description;
	private LocatorApartment locatorApartment;
	private Condominium condominium;

	public ApartamentDto() {

	}

	public ApartamentDto(Apartment apartament) {
		this.numero = apartament.getNumero();
		this.locatorApartment = apartament.getLocator();

		this.Description = apartament.getDescription();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocatorApartment getLocatorApartment() {
		return locatorApartment;
	}

	public void setLocatorApartment(LocatorApartment locatorApartment) {
		this.locatorApartment = locatorApartment;
	}

	public Condominium getCondominium() {
		return condominium;
	}

	public void setCondominium(Condominium condominium) {
		this.condominium = condominium;
	}

	public static List<ApartamentDto> convertToList(List<Apartment> apartaments) {
		return apartaments.stream().map(ApartamentDto::new).collect(Collectors.toList());

	}

}
