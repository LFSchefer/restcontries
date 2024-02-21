package co.simplon.rescontries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public List<Country> contryList() {
	List<Country> list = new ArrayList();
	list.add(new Country("Super test pays", "Super test capital", 3, "https://flagcdn.com/w320/cy.png"));
	list.add(new Country("Le pays de la fleurs", "LA super fleur", 3334566, "https://flagcdn.com/w320/bm.png"));
	return list;
    }

    public Country country() {
	Country tester = new Country("Super test pays", "Spuer test capital", 3, "exempleUrl.png");
	return tester;
    }

}
