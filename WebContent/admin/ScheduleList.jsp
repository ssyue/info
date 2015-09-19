<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理平台</title>
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
		table,h1{ 
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
	    table{
	    	    		table-layout: fixed;
    					width: 100%;
	    				font-size:1em;
	    				display: block;

	    		}
		button{	
							background: #fff;
    						color: #17aad5;
    						border-radius: 30px;
			}
		#prev{
					float:left;
		}
		#next{
					float:right;
			}
</style>
</head>
<body>
		<h1>所有信息
		</h1>
		<table id=¨dash¨>
				<tr>
						<td>姓名</td>
						<td>手机号码</td>
						<td>身份证号</td>
						<td>预约时间</td>
				</tr>
				<c:forEach items="${ requestScope.list}" var="res">
						<tr>
						<td>${res.name }</td>
						<td>${res.phoneNum }</td>
						<td>${res.IDNum}</td>
						<td>${res.date}</td>
						</tr>
				</c:forEach>		
		</table>
		
		<h1>
			<button type = "button"   class = "prev"  id = "prev">
					上一页
			</button>
			<button type = "button"  class = "next"   id = "next">
					下一页
			</button>
		</h1>
		<script type="text/javascript">
				var prev  =  document.getElementById("prev");
				var next  =  document.getElementById("next");
				var pageIndex=${requestScope.page};
				
				prev.addEventListener('click',
						function(e){						
							if(pageIndex >=2)
							{	pageIndex--;  };
							window.submit();
							console.log( " page -- "+pageIndex);
				},false);
				
				next.addEventListener('click',
						function(e){					
							pageIndex++;
							window.submit();
							console.log(  " page ++ "+pageIndex);
				},false);
				
				
				function createXHR(){
						var xhr = null ;
						if(window.XMLHttpRequest){
							xhr = new XMLHttpRequest();
						}else if(window.ActiveXobject){
							xhr = new ActiveXobject('Mircosoft.XMLHttp');
						}
						return xhr;
				}	
				
				var xhr = createXHR();

				function stop () {
							xhr.abort();
				}
				
				function submit(){
					console.log(location.pathname);
						location.pathname="info/ScheduleList";
						console.log(location.pathname);
// 						location.search = "?page="+pageIndex;
						console.log(location.search);
 						 location.replace("${pageContext.request.contextPath}/ScheduleList?page="+pageIndex);
						//location.href = location.host + "/info/ScheduleList?page="+pageIndex;
/*						xhr.open('POST','http://localhost:8080/info/ScheduleList',true);
						
						xhr.onreadystatechange = function(){
							if(this.readyState == 4){
								var str = "";
								str = this.responseText;							
							}
						}
						xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
						xhr.send('page='+pageIndex);		
						
						return false; */
				}
		</script>
</body>
</html>