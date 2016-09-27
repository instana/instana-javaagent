package com.instana.agent.javaagent;

import java.lang.instrument.Instrumentation;

/**
 * A Java agent that only ensures that a dynamically attached agent can retransform classes on J9 and ensures the
 * Instrumentation API is loaded.
 */
public class InstanaStartupAgent {

  public static void premain(String argument, Instrumentation instrumentation) {
    if (instrumentation.getAllLoadedClasses().length == 0) {
      System.err.println("Instana Agent could not initialize Instrumenation API");
    }
  }
}
