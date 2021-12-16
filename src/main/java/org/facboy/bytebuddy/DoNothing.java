package org.facboy.bytebuddy;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.AgentBuilder.Listener.StreamWriting;
import net.bytebuddy.dynamic.scaffold.TypeValidation;

public class DoNothing {

  public static void premain(String agentArgs, Instrumentation instrumentation) {
    ByteBuddy byteBuddy = new ByteBuddy().with(TypeValidation.DISABLED);
    AgentBuilder agentBuilder =
        new AgentBuilder.Default(byteBuddy).with(StreamWriting.toSystemError().withErrorsOnly());
    agentBuilder.installOn(instrumentation);
  }
}
