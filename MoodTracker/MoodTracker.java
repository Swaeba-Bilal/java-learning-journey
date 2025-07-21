import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
class InvalidMoodException extends Exception{
    public InvalidMoodException(){
        super();
    }
}
public class MoodTracker {
    public static void main(String[] args) {
        ArrayList<Mood> moodList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("press \"a\" to add mood\n" +
                    "'d' to delete mood\n" +
                    "'e to edit mood\n" +
                    "'m' to get ll moods\n" +
                    "'w' to write mood on to a file\n" +
                    "Type 'Exit' to exit");
            String option = sc.nextLine().toLowerCase();
            switch (option){
                case "a":
                    addMood(sc,moodList);
                    break;
                case "d":
                    delete(sc,moodList);
                    break;
                case "e":
                    edit(sc,moodList);
                    break;
                case "m":
                    listAllMoods(moodList);
                    break;
                case "w":
                    writeOnFile(moodList);
                    break;
                case "exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice");
                    continue;

            }

        }
    }

    public static boolean isMoodValid(Mood mood, ArrayList<Mood> moodList) throws InvalidMoodException {
        for (Mood tempMood : moodList) {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }

    public static void addMood(Scanner sc, ArrayList<Mood> moodList) {
        System.out.println("Enter the name of the mood: ");
        String name = sc.nextLine();
        System.out.println("Are you tracking the mood for the current day?(y/n)");
        String isForCurrentDate = sc.nextLine();
        Mood moodToAdd = null;
        if (isForCurrentDate.trim().equalsIgnoreCase("n")) {
            try {
                System.out.println("Input the date in dd/MM/yyyy format");
                String dateStr = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate moodDate = LocalDate.parse(dateStr, formatter);
                System.out.println("Input the time in HH:mm format");
                String timeStr = sc.nextLine();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime moodTime = LocalTime.parse(timeStr, formatter1);
                System.out.println("Add notes about this mood:");
                String moodNotes = sc.nextLine();
                if (moodNotes.strip().equalsIgnoreCase("")) {
                    moodToAdd = new Mood(name, moodDate, moodTime);
                } else {
                    moodToAdd = new Mood(name, moodDate, moodTime, moodNotes);
                }
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format of date and time. Cannot create mood\n" + e);
            }

        } else {
            System.out.println("Add notes about this mood: ");
            String moodNotes = sc.nextLine();
            if (moodNotes.strip().equalsIgnoreCase("")) {
                moodToAdd = new Mood(name);
            } else {
                moodToAdd = new Mood(name, moodNotes);
            }

        }
        if(moodToAdd!=null){
        try {
            boolean isValid = isMoodValid(moodToAdd, moodList);
            if (isValid) {
                moodList.add(moodToAdd);
                System.out.println("The mood has been added to tracker");
            }

        } catch (InvalidMoodException e) {
            System.out.println("The mood is not valid.");
        }}
        else {
            System.out.println("Mood creation failed due to invalid input.");
        }
    }

    public static boolean deleteMoodsByDate(LocalDate moodDate, ArrayList<Mood> moodList) {
        boolean removed = false;
        Iterator<Mood> iterator = moodList.iterator();
        while (iterator.hasNext()) {
            Mood tempMood = iterator.next();
            if (tempMood.getDate().equals(moodDate)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    public static boolean deleteMood(Mood mood, ArrayList<Mood> moodList) {
        for (Mood tempMood : moodList) {
            if (tempMood.equals(mood)) {
                moodList.remove(tempMood);
                return true;
            }
        }
        return false;
    }

    public static void delete(Scanner sc, ArrayList<Mood> moodList) {
        System.out.println("Enter '1' to delete all moods by date");
        System.out.println("Enter '2' to delete a specific mood");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            try {
                System.out.println("Enter the date in dd/MM/yyyy format: ");
                String dateStr = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateStr, formatter);
                boolean getDeleted = deleteMoodsByDate(date, moodList);
                if (getDeleted) {
                    System.out.println("The moods tracked on " + date + " have been deleted ");
                } else {
                    System.out.println("No matching moods found");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format of date. Cannot delete mood");
            }
        } else if (choice.equals("2")) {
            try {
                System.out.println("Enter the name of the mood: ");
                String name = sc.nextLine();
                System.out.println("Enter the date in dd/MM/yyyy format: ");
                String dateStr = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateStr, formatter);
                System.out.println("Enter the time in HH:mm format");
                String timeStr = sc.nextLine();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime time = LocalTime.parse(timeStr, formatter1);
                Mood delMood = new Mood(name, date, time);
                boolean isMoodDeleted = deleteMood(delMood, moodList);
                if (isMoodDeleted) {
                    System.out.println("The mood has been deleted" + delMood.getName() + "-" + delMood.getDate());
                } else {
                    System.out.println("No matching moods found");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format of date. Cannot delete mood");
            }
        } else {
            System.out.println("Invalid choice.Try again");
        }
    }

    public static boolean editMood(Mood moodToEdit, ArrayList<Mood> moodList) {
        boolean isEdited = false;
        for (Mood tempMood : moodList) {
            if (tempMood.equals(moodToEdit)) {
                tempMood.setNotes(moodToEdit.getNotes());
                isEdited = true;
            }
        }
        return isEdited;
    }

    public static void edit(Scanner sc, ArrayList<Mood> moodList) {
        Mood moodToEdit = null;
        try {
            System.out.println("Enter the name of the mood: ");
            String name = sc.nextLine();
            System.out.println("Enter the date in dd/MM/yyyy format: ");
            String dateStr = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            System.out.println("Enter the time in HH:mm format");
            String timeStr = sc.nextLine();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(timeStr, formatter1);
            System.out.println("Enter the new notes about this mood:");
            String moodNotes = sc.nextLine();
            if (moodNotes.strip().equals("")) {
                System.out.println("No notes entered");
            } else {
                moodToEdit = new Mood(name, date, time, moodNotes);
                boolean isMoodEdited = editMood(moodToEdit, moodList);
                if (isMoodEdited) {
                    System.out.println("The mood has been successfully edited");
                } else {
                    System.out.println("No matching mood could be found.Cannot edited");
                }
            }
        } catch (DateTimeParseException dfe) {
            System.out.println("Incorrect format of date or time. Cannot edit mood.");
        }
    }
    public static void searchMoodsByDate(LocalDate moodDate, ArrayList<Mood> moodList) {
        boolean found = false;
        for (Mood tempMood : moodList) {
            if (tempMood.getDate().equals(moodDate)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if(!found) {
            System.out.println("No matching records could be found!");
        }
    }
    public static void searchMood(Mood mood, ArrayList<Mood> moodList) {
        boolean found = false;
        for (Mood tempMood : moodList) {
            if (tempMood.equals(mood)) {
                found = true;
                System.out.println(tempMood);

            }
        }
        if(!found) {
            System.out.println("No matching records could be found!");
        }
    }
    public static void search(Scanner sc, ArrayList<Mood> moodList) {
        System.out.println("Enter '1' to search all moods by date");
        System.out.println("Enter '2' to search a specific mood");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            try {
                System.out.println("Enter the date in dd/MM/yyyy format: ");
                String dateStr = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateStr, formatter);
                 searchMoodsByDate(date,moodList);

            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format of date. Cannot search mood");
            }
        } else if (choice.equals("2")) {
            try {
                System.out.println("Enter the name of the mood: ");
                String name = sc.nextLine();
                System.out.println("Enter the date in dd/MM/yyyy format: ");
                String dateStr = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateStr, formatter);
                System.out.println("Enter the time in HH:mm format");
                String timeStr = sc.nextLine();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime time = LocalTime.parse(timeStr, formatter1);
                Mood searchMood = new Mood(name, date, time);
                 searchMood(searchMood, moodList);
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect format of date. Cannot delete mood");
            }
        } else {
            System.out.println("Invalid choice.Try again");
        }
    }
    public static void listAllMoods(ArrayList<Mood> moodList){
        for(Mood tempMood:moodList){
            System.out.println(tempMood);
        }
    }
    public static void writeOnFile(ArrayList<Mood> moodsList){
        try (PrintWriter writer = new PrintWriter(new FileWriter("Moods.txt"))) {
            for (Mood mood : moodsList) {
                writer.println(mood+"\n\n");
            }
            System.out.println("The entries are written to a file");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
