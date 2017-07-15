var merchantId = null;
$(function(){
	 merchantId = request.QueryString("merchantId");
});


addWechat = function () {
    var url = "page/alipay/addAlipay.html?merchantId="+merchantId;
    topWindow(url, "新增支付宝配置",{width:610,height:500});
}