<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<style type="text/css">
		html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,abbr,address,cite,code,del,dfn,em,img,ins,kbd,q,samp,small,strong,sub,sup,var,b,i,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,ruby,section,summary,time,mark,audio,video{margin:0;padding:0;border:0;font-weight:inherit;font-style:inherit;font-family:inherit;font-size:100%;vertical-align:baseline}
		html{font-family:'Open Sans',sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%}''
		html{background:#f0f4f7;-webkit-tap-highlight-color:rgba(0,0,0,0);-webkit-tap-highlight-color:transparent;font-size:18px}
		body{   
						background: #f1f1f1;
					    min-width: 0;
					    color: #444;
					    font-family: "Open Sans",sans-serif;
					    font-size: 0.77rem;
					    line-height: 1.4em;}
		form,h1{ 
						width: 17.7rem;
					    box-shadow: 0 0.05rem 0.16rem rgba(0,0,0,.13);
					    margin:auto;
					    margin-top: 0.55rem;
					    padding: 1.44rem 1.33rem 1.55rem;
					    font-weight: 400;
					    overflow: hidden;
					    background: #17aad5;
    					color: #fff;
   					    border-radius: 30px;}
		h1{
						   padding:auto;
						    font-size: 1.6rem;
						    text-align: center;
						    vertical-align: middle;
						    }
		button{	
							background: #fff;
    						color: #17aad5;
    						border-radius: 30px;
			}
		input{background-color: rgb(251, 251, 251);
					  font-size: 1.33rem;
   					  width: 100%;
    				  padding: 0.16rem;
    				  margin: 0.11rem 0.33rem 0.88rem 0;
    				  }
</style>
</head>
<body>
    <h1>预约后台管理系统登陆</h1>
	<form method="post" action="login">	
			<p>
				<label for="user_login">用户名<br>
				<input type="text" name="username" id="user_login" class="input" value="" size="20"></label>
			</p>
			<p>
				<label for="user_pass">密码<br>
				<input type="password" name="password" id="user_pass" class="input" value="" size="20"></label>
			</p>
				<p>	<label for="passcode">验证码<br>
				<input  name="code" id="user_pass" class="input" value="" size="20"></label>
				<img id="img" alt=""  src="${pageContext.request.contextPath}/certificate">
				</p>
			<p>
				<button type="submit">提交</button>
			</p>
	</form>
</body>
</html>