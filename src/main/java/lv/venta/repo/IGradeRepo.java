package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.Model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

	

	ArrayList<Grade> findByGrvalueLessThan(int i);

}
