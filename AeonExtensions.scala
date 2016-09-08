object Functions {
	@ZeroComplexity
	def valuesOfAttributesOfObjectsInCircle(c: GeoCircle): scala.collection.Map[String, Double] = attributesOfNearestObjects(c).map{
		case ((l,r), d: Double) => r.toString->d
	}
}