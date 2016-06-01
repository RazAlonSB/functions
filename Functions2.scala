def mapmap(m1: Map[com.sparkbeyond.runtime.feature.types.Text, Double], m2:   Map[com.sparkbeyond.runtime.feature.types.Text,Double]): Seq[com.sparkbeyond.runtime.feature.types.Text] = {
  m1.keys.toSet.intersect(m2.keys.toSet).toSeq
}

