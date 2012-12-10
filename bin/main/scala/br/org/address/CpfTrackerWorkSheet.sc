
import br.org.address._
import java.net._
import java.io._
import scala.xml._

object CpfTrackerWorkSheet {
  println("Cpf Tracker")                          //> Cpf Tracker
  println("Correios URL: " + CorreiosInfo.url)    //> Correios URL: http://m.correios.com.br/movel/buscaCepConfirma.do
 	var url = new URL(CorreiosInfo.url)       //> url  : java.net.URL = http://m.correios.com.br/movel/buscaCepConfirma.do|
 	
 	
  var result = XML.load(url)
  println(result)
}