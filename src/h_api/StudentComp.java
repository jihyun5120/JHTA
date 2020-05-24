package h_api;

import java.util.Comparator;

public class StudentComp implements Comparator<Student>{
	   char flag;
	   
	   public StudentComp(char flag) {
	      this.flag = flag;
	   }
	   
	   @Override
	   public int compare(Student s1, Student s2) {
	      int result = 0;
	      if(flag == 'n') {
	         result = s1.sno - s2.sno;
	      } else {
	         result = s1.score - s2.score;
	      }
	      return result;
	   }
	   
	}
//<>(제네릭)이 없는 경우
//public class StudentComp implements Comparator{
//		
//	@Override
//	public int compare(Object o1, Object o2) {
//		Student s1 = (Student)o1;
//		Student s2 = (Student)o2;
//		return s1.score - s2.score; 
//	}
//}
