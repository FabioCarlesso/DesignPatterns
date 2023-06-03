package com.fabiocarlesso.mainexecution;

import com.fabiocarlesso.observer.editor.Editor;
import com.fabiocarlesso.observer.listeners.EmailNotificationListener;
import com.fabiocarlesso.observer.listeners.LogOpenListener;

public class ObserverMain {
    public static void observerMain() {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
