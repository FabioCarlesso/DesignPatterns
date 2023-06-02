package com.fabiocarlesso.command.commands;

import com.fabiocarlesso.command.receiver.TextFile;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CopyTextFileOperation implements TextFileOperation {
    private TextFile textFile;
    @Override
    public String execute() {
        return textFile.copy();
    }
}
