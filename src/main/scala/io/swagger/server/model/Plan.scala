package io.swagger.server.model


/**
 * = Plan =
 *
 * @param bindable  for example: ''false''
 * @param binding_rotatable  for example: ''false''
 * @param description 
 * @param free  for example: ''false''
 * @param id 
 * @param maintenance_info 
 * @param maximum_polling_duration 
 * @param metadata 
 * @param name 
 * @param plan_updateable  for example: ''false''
 * @param schemas 
 */
case class Plan (
  bindable: Option[Boolean],
  binding_rotatable: Option[Boolean],
  description: String,
  free: Option[Boolean],
  id: String,
  maintenance_info: Option[MaintenanceInfo],
  maximum_polling_duration: Option[Int],
  metadata: Option[Metadata],
  name: String,
  plan_updateable: Option[Boolean],
  schemas: Option[Schemas]
)

