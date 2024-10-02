# ARCHIVED

Please refer to the new repository location: https://github.ibm.com/instana/agent


----

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

The latest version of that jar can be found in [Artifact public -> com -> instana -> instana-javaagent](https://artifact-public.instana.io/artifactory/shared/com/instana/instana-javaagent/).

Should the J9 that is used be a Java 8 updated with recent fixpacks, this is no longer necessary, but a command line switch can be used instead. Since as of "Java 8 - Service refresh 3 fix pack 22 (Dec 2016)" an option exists which basically performs the same:

`-XX:+EnableHCR`

```
Use the -XX:+EnableHCR option to enable late attached agents to redefine or retransform classes. 
This option might incur a performance penalty. This option is temporary and deprecated and will
be removed in a future update when no longer necessary.
```
