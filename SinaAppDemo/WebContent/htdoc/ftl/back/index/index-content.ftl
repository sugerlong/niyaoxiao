 <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>一些常用模块</small></div>
    </div>

    
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-1'}">最近发表<span class="am-icon-chevron-down am-fr" ></span></div>
          <div class="am-panel-bd am-collapse am-in am-cf" id="collapse-panel-1">
            <ul class="am-comments-list admin-content-comment">
              <li class="am-comment">
                <a href="#"><img src="http://amui.qiniudn.com/bw-2014-06-19.jpg?imageView/1/w/96/h/96" alt="" class="am-comment-avatar" width="48" height="48"></a>
                <div class="am-comment-main">
                  <header class="am-comment-hd">
                    <div class="am-comment-meta"><a href="#" class="am-comment-author">某人</a> 发表于 <time>2014-7-12 15:30</time></div>
                  </header>
                  <div class="am-comment-bd"><p>遵循 “移动优先（Mobile First）”、“渐进增强（Progressive enhancement）”的理念，可先从移动设备开始开发网站，逐步在扩展的更大屏幕的设备上，专注于最重要的内容和交互，很好。</p>
                  </div>
                </div>
              </li>

              <li class="am-comment">
                <a href="#"><img src="http://amui.qiniudn.com/bw-2014-06-19.jpg?imageView/1/w/96/h/96" alt="" class="am-comment-avatar" width="48" height="48"></a>
                <div class="am-comment-main">
                  <header class="am-comment-hd">
                    <div class="am-comment-meta"><a href="#" class="am-comment-author">某人</a> 发表于 <time>2014-7-12 15:30</time></div>
                  </header>
                  <div class="am-comment-bd"><p>有效减少为兼容旧浏览器的臃肿代码；基于 CSS3 的交互效果，平滑、高效。AMUI专注于现代浏览器（支持HTML5），不再为过时的浏览器耗费资源，为更有价值的用户提高更好的体验。</p>
                  </div>
                </div>
              </li>

            </ul>
            <ul class="am-pagination am-fr admin-content-pagination">
              <li class="am-disabled"><a href="#">&laquo;</a></li>
              <li class="am-active"><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#">&raquo;</a></li>
            </ul>
          </div>
        </div>
        
        
        
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">用户列表<span class="am-icon-chevron-down am-fr" ></span></div>
          <div class="am-panel-bd am-collapse am-in am-cf" id="collapse-panel-2">
		            <table class="am-table am-table-bd am-table-striped admin-content-table">
			          <thead>
				          <tr>
				            <th>用户id</th>
					        <th>用户名称</th>
					        <th>真实姓名</th>
					        <th>管理员</th>
					        <th>操作</th>
				          </tr>
			          </thead>
			          <tbody>
			         		<#list userList as b>
							    <tr>
						            <td>${(b.id)!''}</td>
						            <td>${(b.account)!''}</td>
						            <td>${(b.sname)!''}</td>
						           	<td><span class="am-badge am-badge-success">+20</span></td>
						            <td>
							              <div class="am-dropdown" data-am-dropdown>
							                <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
							                <ul class="am-dropdown-content">
							                  <li><a href="#">1. 编辑</a></li>
							                  <li><a href="#">2. 下载</a></li>
							                  <li><a href="#">3. 删除</a></li>
							                </ul>
							              </div>
						            </td>
						        </tr>	
						    </#list> 
			          </tbody>
		        </table>
            <ul class="am-pagination am-fr admin-content-pagination">
              <li class="am-disabled"><a href="#">&laquo;</a></li>
              <li class="am-active"><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#">&raquo;</a></li>
            </ul>
          </div>
        </div>
        
      </div>
    </div>
  </div>
  <!-- content end -->