package io.swagger.server.model


/**
 * = Service =
 *
 * @param bindable  for example: ''false''
 * @param binding_rotatable  for example: ''false''
 * @param dashboard_client 
 * @param description 
 * @param id 
 * @param metadata 
 * @param name 
 * @param plan_updateable  for example: ''false''
 * @param plans 
 * @param requires 
 * @param tags 
 */
case class Service (
  bindable: Boolean,
  binding_rotatable: Option[Boolean],
  dashboard_client: Option[DashboardClient],
  description: String,
  id: String,
  metadata: Option[Metadata],
  name: String,
  plan_updateable: Option[Boolean],
  plans: List[Plan],
  requires: Option[List[String]],
  tags: Option[List[String]]
)

