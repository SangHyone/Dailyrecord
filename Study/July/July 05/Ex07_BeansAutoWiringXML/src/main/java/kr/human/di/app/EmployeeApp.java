package kr.human.di.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.human.di.vo.Employee;

public class EmployeeApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");

		Employee emp1 = context.getBean("emp1", Employee.class);
		System.out.println(emp1);

		Employee emp2 = context.getBean("emp2", Employee.class);
		System.out.println(emp2);

		context.close();
	}
}
