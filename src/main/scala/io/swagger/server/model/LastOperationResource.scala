package io.swagger.server.model


/**
 * = LastOperationResource =
 *
 * @param description 
 * @param instance_usable  for example: ''false''
 * @param state 
 * @param update_repeatable  for example: ''false''
 */
case class LastOperationResource (
  description: Option[String],
  instance_usable: Option[Boolean],
  state: String,
  update_repeatable: Option[Boolean]
)

