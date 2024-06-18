package com.tdd;

import com.tdd.commands.Command;

public abstract class Bulldozer {
    abstract void enterCommands(Command command);
    abstract void executeCommands();
}
