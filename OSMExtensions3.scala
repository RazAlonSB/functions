import com.sparkbeyond.runtime.feature.types._
import com.sparkbeyond.runtime.util.datastructures.geo._
import com.sparkbeyond.runtime.graph._

object MyZeroComplexityFunctions3 {
	def valuesOfAttributesOfObjectsInCircle(c: GeoCircle, osm: OpenStreetMapTrait): scala.collection.Map[String, Double] = {

		osm.attributesOfNearestObjects(c).map{ case ((l,r), d: Double) => r.toString->d }
	}
	def mapKeyToLookupValue(map: scala.collection.Map[String, Double], lookupTable: MapWrapper[String, Text]): scala.collection.GenSeq[(String	, Double)] = {
		println("<<<<<<< Hey, I'm here >>>>>>>>>>>")
		map.toSeq.map { case (key, d) => lookupTable.get(key).getOrElse("").toString -> d }
	}

}