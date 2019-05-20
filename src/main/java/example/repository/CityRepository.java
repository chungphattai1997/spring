package example.repository;

import org.springframework.data.repository.CrudRepository;

import example.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
