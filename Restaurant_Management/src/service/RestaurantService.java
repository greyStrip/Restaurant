package service;

import java.util.List;

import model.Cook;
import model.Seat;
import model.Waiter;

public interface RestaurantService {
	List<Seat> getAllAvailableSeats();
	List<Waiter> getAllAvailableWaiters();
	List<Cook> getAllAvailableCooks();
}
