def mapmap(m1: Map[Text, Double], m2:   Map[Text,Double]) = {
  m1.keys.toSet.intersect(m2.keys.toSet).toSeq
}

