package com.fan1tuan.shop.pojos;

import com.fan1tuan.general.pojos.EntityObject;

public class DishCommentDto extends EntityObject{
	private DishComment dishComment;
	private Dish dish;
	public DishComment getDishComment() {
		return dishComment;
	}
	public void setDishComment(DishComment dishComment) {
		this.dishComment = dishComment;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	
}
