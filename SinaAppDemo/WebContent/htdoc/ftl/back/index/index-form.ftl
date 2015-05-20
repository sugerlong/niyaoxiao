<!doctype html>
<html class="no-js">
<head>
  <title>Amaze后台管理系统模板HTML表单页面 - JS代码网</title>
  <meta name="description" content="这是一个form页面">
  <#include "/htdoc/ftl/back/index/index-common.ftl" />
  
</head>
<body>
<#include "/htdoc/ftl/back/index/index-top.ftl" />

<div class="am-cf admin-main">
<#include "/htdoc/ftl/back/index/index-left.ftl" />

<!-- content start -->
<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">笑话</strong> / <small>form</small></div>
  </div>

  <div class="am-tabs am-margin" data-am-tabs>
    <ul class="am-tabs-nav am-nav am-nav-tabs">
      <li class="am-active"><a href="#tab1">新增</a></li>
    </ul>

    <div class="am-tabs-bd">
        <form class="am-form" id="addXiaohuaForm" action="addArticle.action" method="post">
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              文章标题
            </div>
            <div class="am-u-sm-4">
              <input type="text" class="am-input-sm" id = "title" name = "xiaoHua.title"> 
            </div>
            <div class="am-u-sm-6">*必填</div>
          </div>
			 
        	<div class="am-g am-margin-top">
			  	  <div class="am-u-sm-2 am-text-right">笑话状态</div>
			      <div class="am-u-sm-10">
			        <select style="width:100px" id = "status" name = "xiaoHua.status">
			          <option value="1">正式</option>
			          <option value="9">草稿</option>
			        </select>
			      </div>
			</div>
          <!--<div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              信息来源
            </div>
            <div class="am-u-sm-4">
              <input type="text" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">选填</div>
          </div>
          <div class="am-g am-margin-top">
            <div class="am-u-sm-2 am-text-right">
              内容摘要
            </div>
            <div class="am-u-sm-4">
              <input type="text" class="am-input-sm">
            </div>
            <div class="am-u-sm-6">不填写则自动截取内容前255字符</div>
          </div>
-->
          <div class="am-g am-margin-top-sm">
            <div class="am-u-sm-2 am-text-right">
              内容描述
            </div>
            <div class="am-u-sm-10">
              <script id="editor" name = "xiaoHua.content" type="text/plain" style="width:600px;height:400px;"></script>
            </div>
          </div>



	<div class="am-margin">
	    <button type="button"  onclick="saveAdd()" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
	    <button type="button" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
  	</div>

        </form>
      			
    </div>
  </div>
</div>
<!-- content end -->

</div>


<#include "/htdoc/ftl/back/index/footer.ftl" />
 <script type="text/javascript" charset="utf-8" src="/htdoc/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/htdoc/ueditor/ueditor.all.min.js"> </script>
  <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }
</script>
<script type="text/javascript">

function saveAdd() {
	alert("11");
    $("#addXiaohuaForm").submit();
}
</script>
</body>
</html>
