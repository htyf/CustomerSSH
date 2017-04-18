$(function(){
	$("#custName").unbind();
	$("#custName").bind("blur",isExistName);
});

/**
 * 是否存在用户名
 * @returns
 */
function isExistName(){
	var custName = $("#custName").val();
	if(custName==""){
		$("#custNameState").empty().append("用户名不能为空");
		$("#custNameState").css("color","red");
	}else{
		var url = "customer_isExistCustomer";
		var args = {"custName":custName,"time":new Date()};
		$.post(url,args,function(data){
			if(data=="exist"){
				$("#custNameState").empty().append('该客户名已存在');
				$("#custNameState").css("color","red");
			}else if(data=="notexist"){
				$("#custNameState").empty().append('该客户名可用');
				$("#custNameState").css("color","green");
			}else{
//				window.parent.location="../../login.jsp";
			}
			
			
		});
		
	}
	
}

/*
 * type--请求方式常见get和post
 * url--异步请求的地址
 * dataType--请求和响应的数据类型 json/text/javascript/xmlml
 * async--是否异步请求，默认为true,如果改为false则当前页面会locked锁
 * data--为post请求时所用的参数，里面包含数据，多个数据以&隔开
 * success--当返回状态码为200的时候回调的方法，data代表response里的数据
 * error--有以下三个参数：XMLHttpRequest 对象、错误信息、
 *       （可选）捕获的异常对象。如果发生了错误，错误信息（第二个参数）除了得到null之外，
 *        还可能是"timeout", "error", "notmodified" 和 "parsererror"。
 * function (XMLHttpRequest, textStatus, errorThrown) {
 * 			通常 textStatus 和 errorThrown 之中
 * 			只有一个会包含信息
 * this; // 调用本次AJAX请求时传递的options参数
 * JSON.parse(data)或者jQuery.parseJSON(data):解析json类型数据得到json对象
 * }
 */

/**
 * 判断用户名是否存在
 * @returns
 */
function isExistName2(){
	var custName = $("#custName").val();
	if(custName==""){
		$("#custNameState").text("用户名不能为空");
		$("#custNameState").css("color","red");
	}else{
		var url = "customer_isExistCustomer";
		var args = {"custName":custName};
		$.ajax({
			"url":"customer_isExistCustomer",
			"type":"POST",
			"dataType":"JSON",
			"data":{"custName":custName,"time":new Date()},
			"async":true,
			"success":function(data){
				
				if(data=="exist"){
					$("#custNameState").text("该客户名已存在");
					$("#custNameState").css("color","red");
				}else if(data=="notexist"){
					$("#custNameState").text("该客户名可用");
					$("#custNameState").css("color","green");
				}else{
					window.parent.location="../../login.jsp";
				}
			}
			
			
		});
		
	}
}


















