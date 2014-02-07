package servicelocator;

import org.testng.annotations.Test;

/**
 * The service locator design pattern is used when we want to locate various
 * services using JNDI lookup. Considering high cost of looking up JNDI for a
 * service, Service Locator pattern makes use of caching technique. For the
 * first time a service is required, Service Locator looks up in JNDI and caches
 * the service object. Further lookup or same service via Service Locator is
 * done in its cache which improves the performance of application to great
 * extent. Following are the entities of this type of design pattern.
 * <ul>
 * <li>Service - Actual Service which will process the request. Reference of
 * such service is to be looked upon in JNDI server.
 * 
 * <li>Context / Initial Context -JNDI Context, carries the reference to service
 * used for lookup purpose.
 * 
 * <li>Service Locator - Service Locator is a single point of contact to get
 * services by JNDI lookup, caching the services.
 * 
 * <li>Cache - Cache to store references of services to reuse them
 * 
 * <li>Client - Client is the object who invokes the services via
 * ServiceLocator.
 * </ul>
 * 
 * @author ktakemur
 * 
 */
public class ServiceLocatorPatternTest {
	@Test
	public void f() {
		Service service = ServiceLocator.getService("Service1");
		service.execute();
		service = ServiceLocator.getService("Service2");
		service.execute();
		service = ServiceLocator.getService("Service1");
		service.execute();
		service = ServiceLocator.getService("Service2");
		service.execute();
	}
}
