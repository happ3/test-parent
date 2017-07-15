var n = true;
$(function() {
	validator();//初始化验证
	var merchantId = request.QueryString("merchantId");
	var agentId = request.QueryString("agentId");

	$("#merchantId").val(merchantId);
	$("#agentId").val(agentId);

    
    $("#btnsave").click(function() {
    	if($('#wxpayForm').bootstrapValidator('validate')){
    		if(n){changeDialogHeight(125); n = false;}//改变窗口高度
    		var json = postAjaxSubmit("/saveWechatConfig","wxpayForm");
            alert("success");
            closeDialog();
        }
    	
    	
    });

    $('#resetBtn').click(function() {
        $('#wxpayForm').data('bootstrapValidator').resetForm(true);
        if(!n){changeDialogHeight(-125); n = true;}//改变窗口高度
    });

});


function validator() {
    $('#wxpayForm').bootstrapValidator({
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
                        message: 'The first name is required and cannot be empty'
                    }
                }
            },
            mchId: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required and cannot be empty'
                    }
                }
            },
            appid: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required and cannot be empty'
                    }
                }
            },
            appSecret: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required and cannot be empty'
                    }
                }
            },
            appidKey: {
                validators: {
                    notEmpty: {
                        message: 'The last name is required and cannot be empty'
                    }
                }
            },
            keyStoreId: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    }
                }
            },
            certPassword: {
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