package arraywithstring;

public class StrStr {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        int n = haystack.length();
        for (int start = 0; start < n - l + 1; start++) {
            if (haystack.substring(start, start + l).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

}
