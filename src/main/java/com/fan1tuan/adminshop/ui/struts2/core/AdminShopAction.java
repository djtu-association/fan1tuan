package com.fan1tuan.adminshop.ui.struts2.core;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.shop.pojos.ShopClient;
import com.opensymphony.xwork2.Action;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Li He on 2014/12/23.
 *
 */
public class AdminShopAction extends Fan1TuanAction {

    private AdminShopService adminShopService;

    public AdminShopService getAdminShopService() {
        return adminShopService;
    }

    public void setAdminShopService(AdminShopService adminShopService) {
        this.adminShopService = adminShopService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    //-------------- /admin/shop/index.f1t -----------------
    //private int message;

    public String execute(){
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean)session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {


            return Action.SUCCESS;
        } else {
            message = 2; // 需要先登陆

            return "login";
        }

    }



    //------------- /admin/shop/signin.f1t ----------------
    private String username;
    private String password;
    private int message;

    public String signin() {
        ShopClient shopClient = adminShopService.signin(username, password);

        if (shopClient!=null) {
            session.put("SHOP_CLIENT_LOGIN", true);
            Map<String, String> client_cache = new HashMap<String, String>();
            client_cache.put("ID", shopClient.getId());
            client_cache.put("USERNAME", shopClient.getUsername());
            session.put("SHOP_CLIENT", client_cache);

            return Action.SUCCESS;
        } else {
            message = 1; // 用户名或密码错误

            return Action.INPUT;
        }

    }




    //------------- /admin/shop/signup.f1t ----------------
    //private String username;
    //private String password;
    //private int message;

    public String signup() {
        ShopClient shopClient = adminShopService.signup(username, password);

        if (shopClient!=null) {
            session.put("SHOP_CLIENT_LOGIN", true);
            Map<String, String> client_cache = new HashMap<String, String>();
            client_cache.put("ID", shopClient.getId());
            client_cache.put("USERNAME", shopClient.getUsername());
            session.put("SHOP_CLIENT", client_cache);

            return Action.SUCCESS;
        } else {
            message = 1; // 用户名已被占用

            return Action.INPUT;
        }
    }




    //------------- /admin/shop/signout.f1t ----------------

    public String signout() {
        session.put("SHOP_CLIENT_LOGIN", false);
        session.put("SHOP_CLIENT", null);

        return Action.SUCCESS;
    }

}
