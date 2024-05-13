package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Model.Grade;
import lv.venta.repo.IGradeRepo;
import lv.venta.service.IGradeFilterService;


@Service
public class GradeFIlterServiceImpl implements IGradeFilterService{
	
	@Autowired
	private IGradeRepo gradeRepo;

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		
		ArrayList<Grade> result=gradeRepo.findByGrvalueLessThan(4);
		if(result.isEmpty())throw new Exception("There is no failed grades!");
		
		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesAVGInCourseID(int id) throws Exception {
		
		return null;
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) throws Exception {
		
		return 0;
	}

}
