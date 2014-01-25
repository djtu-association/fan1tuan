/**
 * Created by Administrator on 13-10-23.
 */
$(document).ready()
{
    //config the messenger
    $._messengerDefaults = {
        extraClasses: 'messenger-fixed messenger-theme-future messenger-on-bottom'
    }

    //-----------------------------------adminUser.html--------
    //选择性别单选框触发事件
    $('.labGender').click(function(){
        alert("1:男，0女："+"结果："+this.value);
        alert("ajax refresh the table");
    });

    //点击选择大学下拉列表触发事件
    $('#selCollage').change(function(){
        alert(this.value);
        alert("ajax refresh the table");
    });

    //删除对话框
    $('.btnDel').click(function(){
        //$('#delModal').modal('toggle');
        /*
        $.globalMessenger().post({
            message: 'There was an explosion while processing your request.',
            type: 'success',
            showCloseButton: true
        });
        */

        msg = $.globalMessenger()["do"](
            {
                actions:{
                    "确定删除":{
                        label: '确定删除',
                        phrase: 'Retrying TIME',
                        auto: true,
                        delay: 10,
                        action: function() {
                            alert("success");
                            $.ajax({
                                type:"GET",
                                url:"",
                                data:"{}",
                                contentType: "application/json; charset=utf-8",//发送信息至服务器时内容编码类型。
                                dataType: "json",//预期服务器返回的数据类型,xml,json,html,script,text
                                success:function(data){

                                },
                                error:function(msg){

                                }
                            });
                            alert("end");
                            return msg.cancel();
                        }
                    },
                    "取消":{
                        label: '取消',
                        action: function() {
                            return msg.cancel();
                        }
                    }
                },
                successMessage:"确定是否删除"
            }
        );
    });

    function checkUserHistoryOrder(userid)
    {
        alert("js跳转");
        window.location='';
    }
}
