var n = true;
$(function() {
	validator();//初始化验证
	var merchantId = request.QueryString("merchantId");
	$("#merchantId").val(merchantId);
    $("#btnsave").click(function() {
    	if($('#alipayForm').bootstrapValidator('validate')){
    		if(n){changeDialogHeight(125); n = false;}//改变窗口高度
    		var json = postAjaxSubmit("/saveAlipayConfig","alipayForm");
            alert("success");
            closeDialog();
        }
    });

    $('#resetBtn').click(function() {
        $('#alipayForm').data('bootstrapValidator').resetForm(true);
        if(!n){changeDialogHeight(-125); n = true;}//改变窗口高度
        
    });

});


function validator() {
    $('#alipayForm').bootstrapValidator({
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
            privateKey: {
            	validators: {
            		notEmpty: {
            			message: 'The last name is required and cannot be empty'
            		}
            	}
            },
            partner: {
            	validators: {
            		notEmpty: {
            			message: 'The last name is required and cannot be empty'
            		}
            	}
            },
            alipayPublicKey: {
            	validators: {
            		notEmpty: {
            			message: 'The last name is required and cannot be empty'
            		}
            	}
            },
            publicKey: {
            	validators: {
            		notEmpty: {
            			message: 'The last name is required and cannot be empty'
            		}
            	}
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: 'The password and its confirm are not the same'
                    },
                    different: {
                        field: 'username',
                        message: 'The password cannot be the same as username'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'The confirm password is required and cannot be empty'
                    },
                    identical: {
                        field: 'password',
                        message: 'The password and its confirm are not the same'
                    },
                    different: {
                        field: 'username',
                        message: 'The password cannot be the same as username'
                    }
                }
            },
            birthday: {
                validators: {
                    date: {
                        format: 'YYYY/MM/DD',
                        message: 'The birthday is not valid'
                    }
                }
            },
            gender: {
                validators: {
                    notEmpty: {
                        message: 'The gender is required'
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