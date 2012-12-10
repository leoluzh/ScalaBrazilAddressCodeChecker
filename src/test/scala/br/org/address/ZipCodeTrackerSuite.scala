package br.org.address

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import br.org.address._
import org.hamcrest.core.IsNot

@RunWith(classOf[JUnitRunner])
class ZipCodeTrackerSuite extends FunSuite {

  test("Test Equals"){
	  assert(ZipCodeTracker.find("30510000") === List(Address("Avenida Amazonas - de 5701/5702 a 8999/9000","Gameleira","Belo Horizonte","MG","30510000")) )
  }
  
}