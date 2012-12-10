
import br.org.address._

object ZipCodeTrackerWorkSheet {
  
  println("ZipCodeTracker WorkSheet")             //> ZipCodeTracker WorkSheet
  ZipCodeTracker.find("Avenida Amazonas").foreach(println)
                                                  //> Address(Avenida Amazonas,Prado,Maceió,AL,57010060)
                                                  //| Address(Avenida Amazonas (Prq Laranjeiras),Flores,Manaus,AM,69058300)
                                                  //| Address(Avenida Amazonas,Centro,Parintins,AM,69151000)
                                                  //| Address(Avenida Amazonas,Francesa,Parintins,AM,69151486)
                                                  //| Address(Avenida Amazonas,São Benedito,Parintins,AM,69151540)
                                                  //| Address(Avenida Amazonas,Pacoval,Macapá,AP,68908330)
                                                  //| Address(Avenida Amazonas (Lot Amazonas),Lagoa Azul,Macapá,AP,68909695)
                                                  //| Address(Avenida Amazonas,Liberdade,Salvador,BA,40325795)
                                                  //| Address(Avenida Amazonas,Tancredo Neves,Salvador,BA,41210790)
                                                  //| Address(Avenida Amazonas - até 614/615,Ibirapuera,Vitória da Conquista,BA,45
                                                  //| 075055)
  

}
 