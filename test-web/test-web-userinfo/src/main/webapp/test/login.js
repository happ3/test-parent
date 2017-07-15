var obj = DDLogin({
     id:"login_container",//这里需要你在自己的页面定义一个HTML标签并设置id，例如<div id="login_container"></div>或<span id="login_container"></span>
     goto: "",
     style: "",
     href: "",
     width : "300px",
     height: "300px"
 });


var hanndleMessage = function (event) {
    var loginTmpCode = event.data; //拿到loginTmpCode后就可以在这里构造跳转链接进行跳转了
    var origin = event.origin;
};
if (typeof window.addEventListener != 'undefined') {
    window.addEventListener('message', hanndleMessage, false);
} else if (typeof window.attachEvent != 'undefined') {
    window.attachEvent('onmessage', hanndleMessage);
}



<span>
< img src="../img/btn.png"  onclick="ISLogin('<%=id%>','<%=type%>')"/>
</span>


ISLogin(id,type){
	if(type==?){
		window.localhost.href="???id="+id+"&type="+type;
	}
	if(type==?){
		window.localhost.href="???id="+id+"&type="+type;
	}
	if(type==?){
		window.localhost.href="???id="+id+"&type="+type;
	}
}
