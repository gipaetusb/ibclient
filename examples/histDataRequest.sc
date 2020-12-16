import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

import com.larroy.ibclient.{IBClient}
import com.larroy.ibclient.contract.{CashContract, FutureContract, GenericContract, StockContract}
import org.joda.time._
import com.ib.client.Types.{BarSize, DurationUnit, WhatToShow}

def block[A](f: Future[A]): A = {
    Await.result(f, Duration.Inf)
}

val ibc = new IBClient("localhost", 4002, 3)
block(ibc.connect())
println(ibc.isConnected)

val c = new FutureContract(symbol="BZ", expiry="20201130", exchange="NYMEX")
val futContractDetails = ibc.contractDetails(c)
val contractDetails = block(futContractDetails)

val startDate = new DateTime(2020, 11, 15, 15, 0).toDate
val endDate = new DateTime(2020, 11, 16, 15, 0).toDate

val futBars = ibc.easyHistoricalData(contractDetails(0).contract, startDate, endDate, BarSize._5_secs, WhatToShow.TRADES)
val bars = block(futBars)
