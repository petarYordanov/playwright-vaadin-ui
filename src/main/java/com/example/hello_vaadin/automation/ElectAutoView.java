package com.example.hello_vaadin.automation;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("")
public class ElectAutoView extends VerticalLayout {

    public ElectAutoView(ElectionsAutomationService electionsAutomationService){

        // base layout
        VerticalLayout testsList = new VerticalLayout();
        testsList.add(new H1("US Elections Tests"));


        // 2012 elections test layout
        TextArea area2012 = setupTestLayout(
                "clickElectionsYear(\"2012\")\n" +
                        "assertWinningCandidate(\"Barack Obama (Democrat)\")\n" +
                        "assertCandidateStats(\"Electoral Votes: 341 (63%)\");"
        );
        Button button2012 = setupTestButton("Run Elections 2012 Test");
        button2012.addClickListener(click -> {
            add(new H3(
            electionsAutomationService.electionsTest())
            );
        });

        // 2016 elections test layout
        TextArea area2016 = setupTestLayout(
                "clickElectionsYear(\"2016\")\n" +
                        "assertWinningCandidate(\"Donald Trump (Republican)\")\n" +
                        "assertCandidateStats(\"Electoral Votes: 304 (56.5%)\")"
        );
        Button button2016 = setupTestButton("Run Elections 2016 Test");
        button2016.addClickListener(click -> {
            add(new H3(
                    electionsAutomationService.electionsWinTest())
            );
        });



// add all elements to the view
        add(
                testsList,
                new VerticalLayout(
                        area2012,
                        button2012,
                        area2016,
                        button2016
                )
        );

    }

    private TextArea setupTestLayout(String value){
        TextArea textArea = new TextArea();
        textArea.setWidth("470px");
        textArea.setLabel("Test Steps");
        textArea.setValue(value);

        return textArea;
    }

    private Button setupTestButton(String buttonText){
        Button addButton = new Button(buttonText);
        return addButton;
    }
}
