package org.geogebra.common.spy.builder;

import org.geogebra.common.factories.FormatFactory;
import org.geogebra.common.kernel.parser.cashandlers.ParserFunctions;
import org.geogebra.common.main.App;
import org.geogebra.common.main.AppConfig;
import org.geogebra.common.main.Localization;
import org.geogebra.common.util.NumberFormatAdapter;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Vector;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Creates an App mock.
 */
public class AppBuilder extends SpyBuilder<App>{

	private FormatFactory formatFactory;

	@Override
	App createSpy() {
		mockFormatFactory();
		final App app = mock(App.class);
		app.images = new Vector<>();
		when(app.getConfig()).then(new Answer<AppConfig>() {
			@Override
			public AppConfig answer(InvocationOnMock invocation) {
				return mock(AppConfig.class);
			}
		});
		when(app.getParserFunctions()).then(new Answer<ParserFunctions>() {
			@Override
			public ParserFunctions answer(InvocationOnMock invocation) {
				return mock(ParserFunctions.class);
			}
		});
		when(app.getLocalization()).then(new Answer<Localization>() {
			@Override
			public Localization answer(InvocationOnMock invocation) {
				return mock(Localization.class);
			}
		});
		return app;
	}

	/**
	 * The App uses the FormatFactory's prototype,
	 * so the prototype must be set before constructing the App mock.
	 */
	private void mockFormatFactory() {
		FormatFactory.setPrototypeIfNull(getFormatFactory());
	}

	private FormatFactory getFormatFactory() {
		if (formatFactory == null) {
			formatFactory = createFormatFactory();
		}
		return formatFactory;
	}

	private FormatFactory createFormatFactory() {
		final FormatFactory formatFactory = mock(FormatFactory.class);
		when(formatFactory.getNumberFormat(anyInt())).then(new Answer<NumberFormatAdapter>() {
			@Override
			public NumberFormatAdapter answer(InvocationOnMock invocationOnMock) {
				return mock(NumberFormatAdapter.class);
			}
		});
		return formatFactory;
	}

}