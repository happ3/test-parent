document.writeln("  <link rel=\"stylesheet\" href=\"/bootstrap/css/bootstrap.min.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/font-awesome/4.4.0/css/font-awesome.min.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/dist/css/skins/_all-skins.min.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/css/metro.css\">");

document.writeln("  <script src=\"/js/jQuery-2.1.4.min.js\"></script>");
document.writeln("  <script src=\"/bootstrap/js/bootstrap.min.js\"></script>");
document.writeln("  <script src=\"/js/fastclick.min.js\"></script>");
document.writeln("  <script src=\"/dist/js/app.min.js\"></script>");
document.writeln("  <script src=\"/dist/js/demo.js\"></script>");
document.writeln("  <script src=\"/js/jquery.ztree.all-3.5.min.js\"></script>");
document.writeln("  <script src=\"/js/bootstrap-tab.js\"></script>");
document.writeln("  <script src=\"/js/jquery.json.js\"></script>");




//顶级窗口打开方式
function topWindow(url, title, options){
    setWindowSrc(url);
    setWindowAttr(title, options);
    top.$('#myModal').modal('show');
}

function setWindowAttr(title, options) {
    top.$('#myModalLabel').text(title);
    top.$('.modal-dialog').width(options.width);
    top.$('.modal-body').height(options.height);
    top.$('.modal-footer').remove();
}

changeDialogHeight = function(h){
	top.$('.modal-body').animate({
	      height:'+='+h
    });
}

closeDialog = function(){
	top.$('#myModal').modal('hide');
}

reloaDataTables = function (id){
	var rea = top.$("iframe[id^='contentframe']");
	for (var i = 0; i < rea.length; i++) {
		var result = rea[i].id;
		var t = top.$("#"+result).parent().hasClass("active");
		if(t){
			top.$("#"+result).get(0).contentWindow.$("#"+id).dataTable().fnPageChange('previous', true );
			break;
		}
	}
}



/** 设置window信息 */
function setWindowSrc(url) {
    if (!url) {
        return;
    }
    top.$('#winframe').attr("src", url);
}

function postAjaxSubmit(url, fromId) {
    var json = null;
    var options = {
        url: url,
        async : false,
        cache:false,
        type: 'POST',
        data: $("#"+fromId).serialize(),
        success: function (data) {
            json = data;
        }
    };
    $("#"+fromId).ajaxSubmit(options);
    return json;
}

function postAsyncAjax(url, data) {
        var json = null;
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            async : false,
            success : function(msg) {
                json = msg;
            },
            error : function(request) {
                alert("加载超时！");
            }
        });
    return json;
}

/**
 * 页面参数传递
 */
var request = {
    QueryString : function(val) {
        var uri = window.location.search;
        var re = new RegExp("" + val + "\=([^\&\?]*)", "ig");
        return ((uri.match(re)) ? (uri.match(re)[0].substr(val.length + 1))
            : null);
    },
    QueryStrings : function() {
        var uri = window.location.search;
        var re = /\w*\=([^\&\?]*)/ig;
        var retval = [];
        while ((arr = re.exec(uri)) != null)
            retval.push(arr[0]);
        return retval;
    },
    setQuery : function(val1, val2) {
        var a = this.QueryStrings();
        var retval = "";
        var seted = false;
        var re = new RegExp("^" + val1 + "\=([^\&\?]*)$", "ig");
        for (var i = 0; i < a.length; i++) {
            if (re.test(a[i])) {
                seted = true;
                a[i] = val1 + "=" + val2;
            }
        }
        retval = a.join("&");
        return "?" + retval
            + (seted ? "" : (retval ? "&" : "") + val1 + "=" + val2);
    }
}

//String.prototype.format= function(){
//    var args = arguments;
//    return this.replace(/\{(\d+)\}/g,function(s,i){
//        return args[i];
//    });
//}
Date.prototype.Format = function(fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1,
        //月份
        "d+": this.getDate(),
        //日
        "h+": this.getHours(),
        //小时
        "m+": this.getMinutes(),
        //分
        "s+": this.getSeconds(),
        //秒
        "q+": Math.floor((this.getMonth() + 3) / 3),
        //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}
