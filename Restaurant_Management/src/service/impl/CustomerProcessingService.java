package service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import enums.AvailableDishes;
import enums.CustomerStatus;
import enums.DishStatus;
import enums.Status;
import model.Cook;
import model.Customer;
import model.CustomerProcessing;
import model.Dish;
import model.Restaurant;
import model.Seat;
import model.Waiter;

public class CustomerProcessingService implements Callable<CustomerProcessing> {
	Customer customer;
	Restaurant restaurant;
	CustomerProcessing customerProcessing;
	RestaurantServiceImpl restaurantServiceImpl;
	private static final Logger logger = Logger.getLogger(CustomerProcessingService.class.getName());
		
	static {
		FileHandler fh;
		try {
			fh = new FileHandler("C:\\Workspace\\learning\\Restaurant\\logs\\restaurant_logger.log");
			fh.setFormatter(new Formatter() {
				
				@Override
				public String format(LogRecord record) {
					return record.getThreadID()+"::"+record.getSourceClassName()+"::"
			                +record.getSourceMethodName()+"::"
			                +new Date(record.getMillis())+"::"
			                +record.getMessage()+"\n";
				}
			});
			logger.addHandler(fh);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public CustomerProcessingService() {
	}

	public CustomerProcessingService(Customer customer, Restaurant restaurant) {
		this.customer = customer;
		this.restaurant = restaurant;
	}

	public CustomerProcessingService(Customer customer, Restaurant restaurant, CustomerProcessing customerProcessing) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.customerProcessing = customerProcessing;
		this.restaurantServiceImpl = new RestaurantServiceImpl(restaurant);
	}

	@Override
	public CustomerProcessing call() throws Exception {
		assignSeat();
		assignWaiter();
		orderDishes();
		assignCook();
		deliverOrder();
		cutomerEating();
		completeOrder();
		return customerProcessing;
	}
	
	private void assignSeat() {
			logger.info("Looking for seat for customer " + customer.getCustName());
			// Keep on waiting unless there is a free seat
			while (restaurantServiceImpl.getAllAvailableSeats().size() == 0) {
				logger.info("Waiting for an available seat");
			}
	
			if (restaurantServiceImpl.getAllAvailableSeats().size() != 0) {
				List<Seat> availableSeats = restaurantServiceImpl.getAllAvailableSeats();
				customerProcessing.setCustomer(customer);
				customerProcessing.setSeat(availableSeats.get(0));
				changeCustomerStatus(customer, CustomerStatus.SEAT_OCCUPIED);
				changeSeatStatus(availableSeats.get(0), Status.OCCUPIED);
				
				logger.info("Found seat "+availableSeats.get(0).getSeatId()+" for customer " + customer.getCustName());
			}
		}

	private void assignWaiter() {
		logger.info("Looking for waiter for customer " + customer.getCustName());
		// Keep on waiting unless there is a free waiter
		while (restaurantServiceImpl.getAllAvailableWaiters().size() == 0) {
			logger.info("Waiting for an available waiter");
		}
	
		if (restaurantServiceImpl.getAllAvailableWaiters().size()!=0) {
			List<Waiter> availableWaiters = restaurantServiceImpl.getAllAvailableWaiters();
			customerProcessing.setWaiter(availableWaiters.get(0));
			changeCustomerStatus(customer, CustomerStatus.WAITING_TO_ORDER);
			changeWaiterStatus(availableWaiters.get(0), Status.OCCUPIED);
			
			logger.info("Found waiter "+ availableWaiters.get(0).getWaiterName()+" for customer " + customer.getCustName());
		}
		
	}

	private void orderDishes() {
		logger.info("Customer " + customer.getCustName() + " ordering dishes");
		Map<Dish, Integer> dishMap = new HashMap<>();
	
		dishMap.put(new Dish(AvailableDishes.TEA, DishStatus.ORDERED), 1);
		dishMap.put(new Dish(AvailableDishes.COFFEE, DishStatus.ORDERED), 1);
	
		customerProcessing.setDishes(dishMap);
		changeCustomerStatus(customer, CustomerStatus.WAITING_FOR_FOOD);
		logger.info("Customer " + customer.getCustName() + " ordered dishes");
	}

	private void assignCook() {
		logger.info("Looking for cook for customer " + customer.getCustName());

		while (restaurantServiceImpl.getAllAvailableCooks().size() == 0) {
			logger.info("Waiting for an available waiter");
		}
		if (restaurantServiceImpl.getAllAvailableCooks().size() !=0) {
			List<Cook> availableCooks = restaurantServiceImpl.getAllAvailableCooks();
			Cook cook = availableCooks.get(0);
			customerProcessing.setCook(cook);
			changeCookStatus(cook, Status.OCCUPIED);
			changeDishStatus(customerProcessing, DishStatus.COOKING);
			
			logger.info("Found cook "+availableCooks.get(0).getCookName()+" for customer " + customer.getCustName());
		}
	}

	private void dishesCooking() {
		logger.info("Cook "+customerProcessing.getCook().getCookName()+" cooking dishes "+customer.getCustName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		changeDishStatus(customerProcessing, DishStatus.COOKED);
		logger.info("Cook "+customerProcessing.getCook().getCookName()+" cooked dishes "+customer.getCustName());
	}
	
	private void deliverOrder() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		while(!checkIfAllDishesArePrepared()) {
			logger.info("Dishes are getting ready");
			dishesCooking();
		}
		logger.info("Cook cooked dishes "+customer.getCustName()+" :"+checkIfAllDishesArePrepared());
		
		if (checkIfAllDishesArePrepared()) {
			changeCookStatus(customerProcessing.getCook(), Status.AVAILABLE);
			changeDishStatus(customerProcessing, DishStatus.DELIVERED);
			changeWaiterStatus(customerProcessing.getWaiter(), Status.AVAILABLE);
			changeCustomerStatus(customer, CustomerStatus.EATING);
		}
		logger.info("Customer is eating food " + customer.getCustName());
	}

	private void cutomerEating() {
		logger.info("Customer eating food "+customer.getCustName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		changeCustomerStatus(customer, CustomerStatus.DONE);
		logger.info("Customer ate food "+customer.getCustName());
	}

	private void completeOrder() {
		if(customerProcessing.getCustomer().getCustStatus() == CustomerStatus.DONE) {
			customerProcessing.getSeat().setSeatStatus(Status.AVAILABLE);
		}
		logger.info("Order completed for customer"+customer.getCustName());
	}

	private boolean checkIfAllDishesArePrepared() {
		return customerProcessing.getDishes()
					.entrySet()
						.stream()
							.allMatch(d -> d.getKey().getDishStatus()==DishStatus.COOKED);
	}

	private void changeWaiterStatus(Waiter w, Status status) {
		w.setWaiterStatus(status);
	}

	private void changeCustomerStatus(Customer cs, CustomerStatus status) {
		cs.setCustStatus(status);
	}

	private void changeSeatStatus(Seat s, Status status) {
		s.setSeatStatus(status);
	}

	private void changeCookStatus(Cook c, Status status) {
		c.setCookStatus(status);
	}

	private void changeDishStatus(CustomerProcessing cd, DishStatus status) {
		Map<Dish, Integer> map = cd.getDishes();
		map.entrySet().forEach(d -> d.getKey().setDishStatus(status));
	}
}
