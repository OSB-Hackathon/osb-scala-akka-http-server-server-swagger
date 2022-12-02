package io.swagger.server.model


/**
 * = ServiceBindingResouceObject =
 *
 * @param app_guid 
 * @param route 
 */
case class ServiceBindingResouceObject (
  app_guid: Option[String],
  route: Option[String]
)

