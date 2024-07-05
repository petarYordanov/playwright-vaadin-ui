# Project Goal

Use Vaadin's Java web UI api with Springboot dependency injection to create view for your Playwrite tests\

# Insides

Playwright POM: https://github.com/petarYordanov/playwright-vaadin-ui/tree/master/src/main/java/com/example/pw

It's a good idea to use Java's nested classes concept for your locators: https://github.com/petarYordanov/playwright-vaadin-ui/blob/master/src/main/java/com/example/pw/Locators.java

So they can be called like:
```
assertThat(page.locator(Locators.Elections.RATIO_STATS_PER_CADIDATE).first()).hasText(expectedStats);
```

Using the Springboot Service and Dependency Injection concept to create test scenarios: https://github.com/petarYordanov/playwright-vaadin-ui/blob/master/src/main/java/com/example/hello_vaadin/automation/ElectionsAutomationService.java

Cool thing about Playwright is the assertion api that comes with the framework, so in that service you may exploit **AssertionFailedError** and customize it

The dependency injection from the Service allows the view from Vaadin's api to generate web view in Java that's only restricted by your imagination:
https://github.com/petarYordanov/playwright-vaadin-ui/blob/master/src/main/java/com/example/hello_vaadin/automation/ElectAutoView.java



## Installation


```bash
mvn clean install
```

## Run Project

Start PlaywrightVaadinApplication.java
and
open in browser http://localhost:8080/
