package no.sikt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import java.net.URI;
import no.sikt.testdata.BadExampleProvider;
import no.sikt.testdata.GoodExampleProvider;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class CreativeCommonsLicenseTest {

    @Test
    void shouldCreateCreativeCommonsUri() {
        var uri = URI.create("https://example.org");
        var actual = "https://example.org"; // Do something here?
        assertThat(actual, is(equalTo(uri)));
    }

    /*
    As a convenience, the BadExampleProvider has been created.

    Un-disable the test and run to see the examples.
     */

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(BadExampleProvider.class)
    void shouldReturnInvalidWhenUriIsInvalid(URI invalidUri) {
        System.out.println(invalidUri.toString());
    }

    /*
    As a convenience, the GoodExampleProvider has been created.

    Un-disable the test and run to see the examples.
     */

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(GoodExampleProvider.class)
    void shouldReturnValidWhenUriIsValid(URI validUri) {
        System.out.println(validUri.toString());
    }
}