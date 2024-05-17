package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradeFilterService;


@Service
public class GradeFIlterServiceImpl implements IGradeFilterService{
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private ICourseRepo courseRepo;

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		
		ArrayList<Grade> result=gradeRepo.findByGrvalueLessThan(4);
		if(result.isEmpty())throw new Exception("There is no failed grades!");
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesbyStudentId(int id) throws Exception {
		if(id<1)throw new Exception("ID should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with this id doesnt exists!");
		
		
		ArrayList<Grade> result=gradeRepo.findByStudentIds(id);
		if(result.isEmpty())throw new Exception("Empty!");
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) throws Exception {
		if(id<1)throw new Exception("ID should be positive");
		
		if(!courseRepo.existsById(id))throw new Exception("Course with this id doesnt exists!");
		
		float result = gradeRepo.calculateAVGGradeInCourseById(id);
		
	
		if(result==0)throw new Exception("Empty!");
		

		return result;
	}

}
