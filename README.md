# CREATIVE COMMONS LICENSE

## Preliminaries

This task is an actual task we might perform, yes it is banal, but it is relatively important to avoid GIGO situations since we work with diverse sources.

We will work together. 

We are less interested in solving the entire problem, and more interested in seeing how you reason about code and work with us. 

This goes both ways, take the time to reflect on how we work and reflect on our practices.

We do TDD all the time, so we will do TDD now. Since we're doing TDD, the code QA settings are quite high.

## Task summary

Create an API for Creative Commons License URIs.

## Definitions

### License
A legal document that defines rights and restrictions related to the use of a thing.

For us, a license is ALWAYS represented by a URI in the format:

```
   http(s)://creativecommons.org/licenses/{license-code}/{version}
```

## Task 1

```Gherkin
  When a CreativeCommonsLicense is created with any URI
  Then the URI can be retrieved
```

## Task 2

```Gherkin
  Given a CreativeCommonsLicense created with an HTTP scheme
  When the URI is retrieved
  Then the URI has an HTTPS scheme
```

## Task 3
Background information: [License details](https://wiki.creativecommons.org/wiki/License_Versions)

Questions: 
- how would you approach testing this?
- how are we validating?
- when are we validating?
- where and when do we manage failures?
- what is a validation response?

Note that the [v1.0 BY-ND-NC](https://creativecommons.org/licenses/by-nd-nc/1.0) is anomalous (but the [NC-ND URI](https://creativecommons.org/licenses/by-nc-nd/1.0/) actually resolves…with a 303 response)
```Gherkin
  Given a CreativeCommonsLicense created with a URI
  When the license is validated
  Then a validation response is received
```

## Task 4

```Gherkin
  Given a CreativeCommonsLicense created with the URI https://creativecommons.org/publicdomain/zero/1.0
  When the URI is validated
  Then the URI is considered valid
```