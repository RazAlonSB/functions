import com.sparkbeyond.runtime.feature.types._
import com.sparkbeyond.runtime.feature.functions.ZeroComplexityFunctions._
import com.sparkbeyond.runtime.feature.types.TimeSeries
import com.sparkbeyond.runtime.graph.MapWrapper

object MyFunctions {

  def defaultString(o: Option[String]) = {
    if (o.isEmpty) "" else o.head
  }
  def defaultDouble(o: Option[Double]) = {
    if (o.isEmpty) Double.NaN else o.head
  }
    def defaultInt(o: Option[Int]) = {
    if (o.isEmpty) -1 else o.head
  }
  def defaultText(o: Option[Text]) = {
    if (o.isEmpty) Text("") else o.head
  }
  def zeroComplexityMapTsStringString(ts: TimeSeries[String], m: MapWrapper[String, String]) = {
   	ts.copy(y = ts.y.map(x  => defaultString(m.get(x)))) 
  }
def zeroComplexitymapTimeSeriesStringDouble(ts: TimeSeries[String], m: MapWrapper[String, Double]) = {
		ts.copy(y = ts.y.map(x  => defaultDouble(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesStringInt(ts: TimeSeries[String], m: MapWrapper[String, Int]) = {
		ts.copy(y = ts.y.map(x  => defaultInt(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesStringText(ts: TimeSeries[String], m: MapWrapper[String, Text]) = {
		ts.copy(y = ts.y.map(x  => defaultText(m.get(x)))) 
	}


def zeroComplexitymapTimeSeriesIntDouble(ts: TimeSeries[Int], m: MapWrapper[Int, Double]) = {
		ts.copy(y = ts.y.map(x  => defaultDouble(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesIntString(ts: TimeSeries[Int], m: MapWrapper[Int, String]) = {
   	ts.copy(y = ts.y.map(x  => defaultString(m.get(x)))) 
  }
def zeroComplexitymapTimeSeriesIntInt(ts: TimeSeries[Int], m: MapWrapper[Int, Int]) = {
		ts.copy(y = ts.y.map(x  => defaultInt(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesIntText(ts: TimeSeries[Int], m: MapWrapper[Int, Text]) = {
		ts.copy(y = ts.y.map(x  => defaultText(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesDoubleDouble(ts: TimeSeries[Double], m: MapWrapper[Double, Double]) = {
		ts.copy(y = ts.y.map(x  => defaultDouble(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesDoubleString(ts: TimeSeries[Double], m: MapWrapper[Double, String]) = {
   	ts.copy(y = ts.y.map(x  => defaultString(m.get(x)))) 
  }
def zeroComplexitymapTimeSeriesDoubleInt(ts: TimeSeries[Double], m: MapWrapper[Double, Int]) = {
		ts.copy(y = ts.y.map(x  => defaultInt(m.get(x)))) 
	}
def zeroComplexitymapTimeSeriesDoubleText(ts: TimeSeries[Double], m: MapWrapper[Double, Text]) = {
		ts.copy(y = ts.y.map(x  => defaultText(m.get(x)))) 
	}

}
