package seedu.flashlingo.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.flashlingo.commons.util.ToStringBuilder;
import seedu.flashlingo.model.Model;

/**
 * Indicates user wants to display the learning statistics
 */
public class StatsCommand extends Command {

    public static final String COMMAND_WORD = "stats";

    // For stats function
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Show user statistics\n"
            + "Example: " + COMMAND_WORD + " ";

    public static final String MESSAGE_SUCCESS = "Great work fellow learner! \nTotal number of flashcards: %d\n" +
            "Number of words remembered: %d";

    /**
     * Executes the functioning for this command
     * @param model {@code Model} which the command should operate on.
     * @return CommandResult after executing this command
     */
    @Override
    public CommandResult execute(Model model){
        requireNonNull(model);
        return new CommandResult(String.format(MESSAGE_SUCCESS, model.getNumberOfFlashCards(),
                model.getNumberOfRememberedWords()));
    }

    /**
     * Checks whether this is equal to the passed Object
     * @param other The passed object to check for equality against
     * @return True or False depending on whether this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StatsCommand)) {
            return false;
        }

        return true;
    }

}
