/**
 * 
 */
/*$(function(){
	alert("100000000000")
	getAllCustomerByLinkId();
});*/
window.onload=function(){
	getAllCustomerByLinkId();
}

/**
 * 根据联系人id获取所有的客户
 * @returns
 */
function getAllCustomerByLinkId(){
	alert("12333333333")
	$.ajax({
		"url":"customer_getAllCustsByLidAjax",
		"type":"POST",
		"dataType":"JSON",
		"data":{},
		"async":false,
		"success":function(data){
			//解析json数据
			var datas = $.parseJSON(data);
			if(datas.status=="successId"){
				$.each(datas.data,function(i,item){
					var otn = "<option id='"+item.custId+"' name='custName'>"+item.custName+"</option>";
					$("#custSelect").append(otn);
				});
				$("#custId").val($("#custSelect").val());
			}else if(datas.status=="successAll"){
				var hotn = "<option id='custOption'>请选择</option> ";
				$("#custSelect").append(hotn);
				$.each(datas.data,function(i,item){
					var otn = "<option id='"+item.custId+"' name='custName'>"+item.custName+"</option>";
					$("#custSelect").append(otn);
				});
				$("option[name='custName']").unbind();
				$("option[name='custName']").bind("click",function(){
					$("#custId").val($("#custSelect").val());
				})
				
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



