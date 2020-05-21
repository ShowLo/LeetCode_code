class Solution {
    public String arrangeWords(String text) {
        String[] strs = text.split(" ");
        strs[0] = (new StringBuilder()).append(Character.toLowerCase(strs[0].charAt(0))).append(strs[0].substring(1)).toString();
        StrAndIdx[] sai = new StrAndIdx[strs.length];
        for (int i = 0; i < strs.length; ++i) {
            sai[i] = new StrAndIdx(strs[i], i);
        }
        Arrays.sort(sai, new Comparator<StrAndIdx>() {
           @Override
            public int compare (StrAndIdx s1, StrAndIdx s2) {
                // 稳定排序，相同长度的保证原先位置靠前的排完序还是靠前
                if (s1.str.length() == s2.str.length()) {
                    return s1.idx - s2.idx;
                }
                return s1.str.length() - s2.str.length();
            }
        });
        sai[0].str = (new StringBuilder()).append(Character.toUpperCase(sai[0].str.charAt(0))).append(sai[0].str.substring(1)).toString();
        StringBuilder sb = new StringBuilder();
        for (StrAndIdx s : sai) {
            sb.append(s.str).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

class StrAndIdx {
    String str;
    int idx;
    public StrAndIdx(String s, int i) {
        str = s;
        idx = i;
    }
}
