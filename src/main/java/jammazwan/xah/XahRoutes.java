package jammazwan.xah;

import org.apache.camel.builder.RouteBuilder;

public class XahRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:xah").split().body().to("mock:assert");
	}
}
