var merchantId = null;
var agentId = null;
$(function(){
	 merchantId = request.QueryString("merchantId");
	 agentId = request.QueryString("agentId");
});

addWechat = function () {
    var url = "page/wechat/addWechat.html?merchantId="+merchantId+"&agentId="+agentId;
    topWindow(url, "新增微信配置",{width:610,height:430});
}