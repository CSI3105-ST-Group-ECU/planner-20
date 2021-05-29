package blackBoxTesting.common;

public class ConsoleOutput {
    private static final String VALID_SCHEDULED_MEETING_OUTPUT = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The rooms open at that time are:\n" +
            "JO18.330\n" +
            "JO7.221\n" +
            "JO15.236\n" +
            "JO1.230\n" +
            "JO34.536\n" +
            "JO19.230\n" +
            "ML5.123\n" +
            "ML18.330\n" +
            "ML21.520\n" +
            "ML13.213\n" +
            "ML21.310\n" +
            "ML13.218\n" +
            "\n" +
            "Enter the desired room ID, or cancel to cancel: \n" +
            "The people available to attend at that time are:\n" +
            "Justin Gardener\n" +
            "Ashley Matthews\n" +
            "Mary Jane Cook\n" +
            "Rose Austin\n" +
            "Mike Smith\n" +
            "Helen West\n" +
            "Steven Lewis\n" +
            "Edith Cowan\n" +
            "Mark Colin\n" +
            "Jacquie Martin\n" +
            "Jaci Johnston\n" +
            "Travis Colin\n" +
            "Ashley Martin\n" +
            "\n" +
            "Enter a person's name, or done if finished: \n" +
            "\n" +
            "Enter a person's name, or done if finished: \n" +
            "\n" +
            "Enter a description for the meeting: \n";

    private static final String VALID_BOOK_VACATIONS_OUTPUT = "\n" +
            "Enter the month that the vacation starts (1-12): \n" +
            "\n" +
            "Enter the day the vacation starts (1-31): \n" +
            "\n" +
            "Enter the month that the vacation ends (1-12): \n" +
            "\n" +
            "Enter the day the vacation ends (1-31): \n" +
            "Which person will be taking the vacation:\n" +
            "Justin Gardener\n" +
            "Ashley Matthews\n" +
            "Mary Jane Cook\n" +
            "Rose Austin\n" +
            "Mike Smith\n" +
            "Helen West\n" +
            "Steven Lewis\n" +
            "Edith Cowan\n" +
            "Mark Colin\n" +
            "Jacquie Martin\n" +
            "Jaci Johnston\n" +
            "Travis Colin\n" +
            "Ashley Martin\n" +
            "\n" +
            "Enter a person's name, or cancel to cancel the request: \n";
    //TODO: Check if these are needed by the others if not I will remove 🚀🚀🚀🚀
    private static final String VALID_CHECK_ROOM_OUTPUT =
            "\n" +
                    "Enter the month of the meeting (1-12): \n" +
                    "\n" +
                    "Enter the day of the meeting (1-31): \n" +
                    "\n" +
                    "Enter the starting hour of the meeting (0-23): \n" +
                    "\n" +
                    "Enter the ending hour of the meeting (0-23): \n" +
                    "The rooms available at the specified time are:\n" +
                    "JO18.330\n" +
                    "JO7.221\n" +
                    "JO15.236\n" +
                    "JO1.230\n" +
                    "JO34.536\n" +
                    "JO19.230\n" +
                    "ML5.123\n" +
                    "ML18.330\n" +
                    "ML21.520\n" +
                    "ML13.213\n" +
                    "ML21.310\n" +
                    "ML13.218\n";

    private static final String VALID_CHECK_PERSON_OUTPUT = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The people available to attend at that time are:\n" +
            "Justin Gardener\n" +
            "Ashley Matthews\n" +
            "Mary Jane Cook\n" +
            "Rose Austin\n" +
            "Mike Smith\n" +
            "Helen West\n" +
            "Steven Lewis\n" +
            "Edith Cowan\n" +
            "Mark Colin\n" +
            "Jacquie Martin\n" +
            "Jaci Johnston\n" +
            "Travis Colin\n" +
            "Ashley Martin" +
            "\n";

    private static final String VALID_CHECK_PERSON_OUTPUT_INVALID_MONTH = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The people available to attend at that time are:\n" +
            "Month does not exist.\n";

    private static final String VALID_CHECK_PERSON_OUTPUT_INVALID_DAY = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The people available to attend at that time are:\n" +
            "Day does not exist.\n";

    private static final String VALID_CHECK_PERSON_OUTPUT_INVALID_HOUR = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The people available to attend at that time are:\n" +
            "Illegal hour.\n";

    private static final String VALID_CHECK_PERSON_OUTPUT_ILLOGICAL_HOUR = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The people available to attend at that time are:\n" +
            "Meeting starts before it ends.\n";

    private static final String VALID_CHECK_AGENDA_FOR_ROOM_OUTPUT = "\n"
            + "Enter the month (1-12): \n"
            + "\n"
            + "Enter the day (1-31), or all to see the whole month: "
            + "\n"
            + "Which of the following rooms are you interested in?\n"
            + "JO18.330\n"
            + "JO7.221\n"
            + "JO15.236\n"
            + "JO1.230\n"
            + "JO34.536\n"
            + "JO19.230\n"
            + "ML5.123\n"
            + "ML18.330\n"
            + "ML21.520\n"
            + "ML13.213\n"
            + "ML21.310\n"
            + "ML13.218\n"
            + "\n"
            + "Enter a room ID as shown in the list, or cancel to cancel the request: \n"
            + "No Meetings booked on this date.\n"
            + "\n"
            + "\n";

    private static final String VALID_CHECK_AGENDA_FOR_ROOM_DOES_NOT_EXIST = "\n"
            + "Enter the month (1-12): \n"
            + "\n"
            + "Enter the day (1-31), or all to see the whole month: "
            + "\n"
            + "Which of the following rooms are you interested in?\n"
            + "JO18.330\n"
            + "JO7.221\n"
            + "JO15.236\n"
            + "JO1.230\n"
            + "JO34.536\n"
            + "JO19.230\n"
            + "ML5.123\n"
            + "ML18.330\n"
            + "ML21.520\n"
            + "ML13.213\n"
            + "ML21.310\n"
            + "ML13.218\n"
            + "\n"
            + "Enter a room ID as shown in the list, or cancel to cancel the request: \n"
            + "Requested room does not exist\n";

    private static final String VALID_CHECK_AGENDA_FOR_PERSON_OUTPUT = "\n"
            + "Enter the month (1-12): \n"
            + "\n"
            + "Enter the day (1-31), or all to see the whole month: \n"
            + "Which of the following people are you interested in?\n"
            + "Justin Gardener\n"
            + "Ashley Matthews\n"
            + "Mary Jane Cook\n"
            + "Rose Austin\n"
            + "Mike Smith\n"
            + "Helen West\n"
            + "Steven Lewis\n"
            + "Edith Cowan\n"
            + "Mark Colin\n"
            + "Jacquie Martin\n"
            + "Jaci Johnston\n"
            + "Travis Colin\n"
            + "Ashley Martin\n"
            + "\n"
            + "Enter a name from the list provided, or cancel to cancel the request: \n"
            + "No Meetings booked on this date.\n\n\n";

    private static final String INVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_MONTH = "\n"
            + "Enter the month (1-12): ";

    private static final String INVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_DAY = " \n" +
            "Enter the month (1-12): \n" +
            "Please enter a number from 0 - 6";

    private static final String INVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_PERSON = "\n" +
            "Enter the month (1-12): \n" +
            "\n"+
            "Enter the day (1-31), or all to see the whole month: \n" +
            "Which of the following people are you interested in?\n" +
            "Justin Gardener\n" +
            "Ashley Matthews\n" +
            "Mary Jane Cook\n" +
            "Rose Austin\n" +
            "Mike Smith\n" +
            "Helen West\n" +
            "Steven Lewis\n" +
            "Edith Cowan\n" +
            "Mark Colin\n" +
            "Jacquie Martin\n" +
            "Jaci Johnston\n" +
            "Travis Colin\n" +
            "Ashley Martin\n" +
            "\n" +
            "Enter a name from the list provided, or cancel to cancel the request: \n" +
            "Requested employee does not exist\n";



    public static String getINVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_MONTH() {
        return INVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_MONTH;
    }

    public static String getINVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_DAY() {
        return INVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_DAY;
    }

    public static String getINVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_PERSON() {
        return INVALID_CHECK_AGENDA_FOR_PERSON_OUTPUT_INVALID_PERSON;
    }

    public static String getValidScheduledMeetingOutput() {
        return VALID_SCHEDULED_MEETING_OUTPUT;
    }

    public static String getValidVacationsOutput() {
        return VALID_BOOK_VACATIONS_OUTPUT;
    }

    public static String getValidCheckRoomOutput() {
        return VALID_CHECK_ROOM_OUTPUT;
    }

    public static String getValidCheckPersonOutput() {
        return VALID_CHECK_PERSON_OUTPUT;
    }

    public static String getValidCheckPersonOutputInvalidMonth() {
        return VALID_CHECK_PERSON_OUTPUT_INVALID_MONTH;
    }

    public static String getValidCheckPersonOutputInvalidDay() {
        return VALID_CHECK_PERSON_OUTPUT_INVALID_DAY;
    }

    public static String getValidCheckPersonOutputInvalidHour() {
        return VALID_CHECK_PERSON_OUTPUT_INVALID_HOUR;
    }

    public static String getValidCheckPersonOutputIllogicalHour() {
        return VALID_CHECK_PERSON_OUTPUT_ILLOGICAL_HOUR;
    }

    public static String getValidCheckAgendaForRoomOutput() {
        return VALID_CHECK_AGENDA_FOR_ROOM_OUTPUT;
    }

    public static String getValidCheckAgendaForRoomRoomDoesNotExist() {
        return VALID_CHECK_AGENDA_FOR_ROOM_DOES_NOT_EXIST;
    }

    public static String getValidCheckAgendaForPersonOutput() {
        return VALID_CHECK_AGENDA_FOR_PERSON_OUTPUT;
    }
}

