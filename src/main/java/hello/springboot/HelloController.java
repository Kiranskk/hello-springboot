package hello.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String helloworld() {
        return "Hello World Spring Boot!";
    }

    @RequestMapping("/hellosort")
    public String sort(String[] arr) {

        List<String> list = Arrays.asList(arr);

        System.out.println("Input array List " + list);

        Collections.sort(list);
        
        System.out.println("Collections Sorted list " + list);
        
        Arrays.sort(arr);

        System.out.println("Input array sort " + Arrays.asList(arr));
        
        return "Collections Sorted Array " + list;
    }
    
    @RequestMapping("/hellosortbytype")
    public String sortByType(String[] strArr,SortingType sortingType) {

    if(sortingType.equals(SortingType.BUBBLE_SORT)){
 
     long startTime = System.currentTimeMillis();
 
     int[] arr = new int[strArr.length];
 
     for(int s=0;s<strArr.length;s++){
        arr[s] = Integer.parseInt(strArr[s]);
     } 
 
      boolean swapped = true;
      int j=0;
      int tmp;
      
      while(swapped){
          
          swapped=false;
          j++;
          System.out.println("====== while loop times "+j+" scanning array till size "+(arr.length-j));
          for(int i=0; i<arr.length-j; i++){
              System.out.println("arr["+i+"] :"+arr[i]);
              System.out.println("arr["+(i+1)+"] :"+arr[i+1]); 
              if(arr[i] > arr[i+1]){
                  System.out.println("arr["+i+"] > "+"arr["+(i+1)+"] is true");
                  tmp=arr[i];
                  arr[i]=arr[i+1];
                  arr[i+1]=tmp;
                  swapped=true;
                  System.out.println("swapped "+swapped);
                  System.out.println("arr["+i+"] :"+arr[i]);
                  System.out.println("arr["+(i+1)+"] :"+arr[i+1]); 
              }
              System.out.println("====== comparing next element in array ====");
          }
          
      }
      
      List<String> sortedArr = new ArrayList<String>();
      
      for(int a=0;a<arr.length;a++){
        sortedArr.add(String.valueOf(arr[a]));  
      }
      
      long endTime = System.currentTimeMillis();
       
       return "Bubble Sort Result "+sortedArr+" Elapsed time "+(endTime-startTime) +" millis for array size "+(arr.length);
       
       }else{
           
        List<String> list = Arrays.asList(strArr);

        System.out.println("Input array List " + list);

        Collections.sort(list);
        
        System.out.println("Collections Sorted list " + list);
        
        Arrays.sort(strArr);

        System.out.println("Input array sort " + Arrays.asList(strArr));
        
        return "Default Collections Sorted Array " + list;
        
        }
    }
    
}
