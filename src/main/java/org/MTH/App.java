package org.MTH;
public class App {
    public static void main(String[] args) {
        String[] names = {"Erik Svensson", "Anna Andersson", "John Hans", "Jane Hans", "Alice Smith"};

        // Test findByFirstName
        System.out.println("Names with first name 'Erik':");
        String[] eriks = NameRepository.findByFirstName("Erik", names);
        printNames(eriks);

        // Test findByLastName
        System.out.println("\nNames with last name 'Hans':");
        String[] does = NameRepository.findByLastName("Hans", names);
        printNames(does);

        // Test update
        System.out.println("\nUpdate name 'John Hans' to 'John Smith':");
        boolean updated = NameRepository.update("John Hans", "John Smith", names);
        if (updated) {
            System.out.println("Name updated successfully.");
        } else {
            System.out.println("Failed to update name.");
        }
        System.out.println("Updated names:");
        printNames(names);
    }

    public static void printNames(String[] names) {
        for (String name : names) {
            if (name != null) {
                System.out.println(name);
            }
        }
    }
}
