package jammazwan.xah;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class XahRoutes extends RouteBuilder {
	
	@Autowired
	private XahBean xahBean;

	/*
	 * see NOTES.md
	 */

	@Override
	public void configure() throws Exception {
		// A
		from("direct:xah1").split().body().to("mock:assert1");
		// B
		from("direct:xah2").split().method(xahBean).to("mock:assert2");
		// C
		from("direct:xah3").split(simple("${collate(2)}")).to("mock:assert3");
	}
}
