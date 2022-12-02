package io.swagger.server.model


/**
 * = ServiceInstanceResource =
 *
 * @param dashboard_url 
 * @param maintenance_info 
 * @param metadata 
 * @param parameters 
 * @param plan_id 
 * @param service_id 
 */
case class ServiceInstanceResource (
  dashboard_url: Option[String],
  maintenance_info: Option[MaintenanceInfo],
  metadata: Option[ServiceInstanceMetadata],
  parameters: Option[Object],
  plan_id: Option[String],
  service_id: Option[String]
)

