package kr.human.MavenEx;

public class StuEx {
	public static void main(String[] args) {
		StudentVO studentVO1 = new StudentVO("22020211", "한사람", 78, 82, 54, 99);
		// System.out.println(studentVO1);
		StudentVO studentVO2 = new StudentVO("22020212", "두사람", 100, 82, 100, 99);
		// System.out.println(studentVO2);

		ClassVO classVO = new ClassVO(10);
		classVO.addStudent(studentVO1);
		classVO.addStudent(studentVO2);
		classVO.addStudent("22020213", "세사람", 100, 82, 100, 99);
		
		System.out.println(classVO.getStudentVO("22020211"));
		System.out.println(classVO.getStudentVO("22020219"));
		
		classVO.addStudent("22020214", "네사람", 77, 82, 100, 99);
		classVO.addStudent("22020215", "오사람", 77, 88, 100, 99);
		classVO.addStudent("22020216", "육사람", 77, 82, 100, 99);
		classVO.addStudent("22020217", "칠사람", 77, 82, 100, 99);
		
		System.out.println(classVO);
	}
}
