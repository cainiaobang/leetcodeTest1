package cn.string.operation;

public class Simplify_Path {
    public String simplifyPath(String path){
        StringBuilder result=new StringBuilder();
        int p2=1,number_point=0;
        result.append(path.charAt(0));
        while(p2<path.length()){
            if(path.charAt(p2)=='/'){
                if(result.charAt(result.length()-1)!='/')  result.append(path.charAt(p2));
                number_point=0;
            }else if(path.charAt(p2)=='.'){
                   number_point++;
                   if(number_point==1){
                       if(path.charAt(p2-1)=='/'&&(p2==path.length()-1 || path.charAt(p2+1)=='/')){
                           p2++;number_point=0;
                       }
                       else{
                           result.append('.');
                       }
                   }else if(number_point==2){
                      if(path.charAt(p2-2)=='/'&&((p2+1<path.length()&&path.charAt(p2+1)=='/') ||  p2==path.length()-1)){
                          if(result.length()>2) {
                              result.delete(result.length() - 2, result.length());
                              result.delete(result.lastIndexOf("/") + 1, result.length());
                          } else {
                              result.deleteCharAt(result.length()-1);
                          }
                          number_point=0;
                      }else
                          result.append('.');
                  }else {
                      result.append('.');
                  }
            }else{
                result.append(path.charAt(p2));
                number_point=0;
            }
            p2++;
        }
        if(result.charAt(result.length()-1)=='/'&&result.length()>1) result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new Simplify_Path().simplifyPath("/home/foo/./.././bar"));
    }
    
}
