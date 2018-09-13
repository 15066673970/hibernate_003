package com.jinan.www.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jinan.www.entity.Grade1;
import com.jinan.www.entity.Student1;
import com.jinan.www.util.HibernateUtil;
 /*
  * 测试单向的多对一。（学生->班级）
  */
public class Test1 {
	
		public static void main(String[] args) {
			
//			add();
//			delete();
//			update();
			select();
		}
		//学生信息的保存。
		public static void add() {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Grade1 grade1=new Grade1("java1班","java培训一班");
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
		//学生的删除
		public static void delete() {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Student1 student1= (Student1)session.get(Student1.class, 1);
			System.out.println(student1.toString());
			session.delete(student1);
			transaction.commit();
			HibernateUtil.closeSession(session);
			
		}
		//学生的修改
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
		//学生的查询
		public static void select () {
			Session session = HibernateUtil.getSession();
			Student1 student1 =session.get(Student1.class, 2);
			Grade1  grade1 = student1.getGrade1();
			System.out.println(student1.toString());
			HibernateUtil.closeSession(session);
		}

}
