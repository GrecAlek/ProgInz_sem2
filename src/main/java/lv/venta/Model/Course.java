package lv.venta.Model;


import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "CourseTable")
@Entity
public class Course {
	@Id
	@Column(name = "Idc")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idc;
	
	@Column(name = "Title")
	@NotNull
	@Size(min = 4, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Only letters and space are allowed")
	private String title;
	
	@Column(name = "Creditpoints")
	@Min(0)
	@Max(20)
	private int creditpoints;
	
	
	
	@ManyToMany(mappedBy = "courses")
	private Collection<Professor>professors=new ArrayList<>();
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade>grades;
	
	
	
	public Course(String title, int creditPoints, Professor ...profs) {
		setTitle(title);
		setCreditpoints(creditPoints);
		for(Professor temP:profs)
			addProfessor(temP);
		
	}
	public void addProfessor(Professor professor) {
		if(!professors.contains(professor))
			professors.add(professor);
	}

}