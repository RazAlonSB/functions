def temperature(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "TEMP")
	def maxTemperature(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "MAXTEMP")
	def minTemperature(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "MINTEMP")
	def precipitation(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "PRCP")
	def dewPoint(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "DEWP")
	def seaLevelPressure(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "SLP")
	def stationPressure(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "STP")
	def visibility(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "VISIB")
	def windSpeed(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "WDSP")
	def maxWindSpeed(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "MXSPD")
	def gust(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "GUST")
	def snowDepth(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "SNDP")
	def fog(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "FOG_EXISTS")
	def rain(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "RAIN_EXISTS")
	def snow(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "SNOW_EXISTS")
	def hail(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "HAIL_EXISTS")
	def thunder(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "THUNDER_EXISTS")
	def tornado(timeWindow: KeyedTimeWindow[LatLong]) = NOAATimeSeries(timeWindow, "TORNADO_EXISTS")

	def NOAATimeSeries(timeWindow: KeyedTimeWindow[LatLong], NOAAKey: String): TimeSeries[Double] = {
		import DateHelper._
		val days = DateHelper.diffDays(timeWindow.startDateAsJavaDate, timeWindow.endDateAsJavaDate)
		TimeSeries.fromDatesAndValues( (0 until days).map(offset => {
			val currDate = timeWindow.startDateAsJavaDate.plusDays(offset).toDate
			val w = contentForLatLongDate(timeWindow.key,currDate).toMap
			(currDate, w.getOrElse(NOAAKey, Double.NaN))
		}))
	}
