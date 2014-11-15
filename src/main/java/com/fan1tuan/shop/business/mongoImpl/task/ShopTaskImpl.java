package com.fan1tuan.shop.business.mongoImpl.task;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fan1tuan.shop.business.task.ShopTask;
import com.fan1tuan.shop.pojos.Dish;
import com.fan1tuan.shop.pojos.Shop;

public class ShopTaskImpl implements ShopTask {
	private MongoTemplate template;

	@Override
	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}

	@Override
	public MongoTemplate getTemplate() {
		return this.template;
	}

	@Override
	public boolean refreshShopRank(String shopId) {
		Shop shop = this.getPartOfObject(shopId, new String[] { "commentNum",
				"commentLevel" }, Shop.class);
		template.updateFirst(
				new Query(where("id").is(shopId)),
				new Update().set("avgCommentLevel", shop.getCommentLevel()
						/ shop.getCommentNum()), Shop.class);

		return false;
	}

	@Override
	public boolean refreshDishRank(String dishId) {
		Dish dish = this.getPartOfObject(dishId, new String[] { "commentNum",
				"commentLevel" }, Dish.class);
		template.updateFirst(
				new Query(where("id").is(dishId)),
				new Update().set("avgCommentLevel", dish.getCommentLevel()
						/ dish.getCommentNum()), Dish.class);
		return true;
	}

	private <T> T getPartOfObject(String id, String[] includedFields,
			Class<T> theClass) {
		Query query = new Query(where("id").is(id));

		for (String key : includedFields) {
			query.fields().include(key);
		}

		return template.findOne(query, theClass);
	}

}
