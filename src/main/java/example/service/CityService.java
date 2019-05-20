package example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.model.City;
import example.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;
	
	public Iterable<City> findAll() {
		return cityRepository.findAll();
	}
	
	public City findById(int id) {
		Optional<City> op = cityRepository.findById(id);
		if (!op.isPresent()) {
			System.out.println("Not exist ID: " + id);
			return null;
		}
		return op.get();
	}
	
	public void save(City city) {
		cityRepository.save(city);
	}
	
	public void delete(int id) {
		cityRepository.deleteById(id);
	}
}
