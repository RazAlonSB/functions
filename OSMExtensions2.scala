import com.sparkbeyond.runtime.feature.types._
import com.sparkbeyond.runtime.util.datastructures.geo._
import com.sparkbeyond.runtime.graph._

object MyZeroComplexityFunctions2 {

	def mapKeyToLookupValue(map: scala.collection.Map[String, Double], lookupTable: MapWrapper[String, Text]): scala.collection.GenSeq[(String	, Double)] = {
		println("<<<<<<< Hey, I'm here >>>>>>>>>>>")
		map.toSeq.map { case (key, d) => lookupTable.get(key).getOrElse("").toString -> d }
	}

}