package com.jinan.www.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jinan.www.entity.Grade1;
import com.jinan.www.entity.Student1;
import com.jinan.www.util.HibernateUtil;
 /*
  * ���Ե���Ķ��һ����ѧ��->�༶��
  */
public class Test1 {
	
		public static void main(String[] args) {
			
//			add();
//			delete();
//			update();
			select();
		}
		//ѧ����Ϣ�ı��档
		public static void add() {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Grade1 grade1=new Grade1("java1��","java��ѵһ��");
			Student1 student1 =new Student1("zs", "man", grade1);
			Student1 student12 = new Student1("lisi", "woman", grade1);
			Student1 student13=new Student1("wangwu", "man", grade1);
			
			session.save(grade1);
			session.save(student1);
			session.save(student12);
			session.save(student13);
			
			transaction.commit();
			HibernateUtil.closeSession(session);
			
			
		}
		//ѧ����ɾ��
		public static void delete() {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Student1 student1= (Student1)session.get(Student1.class, 1);
			System.out.println(student1.toString());
			session.delete(student1);
			transaction.commit();
			HibernateUtil.closeSession(session);
			
		}
		//ѧ�����޸�
		public static void update() {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
//			Grade1 grade1 = new Grade1("gname", "gdesc");
			Student1 student1 = session.get(Student1.class, 3);
			System.out.println(student1.toString());
			student1.setSname("wangwuwu");
//			student1.setGrade1(grade1);
//			session.save(grade1);
			session.save(student1);
			
			transaction.commit();
			HibernateUtil.closeSession(session);
		}
		//ѧ���Ĳ�ѯ
		public static void select () {
			Session session = HibernateUtil.getSession();
			Student1 student1 =session.get(Student1.class, 2);
			Grade1  grade1 = student1.getGrade1();
			System.out.println(student1.toString());
			HibernateUtil.closeSession(session);
		}

}
