package program;

import java.util.Calendar;

public class Student {
	private String name, surname;
	private TypeOfStudent type;
	private int yearOfBirth;
	private String city;
	
	public Student(String name, String surname, TypeOfStudent type,
	int yearOfBirth, String city) {
		this.name = name;
		this.surname = surname;
		this.type = type;
		this.yearOfBirth = yearOfBirth;
		this.city = city;
	}
	
	public String GetInfo(){
		return String.valueOf(name.charAt(0))
				+'.'
				+surname
				+' '
		+String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-yearOfBirth)
		+' '
		+city;
	}
}