
/**
 * A weather forecast app determines if the pressure readings from its
 * subscribed weather station, if any, indicate it is likely to rain due to a
 * reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {

	private WeatherStation weatherStation;
	private double currentPressure;
	private double lastPressure;

	/**
	 * Update the reading of this weather observer. Update the current and last
	 * readings of pressure.
	 */
	public void update() {
		/* Your Task */
		WeatherStation ws = this.weatherStation;
		double uP = ws.getPressure(); // uP = updatedPressure
		if (ws != null) {
			if (lastPressure == 0 && currentPressure == 0) {
				lastPressure = uP;
				currentPressure = uP;
			}

			else {
				lastPressure = currentPressure;
				currentPressure = weatherStation.pressure;
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
	 * Get the pressure level read from the last update.
	 * 
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		/* Your Task */
		return this.currentPressure;
	}

	/**
	 * Get the pressure level read from the second last update.
	 * 
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		/* Your Task */
		return this.lastPressure;
	}

	/**
	 * Based on the last and second last readings of the pressure level, it is
	 * determined as likely to rain if there is a reduction on the pressure level;
	 * otherwise it is unlikely to rain.
	 * 
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		/* Your Task */
		boolean likelyRain = this.lastPressure > this.currentPressure;
		return likelyRain;
	}
}