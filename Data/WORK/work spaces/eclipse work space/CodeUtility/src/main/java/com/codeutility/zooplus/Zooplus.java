package com.codeutility.zooplus;

public class Zooplus {

	/**
	 * -- write your code in PostgreSQL 9.4 SELECT
	 * dep.dept_id,count(emp.dept_id),sum(salary) from department dep inner join
	 * employee emp on dep.dept_id=emp.dept_id group by dep.dept_id order by
	 * dep.dept_id asc
	 * 
	 * @param S
	 * @return
	 */

	public String getSolution(String S) {
		String unFormatedPhoneNumber = S.replaceAll("\\D", "");
		StringBuffer formatedPhoneNumber = new StringBuffer();

		int count = 0;
		for (int i = 0; i < unFormatedPhoneNumber.length(); i++) {

			String len = unFormatedPhoneNumber.substring(i);

			if (unFormatedPhoneNumber.length() % 3 != 0) {
				if (count > 0 && count % 3 == 0 && len.length() != 4) {
					formatedPhoneNumber.append("-");
					formatedPhoneNumber.append(unFormatedPhoneNumber.charAt(i));
					count = 0;
				} else if (len.length() == 4 && count > 1) {
					formatedPhoneNumber.append("-");
					formatedPhoneNumber.append(unFormatedPhoneNumber.charAt(i));
					count = 1;
				} else {
					formatedPhoneNumber.append(unFormatedPhoneNumber.charAt(i));
				}

				count++;
			} else {
				if (count > 0 && count % 3 == 0) {
					formatedPhoneNumber.append("-");
					formatedPhoneNumber.append(unFormatedPhoneNumber.charAt(i));
					count = 0;
				} else {
					formatedPhoneNumber.append(unFormatedPhoneNumber.charAt(i));
				}
				count++;
			}

		}

		return formatedPhoneNumber.toString();
	}

	public static void main(String[] args) {
		Zooplus zooplus = new Zooplus();
		// 555372654
		System.out.println(zooplus.getSolution("555372654"));
		// System.out.println(zooplus.getSolution("0 -22 1985--324"));
	}

}
