public class Main {
    public static void main(String[] args) {
        // Create an instance of CalendarToNewDateAdapter
        NewDateInterface adapter = new CalenderToNewDateAdapter();

        // Set the date
        adapter.setDay(23);
        adapter.setMonth(4);
        adapter.setYear(2024);

        // Print the current date
        System.out.println("Current Date: " + adapter.getDay() + "/" + adapter.getMonth() + "/" + adapter.getYear());

        // Advance the date by 5 days
        adapter.advanceDays(5);

        // Print the date after advancing
        System.out.println("Date after advancing 5 days: " + adapter.getDay() + "/" + adapter.getMonth() + "/" + adapter.getYear());
    }
}
