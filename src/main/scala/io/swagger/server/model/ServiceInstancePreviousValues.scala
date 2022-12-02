package io.swagger.server.model


/**
 * = ServiceInstancePreviousValues =
 *
 * @param organization_id 
 * @param plan_id 
 * @param service_id 
 * @param space_id 
 */
case class ServiceInstancePreviousValues (
  organization_id: Option[String],
  plan_id: Option[String],
  service_id: Option[String],
  space_id: Option[String]
)

