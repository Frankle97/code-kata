package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        int metCounts = getMetCriteriaCounts(s);
        switch (metCounts) {
            case 0:
            case 1:
                return PasswordStrength.WEAK;
            case 2:
                return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if (s.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(s)) metCounts++;
        if (meetsContainingUpperCase(s)) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingUpperCase(String s) {
        boolean containsUpp = false;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containsUpp = true;
                break;
            }
        }
        return containsUpp;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
