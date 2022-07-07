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

	//출생년도
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
	
	//나이
	public int getAge() {
		//현재년도 - 출생년도 + 1;
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		int age = current_year - this.getYear() + 1;
		return age;
	}
	
	//띠
	public String getTti() {
		//신유술해자축인묘진사오미
		//원숭이, 닭, 개, 돼지, 쥐, 소, 호랑이, 토끼, 용, 뱀, 말, 양
		String[] arr = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		int year = this.getYear();
		int index = year%12;
		return arr[index];
	}
	
	//성별
	public String getGender() {
		char gender = jumin_no.charAt(7);
		if((gender-'0') % 2 == 1)
			return "남";
		else
			return "여";
	}
	
	//지역
	public String getLocal() {
		String str_local = jumin_no.substring(8, 8+2);
		int local = Integer.parseInt(str_local);
		if(local >= 93 && local <=95) {
			return "제주특별시";
		}else if(local == 85) {
			return "울산광역시";
		}else if(local >= 82) {
			return "경상남도";
		}else if(local == 76) {
			return "대구 광역시";
		}else if(local >= 70) {
			return "경상북도";
		}else if(local >= 67) {
			return "대구 광역시";
		}else if(local >= 55) {
			return "광주 또는 전라남도";
		}else if(local == 49 || local == 44) {
			return "세종특별시";
		}else if(local >= 48) {
			return "전라북도";
		}else if(local >= 41) {
			return "충청남도";
		}else if(local == 40) {
			return "대전";
		}else if(local >= 35) {
			return "충청남도";
		}else if(local >= 26) {
			return "강원도";
		}else if(local >= 16) {
			return "경기도";
		}else if(local >= 13) {
			return "인천";
		}else if(local >= 9) {
			return "부산";
		}else if(local >= 0){
			return "서울";
		}else {
			return "알수없음";
		}
	} 
	
	//계절
	public String getSeason() {
		String str_month = this.jumin_no.substring(2,2+2);
		int month = Integer.parseInt(str_month);
		
		switch(month/3) {
			case 1 : return "봄";
			case 2 : return "여름";
			case 3 : return "가을";
			case 0 : case  4 : return "겨울";
			default : return "알수없음";
		}
	}
	
	//간지
	public String getGanji() {
		//경신임계갑을병정무기
		//신유술해자축인묘진사오미
		String[] ganji10 = {"경","신","임","계","갑","을","병","정","무","기"};
		String[] ganji12 = {"신","유","술","해","자","축","인","묘","진","사","오","미"};
		
		int year = this.getYear();
		
		return String.format("%s%s", ganji10[year % 10], ganji12[year % 12]);
	}
	
	//주민번호 유효성
	//선생님이 작성한 코드 
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
