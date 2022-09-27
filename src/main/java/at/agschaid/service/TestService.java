package at.agschaid.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.agschaid.model.EntityWithMap;
import jakarta.inject.Singleton;

@Singleton
public class TestService {

  private static Logger LOG = LoggerFactory.getLogger(TestService.class);

  public void handleEntity(EntityWithMap entity) {
    LOG.info("received {}", entity);
  }

}
