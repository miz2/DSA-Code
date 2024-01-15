public class StringBuilder_ {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }
        System.out.println(sb);
        System.out.println(sb.length());
    }
    // tc here is O(26) and if we used string it would have been O(n*n)
}
