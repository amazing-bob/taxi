console.log("authjs...");

var that = this;
var myInfo;
var contentHeight;
var keyWordList = new Array();
var sugLis;
var keywordNo;

$(document).ready(function() {
	
	openWebDB();
	
	sugList = $("#suggestions");
	/**
	 * 내용 : 입력받은 키워드값 으로 시작하는 데이터 리스트로 보여주기
	 * 작성자 : 김태경
	 */
	$("#schoolName").on("input", function(e) {
		var text = $(this).val();

		if(text.length < 1) {
			sugList.html("");
			sugList.listview("refresh");
		} else {
			searchKeywordList(text, function(keywordList) {
				var str = "";
			/*	var keywordLi = null;*/
				for ( var i = 0; i < keywordList.length; i++ ) {
					str += "<li class='listdata' data-no="+keywordList[i].KEYWORD_NO+">"
	            	+keywordList[i].KEYWORD_NAME+"</li>";
					
					/*keywordLi = $("<li>").addClass("listdata")
										.data("no", keywordList[i].KEYWORD_NO)
										.text(keywordList[i].KEYWORD_NAME)
										.click(function() {
											console.log("22222222");
										})
										.appendTo(sugList);*/
										
					
					sugList.listview("refresh");
				}
			});
		}
	});

	$('body').on('click', ".listdata", function (e) { 
//	$(".listdata").click(function() {
		
		var i = $(this)[0];
		keywordNo = i.dataset.no;
		console.log(i.dataset.no);
		console.log(i.innerHTML);
	 	    $("#schoolName").val(i.innerHTML);
	    $(".listdata").remove();
	});  
	console.log("ready()");
	initAjaxLoading();

	/* 임시 사용자 로그인 */
//	console.log("tempLogin()...........");
//	console.log(rootPath);
//	var myInfo = {
//			mbrNo: 26,
//			mbrName:"회원001",
//			mbrPhotoUrl: "../images/photo/m01.jpg",
//			startRange: 500,
//			endRange: 1000,
//			fvrtLocList: null,
//			rcntLocList: null,
//			keyNoList: null
//	};
//	setLocalItem("myInfo", myInfo);
	
	// 웹 버전일 경우만 주석 풀어야됨!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	isSignUp( getLocalItem("myInfo") );



	document.addEventListener("deviceready", onDeviceReady, false);
	contentHeight = $(window).height();
	$("#selectionLoginContent").height(contentHeight+"px");

	// 폰번호 입력시 validatePhone() 호출
	$("#content").on('keyup','#txtPhone', function(e) {
		if ( validatePhone('txtPhone') ) {
			$('#spnPhoneStatus').text('Valid');
			$('#spnPhoneStatus').css('color', 'green');
			$("#btnPhoneNo").removeAttr("disabled").button("refresh");//유효성 검사후 트루값 리턴 받으면 초록 Valid 글씨 띄우고 다음 버튼 활성화.
		} else {
			$('#spnPhoneStatus').text('Invalid');
			$('#spnPhoneStatus').css('color', 'red');
			$("#btnPhoneNo").attr("disabled", "disabled").button("refresh");
		}
	});

	// 이름 입력시 validateName() 호출
	$("#contentName").on('keyup','#txtName', function(e) {
		if ( validateName('txtName') ) {
			$('#spnPhoneStatus').text('Valid');
			$('#spnPhoneStatus').css('color', 'green');
			$("#btnName").removeAttr("disabled").button("refresh");

		} else {
			$('#spnPhoneStatus').text('Invalid');
			$('#spnPhoneStatus').css('color', 'red');
			$("#btnName").attr("disabled", "disabled").button("refresh");
		}
	});

	$("#btnLogin").on("touchend", function() { 
		taxiLogin(); 
	});

	$("#btnPhoneNo").on('click', clickNextBtn);
	$("#btnName").on('click', clickKeyWordPage);
	$("#signUpComplete").on('click', clickSignupBtn);

	/*$("#schoolName").on("input",function(){
		var keyVal = $("#schoolName");
		serchKeyWord(keyVal);
	});*/


}); //reday()

/**
 * deviceready 이벤트
 */
function onDeviceReady() {
	console.log("onDeviceReady()");

	//휴대폰 기기안의 주소록 가져오기
    var options = new ContactFindOptions();
    options.multiple  = true; 
    var fields = ["displayName", "name","phoneNumbers"];
    navigator.contacts.find(fields, extractionContactData, onError, options);
	
	
	try {
		//로컬스토리지로 변경 - 종혁
		isSignUp( getLocalItem("myInfo") );
	} catch (e) {
		alert(e);
	}
}

/**
 * 설    명 : 주소록 가져온 정보를 추출하여 contactsList에 저장 후 임시로 세션 스토리지에 저장
 * 작성자 : 장종혁
 * P     S  : 친구의 휴대폰 정보는 Base64 md5 형식으로 저장됨. 
 */
function extractionContactData(contacts) {

	var contactsList = new Array();
	var frndList = new Array();
	
    for (var i=0; i<contacts.length; i++) {

        	if(contacts[i].phoneNumbers==null){
        		
        		contactsList[i] = {
    					type : "notFound",
    					name : 	contacts[i].displayName,
    					value : "noHaveValue"
    			};
        		
        	}else{
        		
	        		for (var j=0; j<contacts[i].phoneNumbers.length; j++) {

	        			contactsList[i] = {
	        					type : contacts[i].phoneNumbers[j].type,
	        					name : 	contacts[i].displayName,
	        					value : contacts[i].phoneNumbers[j].value
	        			};
	        		}
        	}
    }
    
    var num = 0;
    console.log(contactsList);
    for(var i = 0; i<contactsList.length;i++){
    	
    //	console.log("정보 )    타입 : " + contactsList[i].type + "   | 이름 : " + contactsList[i].name + "   |번호 : " + contactsList[i].value+"\n");

    	if( contactsList[i].value.substring(0,3)=="010"){
    		
    		frndList[num] = {
    				frndName : contactsList[i].name ,
    				frndPhoneNo : b64_md5(contactsList[i].value)
    		};
    		
    		num++;
    		
    	}
    	
    }
    
    setSessionItem("frndData",frndList);
    
};

/**
 * 설  명: Taix 어플 회원가입 여부
 * 작성자: 김상헌
 */
var isSignUp = function( myInfo ) {
	console.log("isSignUp(myInfo)");
//	console.log(myInfo);

	if ( myInfo && myInfo.mbrNo ) {

		$.getJSON( rootPath + "/auth/hasMember.do"
				, { mbrNo: myInfo.mbrNo }
				, function(result) {
					if(result.status == "success") {
						myInfo = result.data.myInfo;
						fvrtLocList = result.data.fvrtLocList;
						rcntLocList = result.data.rcntLocList;
						blackList = result.data.blackList;
						
						if ( myInfo ) {
							//로컬 스토리지에 저장
							setLocalItem("myInfo", myInfo);
							
							// WebDB 에 추가
							insertFvrtLocTable(fvrtLocList);
							insertRcntLocTable(rcntLocList);
							insertBlackTable(blackList);
		
							// 이거는 꼭지워야 한다 WebDB를 동기방식으로 바꾸면서 꼭 지워야 하는 부분//////////////////////////////////////////////////////////
							setInterval(function() {
								goHomeOrRoom(myInfo);
							}, 500);
		
						} else {
							clearLocalData();
		
							// 회원가입 화면 이동 
							$.mobile.changePage("#divPhonePage");
						}
		
					} else {
						alert("시스템오류 발생");
					}
				});

	} else {
		clearLocalData();
		
		// 회원가입 화면 이동
		$.mobile.changePage("#divPhonePage");
	}
};

/**
 * 설  명: 로컬 데이터 삭제(WebDB, LocalStorage, SessionStorage)
 * 작성자: 김상헌
 */
var clearLocalData = function() {
	console.log("clearLocalData()");
	
	deleteAllFvrtLocTable();
	deleteAllRcntLocTable();
	deleteAllBlackTable();
	clearSession();
	clearLocal();
};


/**
 * 전화번호 입력후 다음 버튼 클릭
 */
var clickNextBtn = function(){
//	console.log("clickNextBtn 클릭");
	$.mobile.changePage("#divSignUpPage");
};
/**
 * 이름 입력후 다음 버튼 클릭
 */
var clickKeyWordPage = function(){
	console.log("getKeyword()");
	that.getKeyword();
	$.mobile.changePage("#keyWordPage");

};
/**
 * 회원가입(완료) 버튼 클릭
 */
var clickSignupBtn = function(){
	console.log("clickSignupBtn()");

	var phoneNo = $("#txtPhone").val();
	var mbrName = $("#txtName").val();
	
	if ( phoneNo && mbrName ) {
		signUp( phoneNo, mbrName , keywordNo);

	} else {
		console.log("clickSignupBtn 예외발생");

	}

	return false;
}; 

/**
 * 회원가입 
 * 
 * 추가 : 2014-02-25 장종혁 : WebDB에 myInfo값 추가를 위해 서버에서 받은 mbrNo를 받아서 저장.
 */
var signUp = function( phoneNo, mbrName, keywordNo ) {
	console.log("signUp(myInfo, phoneNo, mbrName="+keywordNo+")");

	var params = {
			mbrName 		: 	mbrName,
			mbrPhoneNo 		: 	phoneNo,
			mbrKeywordNo	: 	keywordNo
				
			/*frndList : getSessionItem("frndData")*/
	};

	$.ajax( rootPath + "/auth/signUp.do", {
		type: "POST",
		data: JSON.stringify( params ),
		dataType: "json",
		contentType: "application/json",
		success: function(result) {
			if(result.status == "success") {
				var myInfo = result.data;

				if ( myInfo ) {
					
					//주소록 친구 정보 base64 md5 형식으로 웹DB에 저장.
					insertFrndTable(getSessionItem("frndData"),myInfo.mbrNo);
					
					// 세션스토리지에 저장
					//setSessionItem("myInfo", myInfo );
					//로컬스토리지에 저장
				
					setLocalItem("myInfo", myInfo);
				}

				changeHref("../home/home.html",myInfo);

			} else {
				alert("회원등록 중 오류 발생");

			}
		}
	});
};


/**
 * 휴대폰 번호 유효성 검사
 */
var validatePhone = function(txtPhone) {
	console.log("validatePhone()");
	var testPhone = document.getElementById(txtPhone).value;
	var filter = /[010]\d{8}$/g;

	if(testPhone != '' && testPhone.length > 10 && testPhone.length < 12){
		if (filter.test(testPhone)) {
			return true;
		} else {
			return false;
		}
		return false;
	};
};

/**
 * 회원가입-이름 유효성 검사
 */
var validateName = function(txtName) {
	console.log("validateName()");
	var testName = document.getElementById(txtName).value;
	var filter = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;

	if(testName != '' && testName.length > 1 && testName.length < 10){
		if (!filter.test(testName)) {
			return true;
		} else {
			return false;
		}
		return false;
	};

};


/**
 * 설  명: 방 없으면 홈화면, 방 있으면 방화면
 * 작성자: 김상헌
 */
var goHomeOrRoom = function(myInfo) {
	console.log("goHomeOrRoom(myInfo)");
//	console.log(myInfo);

	// 방 참여여부 설정
	searchMyRoom(
			// callbackFunc
			function() {
				if ( isRoomMbr() ) { // 방 있을 때
					var myRoom = getSessionItem("myRoom");
					changeHref("../room/room.html", { roomNo : myRoom.roomNo });		

				} else { // 방 없을 때
					changeHref("../home/home.html");

				}
			} );
};


/**
 * 내  용: 초기회원가입시 이름입력완료후 서버디비에서 키워드 목록 가져와서 웹디비에 결과 던지기.
 * 작성자: 김태경
 */
var getKeyword = function(){
	$.getJSON( rootPath + "/auth/getKeyWordList.do"
			, function(result) {
		if(result.status == "success") {
			if ( result.data ) {
				var keyWord = result.data;


				for(var i in result.data){
					keyWordList.push(keyWord[i].keyWordName);
				};

				insertKeywordTable(keyWord);

			}

		} else {
			alert("시스템오류 발생");
		}
	});
};



