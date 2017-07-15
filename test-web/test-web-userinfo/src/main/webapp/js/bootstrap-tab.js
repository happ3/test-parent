$(function() {
	$(".nav-tabs").on("click", "[tabclose]", function(e) {
		id = $(this).attr("tabclose");
		closeTab(id);
	});
	$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
		console.log($(e.target));
	})
});

iFrameHeightv = function (str) {
	var ifm = document.getElementById(str);
	var h = $("#"+str).get(0).contentWindow.document.body.clientHeight;
	if(h<730)h=805;
	ifm.height = h;
}

var addTab = function(obj) {
	var str = obj.id;
	var id = "tab_" + obj.id;
	$(".active").removeClass("active");
	//如果TAB不存在，创建一个新的TAB
	if (!$("#" + id)[0]) {
		//固定TAB中IFRAME高度
		//创建新TAB的title
		title = '<li  id="tab_' + id + '" ><a href="#' + id + '" aria-controls="'
		+ id + '" role="tab" data-toggle="tab">' + obj.title;
		//是否允许关闭
		if (!obj.close) {
			title += ' <i class="tabclose"  tabclose="' + id + '"><span class="glyphicon glyphicon-remove" style="cursor: pointer;left: 10px;"></span></i>';
		}
		title += '</a></li>';
		//是否指定TAB内容
		if (obj.content) {
			 content = '<div  class="tab-pane" id="' + id + '">' + obj.content + '</div>';
		} else { //没有内容，使用IFRAME打开链接
			  content = '<div  height="100%" width="100%" class="tab-pane" style="background-color: #fff;" id="' + id + '"><iframe src="' + obj.url + '" width="100%" height="805" '+
              ' id="contentframe'+str+'" name="contentframe" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes" '+
			  'onLoad="iFrameHeightv(this.id)"></iframe></div>';
			  }
		//加入TABS
		$(".nav-tabs").append(title);
		$(".tab-content").append(content);
	}
	//激活TAB
	$("#tab_" + id).addClass('active');
	$("#" + id).addClass("active");
};

var closeTab = function(id) {
	//如果关闭的是当前激活的TAB，激活他的前一个TAB
	if ($("li.active").attr('id') == "tab_" + id) {
		$("#tab_" + id).prev().addClass('active');
		$("#" + id).prev().addClass('active');
	}
	//关闭TAB
	$("#tab_" + id).remove();
	$("#" + id).remove();
};



