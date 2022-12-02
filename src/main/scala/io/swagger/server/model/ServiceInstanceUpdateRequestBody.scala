package io.swagger.server.model


/**
 * = ServiceInstanceUpdateRequestBody =
 *
 * @param context 
 * @param parameters 
 * @param plan_id 
 * @param previous_values 
 * @param service_id 
 */
case class ServiceInstanceUpdateRequestBody (
  context: Option[Context],
  parameters: Option[Object],
  plan_id: Option[String],
  previous_values: Option[ServiceInstancePreviousValues],
  service_id: String
)

