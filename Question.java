package project_patrren;

import java.util.List;


class Question {
    
    private final String text;
    private final List<String> choices;
    private final int correctChoiceIndex;

    public Question(String text, List<String> choices, int correctChoiceIndex) {
        this.text = text;
        this.choices = choices;
        this.correctChoiceIndex = correctChoiceIndex;
    }

    // Methods for getting question text, choices, and checking the correct answer
   
}