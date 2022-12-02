package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model../Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}
import io.swagger.server.model../Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
import io.swagger.server.model../Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}
import io.swagger.server.model.LastOperationResource
import io.swagger.server.model.ServiceInstanceProvisionRequestBody
import io.swagger.server.model.ServiceInstanceProvisionResponse
import io.swagger.server.model.ServiceInstanceResource
import io.swagger.server.model.ServiceInstanceUpdateRequestBody

class ServiceInstancesApi(
    serviceInstancesService: ServiceInstancesApiService,
    serviceInstancesMarshaller: ServiceInstancesApiMarshaller
) {
  import serviceInstancesMarshaller._

  lazy val route: Route =
    path() { (instanceId) => 
      delete {
        parameters("service_id".as[String], "plan_id".as[String], "accepts_incomplete".as[Boolean].?) { (serviceId, planId, acceptsIncomplete) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                
                  serviceInstancesService.serviceInstanceDeprovisionUsingDELETE(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, serviceId = serviceId, planId = planId, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, acceptsIncomplete = acceptsIncomplete)
               
             
            }
          } }
        }
      }
    } ~
    path() { (instanceId) => 
      get {
        parameters("service_id".as[String].?, "plan_id".as[String].?) { (serviceId, planId) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                
                  serviceInstancesService.serviceInstanceGetUsingGET(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, serviceId = serviceId, planId = planId)
               
             
            }
          } }
        }
      }
    } ~
    path() { (instanceId) => 
      get {
        parameters("service_id".as[String].?, "plan_id".as[String].?, "operation".as[String].?) { (serviceId, planId, operation) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => 
            formFields() { () =>
              
                
                  serviceInstancesService.serviceInstanceLastOperationGetUsingGET(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, serviceId = serviceId, planId = planId, operation = operation)
               
             
            }
          }
        }
      }
    } ~
    path() { (instanceId) => 
      put {
        parameters("accepts_incomplete".as[Boolean].?) { (acceptsIncomplete) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                entity(as[ServiceInstanceProvisionRequestBody]){ body =>
                  serviceInstancesService.serviceInstanceProvisionUsingPUT(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, body = body, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, acceptsIncomplete = acceptsIncomplete)
                }
             
            }
          } }
        }
      }
    } ~
    path() { (instanceId) => 
      patch {
        parameters("accepts_incomplete".as[Boolean].?) { (acceptsIncomplete) =>
          headerValueByName("X-Broker-API-Version") { xBrokerAPIVersion => optionalHeaderValueByName("X-Broker-API-Originating-Identity") { xBrokerAPIOriginatingIdentity => 
            formFields() { () =>
              
                entity(as[ServiceInstanceUpdateRequestBody]){ body =>
                  serviceInstancesService.serviceInstanceUpdateUsingPATCH(xBrokerAPIVersion = xBrokerAPIVersion, instanceId = instanceId, body = body, xBrokerAPIOriginatingIdentity = xBrokerAPIOriginatingIdentity, acceptsIncomplete = acceptsIncomplete)
                }
             
            }
          } }
        }
      }
    }
}

trait ServiceInstancesApiService {

  def serviceInstanceDeprovisionUsingDELETE200(responseObject: Object): Route =
    complete((200, responseObject))
  def serviceInstanceDeprovisionUsingDELETE202(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}]): Route =
    complete((202, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}))
  def serviceInstanceDeprovisionUsingDELETE204: Route =
    complete((204, "No Content"))
  def serviceInstanceDeprovisionUsingDELETE400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceDeprovisionUsingDELETE401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceDeprovisionUsingDELETE403: Route =
    complete((403, "Forbidden"))
  def serviceInstanceDeprovisionUsingDELETE410(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((410, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceDeprovisionUsingDELETE422(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
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
  def serviceInstanceDeprovisionUsingDELETE(xBrokerAPIVersion: String, instanceId: String, serviceId: String, planId: String, xBrokerAPIOriginatingIdentity: Option[String], acceptsIncomplete: Option[Boolean])
      (implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceInstanceGetUsingGET200(responseServiceInstanceResource: ServiceInstanceResource)(implicit toEntityMarshallerServiceInstanceResource: ToEntityMarshaller[ServiceInstanceResource]): Route =
    complete((200, responseServiceInstanceResource))
  def serviceInstanceGetUsingGET401: Route =
    complete((401, "Unauthorized"))
  def serviceInstanceGetUsingGET403: Route =
    complete((403, "Forbidden"))
  def serviceInstanceGetUsingGET404(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((404, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: ServiceInstanceResource
   * Code: 401, Message: Unauthorized
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceInstanceGetUsingGET(xBrokerAPIVersion: String, instanceId: String, xBrokerAPIOriginatingIdentity: Option[String], serviceId: Option[String], planId: Option[String])
      (implicit toEntityMarshallerServiceInstanceResource: ToEntityMarshaller[ServiceInstanceResource], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceInstanceLastOperationGetUsingGET200(responseLastOperationResource: LastOperationResource)(implicit toEntityMarshallerLastOperationResource: ToEntityMarshaller[LastOperationResource]): Route =
    complete((200, responseLastOperationResource))
  def serviceInstanceLastOperationGetUsingGET400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceLastOperationGetUsingGET401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceLastOperationGetUsingGET403: Route =
    complete((403, "Forbidden"))
  def serviceInstanceLastOperationGetUsingGET404(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((404, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceLastOperationGetUsingGET410(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((410, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: LastOperationResource
   * Code: 400, Message: Bad Request, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 401, Message: Unauthorized, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 410, Message: Gone, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceInstanceLastOperationGetUsingGET(xBrokerAPIVersion: String, instanceId: String, serviceId: Option[String], planId: Option[String], operation: Option[String])
      (implicit toEntityMarshallerLastOperationResource: ToEntityMarshaller[LastOperationResource], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceInstanceProvisionUsingPUT200(responseServiceInstanceProvisionResponse: ServiceInstanceProvisionResponse)(implicit toEntityMarshallerServiceInstanceProvisionResponse: ToEntityMarshaller[ServiceInstanceProvisionResponse]): Route =
    complete((200, responseServiceInstanceProvisionResponse))
  def serviceInstanceProvisionUsingPUT201(responseServiceInstanceProvisionResponse: ServiceInstanceProvisionResponse)(implicit toEntityMarshallerServiceInstanceProvisionResponse: ToEntityMarshaller[ServiceInstanceProvisionResponse]): Route =
    complete((201, responseServiceInstanceProvisionResponse))
  def serviceInstanceProvisionUsingPUT202(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}]): Route =
    complete((202, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}))
  def serviceInstanceProvisionUsingPUT400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceProvisionUsingPUT401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceProvisionUsingPUT403: Route =
    complete((403, "Forbidden"))
  def serviceInstanceProvisionUsingPUT404: Route =
    complete((404, "Not Found"))
  def serviceInstanceProvisionUsingPUT409(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((409, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceProvisionUsingPUT422(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((422, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: ServiceInstanceProvisionResponse
   * Code: 201, Message: Created, DataType: ServiceInstanceProvisionResponse
   * Code: 202, Message: Accepted, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}
   * Code: 400, Message: Bad Request, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 401, Message: Unauthorized, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 403, Message: Forbidden
   * Code: 404, Message: Not Found
   * Code: 409, Message: Conflict, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 422, Message: Unprocessable Entity, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceInstanceProvisionUsingPUT(xBrokerAPIVersion: String, instanceId: String, body: ServiceInstanceProvisionRequestBody, xBrokerAPIOriginatingIdentity: Option[String], acceptsIncomplete: Option[Boolean])
      (implicit toEntityMarshallerServiceInstanceProvisionResponse: ToEntityMarshaller[ServiceInstanceProvisionResponse], toEntityMarshallerServiceInstanceProvisionResponse: ToEntityMarshaller[ServiceInstanceProvisionResponse], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

  def serviceInstanceUpdateUsingPATCH200(responseObject: Object): Route =
    complete((200, responseObject))
  def serviceInstanceUpdateUsingPATCH202(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}]): Route =
    complete((202, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}))
  def serviceInstanceUpdateUsingPATCH204: Route =
    complete((204, "No Content"))
  def serviceInstanceUpdateUsingPATCH400(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((400, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceUpdateUsingPATCH401(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((401, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  def serviceInstanceUpdateUsingPATCH403: Route =
    complete((403, "Forbidden"))
  def serviceInstanceUpdateUsingPATCH422(response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;})(implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route =
    complete((422, response./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}))
  /**
   * Code: 200, Message: OK, DataType: Object
   * Code: 202, Message: Accepted, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}
   * Code: 204, Message: No Content
   * Code: 400, Message: Bad Request, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 401, Message: Unauthorized, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   * Code: 403, Message: Forbidden
   * Code: 422, Message: Unprocessable entity, DataType: ./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}
   */
  def serviceInstanceUpdateUsingPATCH(xBrokerAPIVersion: String, instanceId: String, body: ServiceInstanceUpdateRequestBody, xBrokerAPIOriginatingIdentity: Option[String], acceptsIncomplete: Option[Boolean])
      (implicit toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}], toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]): Route

}

trait ServiceInstancesApiMarshaller {
  implicit def fromRequestUnmarshallerServiceInstanceProvisionRequestBody: FromRequestUnmarshaller[ServiceInstanceProvisionRequestBody]

  implicit def fromRequestUnmarshallerServiceInstanceUpdateRequestBody: FromRequestUnmarshaller[ServiceInstanceUpdateRequestBody]


  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;AsyncOperation&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshallerServiceInstanceResource: ToEntityMarshaller[ServiceInstanceResource]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshallerLastOperationResource: ToEntityMarshaller[LastOperationResource]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshallerServiceInstanceProvisionResponse: ToEntityMarshaller[ServiceInstanceProvisionResponse]

  implicit def toEntityMarshallerServiceInstanceProvisionResponse: ToEntityMarshaller[ServiceInstanceProvisionResponse]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;ServiceInstanceAsyncOperation&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

  implicit def toEntityMarshaller./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}: ToEntityMarshaller[./Error-ModelName{namespace&#x3D;&#x27;io.swagger.model&#x27;, name&#x3D;&#x27;Error&#x27;}]

}

