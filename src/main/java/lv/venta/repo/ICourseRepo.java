package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

}
