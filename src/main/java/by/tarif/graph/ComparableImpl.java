//$Id$
package by.tarif.graph;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableImpl {
	public static void main(String[] args) {
		ArrayList<Student> sList = new ArrayList<>();
		sList.add(new Student(3, "Adam"));
		sList.add(new Student(0, "John"));
		sList.add(new Student(5, "Tarif"));
		sList.add(new Student(2, "Alice"));
		Collections.sort(sList);
		for(Student s : sList) {
			System.out.print(s);
		}
	}
}
class Student implements Comparable<Student>{
	int roleNumber;
	String name;
	public Student(int num, String name) {
		this.roleNumber = num;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.roleNumber+", ";
	}

	@Override
	public int compareTo(Student student) {
		if(this.roleNumber<student.roleNumber) {
			return -1;
		}else if(this.roleNumber == student.roleNumber) {
			return 0;
		}else {
			return 1;
		}
	}
}
