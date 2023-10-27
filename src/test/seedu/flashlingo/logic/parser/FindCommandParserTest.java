package flashlingo.logic.parser;

import static flashlingo.logic.parser.CommandParserTestUtil.assertParseFailure;
import static flashlingo.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.flashlingo.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.flashlingo.logic.commands.Command;
import seedu.flashlingo.logic.commands.FindCommand;
import seedu.flashlingo.logic.parser.FindCommandParser;
import seedu.flashlingo.model.flashcard.WordContainsKeywordsPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure((Parser<? extends Command>) parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(new WordContainsKeywordsPredicate(Arrays.asList("Alice", "Bob")));
        assertParseSuccess((Parser<? extends Command>) parser, "Alice Bob", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess((Parser<? extends Command>) parser, " \n Alice \n \t Bob  \t", expectedFindCommand);
    }

}
