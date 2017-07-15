$(function() {
	var setting = createSetting();
	
	initZtree(setting);//初始化ZtreeC
	
});

function createSetting(){
	var setting = {
		check: {
			enable: false
		},
		async:{
			enable: false
		},
		view: {
			addHoverDom: addHoverDom,
			removeHoverDom: removeHoverDom,
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: 0,
				name:"",
				title:""
			}
		},callback: {
			onClick: zTreeOnClick,
			beforeExpand: zTreeBeforeExpand
		}
	};
	return setting;
}

//初始化Ztree
initZtree =function (setting){
	var zTree;
	var obj = new Array();
	var array = postAsyncAjax("/qryAgentlist",null);
	
	array = array.list;
	obj.push({id:0,pId:0,name:"代理商管理",open:true,state:"parent"});//组装根节点
	for (var i = 0; i < array.length; i++) {
		obj.push({id:array[i].id,pId:0,name:array[i].agentName,isParent:true,state:"agent"});
	}
    var t = $("#tree");
    t = $.fn.zTree.init(t, setting, obj);
}


zTreeBeforeExpand = function(treeId, treeNode){
//	json = $.parseJSON(json);
	if(treeNode.state="agent"){
		debugger
		var treeObj = $.fn.zTree.getZTreeObj("tree");
		var newNode = {name:"newNode1"};
//		var parentZNode = treeObj.getNodeByParam("id", treeNode.id, null); 
		treeObj.addNodes(treeNode, newNode, true);
//		var json = postAsyncAjax("/qryAgentlist",null);
	}
}


//动态添加节点
function addHoverDom(treeId, treeNode) {
	var addStr = "";
    var sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
    if(treeNode.state=="parent"){
    	addStr += "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
    }
    if(treeNode.state=="agent"){
//  addStr += "<span class='button remove' id='removeBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
    	addStr += "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
    	addStr += "<span class='button edit' id='editBtn_" + treeNode.tId + "'></span>";
    }
    if(treeNode.state=="marchant"){
    	addStr += "<span class='button remove' id='removeBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
    	addStr += "<span class='button add' id='addBtn_" + treeNode.tId + "'></span>";
    	addStr += "<span class='button edit' id='editBtn_" + treeNode.tId + "'></span>";
    }
    
    sObj.after(addStr);
   
    var btn = $("#addBtn_"+treeNode.tId);
    if (btn) btn.bind("click", function(){
    	if(treeNode.state=="agent"){
    		  var url = "page/merchant/addMerchant.html?agentId="+treeNode.agentId;
    		  topWindow(url, "新增商户",{width:610,height:260});
    	}
    });
};
//动态删除节点
function removeHoverDom(treeId, treeNode) {
    $("#addBtn_"+treeNode.tId).unbind().remove();
    $("#removeBtn_"+treeNode.tId).unbind().remove();
    $("#editBtn_"+treeNode.tId).unbind().remove();
};

	
	

//单机树节点触发
function zTreeOnClick(event, treeId, treeNode) {
	if(treeNode.state=="agent"){
		closeTabs();
		addTab({id: treeNode.tId+1,title: treeNode.name,close: true,url: "page/data.html" });
		addTab({id: treeNode.tId+"ddd",title: "微信配置",close: true,url: "page/wechat/wechatList.html" });
	}
	
	if(treeNode.state=="merchant"){
		closeTabs();
		var merchantName = encodeURIComponent(treeNode.name);
		addTab({id: treeNode.tId+"fff",title: "设备配置",close: true,url: "page/devicePayConfig/devicePayConfiglist2.html?merchantId="+treeNode.merchantId+"&merchantName="+merchantName});
		addTab({id: treeNode.tId+"ttt",title: "微信配置",close: true,url: "page/wechat/wechatList.html?merchantId="+treeNode.merchantId+"&agentId="+treeNode.agentId});
		addTab({id: treeNode.tId+"rrr",title: "支付宝配置",close: true,url: "page/alipay/alipayList.html?merchantId="+treeNode.merchantId });
	}

};

//关闭所有tab页
closeTabs=function(){
	var rea  = $("li[id^='tab_']");
	for (var i = 0; i < rea.length; i++) {
		var result = rea[i].id;
		result = result.substring(result.indexOf("_")+1,result.length);
		//关闭TAB
		top.$("#tab_" + result).remove();
		top.$("#" + result).remove();
	}
}

