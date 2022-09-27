package at.agschaid.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.agschaid.model.EntityWithMap;
import io.reactivex.rxjava3.core.Completable;
import jakarta.inject.Singleton;

@Singleton
public class TestService {

  private static Logger LOG = LoggerFactory.getLogger(TestService.class);

  public void handleEntity(EntityWithMap entity) {
    LOG.info("received: {}", entity);
  }

  public Completable handleEntityReactive(EntityWithMap entity) {
    return Completable.fromRunnable(() -> {
    LOG.info("received reactively: {}", entity);
    });
  }

}
