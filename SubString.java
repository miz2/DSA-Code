public class SubString {
    public static String subStr(String str,int si,int ei){
        String substr="";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
         String str="Hello World";
        //  our own method
         System.out.println(subStr(str, 0, 4));
        //  defined by java
         System.out.println(str.substring(0, 4));
    }
}
