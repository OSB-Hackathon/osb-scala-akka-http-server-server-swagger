package io.swagger.server.model


/**
 * = ServiceBindingEndpoint =
 *
 * @param host 
 * @param ports 
 * @param protocol 
 */
case class ServiceBindingEndpoint (
  host: String,
  ports: List[String],
  protocol: Option[String]
)

