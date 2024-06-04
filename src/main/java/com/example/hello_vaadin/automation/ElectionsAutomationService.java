package com.example.hello_vaadin.automation;

import com.example.pw.BasePagePw;
import com.example.pw.UsaElectionsPage;
import com.microsoft.playwright.Page;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.ValueWrapper;
import org.springframework.stereotype.Service;

@Service
class ElectionsAutomationService {

    Page page;
    UsaElectionsPage usaElectionsPage;


    public String electionsTest() {
        String result = "Test PASSED!";
        try {

            BasePagePw.startChromium(false, false);
            usaElectionsPage = new UsaElectionsPage(page);
            usaElectionsPage
                    .clickElectionsYear("2012")
                    .assertWinningCandidate("Barack Obama (Democrat)")
                    .assertCandidateStats("Electoral Votes: 341 (63%)");
            BasePagePw.closeBrowser();
        } catch (AssertionFailedError e) {
            result = "Test FAILED with error: " + e.getActual() + "is not the expected result :" + e.getExpected();
            BasePagePw.closeBrowser();
        }
        return result;
    }


    public String electionsWinTest() {
        String result = "Test PASSED!";
        try {
            BasePagePw.startChromium(false, false);
            usaElectionsPage = new UsaElectionsPage(page);
            usaElectionsPage
                    .clickElectionsYear("2016")
                    .assertWinningCandidate("Donald Trump (Republican)")
                    .assertCandidateStats("Electoral Votes: 304 (56.5%)");
            BasePagePw.closeBrowser();
        } catch (AssertionFailedError e) {
            result = "Test FAILED with error: " + e.getActual() + "is not the expected result :" + e.getExpected();
            BasePagePw.closeBrowser();
        }
        return result;
    }


    public void spyNetworkHeadersTest() throws Exception {
        usaElectionsPage = new UsaElectionsPage(page);
        String networkHeaders = usaElectionsPage.spyNetworkHeaders("usa-elections/data/elections-recent.json");
        System.out.println(networkHeaders);
        if (!networkHeaders.contains("content-security-policy=frame-ancestors"))
            throw new Exception("content-security-policy header does not contain the value 'frame-ancestors' ");

    }
}
