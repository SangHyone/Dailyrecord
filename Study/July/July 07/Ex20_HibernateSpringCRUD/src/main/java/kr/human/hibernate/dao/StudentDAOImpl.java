package kr.human.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.human.hibernate.vo.Student;
@Repository("studentDAO")
@Transactional // 이러면 트랜젝션을 알아서 함
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	//---------------------------------------------------------------------------------
	
	@Override
	public void insert(Student student) {
		sessionfactory.openSession().save(student);
	}
	@Override
	public void update(Student student) {
		Session session = sessionfactory.openSession();
		try {
			session.beginTransaction();
			
			Student student2 = (Student) session.get(Student.class, student.getId());
			student2.setFirstName(student.getFirstName());
			student2.setLastName(student.getLastName());
			student2.setSection(student.getSection());
			session.update(student2);
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	@Override
	public void delete(int id) {
		Session session = sessionfactory.openSession();
		try {
			session.beginTransaction();
			
			Student student2 = (Student) session.get(Student.class, id);
			session.delete(student2);
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> selectList() {
		return sessionfactory.openSession().createQuery("FROM Student ORDER BY id desc").list();
	}
	@Override
	public Student selectById(int id) {
		return (Student) sessionfactory.openSession().find(Student.class, id);
	}

}
