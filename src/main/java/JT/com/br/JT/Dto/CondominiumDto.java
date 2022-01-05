package JT.com.br.JT.Dto;

import java.util.List;
import java.util.stream.Collectors;

import JT.com.br.JT.Locator.LocatorCondominium;
import JT.com.br.JT.places.Apartment;
import JT.com.br.JT.places.Condominium;
import JT.com.br.JT.places.Street;

public class CondominiumDto {

	private long id;
	private String name;
	private int maxCapacity;
	private List<Apartment> apartments;
	private LocatorCondominium locators;
	private String description;
	private Street street;

	public CondominiumDto() {
	}

	public CondominiumDto(Condominium condominium) {
		super();
		this.id = condominium.getId();
		this.name = condominium.getName();
		this.maxCapacity = condominium.getMaxCapacity();
		this.apartments = condominium.getApartment();
		this.locators = condominium.getLocator();
		this.description = condominium.getDescription();
		this.street = condominium.getStreet();
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public void setApartaments(List<Apartment> apartaments) {
		this.apartments = apartaments;
	}

	public void setLocators(LocatorCondominium locators) {
		this.locators = locators;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public List<Apartment> getApartaments() {
		return apartments;
	}

	public LocatorCondominium getLocators() {
		return locators;
	}

	public String getDescription() {
		return description;
	}

	public Street getStreet() {
		return street;
	}

	public long getId() {
		return id;
	}

	public static List<CondominiumDto> convertToList(List<Condominium> condominiums) {
		return condominiums.stream().map(CondominiumDto::new).collect(Collectors.toList());

	}

}
