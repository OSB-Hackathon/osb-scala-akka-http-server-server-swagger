package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model../Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}
import io.swagger.server.model../Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
import io.swagger.server.model.LastOperationResource
import io.swagger.server.model.ServiceBindingRequest
import io.swagger.server.model.ServiceBindingResource
import io.swagger.server.model.ServiceBindingResponse

class ServiceBindingsApi(
    serviceBindingsService: ServiceBindingsApiService,
    serviceBindingsMarshaller: ServiceBindingsApiMarshaller
) {
  import serviceBindingsMarshaller._

  lazy val route: Route =
    path() { (instanceId, bindingId) => 
      put {
        parameters("accepts_incomplete".as[Boolean].?) { (acceptsIncomplete) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                entity(as[ServiceBindingRequest]){ body =>
                  serviceBindingsService.serviceBindingBindingUsingPUT(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, bindingId = bindingId, body = body, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, acceptsIncomplete = acceptsIncomplete)
                }
             
            }
          } }
        }
      }
    } ~
    path() { (instanceId, bindingId) => 
      get {
        parameters("service_id".as[String].?, "plan_id".as[String].?) { (serviceId, planId) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                
                  serviceBindingsService.serviceBindingGetUsingGET(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, bindingId = bindingId, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, serviceId = serviceId, planId = planId)
               
             
            }
          } }
        }
      }
    } ~
    path() { (instanceId, bindingId) => 
      get {
        parameters("service_id".as[String].?, "plan_id".as[String].?, "operation".as[String].?) { (serviceId, planId, operation) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => 
            formFields() { () =>
              
                
                  serviceBindingsService.serviceBindingLastOperationGetUsingGET(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, bindingId = bindingId, serviceId = serviceId, planId = planId, operation = operation)
               
             
            }
          }
        }
      }
    } ~
    path() { (instanceId, bindingId) => 
      delete {
        parameters("service_id".as[String], "plan_id".as[String], "accepts_incomplete".as[Boolean].?) { (serviceId, planId, acceptsIncomplete) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                
                  serviceBindingsService.serviceBindingUnbindingUsingDELETE(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, bindingId = bindingId, serviceId = serviceId, planId = planId, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, acceptsIncomplete = acceptsIncomplete)
               
             
            }
          } }
        }
      }
    }
}

trait ServiceBindingsApiService {

  def serviceBindingBindingUsingPUT200(responseServiceBindingResponse: ServiceBindingResponse)(implicit toEntityMarshallerServiceBindingResponse: ToEntityMarshaller[ServiceBindingResponse]): Route =
    complete((200, responseServiceBindingResponse))
  def serviceBindingBindingUsingPUT201(responseServiceBindingResponse: ServiceBindingResponse)(implicit toEntityMarshallerServiceBindingResponse: ToEntityMarshaller[ServiceBindingResponse]): Route =
    complete((201, responseServiceBindingResponse))
  def serviceBindingBindingUsingPUT202(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}]): Route =
    complete((202, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}))
  def serviceBindingBindingUsingPUT400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingBindingUsingPUT401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingBindingUsingPUT403: Route =
    complete((403, "Forbidden"))
  def serviceBindingBindingUsingPUT404: Route =
    complete((404, "Not Found"))
  def serviceBindingBindingUsingPUT409(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((409, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingBindingUsingPUT422(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((422, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: ServiceBindingResponse
   * Code: 201, Message: Created, DataType: ServiceBindingResponse
   * Code: 202, Message: Accepted, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}
   * Code: 400, Message: Bad Request, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 401, Message: Unauthorized, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found
   * Code: 409, Message: Conflict, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 422, Message: Unprocessable Entity, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceBindingBindingUsingPUT(xBrokerAPIVersion: String, instanceId: String, bindingId: String, body: ServiceBindingRequest, xBrokerAPIOriginatingIdentity: Option[String], acceptsIncomplete: Option[Boolean])
      (implicit toEntityMarshallerServiceBindingResponse: ToEntityMarshaller[ServiceBindingResponse], toEntityMarshallerServiceBindingResponse: ToEntityMarshaller[ServiceBindingResponse], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceBindingGetUsingGET200(responseServiceBindingResource: ServiceBindingResource)(implicit toEntityMarshallerServiceBindingResource: ToEntityMarshaller[ServiceBindingResource]): Route =
    complete((200, responseServiceBindingResource))
  def serviceBindingGetUsingGET401: Route =
    complete((401, "Unauthorized"))
  def serviceBindingGetUsingGET403: Route =
    complete((403, "Forbidden"))
  def serviceBindingGetUsingGET404(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((404, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: ServiceBindingResource
   * Code: 401, Message: Unauthorized
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceBindingGetUsingGET(xBrokerAPIVersion: String, instanceId: String, bindingId: String, xBrokerAPIOriginatingIdentity: Option[String], serviceId: Option[String], planId: Option[String])
      (implicit toEntityMarshallerServiceBindingResource: ToEntityMarshaller[ServiceBindingResource], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceBindingLastOperationGetUsingGET200(responseLastOperationResource: LastOperationResource)(implicit toEntityMarshallerLastOperationResource: ToEntityMarshaller[LastOperationResource]): Route =
    complete((200, responseLastOperationResource))
  def serviceBindingLastOperationGetUsingGET400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingLastOperationGetUsingGET401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingLastOperationGetUsingGET403: Route =
    complete((403, "Forbidden"))
  def serviceBindingLastOperationGetUsingGET404(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((404, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingLastOperationGetUsingGET410(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((410, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: LastOperationResource
   * Code: 400, Message: Bad Request, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 401, Message: Unauthorized, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 410, Message: Gone, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceBindingLastOperationGetUsingGET(xBrokerAPIVersion: String, instanceId: String, bindingId: String, serviceId: Option[String], planId: Option[String], operation: Option[String])
      (implicit toEntityMarshallerLastOperationResource: ToEntityMarshaller[LastOperationResource], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceBindingUnbindingUsingDELETE200(responseObject: Object): Route =
    complete((200, responseObject))
  def serviceBindingUnbindingUsingDELETE202(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}]): Route =
    complete((202, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}))
  def serviceBindingUnbindingUsingDELETE204: Route =
    complete((204, "No Content"))
  def serviceBindingUnbindingUsingDELETE400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingUnbindingUsingDELETE401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingUnbindingUsingDELETE403: Route =
    complete((403, "Forbidden"))
  def serviceBindingUnbindingUsingDELETE410(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((410, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceBindingUnbindingUsingDELETE422(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((422, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: Object
   * Code: 202, Message: Accepted, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}
   * Code: 204, Message: No Content
   * Code: 400, Message: Bad Request, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 401, Message: Unauthorized, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 403, Message: Forbidden
   * Code: 410, Message: Gone, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 422, Message: Unprocessable Entity, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceBindingUnbindingUsingDELETE(xBrokerAPIVersion: String, instanceId: String, bindingId: String, serviceId: String, planId: String, xBrokerAPIOriginatingIdentity: Option[String], acceptsIncomplete: Option[Boolean])
      (implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

}

trait ServiceBindingsApiMarshaller {
  implicit def fromRequestUnmarshallerServiceBindingRequest: FromRequestUnmarshaller[ServiceBindingRequest]


  implicit def toEntityMarshallerServiceBindingResponse: ToEntityMarshaller[ServiceBindingResponse]

  implicit def toEntityMarshallerServiceBindingResponse: ToEntityMarshaller[ServiceBindingResponse]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshallerServiceBindingResource: ToEntityMarshaller[ServiceBindingResource]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshallerLastOperationResource: ToEntityMarshaller[LastOperationResource]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

}

