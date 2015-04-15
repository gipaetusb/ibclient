## Examples

ibclient.marketData(new FutureContract("BZ", "20150316", "NYMEX"))
val  h = Await.result(ibclient.historicalData(new StockContract("SPY"), endDate, 20,
DurationUnit.DAY, BarSize._15_mins, WhatToShow.MIDPOINT, false),  Duration.Inf)

val res2 = Await.result(ibclient.historicalData(new CashContract("EUR","EUR.USD"), endDate2, 120, DurationUnit.SECOND, BarSize._1_min, WhatToShow.MIDPOINT, false), scala.concurrent.duration.Duration.Inf)
scala> import java.text.SimpleDateFormat
import java.text.SimpleDateFormat

    import java.util.Date
    import com.larroy.ibclient.contract.{CashContract, StockContract}
    import com.ib.client.Types.{BarSize, DurationUnit, WhatToShow, SecType}
    import scala.concurrent.duration._
    import scala.concurrent.Await
    import com.larroy.ibclient._
    import com.typesafe.config.ConfigFactory
    val cfg = ConfigFactory.load().getConfig("ibclient.test")
    val ibclient = new IBClient(cfg.getString("tws.host"), cfg.getInt("tws.port"), cfg.getInt("tws.clientId"))
    Await.result(ibclient.connect(), Duration.Inf)

 val subscription = ibclient.realtimeBars(new CashContract("EUR","EUR.USD"), WhatToShow.MIDPOINT)
 subscription.observableBar.subscribe({bar=>println(s"got bar ${bar}")}, {error ⇒ throw (error)})


 java -cp "target/scala-2.11/ibclient-assembly-0.1.jar":jython-standalone-2.7-b4.jar
 org.python.util.jython




import scala.concurrent.duration._
import org.joda.time._

val startDate = new DateTime(2015, 4, 10, 15, 0).toDate

val endDate = new DateTime(2015, 4, 13, 15, 0).toDate


val contract = new CashContract("EUR","EUR.USD")


val h = Await.result(ibclient.easyHistoricalData(contract, startDate, endDate, BarSize._1_min, WhatToShow.TRADES), duration.Duration.Inf)


