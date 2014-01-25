												<div title="${dishItem.dishId}" class="tm-mcOrder tm-mcOrderService tm-mcOrderOne tm-mcOrderSelected">
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
                                                        <strong class="tm-mcSum">${dishItem.dishSum}</strong>
                                                    </div>
                                                </div>