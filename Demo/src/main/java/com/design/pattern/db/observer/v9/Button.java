package com.design.pattern.db.observer.v9;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private List<ActionListener> actionListeners = new ArrayList<>();

    public void buttonPressed() {
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        for (int i = 0; i < actionListeners.size(); i++) {
            ActionListener actionListener = actionListeners.get(i);
            actionListener.actionPerformed(event);
        }
    }

    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }
}
