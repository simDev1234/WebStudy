/**
 * 
 */

class MyMath{
	/* 클래스 내에서는 function을 쓰면 X */
	// 함수 선언 시, function 예약어 대신 함수명만 사용
	max(a,b){
		return a > b ? a : b;
	}
	
	min(a,b){
		return a < b ? a : b;
	}
	
	hap(n){
		var sum = 0;
		for (var i = 1; i <= n; i++){
			sum += i;
		}
		return sum;
	}
	
	//매개변수 사용할 때에 변수타입 X, 선언부에서 반환타입X
}