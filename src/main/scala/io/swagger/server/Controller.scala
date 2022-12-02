package io.swagger.server

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import io.swagger.server.api.CatalogApi
import io.swagger.server.api.ServiceBindingsApi
import io.swagger.server.api.ServiceInstancesApi
import akka.http.scaladsl.server.Directives._
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

class Controller(catalog: CatalogApi, serviceBindings: ServiceBindingsApi, serviceInstances: ServiceInstancesApi)(implicit system: ActorSystem, materializer: ActorMaterializer) {

    lazy val routes: Route = catalog.route ~ serviceBindings.route ~ serviceInstances.route 

    Http().bindAndHandle(routes, "0.0.0.0", 9000)
}