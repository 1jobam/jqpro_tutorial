/**
 * 
 */

function proc1(){
		namevalue = ff.name.value;
		idvalue = ff.id.value;
		
		namelen = namevalue.trim().length; 
		idlen = idvalue.trim().length;
		
		if(namelen == 0){
			alert("이름을 입력하세요");
			return false;
		}
		
		if(namelen < 2 || namelen > 5){
			alert("이름은 2~5 사이 입니다");
			return false;
		}
		
		if(idlen == 0){
			alert("아이디를 입력하세요");
			return false;
		}
		
		if(idlen < 8 || idlen > 12){
			alert("아이디는 8~12 사이 입니다");
			return false;
		}
		
		res = "이름 : " + namevalue + "<br/>";
		res += "아이디 : " + idvalue + "<br/>";
		res += "<span>환영한다</span><br/>";
		
		document.getElementById('result2').innerHTML = res;
	}