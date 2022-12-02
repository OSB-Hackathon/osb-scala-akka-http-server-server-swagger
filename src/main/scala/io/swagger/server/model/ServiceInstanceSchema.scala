package io.swagger.server.model


/**
 * = ServiceInstanceSchema =
 *
 * @param create 
 * @param update 
 */
case class ServiceInstanceSchema (
  create: Option[ServiceInstanceSchemaCreate],
  update: Option[ServiceInstanceSchemaCreate]
)

