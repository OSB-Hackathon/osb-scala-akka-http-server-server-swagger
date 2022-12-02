package io.swagger.server.model


/**
 * = ServiceBindingVolumeMount =
 *
 * @param container_dir 
 * @param device 
 * @param device_type 
 * @param driver 
 * @param mode 
 */
case class ServiceBindingVolumeMount (
  container_dir: String,
  device: ServiceBindingVolumeMountDevice,
  device_type: String,
  driver: String,
  mode: String
)

