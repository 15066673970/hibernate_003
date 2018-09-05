package com.jinan.www.entity;

import java.io.Serializable;

public class Student1 implements Serializable {
		
		private int sid;
		private String sname;
		private String sex;
		/*
		 * 加上一个grade1的属性，就相当于增加了一个grade属性。
		 */
		private Grade1 grade1;
		public Grade1 getGrade1() {
			return grade1;
		}
		public void setGrade1(Grade1 grade1) {
			this.grade1 = grade1;
		}
		public Student1(String sname, String sex, Grade1 grade1) {
			this.sname = sname;
			this.sex = sex;
			this.grade1 = grade1;
		}
		
		
		
		
		
		
		
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Student1() {
			super();
		}
		public Student1(int sid, String sname, String sex) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.sex = sex;
		}
		
		
		
	
	
	
	
	
}
