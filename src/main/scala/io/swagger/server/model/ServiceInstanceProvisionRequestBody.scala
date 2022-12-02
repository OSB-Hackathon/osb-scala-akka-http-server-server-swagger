package io.swagger.server.model


/**
 * = ServiceInstanceProvisionRequestBody =
 *
 * @param context 
 * @param organization_guid 
 * @param parameters 
 * @param plan_id 
 * @param service_id 
 * @param space_guid 
 */
case class ServiceInstanceProvisionRequestBody (
  context: Option[Context],
  organization_guid: String,
  parameters: Option[Object],
  plan_id: String,
  service_id: String,
  space_guid: String
)

