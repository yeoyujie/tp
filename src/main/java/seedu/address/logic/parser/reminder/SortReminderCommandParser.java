package seedu.address.logic.parser.reminder;

import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_CRITERIA;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.reminder.SortReminderCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new SortReminderCommand object
 */
public class SortReminderCommandParser implements Parser<SortReminderCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortReminderCommand
     * and returns an SortReminderCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortReminderCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_SORT_CRITERIA);
        ParserUtil.assertAllPrefixesPresent(argMultimap, SortReminderCommand.MESSAGE_USAGE, PREFIX_SORT_CRITERIA);
        ParserUtil.assertPrefixesPresentNotEmpty(argMultimap, SortReminderCommand.MESSAGE_USAGE, PREFIX_SORT_CRITERIA);

        String criteria = argMultimap.getValue(PREFIX_SORT_CRITERIA).get();
        if (!criteria.equals(SortReminderCommand.CRITERIA_PRIORITY)
                && !criteria.equals(SortReminderCommand.CRITERIA_DEADLINE)) {
            throw new ParseException(Messages.MESSAGE_INVALID_SORTING_CRITERIA);
        }

        return new SortReminderCommand(criteria);
    }
}
