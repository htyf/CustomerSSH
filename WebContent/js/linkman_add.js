/**
 * 
 */
$(function(){
	isExistCustomer();
	getAllCustomers();
});

/**
 * 判断是否存在客户名
 * @returns
 */
function isExistCustomer(){

	$("#custName").unbind();
	$("#custName").bind("blur",function(){
		var custName = $("#custName").val();
		if(custName==''){
			/*$("#isexist").remove();
			$("#cName").append("<span id='isexist' style='color:red'>客户名不能为空</span>")*/
			if($("#custSelect").val()=="请选择"){
				alert("客户名不能为空");
			}else{
				alert("已经选择了客户名，不能重复输入");
				$("#custName").val("");
			}
		}else{
			$.ajax({
				"url":"customer_isExistCustomer",
				"type":"POST",
				"data":{"custName":custName},
				"dataType":"JSON",
				"success":function(data){
					if(data=="exist"){
						$("#isexist").remove();
						$("#cName").append("<span id='isexist'>客户名存在</span>");
						$("#isexist").css("color","green")
					}else if(data=="notexist"){
						/*$("#isexist").remove();
						$("#cName").append("<span id='isexist'>客户名不存在,请重新输入</span>");
						$("#isexist").css("color","red")*/
						if($("#custSelect").val()=="请选择"){
							alert("不存在该客户名,请重新输入");
							$("#custName").val("");
							$("#custName").focus();
						}else{
							if($("#custName").val()!=""){
								alert("已经选择了客户名，不能重复输入");
								$("#custName").val("");
							}
						}
					}else{
//						window.parent.location="../../login.jsp";
					}
				},
				"error":function(){
					alert("error");
				}
			});
		}




	});

}

/**
 * 获取所有的客户
 * @returns
 */
function getAllCustomers(){
	$.ajax({
		"url":"customer_getAllCustomersAjax",
		"type":"POST",
		"dataType":"JSON",
		"data":{},
		"async":false,
		"success":function(data){
			//解析json数据
			var datas = $.parseJSON(data);
			if(datas.status=="success"){
				$.each(datas.data,function(i,item){
					var otn = "<option id='"+item.custId+"' name='custName'>"+item.custName+"</option>";
					$("#custSelect").append(otn);
				});
			}else{
				alert("返回数据失败")
			}
		},
		"error":function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}


	});
}
