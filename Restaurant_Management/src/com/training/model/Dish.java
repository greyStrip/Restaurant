package com.training.model;

import com.training.enums.AvailableDishes;
import com.training.enums.DishStatus;

public class Dish {
	private AvailableDishes dishName;
	private DishStatus dishStatus;

	public Dish() {
		this.dishStatus = DishStatus.UNORDERED;
	}

	public Dish(AvailableDishes dishName) {
		this.dishName = dishName;
		this.dishStatus = DishStatus.UNORDERED;
	}

	public Dish(AvailableDishes dishName, DishStatus dishStatus) {
		this.dishName = dishName;
		this.dishStatus = dishStatus;
	}

	public AvailableDishes getDishName() {
		return dishName;
	}

	public void setDishName(AvailableDishes dishName) {
		this.dishName = dishName;
	}

	public DishStatus getDishStatus() {
		return dishStatus;
	}

	public void setDishStatus(DishStatus dishStatus) {
		this.dishStatus = dishStatus;
	}

	@Override
	public String toString() {
		return "Dish [dishName=" + dishName + ", dishStatus=" + dishStatus + "]";
	}
	
}
