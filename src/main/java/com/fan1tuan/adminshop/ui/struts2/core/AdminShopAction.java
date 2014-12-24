package com.fan1tuan.adminshop.ui.struts2.core;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.AreaDao;
import com.fan1tuan.general.dao.impl.OrderDao;
import com.fan1tuan.general.dao.impl.ShopTasteTagDao;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.shop.pojos.*;
import com.mongodb.WriteResult;
import com.opensymphony.xwork2.Action;

import java.util.Date;
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
    private OrderDao orderDao;

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

    public List<Order> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(List<Order> activeOrders) {
        this.activeOrders = activeOrders;
    }

    public List<Order> getNonactiveOrders() {
        return nonactiveOrders;
    }

    public void setNonactiveOrders(List<Order> nonactiveOrders) {
        this.nonactiveOrders = nonactiveOrders;
    }

    public Map<String, Integer> getDishTagData() {
        return dishTagData;
    }

    public void setDishTagData(Map<String, Integer> dishTagData) {
        this.dishTagData = dishTagData;
    }

    public Map<String, Integer> getOrderData() {
        return orderData;
    }

    public void setOrderData(Map<String, Integer> orderData) {
        this.orderData = orderData;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
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
    private List<Order> activeOrders;
    private List<Order> nonactiveOrders;

    private Map<String, Integer> dishTagData;
    private Map<String, Integer> orderData;
    private Date today;

    public String execute(){
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean)session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>)session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            if (shopClient.getShopId() != null && !"".equals(shopClient.getShopId())) {
                shop = adminShopService.fetchShop(shopClient.getId(), shopClient.getShopId());
                dishTasteTags = adminShopService.fetchDishTasteTags(shopClient.getId(), shopClient.getShopId());
                dishes = adminShopService.fetchDishes(shopClient.getId(), shopClient.getShopId());
                activeOrders = adminShopService.fetchActiveOrders(shopClient.getId(), shopClient.getShopId());
                nonactiveOrders = adminShopService.fetchNonActiveOrders(shopClient.getId(), shopClient.getShopId());

                dishTasteMap = new HashMap<String, String>();
                for (DishTasteTag tag: dishTasteTags) {
                    dishTasteMap.put(tag.getId(), tag.getName());
                }

                dishTagData = new HashMap<String, Integer>();
                for (Dish dish: dishes) {
                    String tempId = dish.getDishTasteTagId();
                    if (dishTagData.get(tempId)==null) {
                        dishTagData.put(tempId, 1);
                    } else {
                        int num = dishTagData.get(tempId);
                        dishTagData.put(tempId, ++num);
                    }
                }

                orderData = new HashMap<String, Integer>();
                for (Order order: activeOrders) {
                    if(orderData.get(order.getStatus())==null) {
                        orderData.put(order.getStatus()+"", 1);
                    } else {
                        int num = orderData.get(order.getStatus());
                        orderData.put(order.getStatus()+"", ++num);
                    }
                }
                today = new Date();
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


    //------------ /admin/shop/fetchOrder.f1t
    private String orderId;

    private Order order;
    public String fetchOrder(){
        //为了图简单，1未验证用户登陆身份 2未验证订单是否属于用户的店铺
        order = orderDao.findOneById(orderId);

        return Action.SUCCESS;
    }

    //------------ /admin/shop/updateOrder.f1t
    //private String orderId;

    public String updateOrder() {
        WriteResult wr = orderDao.updateFirstByParams(CriteriaWrapper.instance().is("id", orderId), UpdateWrapper.instance().inc("status", 1));

        if (wr.getN()>0) {
            makeFlag(true);
        } else {
            makeFlag(false);
        }

        return Action.SUCCESS;
    }

}
