								<div title="${shopItem.shopId}" class="tm-mcBundle tm-mcBundleB">
                                    <div class="tm-mcBundleHeader">
                                        <div class="tm-mcTitle"><span class="label label-info" style="font-size: 15px" title="">${shopItem.shopName}</span></div>
                                        <div class="tm-mcCost"><strong class="tm-mcPrice">${shopItem.sumPrice}</strong></div>
                                    </div>
                                    <div class="tm-mcBundleList">
                                        <div class="tm-mcMainOne" id="tmcMain0">
                                            <div class="tm-mcMainHead">
                                                <div class="tm-mcMainHeader">
                                                    <span class="tm-mcMjzPromo">*元起送</span>
                                                </div>
                                            </div>
                                            <div class="tm-mcMainList">
                                                <div class="tm-mcOrder tm-mcOrderService tm-mcOrderOne tm-mcOrderSelected">
                                                    <div class="tm-mcItem"><a target="_blank" class="tm-mcPic">
                                                        <img style="padding-left:3px" height="50" src="../res/images/shop-image.jpeg"></a>
                                                    </div>
                                                    <div class="tm-mcSku" style="padding-left: 5px">
                                                        <p class="lead" style="font-size: 15px" title="">${dishItem.dishName}</p>
                                                    </div>
                                                    <div class="tm-mcAmount">
                                                        <a hidefocus="true" class="tm-mcMinus tm-mcMinusOff" href="javascript:void(0)"><s></s></a>
                                                        <span class="tm-mcQuantity">${dishItem.number}</span>
                                                        <a hidefocus="true" class="tm-mcPlus" href="javascript:void(0)"><s></s><b></b></a>
                                                    </div>
                                                    <div class="tm-mcCost">
                                                        <a data-tmc="del" title="删除" class="tm-mcDel"></a><br>
                                                        <strong>${dishItem.dishSum}</strong>
                                                    </div>
                                                </div>

                                                <div data-order="0_0" class="tm-mcService tm-mcServiceSelected"
                                                     id="tmcOrderService0_0">
                                                    <table>
                                                        <tbody>
                                                        <tr>
                                                            <td class="tm-mcChk">&nbsp;</td>
                                                            <td class="tm-mcServList">
                                                                <i class="icon-rst-badge online-payment"></i>在线付款
                                                                <i class="icon-rst-badge new-restaurant"></i>新店
                                                                <i class="icon-rst-badge invoice"></i>发票
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>