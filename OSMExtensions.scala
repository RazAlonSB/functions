import com.sparkbeyond.runtime.feature.types._
import com.sparkbeyond.runtime.util.datastructures.geo._
import com.sparkbeyond.runtime.graph._

object MyZeroComplexityFunctions {

	def valuesOfAttributesOfObjectsInCircle(c: GeoCircle, osm: OpenStreetMapTrait): scala.collection.Map[String, Double] = {

		osm.attributesOfNearestObjects(c).map{
		case ((l,r), d: Double) => r.toString->d
	}
}

	def valuesOfAttributesOfObjectsDistributionInCircle(c: GeoCircle, osm: OpenStreetMapTrait): Histogram[(String, Any)] = new Histogram(valuesOfAttributesOfObjectsInCircle(c,osm))

	def mapKeyToLookupValue[TKey, TDummy](map: scala.collection.Map[TKey, Double], lookupTable: MapWrapper[TKey, TDummy]): scala.collection.GenSeq[(String	, Double)] = {
		println("<<<<<<< Hey, I'm here >>>>>>>>>>>")
		map.toSeq.map { case (key, d) => lookupTable.get(key).getOrElse("").toString -> d }
	}

}