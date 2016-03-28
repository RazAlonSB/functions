  def portfolioTsTs[K1, K2](portfolio: Iterable[(K1, Double)], ts1: TimeSeries[K2], ts2: TimeSeries[Double]) = {

    val tsPortfolio = core.Solving.SpecialFunctions.timeSeriesValuesDistributionMap(ts1, ts2)

    val rankedPortfolio = core.Solving.SpecialFunctions.rankedKeys(portfolio)
    val rankedTSPortfolio = core.Solving.SpecialFunctions.rankedKeys(tsPortfolio)

    core.Solving.SpecialFunctions.crossProduct(rankedPortfolio.take(3).map(_._1), rankedTSPortfolio.take(3).map(_._1)).map { x => (x._1, x._2) -> portfolio.toMap.getOrElse(x._1, 0.0) / tsPortfolio.toMap.getOrElse(x._2, 1.1) }.toMap
  }
  def portfolioTsTsNormalized[K1, K2](portfolio: Iterable[(K1, Double)], ts1: TimeSeries[K2], ts2: TimeSeries[Double]) = {

    val tsPortfolio = core.Solving.SpecialFunctions.timeSeriesValuesNormalizedDistributionMap(ts1, ts2)

    val rankedPortfolio = core.Solving.SpecialFunctions.rankedKeys(portfolio)
    val rankedTSPortfolio = core.Solving.SpecialFunctions.rankedKeys(tsPortfolio)

    core.Solving.SpecialFunctions.crossProduct(rankedPortfolio.take(3).map(_._1), rankedTSPortfolio.take(3).map(_._1)).map { x => (x._1, x._2) -> portfolio.toMap.getOrElse(x._1, 0.0) / tsPortfolio.toMap.getOrElse(x._2, 1.1) }.toMap
  }
