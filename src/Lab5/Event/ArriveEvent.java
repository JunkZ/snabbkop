package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.*;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class ArriveEvent extends Event {
	private Customer customer;
    private MarketState marketState;

	public ArriveEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer) {
		super(startTime, queue);
		this.customer = customer;
	}

	@Override
	public void ExecuteEvent() {
		if ( marketState.getStore() == true) {
	        Customer customer2 = new Customer();
	        ArriveEvent arriveEvent = new ArriveEvent(marketState.getTime().getNextCustomer(), queue,marketState,customer2);
	        queue.addEvent(arriveEvent);
		if (marketState.getMaxCustomers() <= marketState.getCurrentCustomers()) {
	        PickupEvent pickupEvent = new PickupEvent(marketState.getTime().getNextCustomer(), queue,marketState,customer);
	        queue.addEvent(pickupEvent);
		} else {
			marketState.addMissedCustomers();
		}
		}
	}

	@Override
	public double getStartTime() {
		return startTime;
	}

	public Customer getCustomer() {
		return customer;
	}
}
