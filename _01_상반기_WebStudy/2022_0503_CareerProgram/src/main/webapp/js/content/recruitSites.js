function siteOpen(site){
	
	var siteName = site.innerHTML;
	
	if (siteName == '사람인'){
	    window.open('https://www.saramin.co.kr',"_blank");
	}else if (siteName == '잡코리아'){
		window.open('https://www.jobkorea.co.kr',"_blank");
	}else if (siteName == '원티드'){
		window.open('https://www.wanted.co.kr',"_blank");
	}else if (siteName == '워크넷'){
		window.open('https://www.work.go.kr',"_blank");
	}else if (siteName == '커리어'){
		window.open('https://www.career.co.kr',"_blank");
	}else if (siteName == '스카우트'){
		window.open('https://www.scout.co.kr',"_blank");
	}else if (siteName == '인디드'){
		window.open('https://kr.indeed.com',"_blank");
	}else if (siteName == '벼룩시장'){
		window.open('https://www.findjob.co.kr',"_blank");
	}else if (siteName == '피플앤잡'){
		window.open('https://www.peoplenjob.com',"_blank");
	}
}