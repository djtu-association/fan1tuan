package com.fan1tuan.adminshop.ui.struts2.core;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.ShopTasteTagDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.shop.pojos.*;
import com.opensymphony.xwork2.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Li He on 2014/12/23.
 *
 */
public class AdminShopAction extends Fan1TuanAction {

    private AdminShopService adminShopService;
    private ShopTasteTagDao shopTasteTagDao;
    private AreaDao areaDao;

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public ShopTasteTagDao getShopTasteTagDao() {
        return shopTasteTagDao;
    }

    public void setShopTasteTagDao(ShopTasteTagDao shopTasteTagDao) {
        this.shopTasteTagDao = shopTasteTagDao;
    }

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

    public ShopClient getShopClient() {
        return shopClient;
    }

    public void setShopClient(ShopClient shopClient) {
        this.shopClient = shopClient;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<ShopTasteTag> getShopTasteTags() {
        return shopTasteTags;
    }

    public void setShopTasteTags(List<ShopTasteTag> shopTasteTags) {
        this.shopTasteTags = shopTasteTags;
    }

    public List<DishTasteTag> getDishTasteTags() {
        return dishTasteTags;
    }

    public void setDishTasteTags(List<DishTasteTag> dishTasteTags) {
        this.dishTasteTags = dishTasteTags;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Map<String, String> getDishTasteMap() {
        return dishTasteMap;
    }

    public void setDishTasteMap(Map<String, String> dishTasteMap) {
        this.dishTasteMap = dishTasteMap;
    }

    //-------------- /admin/shop/index.f1t -----------------
    //private int message;
    private ShopClient shopClient;
    private Shop shop;
    private List<ShopTasteTag> shopTasteTags;
    private List<Area> areas;
    private List<DishTasteTag> dishTasteTags;
    private List<Dish> dishes;
    private Map<String, String> dishTasteMap;

    public String execute(){
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean)session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>)session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            if (shopClient.getShopId() != null && !"".equals(shopClient.getShopId())) {
                shop = adminShopService.fetchShop(shopClient.getId(), shopClient.getShopId());
                dishTasteTags = adminShopService.fetchDishTasteTags(shopClient.getId(), shopClient.getShopId());
                dishes = adminShopService.fetchDishes(shopClient.getId(), shopClient.getShopId());

                dishTasteMap = new HashMap<String, String>();
                for (DishTasteTag tag: dishTasteTags) {
                    dishTasteMap.put(tag.getId(), tag.getName());
                }
            } else {
                shop = null;
            }

            shopTasteTags = shopTasteTagDao.findAll();
            areas = areaDao.findAll();

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
