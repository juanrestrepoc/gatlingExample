package middletier

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

/**
  * Created by fcardona on 4/12/16.
  */
object Engine extends App{
  val props = new GatlingPropertiesBuilder
  props.dataDirectory("jar")
  /*props.simulationClass(System.getProperty("gatlingClass"))*/
  props.simulationClass(classOf[RecordedSimulation].getName)
  Gatling.fromMap(props.build)
  sys.exit()
}
