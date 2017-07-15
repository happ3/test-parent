var merchantId; 
var merchantName; 
$(function () {
	
	merchantId = request.QueryString("merchantId");
	merchantName = request.QueryString("merchantName");
	queryDataTable();
	initTable();
});
 
initTable = function(){
	$('#df_table').dataTable( {
	    language: {
	        "sProcessing": "处理中...",
	        "sLengthMenu": "显示 _MENU_ 项结果",
	        "sZeroRecords": "没有匹配结果",
	        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
	        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
	        "sInfoFiltered": "",
	        "sInfoPostFix": "",
	        "sSearch": "搜索:",
	        "sUrl": "",
	        "sEmptyTable": "表中数据为空",
	        "sLoadingRecords": "载入中...",
	        "sInfoThousands": ",",
	        "oPaginate": {
	            "sFirst": "首页",
	            "sPrevious": "上页",
	            "sNext": "下页",
	            "sLast": "末页"
	        },
	        "oAria": {
	            "sSortAscending": ": 以升序排列此列",
	            "sSortDescending": ": 以降序排列此列"
	        }
	    },
	    displayStart: 0,
	    pageLength: 10,//首次加载的数据条数
	    serverSide: true,
	    searching:false,
	    ordering: false,
	    paging: true,//分页
	    ajax: {
	        url: '/queryDevicePayConfigByPage',
	        type: 'POST',
	        dataSrc: "data",
	        data: function (d) {//d 是原始的发送给服务器的数据，默认很长。
                var param = {};//因为服务端排序，可以新建一个参数对象
                param.start = d.start;//开始的序号
                param.length = d.length;//要取的数据的
                param.merchantId = merchantId;
                var formData = $("#formSearch").serializeArray();//把form里面的数据序列化成数组
                formData.forEach(function (e) {
                    param[e.name] = e.value;
                });
                return param;//自定义需要传递的参数。
            },
	    },
	    columns: [
	        { data: 'id'},
	        { data: 'configName' },
	        { data: 'alipayconfigName' },
	        { data: 'wxconfigName' },
	        { data: 'payType' ,render: function(data, type, row, meta) {
	        	
	        	var j = data.indexOf("alipay");
	        	var g = data.indexOf("wxpay");
	        	if(j>0&& g<0){
	        		 return "alipay";
	        	}
	        	if(g>0 && j<0){
	        		return "wechat";
	        	}
	        	if(j>0 && g>0){
	        		return "alipay,wechat";
	        	}
	        }},
	        { data: 'insertTimestamp' ,render: function(data, type, row, meta) {
	            return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
	        } },
	        { data: 'state' ,render: function(data, type, row, meta) {
	            return "<button class=\"btn  btn-primary btn-xs\" onclick = 'toConfig("+row.payType+","+row.id+");'>分配</button>"; //date的格式 Thu Apr 26 2016 00:00:00 GMT+0800
	        } }
	    ]
	} );
}




toConfig = function(payType,configId){
	 payType = JSON.stringify(payType);
	 payType = encodeURIComponent(payType);
	 var url = "page/devicePayConfig/toConfig.html?merchantId="+merchantId
 				+"&payType="+payType+"&merchantName="+merchantName+"&configId="+configId;
     topWindow(url, "分配配置",{width:510,height:350});
}

queryDataTable = function(){
	$("#btn_query").click(function(){
		$('#df_table').dataTable().fnPageChange('previous',true); 
	})
}

addDevicePayCofig = function () {
    var url = "page/devicePayConfig/addDevicePayConfig.html?merchantId="+merchantId;
    topWindow(url, "新增设备配置",{width:510,height:350});
};



