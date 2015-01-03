<#list orders as order>
<div class="row-fluid">
    <div class="span12">
        <div class="flowstep">
            <ol class="flowstep-5" style="list-style:none">
                <li class="step-first">
                    <div class="<#if order.status < 1>step-sub-done<#elseif order.status==1>step-cur<#else>step-done</#if>">
                        <div class="step-name">确认饿单</div>
                        <div class="step-no"><#if order.status == 1>1</#if></div>

                    </div>
                </li>
                <li>
                    <div class="<#if order.status < 2>step-sub-done<#elseif order.status==2>step-cur<#else>step-done</#if>">
                        <div class="step-name">店家受理</div>
                        <div class="step-no"><#if order.status == 2>2</#if></div>

                    </div>
                </li>

                <li>
                    <div class="<#if order.status < 3>step-sub-done<#elseif order.status==3>step-cur<#else>step-done</#if>">
                        <div class="step-name">美味派送</div>
                        <div class="step-no"><#if order.status == 3>3</#if></div>

                    </div>
                </li>
                <li class="step-last">
                    <div class="<#if order.status < 4>step-sub-done<#elseif order.status==4>step-cur<#else>step-done</#if>">
                        <div class="step-name">买家收货</div>
                        <div class="step-no"><#if order.status == 4>4</#if></div>
                    </div>
                </li>
            </ol>
        </div>
    </div>
</div>
<div class="row-fluid">
    <div class="span12">
        <table class="table table-hover">
            <tr>
                <th colspan="4" title="订单编号:${order.orderNo}"><span class="lead"
                                                                    style="font-size:13px">订单编号:${order.orderNo}</span>
                </th>
                <th><a class="btn btn-info btn-xs" href="/shop/index.f1t?shopId=${order.shopId}">${order.shopName}</a>
                </th>
                <th>￥${order.price}</th>
            </tr>
            <#list order.dishItems as dishItem>
                <tr>
                    <td style="width: 50px">
                        <a href="#"><img style="height: 32px;width: 32px" src="/res/avatar/dish/${dishItem.dishImage}"></a>
                    </td>
                    <td colspan="2">
                        <span class="text-primary lead" style="font-size: 17px">${dishItem.dishName}</span><br>
                    </td>
                    <td colspan="1">
                        <span class="lead" style="font-size: 17px">￥${dishItem.dishPrice}</span>
                    </td>
                    <td colspan="1">
                        <span class="lead" style="font-size: 17px">${dishItem.number}</span>
                    </td>
                    <td style="text-align: center;vertical-align: baseline" colspan="1">
                        <strong class="lead text-info" style="font-size: 17px">￥${dishItem.dishSum}</strong><br>
                    </td>
                </tr>
            </#list>

            <tr>
                <td colspan="2">
                    <span class="text"><span class="label label-primary">备注</span>&nbsp;&nbsp;&nbsp;${order.userRemark}</span>
                </td>
                <td colspan="3">
                    <span class="text"><span
                            class="label label-primary">地址</span>&nbsp;&nbsp;&nbsp;${order.address}</span>
                </td>
                <td style="text-align: center;vertical-align: baseline">
                    <span class="label label-info">${order.deliveryTime?string("HH:mm")}</span>
                </td>
            </tr>

        </table>
    </div>
</div>
</div>
<hr>
</#list>