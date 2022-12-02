package io.swagger.server.model


/**
 * = ServiceInstanceProvisionResponse =
 *
 * @param dashboard_url 
 * @param metadata 
 */
case class ServiceInstanceProvisionResponse (
  dashboard_url: Option[String],
  metadata: Option[ServiceInstanceMetadata]
)

