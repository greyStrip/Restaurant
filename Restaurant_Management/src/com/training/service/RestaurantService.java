package com.training.service;

import java.util.List;

import com.training.model.Cook;
import com.training.model.Seat;
import com.training.model.Waiter;

public interface RestaurantService {
	List<Seat> getAllAvailableSeats();
	List<Waiter> getAllAvailableWaiters();
	List<Cook> getAllAvailableCooks();
}
