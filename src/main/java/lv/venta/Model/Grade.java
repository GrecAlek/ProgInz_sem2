package lv.venta.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.Model.Course;
import lv.venta.Model.Professor;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "GradeTable")
@Entity

public class Grade {
	
	@Id
	@Column(name = "Idg")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idg;
	
	@Column(name="Grvalue")
	@Min(1)
	@Max(10)
	private int grvalue;
	
	@ManyToOne
	@JoinColumn(name="Idc")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="Ids")
	private Student student;
	
	public Grade(int grValue, Course course, Student student) {
		setCourse(course);
		setGrvalue(grValue);
		setStudent(student);
		
	}
	
	

}