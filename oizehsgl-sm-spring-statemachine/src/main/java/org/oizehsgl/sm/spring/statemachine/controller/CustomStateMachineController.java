package org.oizehsgl.sm.spring.statemachine.controller;

import jakarta.annotation.Resource;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.service.CustomStateMachineService;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachineEventResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author oizehsgl
 */
@RestController
public class CustomStateMachineController {
  @Resource
  private CustomStateMachineService customStateMachineService;

  @GetMapping("/s")
  public Flux<List<String>> s() {
    return Flux.just(List.of("1", "2", "3"));
  }

  @GetMapping("/state")
  public Mono<CustomState> state() {
    return Mono.defer(
        () ->
            Mono.justOrEmpty(
                customStateMachineService.acquireStateMachine("1024").getState().getId()));
  }

  @PostMapping("/event")
  public Flux<StateMachineEventResult<CustomState, CustomEvent>> event(
      // @RequestBody Flux<List<String>> stringFluxs
      ) {
    // System.out.println(stringFluxs);
    Flux<String> stringFlux = Flux.just("RESTART", "E2", "E3");

    Flux<StateMachineEventResult<CustomState, CustomEvent>> stateMachineEventResultFlux =
        customStateMachineService
            .acquireStateMachine("1024")
            .sendEvent(Mono.just(MessageBuilder.withPayload(CustomEvent.INITIAL).build()));
    return stateMachineEventResultFlux;
    // return stringFlux
    //    .map(CustomEvent::valueOf)
    //    .filter(Objects::isNull)
    //    .map(MessageBuilder::withPayload)
    //    .map(MessageBuilder::build)
    //    .map(Mono::just)
    //    .flatMap(customStateMachineService.acquireStateMachine("1024")::sendEvent);
  }
}
