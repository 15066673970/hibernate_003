package com.jinan.www.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade1 implements Serializable {
	
	private int gid;
	private String gname;
	private String gdesc;
	/*
	 * ����������Ժ���൱��һ�Զ��ˡ�Ϊ�˲�����ע�͵�
	 */
//	private Set<Student1> student1s = new HashSet<Student1>();
	
//	public Set<Student1> getStudent1s() {
//		return student1s;
//	}
//	public void setStudent1s(Set<Student1> student1s) {
//		this.student1s = student1s;
//	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGdesc() {
		return gdesc;
	}
	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}
	public Grade1() {
		super();
	}
//	public Grade1(int gid, String gname, String gdesc, Set<Student1> student1s) {
//		super();
//		this.gid = gid;
//		this.gname = gname;
//		this.gdesc = gdesc;
//		this.student1s = student1s;
//	}
	public Grade1( String gname, String gdesc) {
		this.gname = gname;
		this.gdesc = gdesc;
	}
	
	
	
	

}
