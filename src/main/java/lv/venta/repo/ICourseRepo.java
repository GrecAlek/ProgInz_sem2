package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{


	Course findByProfessorsIdpe(int id);

	ArrayList<Course> findByGradesStudentIdpe(int id);

	ArrayList<Course> findByCreditpoints(int creditPoints);

}
