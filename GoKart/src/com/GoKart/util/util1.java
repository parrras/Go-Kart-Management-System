package com.GoKart.util;

import java.util.regex.Pattern;

public class util1 {

    // Regular expression patterns
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");
    private static final Pattern AGE_PATTERN = Pattern.compile("^(1[89]|[2-9][0-9]|30)$"); // Age 18-30
    private static final Pattern GENDER_PATTERN = Pattern.compile("^(male|female)$", Pattern.CASE_INSENSITIVE); // Male or Female
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^9\\d{9}$"); // Starts with 9, 10 digits
    private static final Pattern KART_NO_PATTERN = Pattern.compile("^(1[0-9]{2}|19[0-9])$"); // 100-199

    /**
     * Validates if a string is null or empty.
     *
     * @param value the string to validate
     * @return true if the string is null or empty, otherwise false
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates if the name contains only alphabets and spaces.
     *
     * @param name the name to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidName(String name) {
        return !isNullOrEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Validates if the age is between 18 and 30 (inclusive).
     *
     * @param ageText the age to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidAge(String ageText) {
        return !isNullOrEmpty(ageText) && AGE_PATTERN.matcher(ageText).matches();
    }

    /**
     * Validates if the gender is "male" or "female".
     *
     * @param gender the gender to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidGender(String gender) {
        return !isNullOrEmpty(gender) && GENDER_PATTERN.matcher(gender).matches();
    }

    /**
     * Validates if the contact number starts with 9 and has 10 digits in total.
     *
     * @param contact the contact number to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidContact(String contact) {
        return !isNullOrEmpty(contact) && CONTACT_PATTERN.matcher(contact).matches();
    }

    /**
     * Validates if the kart number is between 100 and 199.
     *
     * @param kartNo the kart number to validate
     * @return true if valid, otherwise false
     */
    public static boolean isValidKartNo(String kartNo) {
        return !isNullOrEmpty(kartNo) && KART_NO_PATTERN.matcher(kartNo).matches();
    }

    /**
     * Generic field validation utility that checks for non-empty and specific criteria.
     *
     * @param value      the field value to validate
     * @param isCriteria the specific criteria to validate against
     * @return true if both non-empty and criteria validation pass, otherwise false
     */
    public static boolean validateField(String value, boolean isCriteria) {
        return !isNullOrEmpty(value) && isCriteria;
    }

    /**
     * Utility to parse and validate an age value.
     *
     * @param ageText the text representing age
     * @return true if valid, otherwise false
     */
    public static boolean validateAgeInput(String ageText) {
        return isValidAge(ageText);
    }
}
