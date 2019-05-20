package example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.model.City;
import example.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/getall")
	public List<City> getAll() {
		System.out.println("Get all");
		return (List<City>) cityService.findAll();
	}
	
	@GetMapping("/{id}")
	public City getById(@PathVariable("id") int id) {
		System.out.println("Searching by id: " + id);
		City c = cityService.findById(id);
		if (c == null) {
			System.out.println("ID: " + id + " not found");
		}
		return c;
	}
	
	@PostMapping("/add")
	public City add(@RequestBody City city) {
		System.out.println("Added: " + city);
		cityService.save(city);
		return city;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") int id) {
		City temp = cityService.findById(id);
		if (temp == null) {
			System.out.println("Not exsit ID! Don't delete!");
			return;
		}
		cityService.delete(id);
		System.out.println("Deleted id: " + id);
	}
	
	@PutMapping("/update")
	public City update(@RequestBody City city) {
		City temp = cityService.findById(city.getId());
		if (temp != null) {
			System.out.println("Update id: " + city.getId());
			cityService.save(city);
			return city;
		}
		System.out.println("Not exsit ID!");
		return temp;
	}
	
	@RequestMapping("/test")
	public String test() {
		return "Testing";
	}
}
