import java.util.ArrayList;

/**
 * A weather station measures temperature and pressure and has a list of
 * subscribed weather observers. When there is an update on the measures, the
 * weather station publishes the update to all currently-subscribed observers.
 */
public class WeatherStation {

	/*
	 * Your Task: Declare an attribute for the ***list*** of subscribed weather
	 * observers.
	 */
	ArrayList<WeatherObserver> subscribed;
	double temperature;
	double pressure;

	/**
	 * Initialize a new weather station.
	 * 
	 * @param t initial temperature measure
	 * @param p initial pressure measure
	 */
	public WeatherStation(double t, double p) {
		/* Your Task */
		this.subscribed = new ArrayList<WeatherObserver>();
		this.temperature = t;
		this.pressure = p;
	}

	/**
	 * Subscribe the input weather observer o as one of the observers of the current
	 * weather station. Add the input o to the list of subscribed observers.
	 * 
	 * @param o a weather observer
	 */
	public void subscribe(WeatherObserver o) {
		/* Your Task */
		o.setWeatherStation(this);
		this.subscribed.add(o);
	}

	/**
	 * Unsubscribe the input weather observer o from the list of observers of the
	 * current weather station. Remove the input o from the list of subscribed
	 * observers. Assume that the input o is an already-subscribed observer.
	 * 
	 * @param o a weather observer
	 */
	public void unsubscribe(WeatherObserver o) {
		/* Your Task */
		o.setWeatherStation(null);
		this.subscribed.remove(o);
	}

	/**
	 * Publish the latest readings of weather data to all subscribed observers. That
	 * is, perform an update on each subscribed observer.
	 */
	public void publish() {
		/* Your Task */
		for (WeatherObserver wo : this.subscribed) {
			wo.update();
		}
	}

	/**
	 * Get the list of subscribed weather observers.
	 * 
	 * @return an array of subscribed weather observers.
	 */
	public WeatherObserver[] getObservers() {
		/* Your Task */
		WeatherObserver[] wo = new WeatherObserver[this.subscribed.size()];
		for (int i = 0; i < this.subscribed.size(); i++) {
			wo[i] = this.subscribed.get(i);
		}
		return wo;
	}

	/**
	 * Get the latest temperature measure.
	 * 
	 * @return latest temperature measure
	 */
	public double getTemperature() {
		/* Your Task */
		return this.temperature;
	}

	/**
	 * Get the latest pressure measure.
	 * 
	 * @return latest pressure measure
	 */
	public double getPressure() {
		/* Your Task */
		return this.pressure;
	}

	/**
	 * Update the weather data
	 * 
	 * @param t new temperature measure
	 * @param p new pressure measure
	 */
	public void set_measurements(double t, double p) {
		/* Your Task */
		this.temperature = t;
		this.pressure = p;
	}
}