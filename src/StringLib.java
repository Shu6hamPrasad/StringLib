/*
    Copyright © Shubham Prasad. All Rights Reserved.
    Licensed under the GNU GPL license.
    https://github.com/Shu6hamPrasad/
    IDE Used: IntelliJ IDEA Ultimate 2021.2
*/

public class StringLib {
    StringLib() {
    }

    public static String[] toStringArray(String s) {
        int c = countWords(s);
        int o = 0;
        String[] f = new String[c];
        int k = 0;

        for(int i = 0; i < s.length(); ++i) {
            if ((s.charAt(i) == ' ' || i + 1 == s.length()) && c > 0) {
                String l = subString(s, k, i + 1);
                f[o] = l.trim();
                k = i;
                ++o;
                --c;
            }
        }

        return f;
    }

    public static char charAt(int i, int f) {
        return charAt(String.valueOf(i), f);
    }

    public static char charAt(float i, int s) {
        return charAt(String.valueOf(i), s);
    }

    public static char charAt(double d, int i) {
        return charAt(String.valueOf(d), i);
    }

    public static char charAt(short s, int i) {
        return charAt(String.valueOf(s), i);
    }

    public static int countWords(String s) {
        int out = 0;
        String ch = trim(s);

        for(int i = 0; i < ch.length(); ++i) {
            if (charAt(ch, i) == ' ' || ch.length() == i + 1) {
                ++out;
            }
        }

        return out;
    }

    public static char[] getChars(int begin, int end, String tgt, char[] dst, int dstStart) {
        String f = subString(tgt, begin, end);

        for(int i = dstStart; i < dst.length; ++i) {
            dst[i] = charAt(f, i);
        }

        return dst;
    }

    public static char charAt(String x, int i) {
        char[] c = toCharArray(x);
        return c[i];
    }

    public static char[] toCharArray(String s, int x) {
        return toCharArray(subString(s, x));
    }

    public static char[] toCharArray(String s, int x, int y) {
        return toCharArray(subString(s, x, y));
    }

    public static char[] toCharArray(String s) {
        char[] f = new char[s.length()];
        if (!isEmpty(s)) {
            for(int i = 0; i < s.length(); ++i) {
                f[i] = s.charAt(i);
            }
        }

        return f;
    }

    public static String toUpperCase(String x) {
        char[] xArr = x.toCharArray();
        if (isEmpty(x)) {
            return x;
        } else {
            for(int i = 0; i < xArr.length; ++i) {
                if (xArr[i] >= 'a' && xArr[i] <= 'z') {
                    xArr[i] = (char)(xArr[i] - 32);
                }
            }

            return String.valueOf(xArr);
        }
    }

    public static String toLowerCase(String x) {
        char[] xArr = x.toCharArray();
        if (isEmpty(x)) {
            return x;
        } else {
            for(int i = 0; i < xArr.length; ++i) {
                if (xArr[i] >= 'A' && xArr[i] <= 'Z') {
                    xArr[i] = (char)(xArr[i] + 32);
                }
            }

            return String.valueOf(xArr);
        }
    }

    public static int indexOf(String s, char c) {
        int out = -1;

        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                out = i;
                break;
            }
        }

        return out;
    }

    public static int indexOf(String str, String substr) {
        if (!isEmpty(str)) {
            int sLen = str.length();
            int sStrLen = substr.length();
            int count = 0;
            int sStrLen2 = substr.length();
            if (sStrLen >= 1) {
                for(int i = 0; i < sLen - sStrLen + 1; ++i) {
                    String A = subString(str, i, sStrLen2);
                    if (equalsIgnoreCase(A, substr)) {
                        return count + 1;
                    }

                    ++count;
                    ++sStrLen2;
                }
            }
        }

        return -1;
    }

    public static int lastIndexOf(String s, char c) {
        int out = -1;
        if (isEmpty(s)) {
            return -1;
        } else {
            for(int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == c) {
                    out = i;
                }
            }

            return out;
        }
    }

    public static String concat(String x, String y) {
        return x + y;
    }

    public static boolean equalsIgnoreCase(String x, String y) {
        return equals(toLowerCase(x), toLowerCase(y));
    }

    public static boolean equals(String x, String y) {
        boolean out = false;
        if (x.length() < y.length()) {
            return false;
        } else if (y.length() < x.length()) {
            return false;
        } else {
            int check = 0;

            for(int i = 0; i < x.length(); ++i) {
                if (x.charAt(i) == y.charAt(i)) {
                    ++check;
                }
            }

            if (check == x.length()) {
                out = true;
            }

            return out;
        }
    }

    public static String subString(String s, int x) {
        return subString(s, x, s.length());
    }

    public static String subString(String s, int x, int y) {
        StringBuilder out = new StringBuilder();

        for(int i = x; i < y; ++i) {
            out.append(s.charAt(i));
        }

        return out.toString();
    }

    public static boolean startsWith(String x, String y) {
        boolean out = false;
        int l = y.length();
        if (subString(x, l) == y) {
            out = true;
        }

        return out;
    }

    public static boolean startsWith(String s, char c) {
        return s.charAt(0) == c;
    }

    public static boolean endsWith(String s, char c) {
        return s.charAt(s.length() - 1) == c;
    }

    public static boolean endsWith(String x, String y) {
        boolean out = false;
        int l = x.length() - y.length();
        if (equals(subString(x, l), y)) {
            out = true;
        }

        return out;
    }

    public static String reverse(String s) {
        StringBuilder out = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; --i) {
            out.append(s.charAt(i));
        }

        return out.toString();
    }

    public static boolean palindrome(String s) {
        boolean out = false;
        if (equals(s, reverse(s))) {
            out = true;
        }

        return out;
    }

    public static boolean palindromeIgnoreCase(String s) {
        return palindrome(toLowerCase(s));
    }

    public static String replace(String s, char x, char y) {
        char[] c = toCharArray(s);

        for(int i = 0; i < c.length; ++i) {
            if (c[i] == x) {
                c[i] = y;
            }
        }

        return String.valueOf(c);
    }

    public static char[] getChars(String s, int x, int y) {
        char[] out = new char[y - x];

        for(int i = x; i < y; ++i) {
            out[i] = s.charAt(i);
        }

        return out;
    }

    public static char[] getChars(String x, int y) {
        return getChars(x, y, x.length());
    }

    public static boolean isEmpty(String s) {
        return s.length() == 0;
    }

    public static String trim(String s) {
        int fs = 0;
        int ff = 0;

        int i;
        for(i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ') {
                fs = i;
                break;
            }
        }

        for(i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                ff = i + 1;
                break;
            }
        }

        return subString(s, fs, ff);
    }

    public static boolean isUpperCase(String s) {
        int count = 0;
        boolean out = false;
        if (isEmpty(s)) {
            return false;
        } else {
            for(int i = 0; i < s.length() && charAt(s, i) >= 'A' && charAt(s, i) <= 'Z'; ++i) {
                ++count;
            }

            if (count == s.length() - 1) {
                out = true;
            }

            return out;
        }
    }

    public static boolean isLowerCase(String s) {
        int count = 0;
        boolean out = false;
        if (isEmpty(s)) {
            return false;
        } else {
            for(int i = 0; i < s.length() && charAt(s, i) >= 'a' && charAt(s, i) <= 'z'; ++i) {
                ++count;
            }

            if (count == s.length() - 1) {
                out = true;
            }

            return out;
        }
    }
}
