package com.fan1tuan.search.ui.struts2.core;

import com.fan1tuan.general.ui.struts2.core.support.Fan1TuanAction;
import com.fan1tuan.general.util.ISession;
import com.fan1tuan.general.util.SessionUtil;
import com.fan1tuan.search.business.SearchService;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.Shop;
import com.opensymphony.xwork2.Action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by Li He on 2014/12/21.
 *
 */
public class SearchAction extends Fan1TuanAction{
    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public boolean isHaveResult() {
        return haveResult;
    }

    public void setHaveResult(boolean haveResult) {
        this.haveResult = haveResult;
    }

    public boolean isBlandRequest() {
        return blandRequest;
    }

    public void setBlandRequest(boolean blandRequest) {
        this.blandRequest = blandRequest;
    }

    private SearchService searchService;

    private List<Shop> shops;
    private List<Dish> dishes;
    private String keyword;
    private String areaId;
    private boolean haveResult;
    private boolean blandRequest;


    //------------------- /search/index.f1t ----------------------
    //in
    // String keyword
    //out
    // Shops
    // Dishes

    public String index() {
        blandRequest = false;
        haveResult = true;

        if (keyword==null||"".equals(keyword)) {
            blandRequest = true;
            return Action.SUCCESS;
        }

        try {
            keyword = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        areaId = (String) SessionUtil.getArea(session).get(ISession.AREAID);

        shops = searchService.searchShopsForKeyword(keyword, areaId);
        dishes = searchService.searchDishesForKeyword(keyword, areaId);

        if(shops.size()==0&&dishes.size()==0) {
            haveResult = false;
        }

        return Action.SUCCESS;
    }

}
