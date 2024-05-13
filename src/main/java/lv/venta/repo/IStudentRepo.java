package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Course;
import lv.venta.Model.Student;

public interface IStudentRepo extends CrudRepository<Student, Integer>{


}
