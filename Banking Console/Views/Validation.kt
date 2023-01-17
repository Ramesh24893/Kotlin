package Views

import java.util.regex.Pattern

class Validation {
    fun validateMobileNum(mobileNum: String): Boolean {
        val pattern = Pattern.compile("^[6-9][0-9]{9}")
        val matcher = pattern.matcher(mobileNum)
        return matcher.matches()
    }

    fun validateAccNumber(accNum: String): Boolean {
        val pattern = Pattern.compile("[0-9]{14}")
        val matcher = pattern.matcher(accNum)
        return matcher.matches()
    }

    fun validateName(name: String): Boolean {
        val pattern = Pattern.compile("[A-Za-z\\s]{3,21}")
        val matcher = pattern.matcher(name)
        return matcher.matches()
    }

    fun validateAadhaar(aadhaarNum: String): Boolean {
        val pattern = Pattern.compile("[0-9]{12}")
        val matcher = pattern.matcher(aadhaarNum)
        return matcher.matches()
    }

    fun validateGender(gender: String): Boolean {
        val pattern = Pattern.compile("^[MFO]$")
        val matcher = pattern.matcher(gender)
        return matcher.matches()
    }

    fun validatePan(pan: String): Boolean {
        val pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")
        val matcher = pattern.matcher(pan)
        return matcher.matches()
    }

    fun validatePassword(password: String): Boolean {
        val pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

    fun validateUserName(name: String): Boolean {
        val pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_@]{7,20}$")
        val matcher = pattern.matcher(name)
        return matcher.matches()
    }
}