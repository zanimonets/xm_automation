package ui.constants;

public enum JSCommands {

    SCROLL_IN_TO_VIEW("arguments[0].scrollIntoView(true);"),
    REMOVE_ELEMENT_FROM_PAGE("arguments[0].remove();");


    private String commandString;

    JSCommands(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }
}
