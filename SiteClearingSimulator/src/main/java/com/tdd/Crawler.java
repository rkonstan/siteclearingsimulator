package com.tdd;

import com.tdd.commands.Command;

import java.util.ArrayList;
import java.util.List;

// Invoker
public class Crawler extends Bulldozer {
    List<Command> commandList = new ArrayList<>();

    @Override
    void enterCommands(Command command) {
        commandList.add(command);
    }

    @Override
    void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
