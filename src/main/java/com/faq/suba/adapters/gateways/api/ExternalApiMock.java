package com.faq.suba.adapters.gateways.api;

import java.util.Random;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

public class ExternalApiMock implements ExternalApiGateway {

  /**
   * Para emular el servicio externo se genera número entre 0 y 101
   * con los siguientes casos:
   * 
   * 0: el servicio no devuelve valor -> error en la api que llama
   * 101: una excepción en el servicio -> se espera el reintento (3 veces)
   * 1..100: es devuelto por el mock
   * 
   */
  @Override
  @Scheduled(fixedRate = 30 * 60 * 1000)
  @CacheEvict(value = "percent", allEntries = true)
  public double get() throws Exception {
    /* Se generan numeros entre 0 y 101 */
    var percent = new Random().nextInt(102);

    switch (percent) {
      /* Caso para que devuelva sin valor */
      case 0:
        return 0D;
      /* Caso para que devuelva una excepción -> servicio externo falló */
      case 101:
        throw new Exception("Error al obtener dato desde servicio externo");
      /* Por defecto devolverá un valor entre 1 y 100 */
      default:
        return percent;
    }
  }

}
