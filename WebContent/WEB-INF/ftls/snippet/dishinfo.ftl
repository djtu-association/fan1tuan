		<header class="rst-drawer-header">
            <a class="rst-drawer-close" id="rst_cmt_close">×</a>
            <div class="rst-drawer-dish">
                <h3 title="${dish.name}" class="dish-name">${dish.name}<a class="text text-danger lead"><i class="glyphicon glyphicon-heart-empty"></i> </a>
                </h3>
                <p class="dish-intro">${dish.description}</p>
            </div>
        </header>
        <section class="rst-drawer-rating group" >
            <div class="rating-point"><strong class="point">${dish.avgCommentLevel}</strong><span class="comment">${dish.commentNum}人评价</span></div>
            <ul style="list-style-type:none;margin-left:0px;margin-right:0px;" class="rating-diagram">
            <#if dish.commentNum==0 >
                  <#assign commentNum=1 />
            <#else>
                  <#assign commentNum=dish.commentNum />
            </#if>
                <li><i class="icon-star s5"></i><span style="width: ${78*(commentLevel['5']!'0')?number/commentNum}px;" class="bar"></span>${100*(commentLevel['5']!'0')?number/commentNum}%</li>

                <li><i class="icon-star s4"></i><span style="width: ${78*(commentLevel['4']!'0')?number/commentNum}px;" class="bar"></span>${100*(commentLevel['4']!'0')?number/commentNum}%</li>

                <li><i class="icon-star s3"></i><span style="width: ${78*(commentLevel['3']!'0')?number/commentNum}px;" class="bar"></span>${100*(commentLevel['3']!'0')?number/commentNum}%</li>

                <li><i class="icon-star s2"></i><span style="width: ${78*(commentLevel['2']!'0')?number/commentNum}px;" class="bar"></span>${100*(commentLevel['2']!'0')?number/commentNum}%</li>

                <li><i class="icon-star s1"></i><span style="width: ${78*(commentLevel['1']!'0')?number/commentNum}px;" class="bar"></span>${100*(commentLevel['1']!'0')?number/commentNum}%</li>
            </ul>
        </section>
        <section class="rst-drawer-comment comment_wrap">
            <h4 class="rst-drawer-cheader">用户评价</h4>
            <div style="list-style-type:none;">
            <#list dishComments as dishComment>
            	<li class="rst-drawer-citem">
                    <p class="cmt-info">${dishComment.userName!"匿名"} ${dishComment.date?string("yyyy-MM-dd")}<i class="icon-d-star s${dishComment.commentLevel*2}"></i></p>
                    <p>鸡肉很嫩，虽然是炸鸡但看起来也不算很油，配有一碗米饭，一点沙拉</p>
                </li>
            </#list>
                
                
            </div>
            <p class="rst-drawer-helper hide c_l_t">加载中…</p>
        </section>