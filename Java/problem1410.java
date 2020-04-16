class Solution {
    public String entityParser(String text) {
        char[] chars = text.toCharArray();
        char[] result = new char[chars.length];
        int idx = 0;
        int i = 0;
        while(i < chars.length) {
            boolean add = false;
            if (chars[i] == '&') {
                if (i + 6 < chars.length) {
                    if (chars[i + 1] == 'f' && chars[i + 2] == 'r' && chars[i + 3] == 'a' && chars[i + 4] == 's' && chars[i + 5] == 'l' && chars[i + 6] == ';') {
                        result[idx++] = '/';
                        add = true;
                        i += 7;
                        continue;
                    }
                }
                if (i + 5 < chars.length) {
                    if (chars[i + 1] == 'q' && chars[i + 2] == 'u' && chars[i + 3] == 'o' && chars[i + 4] == 't' && chars[i + 5] == ';') {
                        result[idx++] = '\"';
                        add = true;
                        i += 6;
                        continue;
                    }
                    else if (chars[i + 1] == 'a' && chars[i + 2] == 'p' && chars[i + 3] == 'o' && chars[i + 4] == 's' && chars[i + 5] == ';') {
                        result[idx++] = '\'';
                        add = true;
                        i += 6;
                        continue;
                    }
                }
                if (i + 4 < chars.length) {
                    if (chars[i + 1] == 'a' && chars[i + 2] == 'm' && chars[i + 3] == 'p' && chars[i + 4] == ';') {
                        result[idx++] = '&';
                        add = true;
                        i += 5;
                        continue;
                    }
                }
                if (i + 3 < chars.length) {
                    if (chars[i + 1] == 'g' && chars[i + 2] == 't' && chars[i + 3] == ';') {
                        result[idx++] = '>';
                        add = true;
                        i += 4;
                        continue;
                    }
                    else if (chars[i + 1] == 'l' && chars[i + 2] == 't' && chars[i + 3] == ';') {
                        result[idx++] = '<';
                        add = true;
                        i += 4;
                        continue;
                    }
                }
            }
            if (!add) {
                result[idx++] = chars[i++];
            }
        }
        return new String(result, 0, idx);
    }
}
