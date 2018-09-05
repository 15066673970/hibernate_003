package com.jinan.www.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jinan.www.entity.Grade;
import com.jinan.www.entity.Student;
import com.jinan.www.util.HibernateUtil;

/*
 * �����һ�Զ������ϵ���༶---��ѧ����
 * ����������ϵ�󣬿��Է���Ĵ�һ�����󵼺�����һ������
 * ע������ķ���
 */
public class Test {
	public static void main(String[] args) {
		add();
//		findStudentsByGrade();
//		updateStudents();	
//		deleteStudents();
		
		
	}

	//��ѧ����ӵ��༶
	public static void add() {
		Grade grade = new Grade("javaһ��", "java�������1��");
		Student student = new Student("zs", "��");
		Student student2 =new Student("lisi","Ů");
		
		//���ϣ����ѧ��������Ӷ�Ӧ�İ༶��ţ���Ҫ�ڰ༶�����ѧ����������Ӧ�Ĺ�����ϵ��
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
	//��ѯ�༶�а�����ѧ��
	public static void findStudentsByGrade() {
		Session session = HibernateUtil.getSession();
		Grade grade=session.get(Grade.class, 1);
		Set<Student> students =grade.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}
		
		HibernateUtil.closeSession(session);
		
		
	}

	//�޸�ѧ����Ϣ
	public static void updateStudents() {
		Grade grade1  =new Grade("java2��","java��������");
				
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 1);
		grade1.getStudents().add(student);
		
		session.save(grade1);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
	}
	//ɾ��ѧ����Ϣ
	public static void deleteStudents() {
		Session session =HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student =session.get(Student.class, 2);
		session.delete(student);
		transaction.commit();
		HibernateUtil.closeSession(session);
	}
}
