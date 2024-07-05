# Project Goal

Use Vaadin's Java web UI api with Springboot dependency injection to create view for your Playwrite tests\

# Insides

Playwright POM: https://github.com/petarYordanov/playwright-vaadin-ui/tree/master/src/main/java/com/example/pw

It's a good idea to use Java's nested classes concept for your locators: https://github.com/petarYordanov/playwright-vaadin-ui/blob/master/src/main/java/com/example/pw/Locators.java

So they can be called like:
```
assertThat(page.locator(Locators.Elections.RATIO_STATS_PER_CADIDATE).first()).hasText(expectedStats);
```

## Installation


```bash
mvn clean install
```

## Run Project

Start PlaywrightVaadinApplication.java
and
open in browser http://localhost:8080/
