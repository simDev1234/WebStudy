/**
 * 
 */

class Jumin{
	
	//접근 제어자 private등 사용 가능
	//- 내부 변수 : _변수명... <<-- 권장사항
	//_jumin_no; 생략하고 생성자 내부에서 쓰면 알아서 생성됨
	
	//생성자(Constructor)
	constructor(jumin_no){
		this._jumin_no = jumin_no;
	}
	
	//getter
	get jumin_no(){
		return this._jumin_no;
	}
	
	//setter
	set jumin_no(jumin_no){
		this._jumin_no = jumin_no;
	}
	
	//출생년도 구하기
	getYear(){
		var index7 = this._jumin_no.substr(7,1);
		var year = parseInt(this._jumin_no.substr(0,2));
		
		if (index7 == '0' || index7 == '9'){
			year += 1800;			
		}else if(index7 == '1' || index7 == '2' || index7 == '5' || index7 == '6'){
			year += 1900;
		}else{
			year += 2000;
		}
		
		return year;	
	}
	
	//나이 구하기
	getAge(){
		var today = new Date();
		return (today.getFullYear() - this.getYear() + 1);
		// https://cofs.tistory.com/346  << getFullYear() 을 사용해야 하는 이유 (getYear()는 deprecated 됐다.)
	}
	
	//띠 구하기
	getTti(){
		var ji = ["원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"];
		
		var year = this.getYear();
		
		return ji[year % 12];
	}
	
	//간지 구하기
	getGanji(){
		var gan = ["경","신","임","계","갑","을","병","정","무","기"];
		var ji = ["신","유","술","해","자","축","인","묘","진","사","오","미"];
		var year = this.getYear();
		
		return gan[year % 10] + ji[year % 12];
	}
	
	//성별 구하기
	getGender(){
		var gender = this._jumin_no.substr(7,1);
		
		if (gender == '1' || gender == '3' || gender == '5' || gender == '7' || gender =='9'){
			return '남자';
		}else{
			return '여자';
		}
	}
	
	//지역 구하기
	getLocal(){
		var year = this.getYear();
		var local = parseInt(this._jumin_no.substr(8,2));
		
		if (year >= 2021){
			return '알수 없음'
		}
		
		if (local >= 93){
			return '제주';
		}else if (local ==85){
			return '울산';
		}else if (local >= 82){
			return '경상남도';
		}else if (local == 76){
			return '대구';
		}else if (local >= 70){
			return '경상북도';
		}else if (local >= 67){
			return '대구';
		}else if (local == 55 || local == 56){
			return '광주';
		}else if (local >= 48 && local <= 54){
			return '전라북도';
		}else if (local == 44 || local == 49){
			return '세종특별';
		}else if (local >= 41 && local <= 47){
			return '충청남도';
		}else if (local == 40){
			return '대전';
		}else if (local >= 35 && local <= 39){
			return '충청남도';
		}else if (local >= 26 && local <= 34){
			return '강원도';
		}else if (local >= 16 && local <= 25){
			return '경기도';
		}else if (local >= 13 && local <= 15){
			return '인천';
		}else if (local >= 9 && local <= 12){
			return '부산';
		}else{
			return '서울';
		}
		
	}
	
	//계절 구하기
	getSeason(){
		var month = parseInt(this._jumin_no.substr(2,2));
		
		//javascript에서 / 나누기를 하고 나면 소수점으로 값이 나옴
		//---> 꼭 floor를 해주어야 한다.
		switch (Math.floor(month / 3)){
			case 1 : return '봄';
			case 2 : return '여름';
			case 3 : return '가을';
			default : return '겨울';
		}
	}
	
}