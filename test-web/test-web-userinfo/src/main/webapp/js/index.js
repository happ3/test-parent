document.writeln("  <link rel=\"stylesheet\" href=\"/bootstrap/css/bootstrap.min.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/font-awesome/4.4.0/css/font-awesome.min.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/dist/css/AdminLTE.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/dist/css/skins/_all-skins.min.css\">");
document.writeln("  <link rel=\"stylesheet\" href=\"/css/metro.css\">");

document.writeln("  <script src=\"/js/jQuery-2.1.4.min.js\"></script>");
document.writeln("  <script src=\"/bootstrap/js/bootstrap.min.js\"></script>");
document.writeln("  <script src=\"/js/fastclick.min.js\"></script>");
document.writeln("  <script src=\"/dist/js/app.min.js\"></script>");
document.writeln("  <script src=\"/dist/js/demo.js\"></script>");
document.writeln("  <script src=\"/js/jquery.ztree.all-3.5.min.js\"></script>");
document.writeln("  <script src=\"/js/left.js\"></script>");
document.writeln("  <script src=\"/js/bootstrap-tab.js\"></script>");


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
        type: 'post',
        dataType: 'text',
        data: $("#"+fromId).serialize(),
        success: function (data) {
            var json = data;
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