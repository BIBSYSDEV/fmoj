package no.sikt.testdata;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class BadExampleProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of("https://example.org",
                         "https://creativecommons.org/licences/by/4.0",
                         "https://creativecommons.org/licenses/1.0/by",
                         "https://creativecommons.org/licenses/by/1.2",
                         "https://creativecommons.org:8080/licenses/by/1.0",
                         "https://balthazar@creativecommons.org/licenses/by/1.0",
                         "https://creativecommons.org/licenses/by/1.0/deed",
                         "https://creativecommons.org/licenses/by/1.0?query=10",
                         "https://creativecommons.org/licenses/by/1.0#fragment")
                   .map(Arguments::of);
    }
}
