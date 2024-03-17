package org.MTH;

public class NameRepository {
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
}
