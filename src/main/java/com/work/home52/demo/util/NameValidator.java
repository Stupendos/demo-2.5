package com.work.home52.demo.util;

import org.apache.commons.lang3.StringUtils;

public class NameValidator {
    public static boolean validate(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }
}
