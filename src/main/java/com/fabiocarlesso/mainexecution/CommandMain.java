package com.fabiocarlesso.mainexecution;

import com.fabiocarlesso.command.invoker.TextFileOperationExecutor;
import com.fabiocarlesso.command.receiver.TextFile;

public class CommandMain {
    public static void commandMain() {
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        TextFile textFile = new TextFile("file1.txt");
        System.out.println(textFileOperationExecutor.executeOperation(textFile::open));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::save));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::copy));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::paste));
    }
}
