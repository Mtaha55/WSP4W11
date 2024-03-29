package org.MTH;

public class NameApplication {

    public static String[] findByFirstName(final String firstName, final String[] names) {
        int count = 0;
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                count++;
            }
        }
        String[] matches = new String[count];
        int index = 0;
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                matches[index++] = name;
            }
        }
        return matches;
    }

    public static String[] findByLastName(final String lastName, final String[] names) {
        int count = 0;
        for (String name : names) {
            if (name.endsWith(" " + lastName)) {
                count++;
            }
        }
        String[] matches = new String[count];
        int index = 0;
        for (String name : names) {
            if (name.endsWith(" " + lastName)) {
                matches[index++] = name;
            }
        }
        return matches;
    }

    public static boolean update(final String original, final String updatedName, String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                if (isNameAvailable(updatedName, names)) {
                    names[i] = updatedName;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean isNameAvailable(String updatedName, String[] names) {
        for (String name : names) {
            if (name != null && name.equals(updatedName)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] names = {"Erik Svensson", "Anna Andersson", "John Hans", "Jane Hans", "Alice Smith"};

        // Test findByFirstName
        System.out.println("Names with first name 'Erik':");
        String[] eriks = findByFirstName("Erik", names);
        printNames(eriks);

        // Test findByLastName
        System.out.println("\nNames with last name 'Hans':");
        String[] does = findByLastName("Hans", names);
        printNames(does);

        // Test update
        System.out.println("\nUpdate name 'John Hans' to 'John Smith':");
        boolean updated = update("John Hans", "John Smith", names);
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
