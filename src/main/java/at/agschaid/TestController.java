package at.agschaid;

import at.agschaid.model.EntityWithMap;
import at.agschaid.service.TestService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Put;
import io.reactivex.rxjava3.core.Completable;
import jakarta.inject.Inject;

@Controller(value = "test", consumes = MediaType.APPLICATION_JSON )
public class TestController {

  @Inject
  TestService testService;

  @Put("/entity")
  public void receiveEntity(EntityWithMap entity) {
    testService.handleEntity(entity);
  }

  @Put("/entityReactive")
  public Completable receiveEntityReactive(EntityWithMap entity) {
    return testService.handleEntityReactive(entity);
  }

}


