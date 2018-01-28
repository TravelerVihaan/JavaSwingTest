package program;

import java.util.ArrayList;
import java.util.List;

public class Szkola {
	
	private List<Student> students = new ArrayList<Student>();

	public void Add(Student student){
		if(!students.contains(student))
			students.add(student);
	}

	public int GetCount(){
		return students.size();
	}
}
