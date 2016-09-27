# Instana JVM Startup Agent

The Instana agent architecture is modular. When the Instana agent runs, it will
perform a runtime attach to any JVM and load the required classes lazily.

Compatibility tests however have shown that certain versions of J9 do not
support all required features when no `-javaagent` was present on the JVM start
command line. J9 will log a message like this:

    *** java.lang.instrument ASSERTION FAILED ***: "jvmtierror == JVMTI_ERROR_NOT_AVAILABLE" at JPLISAgent.c line: 1009

Additionally tests have shown that the first runtime attach can cause a short
pause when the JVM starts the necessary services for the agent.

For those reasons we recommend to start the JVM with this javaagent like this:

`java -javaagent:instana-javaagent-1.0.0.jar -jar app.jar server`

The latest version of that jar can be found in [MavenCentral -> Instana](http://central.maven.org/maven2/com/instana/instana-javaagent/).
