package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{


	Course findByProfessorIdp(int id);

	ArrayList<Course> findByStudentIds(int id);

	ArrayList<Course> findByCreditpoints(int creditPoints);

}
