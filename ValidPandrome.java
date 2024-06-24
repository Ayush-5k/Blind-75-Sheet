class ValidPalindrome {
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        String b = s.toLowerCase();
        int i = 0;
        int j = b.length() - 1;
        while (i <= j) {
            if (!isAlphaNumeric(b.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphaNumeric(b.charAt(j))) {
                j--;
                continue;
            }

            if (b.charAt(i) != b.charAt(j)) {
                System.out.println(i + " " + j);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}