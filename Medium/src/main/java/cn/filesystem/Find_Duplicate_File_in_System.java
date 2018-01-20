package cn.filesystem;

import java.util.*;

public class Find_Duplicate_File_in_System {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map=new HashMap<String, List<String>>();
        List<List<String>> result=new LinkedList<List<String>>();
        for(int i=0;i<paths.length;i++){
            String[] values=paths[i].split(" ");
            String path=values[0];
            int j=1;
            while(j<values.length){
                String file=values[j++];
                String fileName=file.substring(0,file.indexOf('('));
                String fileConten=file.substring(file.indexOf('(')+1,file.length());
                //System.out.println(file+"      "+fileConten+"   "+fileName);
                List<String> list=map.get(fileConten);
             //   System.out.println(list+ "             "+fileConten);
                if(list==null) {
                    list=new LinkedList<String>();
                    map.put(fileConten,list);
                }
                list.add(path+"/"+fileName);
            }
        }
        Iterator<List<String>> iterator=  map.values().iterator();
        while(iterator.hasNext()){
            List<String> value=iterator.next();
            if(value.size()>1)  result.add(value);
        }
        return result;
    }

    public static void main(String[] args){
        String[] paths={"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(new Find_Duplicate_File_in_System().findDuplicate(paths));
        System.out.println(Arrays.toString("1.txt(abcd)".split("\\(")));
    }
}
