package lv.venta.service;

import java.util.ArrayList;

import lv.venta.Model.Grade;

public interface IGradeFilterService {
	
	public abstract ArrayList<Grade> selectFailedGrades()throws Exception;
	
	public abstract ArrayList<Grade>selectGradesAVGInCourseID(int id)throws Exception;
	
	public abstract float calculateAVGGradeInCourseId(int id)throws Exception;
	
	

}
