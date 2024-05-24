package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Person;

public interface IPersonRepo extends CrudRepository<Person, Integer> {

}
