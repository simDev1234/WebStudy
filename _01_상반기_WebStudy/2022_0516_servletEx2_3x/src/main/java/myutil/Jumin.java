package myutil;

import java.util.*;

public class Jumin {
	private String jumin_no;
	//01234567890123
	//000000-0000000

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	//����⵵
	public int getYear() {
		String year_str = jumin_no.substring(0,2);
		int year = Integer.parseInt(year_str);
		char gender = jumin_no.charAt(7);
		if(gender == '9' || gender == '0') {
			year += 1800;
		}else if(gender == '1' || gender == '2' || gender == '5' || gender == '6') {
			year += 1900;
		}else {
			year += 2000;
		}
		return year;
	}
	
	//����
	public int getAge() {
		//����⵵ - ����⵵ + 1;
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		int age = current_year - this.getYear() + 1;
		return age;
	}
	
	//��
	public String getTti() {
		//�������������ι��������
		//������, ��, ��, ����, ��, ��, ȣ����, �䳢, ��, ��, ��, ��
		String[] arr = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
		int year = this.getYear();
		int index = year%12;
		return arr[index];
	}
	
	//����
	public String getGender() {
		char gender = jumin_no.charAt(7);
		if((gender-'0') % 2 == 1)
			return "��";
		else
			return "��";
	}
	
	//����
	public String getLocal() {
		String str_local = jumin_no.substring(8, 8+2);
		int local = Integer.parseInt(str_local);
		if(local >= 93 && local <=95) {
			return "����Ư����";
		}else if(local == 85) {
			return "��걤����";
		}else if(local >= 82) {
			return "��󳲵�";
		}else if(local == 76) {
			return "�뱸 ������";
		}else if(local >= 70) {
			return "���ϵ�";
		}else if(local >= 67) {
			return "�뱸 ������";
		}else if(local >= 55) {
			return "���� �Ǵ� ���󳲵�";
		}else if(local == 49 || local == 44) {
			return "����Ư����";
		}else if(local >= 48) {
			return "����ϵ�";
		}else if(local >= 41) {
			return "��û����";
		}else if(local == 40) {
			return "����";
		}else if(local >= 35) {
			return "��û����";
		}else if(local >= 26) {
			return "������";
		}else if(local >= 16) {
			return "��⵵";
		}else if(local >= 13) {
			return "��õ";
		}else if(local >= 9) {
			return "�λ�";
		}else if(local >= 0){
			return "����";
		}else {
			return "�˼�����";
		}
	} 
	
	//����
	public String getSeason() {
		String str_month = this.jumin_no.substring(2,2+2);
		int month = Integer.parseInt(str_month);
		
		switch(month/3) {
			case 1 : return "��";
			case 2 : return "����";
			case 3 : return "����";
			case 0 : case  4 : return "�ܿ�";
			default : return "�˼�����";
		}
	}
	
	//����
	public String getGanji() {
		//����Ӱ谩����������
		//�������������ι��������
		String[] ganji10 = {"��","��","��","��","��","��","��","��","��","��"};
		String[] ganji12 = {"��","��","��","��","��","��","��","��","��","��","��","��"};
		
		int year = this.getYear();
		
		return String.format("%s%s", ganji10[year % 10], ganji12[year % 12]);
	}
	
	//�ֹι�ȣ ��ȿ��
	//�������� �ۼ��� �ڵ� 
	public boolean isValid() {
		int sum = 0;
		int check_su = 2;
		
		for(int i = 0; i <= 12; i++) {
			if(i == 6) continue;
			sum = sum + (jumin_no.charAt(i)-'0') * check_su;
			check_su++;
			if(check_su > 9) check_su = 2;
		}
		
		sum = (11-(sum % 11))%10;
		
		int last_no = jumin_no.charAt(13)-'0';
		
		return (sum == last_no);
	}
}
