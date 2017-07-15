var merchantId;
$(function() {
		merchantId = request.QueryString("merchantId");
	  	validator();//初始化验证
	  	initSelect();//初始化下拉框
		commit();//添加
	  	
	    $('#resetBtn').click(function() {
	    	$('#wechatSelect').val(-1);
	    	$('#alipaySelect').val(-1);
	        $('#deviceForm').data('bootstrapValidator').resetForm(true);
	    });

});

commit = function(){
$("#btnsave").click(function() {
	if($('#deviceForm').bootstrapValidator('validate')){
		var wxval=$("#wechatSelect").val();
		var alival=$("#alipaySelect").val();
		var pt;
		if(alival!=-1&&wxval!=-1){
			 pt = {wxpay:wxval,alipay:alival}; 
		}else if(wxval==-1&&alival!=-1){
			 pt = {alipay:alival}; 
		}else if(wxval!=-1&&alival==-1){
			 pt = {wxpay:wxval}; 
		}else{
			alert("微信支付宝必须选择一项!");
			pt={};
			return false;
		}
		debugger
		var str = JSON.stringify(pt); 
		$("#payType").val(str);
		$("#merchantId").val(merchantId);
		var wxConfigName = $("#wechatSelect").find("option:selected").text();
		var alipayConfigName = $("#alipaySelect").find("option:selected").text();
		$("#alipayconfigName").val(alipayConfigName);
		$("#wxconfigName").val(wxConfigName);
		
	    var json = postAjaxSubmit("/addDevicePayConfig","deviceForm");
	    if(null != json && json.code=="SUCCESS"){
	    	alert("success");
	    	closeDialog();
	    	reloaDataTables("df_table");
	    }
	}
});
}


//初始化下拉组件
initSelect = function(){
	var alipayjson = postAsyncAjax("/queryAllAlipayConfig",{"merchantId":merchantId});
	alipayjson = alipayjson.alipayConfig;
    
	var alipay_array = new Array();
	alipay_array.push("<option value='-1'>--请选择--</option>");
	for(var i = 0; i < alipayjson.length; i ++){
		alipay_array.push("<option value='"+alipayjson[i].id+"'>"+alipayjson[i].configName+"</option>");
	}
	$("#alipaySelect").html(alipay_array.join(""));
	
    var wechatjson = postAsyncAjax("/queryAllWechatConfig",{"merchantId":merchantId});
	wechatjson = wechatjson.wxpayConfig;

	var wechat_array = new Array();
	wechat_array.push("<option value='-1'>--请选择--</option>");
	for(var i = 0; i < wechatjson.length; i ++){
		wechat_array.push("<option value='"+wechatjson[i].id+"'>"+wechatjson[i].configName+"</option>");
	}
	$("#wechatSelect").html(wechat_array.join(""));
}


function validator() {
    $('#deviceForm').bootstrapValidator({
//        live: 'disabled',
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	configName: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required and cannot be empty'
                    }
                }
            },
            wechatSelect: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    }
                }
            },
            alipaySelect: {
                validators: {
                    notEmpty: {
                        message: 'The confirm password is required and cannot be empty'
                    }
                }
            },
            'languages[]': {
                validators: {
                    notEmpty: {
                        message: 'Please specify at least one language you can speak'
                    }
                }
            },
            'programs[]': {
                validators: {
                    choice: {
                        min: 2,
                        max: 4,
                        message: 'Please choose 2 - 4 programming languages you are good at'
                    }
                }
            },
            captcha: {
                validators: {
                    callback: {
                        message: 'Wrong answer',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            }
        }
    });
}