package com.test.pkgs;

import org.junit.Test;

public class CloneTest {
	@Test
	public void test() throws Exception {
		Student mr3306 = new Student();
		mr3306.setNo("3306");
		mr3306.setName("mr3306");

		Student copy = mr3306.clone();

		System.out.println(copy);
		System.out.println(mr3306);

		System.out.println(copy.getNo() + "," + copy.getName());
		System.out.println(mr3306.getNo() + "," + mr3306.getName());
	}

	static class Student implements Cloneable {

		private String no;
		private String name;
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public Student clone() {
			Student stu = null;
			try {
				stu = (Student) super.clone();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return stu;
		}

	}
}
