package com.fan1tuan.adminshop.ui.struts2.core;

import com.fan1tuan.adminshop.business.AdminShopService;
import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.fan1tuan.general.dao.impl.*;
import com.fan1tuan.general.pojos.Area;
import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.Constants;
import com.fan1tuan.general.util.UUIDGenerator;
import com.fan1tuan.order.pojos.Order;
import com.fan1tuan.order.util.SystemOutEntity;
import com.fan1tuan.shop.pojos.*;
import com.mongodb.WriteResult;
import com.opensymphony.xwork2.Action;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Li He on 2014/12/23.
 *
 */
public class AdminShopAction extends Fan1TuanAction {

    private AdminShopService adminShopService;
    private ShopTasteTagDao shopTasteTagDao;
    private AreaDao areaDao;
    private OrderDao orderDao;
    private DishTasteTagDao dishTasteTagDao;
    private DishDao dishDao;

    public Map<String, Integer> getOrderActivity() {
        return orderActivity;
    }

    public void setOrderActivity(Map<String, Integer> orderActivity) {
        this.orderActivity = orderActivity;
    }

    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public File getAvatar() {
        return avatar;
    }

    public DishTasteTagDao getDishTasteTagDao() {
        return dishTasteTagDao;
    }

    public void setDishTasteTagDao(DishTasteTagDao dishTasteTagDao) {
        this.dishTasteTagDao = dishTasteTagDao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }

    public String getAvatarFileName() {
        return avatarFileName;
    }

    public void setAvatarFileName(String avatarFileName) {
        this.avatarFileName = avatarFileName;
    }

    public String getAvatarContentType() {
        return avatarContentType;
    }

    public void setAvatarContentType(String avatarContentType) {
        this.avatarContentType = avatarContentType;
    }

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

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getShopTasteTagIds() {
        return shopTasteTagIds;
    }

    public void setShopTasteTagIds(ArrayList<String> shopTasteTagIds) {
        this.shopTasteTagIds = shopTasteTagIds;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDishTasteTagId() {
        return dishTasteTagId;
    }

    public void setDishTasteTagId(String dishTasteTagId) {
        this.dishTasteTagId = dishTasteTagId;
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
    private Map<String, Integer> orderActivity;
    private Date today;

    public String execute() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            if (shopClient.getShopId() != null && !"".equals(shopClient.getShopId())) {
                shop = adminShopService.fetchShop(shopClient.getId(), shopClient.getShopId());
                dishTasteTags = adminShopService.fetchDishTasteTags(shopClient.getId(), shopClient.getShopId());
                dishes = adminShopService.fetchDishes(shopClient.getId(), shopClient.getShopId());
                activeOrders = adminShopService.fetchActiveOrders(shopClient.getId(), shopClient.getShopId());
                nonactiveOrders = adminShopService.fetchNonActiveOrders(shopClient.getId(), shopClient.getShopId());
                dishTasteMap = new HashMap<String, String>();
                for (DishTasteTag tag : dishTasteTags) {
                    dishTasteMap.put(tag.getId(), tag.getName());
                }

                dishTagData = new HashMap<String, Integer>();
                for (Dish dish : dishes) {
                    String tempId = dish.getDishTasteTagId();
                    if (dishTagData.get(tempId) == null) {
                        dishTagData.put(tempId, 1);
                    } else {
                        int num = dishTagData.get(tempId);
                        dishTagData.put(tempId, ++num);
                    }
                }

                orderData = new HashMap<String, Integer>();
                for (Order order : activeOrders) {
                    if (orderData.get(order.getStatus()+"") == null) {
                        orderData.put(order.getStatus() + "", 1);
                    } else {
                        int num = orderData.get(order.getStatus()+"");
                        orderData.put(order.getStatus() + "", ++num);
                    }
                }

                today = new Date();
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(today);
                gc.set(Calendar.DAY_OF_MONTH, 1);
                gc.set(Calendar.DATE, -1);
                int days = gc.get(Calendar.DAY_OF_MONTH);
                gc.setTime(today);
                gc.set(Calendar.MINUTE, 0);
                gc.set(Calendar.HOUR, 0);
                gc.set(Calendar.SECOND, 0);
                gc.add(Calendar.DATE, -6);
                Date startDate = gc.getTime();

                orderActivity = new HashMap<String, Integer>();
                orderActivity.put("0", 0);
                orderActivity.put("1", 0);
                orderActivity.put("2", 0);
                orderActivity.put("3", 0);
                orderActivity.put("4", 0);
                orderActivity.put("5", 0);
                orderActivity.put("6", 0);
                List<Order> tempOrders = orderDao.findByParams(CriteriaWrapper.instance().is("shopId", shop.getId()).gte("date", startDate));
                for(Order temp: tempOrders) {
                    //System.out.println(temp.getDate());
                    int keyInt = (today.getDate() - temp.getDate().getDate());
                    if(keyInt<0) {
                        keyInt=days-temp.getDate().getDate()+today.getDate()+1;
                    }
                    String key = keyInt+"";
                    orderActivity.put(key, orderActivity.get(key) + 1);
                    //System.out.println("key = "+key+", value="+orderActivity.get(key));
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

        if (shopClient != null) {
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

        if (shopClient != null) {
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

    public String fetchOrder() {
        //为了图简单，1未验证用户登陆身份 2未验证订单是否属于用户的店铺
        order = orderDao.findOneById(orderId);

        return Action.SUCCESS;
    }

    //------------ /admin/shop/updateOrder.f1t
    //private String orderId;

    public String updateOrder() {

        if (orderDao.findOneById(orderId).getStatus() >= Constants.OrderStatus.SHOP_DELIVERY.ordinal()) {
            makeFlag(false);

            return Action.SUCCESS;
        }

        WriteResult wr = orderDao.updateFirstByParams(CriteriaWrapper.instance().is("id", orderId), UpdateWrapper.instance().inc("status", 1));

        if (wr.getN() > 0) {
            flag = makeFlag(true);
        } else {
            flag = makeFlag(false);
        }

        return Action.SUCCESS;
    }

    //------------ /admin/shop/declineOrder.f1t
    //private String orderId;

    public String declineOrder() {
        if (orderDao.findOneById(orderId).getStatus() >= Constants.OrderStatus.SHOP_ACCEPT.ordinal()) {
            makeFlag(false);

            return Action.SUCCESS;
        }

        WriteResult wr = orderDao.updateFirstByParams(CriteriaWrapper.instance().is("id", orderId), UpdateWrapper.instance().set("status", Constants.OrderStatus.SHOP_DECLINE.ordinal()));

        if (wr.getN() > 0) {
            flag = makeFlag(true);
        } else {
            flag = makeFlag(false);
        }

        return Action.SUCCESS;
    }

    //------------ /admin/shop/fetchActiveOrders.f1t
    //private List<Order> activeOrders;

    public String fetchActiveOrders() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            activeOrders = adminShopService.fetchActiveOrders(shopClient.getId(), shopClient.getShopId());

            flag = makeFlag(true);
        } else {
            flag = makeFlag(false);
        }

        return Action.SUCCESS;
    }

    //------------ /admin/shop/fetchNonActiveOrders.f1t
    //private List<Order> nonactiveOrders;

    public String fetchNonActiveOrders() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            nonactiveOrders = adminShopService.fetchNonActiveOrders(shopClient.getId(), shopClient.getShopId());

            flag = makeFlag(true);
        } else {
            flag = makeFlag(false);
        }

        return Action.SUCCESS;
    }

    //------------ /admin/shop/changePassword.f1t
    //private String password;
    private String newPassword;

    public String changePassword() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            flag = makeFlag(adminShopService.changePassword(shopClient.getId(), password, newPassword));
        } else {
            flag = makeFlag(false);
        }

        return Action.SUCCESS;
    }

    //------------ /admin/shop/updateShop.f1t
    private String name;
    private ArrayList<String> shopTasteTagIds;
    private int type;
    private double deliveryCharge;
    private String address;
    private String areaId;
    private String cellphone;
    private String openTime;
    private String closeTime;
    private String announcement;
    private String description;

    private File avatar;
    private String avatarFileName;
    private String avatarContentType;

    public String updateShop() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            Shop shop;

            if (shopClient.getShopId() == null || "".equals(shopClient.getShopId())) {
                shop = new Shop();
                shop.setRankTagIds(new ArrayList<String>());
                shop.setShopAffairTagIds(new ArrayList<String>());
                shop.setOrderType(Constants.OrderType.ONLINE.ordinal());
                shop.setPopularity(0);
                shop.setSaleVolume(0);
                shop.setAvgDeliveryTime(0);
                shop.setAvgPersonCost(0);
                shop.setDishRecs(new ArrayList<DishRec>());
                shop.setShopSales(new ArrayList<ShopSale>());
                shop.setOpen(true);
                shop.setCommentNum(0);
                shop.setCommentLevel(0);
                shop.setAvgCommentLevel(0);
                shop.setCreateTime(new Date());
                shop.setAvatar("000.jpeg");
            } else {
                shop = adminShopService.fetchShop(shopClient.getId(), shopClient.getShopId());
            }

            shop.setName(name);
            if (shopTasteTagIds == null) {
                shopTasteTagIds = new ArrayList<String>();
            }
            shop.setShopTasteTagIds(shopTasteTagIds);
            shop.setType(type);
            shop.setAnnouncement(announcement);
            shop.setDescription(description);
            shop.setDeliveryCharge(deliveryCharge);
            shop.setAddress(address);
            if (areaId != null && !"".equals(areaId) && !"default".equals(areaId)) {
                Area tempArea = areaDao.findOneById(areaId);
                shop.setLocation(new double[]{tempArea.getLongtitude(), tempArea.getLatitude()});
            }
            shop.setCellphone(cellphone);
            shop.setTelephone(cellphone);

            try {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");

                shop.setOpenTime(format.parse(openTime));
                shop.setCloseTime(format.parse(closeTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }


            if (avatar != null) {
                String realPath = ServletActionContext.getServletContext().getRealPath("/res/avatar/shop");
                String fileName = UUIDGenerator.generateUUID() + ".jpeg";
                File saveFile = new File(new File(realPath), fileName);
                try {
                    FileUtils.copyFile(avatar, saveFile);
                    shop.setAvatar(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            adminShopService.saveShop(shopClient.getId(), shop);

            return Action.SUCCESS;
        } else {
            return "login";
        }
    }

    //------------ /admin/shop/updateDishTasteTag.f1t
    private String id;

    //private String name;
    //private String description;
    public String updateDishTasteTag() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            DishTasteTag dishTasteTag;

            if (id == null || "".equals(id)) {
                dishTasteTag = new DishTasteTag();
                dishTasteTag.setShopId(shopClient.getShopId());
            } else {
                dishTasteTag = dishTasteTagDao.findOneById(id);
            }

            dishTasteTag.setDescription(description);
            dishTasteTag.setName(name);

            adminShopService.saveDishTasteTag(shopClient.getId(), dishTasteTag);

            return Action.SUCCESS;

        } else {
            return "login";
        }
    }

    //------------ /admin/shop/removeDishTasteTag.f1t
    private String dishTasteTagId;

    public String removeDishTasteTag() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            flag = makeFlag(adminShopService.removeDishTasteTag(shopClient.getId(), dishTasteTagId));

        } else {
            flag = makeFlag(false);
        }
        return Action.SUCCESS;
    }

    //------------ /admin/shop/updateDish.f1t
    //private String id;
    //private String name;
    //private String dishTasteTagId;
    private double originPrice;
    private double price;
    private int status;
    //private String description;

    private File image;
    private String imageFileName;
    private String imageContentType;

    public String updateDish() {
        boolean loginFlag = session.get("SHOP_CLIENT_LOGIN") != null ? (Boolean) session.get("SHOP_CLIENT_LOGIN") : false;

        if (loginFlag) {
            String userId = ((Map<String, String>) session.get("SHOP_CLIENT")).get("ID");
            shopClient = adminShopService.fetchShopClient(userId);

            Dish dish;

            if (id==null||"".equals(id)) {
                dish = new Dish();
                dish.setShopId(shopClient.getShopId());
                dish.setRankTagIds(new ArrayList<String>());
                dish.setSaleVolume(0);
                dish.setImage("000.jpeg");
                dish.setCommentNum(0);
                dish.setCommentLevel(0);
                dish.setAvgCommentLevel(0);

                dish.setCreateTime(new Date());
            } else {
                dish = dishDao.findOneById(id);
            }

            dish.setDishTasteTagId(dishTasteTagId);
            dish.setName(name);
            dish.setPrice(price);
            dish.setOriginPrice(originPrice);
            dish.setStatus(status);
            dish.setDescription(description);

            if (image != null) {
                String realPath = ServletActionContext.getServletContext().getRealPath("/res/avatar/dish");
                String fileName = UUIDGenerator.generateUUID() + ".jpeg";
                File saveFile = new File(new File(realPath), fileName);
                try {
                    FileUtils.copyFile(image, saveFile);
                    dish.setImage(fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            adminShopService.saveDish(shopClient.getId(), dish);

            return Action.SUCCESS;
        } else {
            return "login";
        }
    }

    // ---------------- /admin/shop/fetchDish.f1t
    private String dishId;

    private Dish dish;

    public String fetchDish() {
        dish = dishDao.findOneById(dishId);

        if(dish!=null) {
            flag = makeFlag(true);
        } else {
            flag = makeFlag(false);
        }

        return Action.SUCCESS;
    }

}
