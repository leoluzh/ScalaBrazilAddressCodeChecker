package br.org.address

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.NameValuePair
import java.util.ArrayList
import org.apache.http.message.BasicNameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.jsoup.Jsoup

object RequestInfo {
  val baseUrl = "http://m.correios.com.br"
  val url = "http://m.correios.com.br/movel/buscaCepConfirma.do" 
  val searchField = "cepEntrada"
  val hiddenFields = Map( "tipoCep"-> "" , "cepTemp" -> "" , "metodo" -> "buscarCep" )
  val encode = "ISO-8859-1"
  val selector = ".respostadestaque"
}

case class Address( val street : String , val neighborhood : String , val city : String , val county : String , val zipCode : String )

object ZipCodeTracker {

  private def source( searchAddressOrZipCode : String ) = {
    val client = new DefaultHttpClient
    val post = new HttpPost(RequestInfo.url)
    val params = new ArrayList[NameValuePair]()
    params.add(new BasicNameValuePair(RequestInfo.searchField,searchAddressOrZipCode))
    RequestInfo.hiddenFields.foreach{ case(key,value) => params.add(new BasicNameValuePair(key,value)) }
    post.setEntity(new UrlEncodedFormEntity(params))
    val response = client.execute(post)
    response.getEntity().getContent()
  }
  
  def find( searchAddressOrZipCode : String ) = {
    require(searchAddressOrZipCode.nonEmpty)
    //Xml.load() ... does not work with mal-formed documents
    val document = Jsoup.parse(source(searchAddressOrZipCode),RequestInfo.encode,RequestInfo.baseUrl)
    val selected = document.select(RequestInfo.selector)
    val it = selected.iterator
    val list = new scala.collection.mutable.MutableList[Address]
    while(it.hasNext){
      val street = it.next.text.trim 
      val neighborhood = it.next.text.trim 
      val cityCounty = it.next.text.split("/")
      val zipCode = it.next.text.trim
      val address = 
      Address( street ,
               neighborhood ,
               cityCounty(0).trim ,
               cityCounty(1).trim ,
               zipCode)
      list+=address      
    }
    //to immutable list
    list.toList
  }
  
}