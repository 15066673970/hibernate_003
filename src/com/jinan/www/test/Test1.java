package com.jinan.www.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jinan.www.entity.Grade1;
import com.jinan.www.entity.Student1;
import com.jinan.www.util.HibernateUtil;

public class Test1 {
	
		public static void main(String[] args) {
			
			add();
			
		}
		public static void add() {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Grade1 grade1=new Grade1("java1∞‡","java≈‡—µ“ª∞‡");
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

}
