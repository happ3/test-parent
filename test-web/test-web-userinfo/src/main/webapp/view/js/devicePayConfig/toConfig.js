var zTree;
var merchantId; 
var merchantName; 
var treeObj;
var configId;
var payType;
$(function() {
	merchantId = request.QueryString("merchantId");
	merchantName = decodeURIComponent(request.QueryString("merchantName"));
	payType = decodeURIComponent(request.QueryString("payType"));
	configId = decodeURIComponent(request.QueryString("configId"));
	
	
	var obj = {};
	obj.merchantId = merchantId;
	obj.merchantName = merchantName;
	var json = postAsyncAjax("/findAllDeviceByTree",obj);
	
	treeObj = $("#merchanttree");
	treeObj = $.fn.zTree.init(treeObj, setting, json.treesList);
	treeObj.expandAll(true);
	distribution();
});

var setting = {
	    check: {
	        enable: true
	    },
	    async:{
	    	enable: true
	    },
	    view: {
	        dblClickExpand: false,
	        showLine: true,
	        selectedMulti: false
	    },
	    data: {
	        simpleData: {
	            enable:true,
	            idKey: "id",
	            pIdKey: "pId",
	            rootPId: ""
	        }
	    }
    };



distribution = function(){
	$("#distribution").click(function(){
		var nodes = treeObj.getCheckedNodes(true);
		var ids = new Array();
		debugger
		for (var i = 0; i < nodes.length; i++) {
			if(nodes[i].state == "device"){
				ids.push(nodes[i].name);
			}
		}
		ids = ids.toString();
		if (ids == "") {
			alert("至少选择一个商户！");
			return;
		}
		
		var object = new Object();
		object.payType = payType;
		object.devieId = ids;
		object.merchantId = merchantId;
		object.devicePayConfigId = configId;
		var json = postAsyncAjax("/distributionConfig",object);
		if(json.code == "SUCCESS"){
			alert("分配成功!");
		}else{
			alert("失败!");
		}
		
	});
}

















