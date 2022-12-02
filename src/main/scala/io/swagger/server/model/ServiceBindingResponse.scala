package io.swagger.server.model


/**
 * = ServiceBindingResponse =
 *
 * @param credentials 
 * @param endpoints 
 * @param metadata 
 * @param route_service_url 
 * @param syslog_drain_url 
 * @param volume_mounts 
 */
case class ServiceBindingResponse (
  credentials: Option[Object],
  endpoints: Option[List[ServiceBindingEndpoint]],
  metadata: Option[ServiceBindingMetadata],
  route_service_url: Option[String],
  syslog_drain_url: Option[String],
  volume_mounts: Option[List[ServiceBindingVolumeMount]]
)

