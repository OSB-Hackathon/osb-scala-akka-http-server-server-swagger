package io.swagger.server.model


/**
 * = Schemas =
 *
 * @param service_binding 
 * @param service_instance 
 */
case class Schemas (
  service_binding: Option[ServiceBindingSchema],
  service_instance: Option[ServiceInstanceSchema]
)

