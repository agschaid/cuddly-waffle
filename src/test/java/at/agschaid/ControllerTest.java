package at.agschaid;


import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import at.agschaid.model.EntityWithMap;
import at.agschaid.service.TestService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.reactivex.rxjava3.core.Completable;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@MicronautTest
public class ControllerTest {

  @Inject
  @Client("/test")
  HttpClient client;

  @Inject
  TestService serviceMock;

  @MockBean(TestService.class)
  public TestService mockTestService() {
    return Mockito.mock(TestService.class);
  }

  @AfterEach
  public void verifyMocks() {
    Mockito.verifyNoMoreInteractions(serviceMock);
  }

  @Test
  public void testNullValueInMap() throws InterruptedException {

    final String serialized = "{ \"simpleString\":\"just a simple man\", \"stringMap\":{ \"foo\":\"bar\", \"testNull\":null } }";
    final HttpRequest request = HttpRequest.PUT("/entity", serialized);
    Mono.from(client.exchange(request)).block();

    ArgumentCaptor<EntityWithMap> entityCaptor = ArgumentCaptor.forClass(EntityWithMap.class);
    verify(serviceMock).handleEntity(entityCaptor.capture());

    final EntityWithMap entityInService = entityCaptor.getValue();
    assertTrue(entityInService.getStringMap().containsKey("testNull"));
    assertNull(entityInService.getStringMap().get("testNull"));

  }

  @Test
  public void testNullValueInMapReactively() throws InterruptedException {

    Mockito.when(serviceMock.handleEntityReactive(any())).thenReturn(Completable.complete());

      final String serialized = "{ \"simpleString\":\"just a simple man\", \"stringMap\":{ \"foo\":\"bar\", \"testNull\":null }, \"objectMap\": { \"oans\": { \"aString\":\"eins\" }, \"koans\": null } }";
    final HttpRequest request = HttpRequest.PUT("/entityReactive", serialized);
    Mono.from(client.exchange(request)).block();

    ArgumentCaptor<EntityWithMap> entityCaptor = ArgumentCaptor.forClass(EntityWithMap.class);
    verify(serviceMock).handleEntityReactive(entityCaptor.capture());

    final EntityWithMap entityInService = entityCaptor.getValue();
    assertTrue(entityInService.getStringMap().containsKey("testNull"));
    assertNull(entityInService.getStringMap().get("testNull"));
    assertTrue(entityInService.getObjectMap().containsKey("koans"));
    assertNull(entityInService.getObjectMap().get("koans"));

  }

}
