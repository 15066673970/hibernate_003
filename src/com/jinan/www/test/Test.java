package com.jinan.www.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jinan.www.entity.Grade;
import com.jinan.www.entity.Student;
import com.jinan.www.util.HibernateUtil;

/*
 * 单向的一对多关联关系（班级---》学生）
 * 建立关联关系后，可以方便的从一个对象导航到另一个对象
 * 注意关联的方向
 */
public class Test {
	public static void main(String[] args) {
		add();
//		findStudentsByGrade();
//		updateStudents();	
//		deleteStudents();
		
		
	}

	//将学生添加到班级
	public static void add() {
		Grade grade = new Grade("java一班", "java软件开发1班");
		Student student = new Student("zs", "男");
		Student student2 =new Student("lisi","女");
		
		//如果希望在学生表中添加对应的班级编号，需要在班级中添加学生，建立对应的关联关系。
		grade.getStudents().add(student);
		grade.getStudents().add(student2);
		
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(grade);
		session.save(student);
		session.save(student2);
		
		transaction.commit();
		
		HibernateUtil.closeSession(session);
		
		
		
	}
	//查询班级中包含的学生
	public static void findStudentsByGrade() {
		Session session = HibernateUtil.getSession();
		Grade grade=session.get(Grade.class, 1);
		Set<Student> students =grade.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		
		HibernateUtil.closeSession(session);
		
		
	}

	//修改学生信息
	public static void updateStudents() {
		Grade grade1  =new Grade("java2班","java开发二班");
				
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 1);
		grade1.getStudents().add(student);
		
		session.save(grade1);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
	}
	//删除学生信息
	public static void deleteStudents() {
		Session session =HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student =session.get(Student.class, 2);
		session.delete(student);
		transaction.commit();
		HibernateUtil.closeSession(session);
	}
}
