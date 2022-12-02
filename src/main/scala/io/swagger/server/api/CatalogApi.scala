package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.Catalog

class CatalogApi(
    catalogService: CatalogApiService,
    catalogMarshaller: CatalogApiMarshaller
) {
  import catalogMarshaller._

  lazy val route: Route =
    path() { () => 
      get {
        parameters() { () =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => 
            formFields() { () =>
              
                
                  catalogService.catalogGetUsingGET(xBrokerAPIVersion = xBrokerAPIVersion)
               
             
            }
          }
        }
      }
    }
}

trait CatalogApiService {

  def catalogGetUsingGET200(responseCatalog: Catalog)(implicit toEntityMarshallerCatalog: ToEntityMarshaller[Catalog]): Route =
    complete((200, responseCatalog))
  def catalogGetUsingGET401: Route =
    complete((401, "Unauthorized"))
  def catalogGetUsingGET403: Route =
    complete((403, "Forbidden"))
  def catalogGetUsingGET404: Route =
    complete((404, "Not Found"))
  /**
   * Code: 200, Message: catalog response, DataType: Catalog
   * Code: 401, Message: Unauthorized
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found
   */
  def catalogGetUsingGET(xBrokerAPIVersion: String)
      (implicit toEntityMarshallerCatalog: ToEntityMarshaller[Catalog]): Route

}

trait CatalogApiMarshaller {

  implicit def toEntityMarshallerCatalog: ToEntityMarshaller[Catalog]

}

