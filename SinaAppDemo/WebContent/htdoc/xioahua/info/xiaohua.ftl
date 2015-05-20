<!doctype html>
<html>
<head>
  <head>
  <title>你不笑我的错</title>
    <meta charset="UTF-8"/>
 </head>
</head>
<body>
<#include "/htdoc/xioahua/info/guanzhu.ftl" />


<#list xhList as b>
	<blockquote style="padding: 15px; margin: 0px; color: rgb(51, 51, 51); font-family: 微软雅黑; font-size: 12px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 1; word-spacing: 0px; -webkit-text-stroke-width: 0px; border: 1px solid rgb(0, 187, 236);">
	    <p class="ue_t" style="padding: 0px; margin: 0px;">
	        	${(b.content)!''}
	    </p>
	</blockquote>
	<br>
</#list> 
<br>
<#include "/htdoc/xioahua/info/ruhrguanzhu.ftl" />
</body>
</html>
