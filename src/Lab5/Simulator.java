package Lab5;

import Lab5.View.*;
import Lab5.State.*;
import Lab5.Queue.*;

/**
 * Runs simulation
 * 
 * @author Klas Mannberg
 * @version 0.9
 * @since 2019-03-08
 */
public class Simulator {
	public Boolean emergencystop;
	private SimView view;
	private EventQueue events;
	private SimState state;
	/**
	 * Creates new Simulator by setting this objects view, eventqueue and state from
	 * given parameters
	 */
	public Simulator(SimView view, EventQueue events, SimState state) {
		this.view = view;
		this.events = events;
		this.state = state;
	}

	/**
	 * Runs ExecuteEvent for all Events in EventQueue. Runs startprint and endprint
	 * from view
	 */
	public void start() {
		view.start();
		while (!emergencystop) {
			events.getNextEvent().ExecuteEvent();
		}
		view.end();
	}

}
