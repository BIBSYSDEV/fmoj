package no.sikt.testdata;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class GoodExampleProvider implements ArgumentsProvider {

    private static final String BY_NC_ND = "by-nc-nd";
    private static final Set<String> LICENSE_TYPES = Set.of("by", "by-sa", "by-nc", "by-nc-sa", "by-nd", BY_NC_ND);
    private static final String PATH_SEPARATOR = "/";
    private static final String CREATIVECOMMONS_ORG_LICENSES = "//creativecommons.org/licenses/";
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final Set<String> SCHEMES = Set.of(HTTP, HTTPS);
    private static final String ANOMALOUS_ND_NC_V1 = "by-nd-nc";
    private static final String VERSION_ONE = "1.0";
    private static final String[] SUPPORTED_VERSIONS = {VERSION_ONE, "2.0", "2.5", "3.0", "4.0"};

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(SUPPORTED_VERSIONS)
                   .flatMap(GoodExampleProvider::createStandardPatternLicenseType)
                   .flatMap(GoodExampleProvider::createCreativeDualSchemeCommonsUris)
                   .map(Arguments::of);
    }

    private static Stream<String> createStandardPatternLicenseType(String version) {
        return LICENSE_TYPES.stream()
                   .map(item -> createLicenseVersion(version, item));
    }

    private static String createLicenseVersion(String version, String license) {
        return String.join(PATH_SEPARATOR, findRequiredLicenseByVersion(version, license), version);
    }

    private static String findRequiredLicenseByVersion(String version, String license) {
        return isAnomalousLicense(version, license) ? ANOMALOUS_ND_NC_V1 : license;
    }

    private static boolean isAnomalousLicense(String version, String license) {
        return version.equalsIgnoreCase(VERSION_ONE) && license.equalsIgnoreCase(BY_NC_ND);
    }

    private static Stream<URI> createCreativeDualSchemeCommonsUris(String path) {
        return SCHEMES.stream().map(scheme -> buildUri(scheme, path));
    }

    private static URI buildUri(String scheme, String path) {
        try {
            return new URI(scheme, CREATIVECOMMONS_ORG_LICENSES + path, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
