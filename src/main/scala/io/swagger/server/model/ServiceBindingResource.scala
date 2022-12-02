package io.swagger.server.model


/**
 * = ServiceBindingResource =
 *
 * @param credentials 
 * @param endpoints 
 * @param metadata 
 * @param parameters 
 * @param route_service_url 
 * @param syslog_drain_url 
 * @param volume_mounts 
 */
case class ServiceBindingResource (
  credentials: Option[Object],
  endpoints: Option[List[ServiceBindingEndpoint]],
  metadata: Option[ServiceBindingMetadata],
  parameters: Option[Object],
  route_service_url: Option[String],
  syslog_drain_url: Option[String],
  volume_mounts: Option[List[ServiceBindingVolumeMount]]
)

