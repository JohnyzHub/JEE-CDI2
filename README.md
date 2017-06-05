# JEE-CDI2
JEE 7 CDI 2.x Practice Project.



					CDI – Annotations


1. Inject – Makes POJO a bean
2. Vetoed – Type or package may be prevented from being considered a bean.
3. Named – Assigns a EL name for the bean.
4. PostConstruct  - Callback method after bean creation.                   
5. PreDestroy – Callback method before starting to destroy a bean.


6. Default - This is by implicitly applied by default as qualifier.
7. Qualifier – To mark the bean with special qualification.
8. Nonbinding – To mark a field that it is not part of qualifier, while determining bean 				qualification.


9. Produces – Produces a bean for non-bean class. 
 Produces a runtime implementation of eligible bean.

          InjectionPoint* - Provides the metadata about 
							the injection point to the object being
							injected into.
10. Disposes – Disposes the @Produces bean.


11. Scope – Specifies the scope of bean.
12. Alternative – Alternative beans. Must be enabled in beans.xml file



Scopes:
1. ApplicationScoped – Entire duration of application.
2. SessionScoped – Entire duration of a session.
3. ReuqestScoped – For a single request
4. ConversationScoped – Associated with user, spans multiple requests and is demarcated
 programatically by the application.
5. Dependent (Default scope) – this scope starts with bean injection and ends with bean removal.




Interceptors: 
	
1. Interceptor – Cross cutting functionality
2. Interceptors – For chaining the interceptors
3. ExcludeClassInterceptors – Excludes class from interceptor calls.
4. InterceptorBinding – Binds the interceptor class with intercepted class.
5. Transactional – Provides transactional interception.
6. Priority – Prioritizes the order of interceptor methods order.
7. Constructor level
AroundConstruct
8. Method level
AroundInvoke
9. Timeout level – (for ejb timers)
AroundTimeout



Events:   

1. Event* - Event object
2. fire - fires the event synchronously.
3. fireAsync - Fires the event asynchronously.
4. Observes - Observes the event.
5. ObservesAsync - Observes the event asynchronously.
6. WithAnnotations – Applies only to the event parameters.
7. Priority – Prioritizes the order of event notification.
				Priority applies only to events fires synchronously.
				
				fire <-> observes
				fireAsync <-> observesAsync

Decorators:
1. Decorator
2. Delegate


Interceptor, Decorators must be enabled explicitly in beans.xml file