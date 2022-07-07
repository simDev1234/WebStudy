/**
 * 
 */

class MyMath_Static{
	/* 정적 함수 */
	static max(a,b){
		return a > b ? a : b;
	}
	
	static min(a,b){
		return a < b ? a : b;
	}
	
	static hap(n){
		var sum = 0;
		for (var i = 1; i <= n; i++){
			sum += i;
		}
		return sum;
	}
	
	//매개변수 사용할 때에 변수타입 X, 선언부에서 반환타입X
}