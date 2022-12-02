package io.swagger.server.model


/**
 * = ServiceBindingRequest =
 *
 * @param app_guid 
 * @param bind_resource 
 * @param context 
 * @param parameters 
 * @param plan_id 
 * @param predecessor_binding_id 
 * @param service_id 
 */
case class ServiceBindingRequest (
  app_guid: Option[String],
  bind_resource: Option[ServiceBindingResouceObject],
  context: Option[Context],
  parameters: Option[Object],
  plan_id: String,
  predecessor_binding_id: Option[String],
  service_id: String
)

