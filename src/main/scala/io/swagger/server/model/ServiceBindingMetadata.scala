package io.swagger.server.model


/**
 * = ServiceBindingMetadata =
 *
 * @param expires_at 
 * @param renew_before 
 */
case class ServiceBindingMetadata (
  expires_at: Option[String],
  renew_before: Option[String]
)

