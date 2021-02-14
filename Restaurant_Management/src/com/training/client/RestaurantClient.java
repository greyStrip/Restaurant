package com.training.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.training.enums.CustomerStatus;
import com.training.model.Cook;
import com.training.model.Customer;
import com.training.model.CustomerProcessing;
import com.training.model.Restaurant;
import com.training.model.Seat;
import com.training.model.Waiter;
import com.training.service.impl.CustomerProcessingService;


public class RestaurantClient {
	public static void main(String[] args) {
		List<Seat> seats = seatsList(5);
		List<Cook> cooks = cooksList(5);
		List<Waiter> waiters = waitersList(5);
		
		Restaurant restaurant = new Restaurant("EatingJoint", cooks, seats, waiters);
		
		//welcome customer (customer:waiting)
		List<Customer> customers = customerList(15);
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		for(int i=0; i<customers.size(); i++) {
			es.submit(new CustomerProcessingService(customers.get(i), restaurant, new CustomerProcessing()));
		}
		
		es.shutdown();
		
		while(customers.stream().allMatch(c->c.getCustStatus()==CustomerStatus.DONE)) {
			//checking if all done
			System.out.println("Checking if all done");
			es.shutdown();
		}
	}
	
	public static List<Customer> customerList(int num) {
		List<Customer> customers = new ArrayList<>();
		for(int i=0; i<num; i++) {
			customers.add(new Customer(500+i,"Customer"+i));
		}
		return customers;
	}

	public static List<Cook> cooksList(int num) {
		List<Cook> cooks = new ArrayList<>();
		for(int i=0; i<num;i++) {
			cooks.add(new Cook(100+i,"Cook"+i));
		}
		return cooks;
	}

	public static List<Waiter> waitersList(int num) {
		List<Waiter> waiters = new ArrayList<>();
		for(int i=0; i<num;i++) {
			waiters.add(new Waiter(100+i,"Waiter"+i));
		}
		return waiters;
	}
	
	public static List<Seat> seatsList(int num) {
		List<Seat> seats = new ArrayList<>();
		for(int i=0; i<num; i++) {
			seats.add(new Seat(010+i));
		}
		return seats;
	}
}
