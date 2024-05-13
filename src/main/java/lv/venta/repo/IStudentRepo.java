package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Student;

public interface IStudentRepo extends CrudRepository<Student, Integer>{

}
