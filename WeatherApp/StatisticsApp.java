
/**
 * A weather statistics app calculates the minimum, maximum, and average
 * temperature read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	private WeatherStation weatherStation;
	double minTemp;
	double maxTemp;

	/**
	 * Update the reading of this weather observer. Update the current temperature
	 * and the maximum, minimum, and average accordingly.
	 */
	public void update() {
		/* Your Task */
		WeatherStation ws = this.weatherStation;
		double uT = ws.getTemperature(); // uT = updatedTemperature
		if (ws != null) {
			if (minTemp == 0 && maxTemp == 0) {
				minTemp = uT;
				maxTemp = uT;
			} else if (uT > maxTemp) {
				minTemp = maxTemp;
				maxTemp = uT;
			} else if (uT < minTemp) {
				minTemp = uT;
			}
		}
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return this.weatherStation;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */
		this.weatherStation = ws;
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * 
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		return this.minTemp;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * 
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		return this.maxTemp;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * 
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		return (this.minTemp + this.maxTemp) / 2.0;
	}
}
