package io.swagger.server.model


/**
 * = DashboardClient =
 *
 * @param id 
 * @param redirect_uri 
 * @param secret 
 */
case class DashboardClient (
  id: Option[String],
  redirect_uri: Option[String],
  secret: Option[String]
)

