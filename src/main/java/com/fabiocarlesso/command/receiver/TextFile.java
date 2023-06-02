package com.fabiocarlesso.command.receiver;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TextFile {

    private String name;

    public String open() {
        return "Opening file " + name;
    }

    public String save() {
        return "Saving file " + name;
    }

    public String copy() {
        return "Copying file " + name;
    }

    public String paste() {
        return "Pasting file " + name;
    }

}
