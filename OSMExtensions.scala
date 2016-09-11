import com.sparkbeyond.runtime.feature.types._
import com.sparkbeyond.runtime.util.datastructures.geo._
import com.sparkbeyond.runtime.graph._

object ZeroComplexityFunctions {

	def valuesOfAttributesOfObjectsInCircle(c: GeoCircle, osm: OpenStreetMapTrait): scala.collection.Map[String, Double] = osm.attributesOfNearestObjects(c).map{
		case ((l,r), d: Double) => r.toString->d
	}

	def valuesOfAttributesOfObjectsDistributionInCircle(c: GeoCircle): Histogram[(String, Any)] = new Histogram(valuesOfAttributesOfObjectsInCircle(c))

	def mapKeyToLookupValue[TKey, TDummy](map: scala.collection.Map[TKey, Double], lookupTable: MapWrapper[TKey, TDummy]): GenSeq[(String	, Double)] = {
		map.toSeq.map { case (key, d) => lookupTable.get(key).getOrElse("").toString -> d }
	}

}