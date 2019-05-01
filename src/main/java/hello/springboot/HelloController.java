package hello.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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
    
    long startTime = System.currentTimeMillis();
    
    if(sortingType.equals(SortingType.BUBBLE_SORT)){
 
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
       
       }else if (sortingType.equals(SortingType.DEFAULT_API_SORT)){
           
        List<String> list = Arrays.asList(strArr);

        System.out.println("Input array List " + list);

        List<Integer> intList = new ArrayList<>(strArr.length);

        //int[] arr = new int[strArr.length];

        for (int s = 0; s < strArr.length; s++) {
            //arr[s] = Integer.parseInt(strArr[s]);
            intList.add(Integer.parseInt(strArr[s]));
        }

        //Collections.sort(list);
        
        //System.out.println("Collections Sorted list " + list);
        
        Collections.sort(intList);
        
        System.out.println("Collections Sorted int list " + intList);
        
        //Arrays.sort(strArr);
        //System.out.println("Input String array sort " + Arrays.asList(strArr));

        //Arrays.sort(arr);
        //System.out.println("Input int array sort " + Arrays.asList(arr));
        
        long endTime = System.currentTimeMillis();
        
        return "Default Collections Sorted Array " + intList+" Elapsed time "+(endTime-startTime) +" millis for array size "+(strArr.length);
        
        }else if(sortingType.equals(SortingType.QUICK_SORT)){
            
            int[] arr = new int[strArr.length];

            for (int s = 0; s < strArr.length; s++) {
                arr[s] = Integer.parseInt(strArr[s]);
            }
            
            int pivot = arr[arr.length/2];
            
            System.out.println("Pivot element "+pivot);
            
            int[] lowArr = new int[arr.length];
            int[] highArr = new int[arr.length];

            int l=0;
            int h=0;

            for(int i=0;i<arr.length;i++){
                
                if(arr[i]>pivot){
                    highArr[h]=arr[i];
                    h++;
                }else if(arr[i]<pivot){
                    lowArr[l] = arr[i];
                    l++;
                }
                
            }
            
            System.out.println("low arr "+Arrays.toString(lowArr));
            System.out.println("high arr "+Arrays.toString(highArr));
            
            return "Quick Sort not fully ready less arr "+Arrays.toString(lowArr)+" Pivot "+pivot +" high arr "+Arrays.toString(highArr);
        }
        else{
            return "Invalid Sorting type";
        }
    }

    @RequestMapping("/hellosortbyrange")
    public String sortByRange(int range,SortingType sortingType) {
        
        Set<String> randomNumSet = new HashSet<String>();
        
        String[] arr = new String[range];
        
        for(int i=0;i<range;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(0, range+1);
            arr[i] = String.valueOf(randomNum);
            randomNumSet.add(String.valueOf(randomNum));
            
        }

        System.out.println("random input array "+Arrays.asList(arr));
        System.out.println("random numbers set input "+randomNumSet);
        
        //Arrays.asList(arr)
        return "Random input array "+randomNumSet +" "+ sortByType(randomNumSet.toArray(new String[randomNumSet.size()]), sortingType);
        
    }
        
    @RequestMapping("/helloguessvalue")
    public String guessValue(int value) {
        
        Set<String> randomNumSet = new HashSet<String>();
        
        //if(value>=1000 && value<10000) 
        
        String[] arr = new String[value];
        int attempt = 0;
        while(true){
            
           int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);//
            //arr[i] = String.valueOf(randomNum);
            randomNumSet.add(String.valueOf(randomNum));
            if(randomNum==value) {
                System.out.println("=== Guessed the value == "+randomNum +"== attempt : "+attempt);
                return "correct guesss on attempt "+attempt + " Values " +randomNumSet;
            }
            attempt++;
        }
        
        /*for(int i=0;i<40;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);//
            arr[i] = String.valueOf(randomNum);
            randomNumSet.add(String.valueOf(randomNum));
            if(randomNum==value) {
                System.out.println("=== Guessed the value == "+randomNum );
                return "correct guesss "+randomNumSet;
            }

        }*/

        //System.out.println("random input array "+Arrays.asList(arr));
        //System.out.println("random numbers set input "+randomNumSet);
        
        
        //return "guesss sample"+randomNumSet;
        //Arrays.asList(arr)
        //return "Random input array "+randomNumSet +" "+ sortByType(randomNumSet.toArray(new String[randomNumSet.size()]), "GuessValue");
        
    }
    
    @RequestMapping("/helloguesscode")
    public String guessCode(int secret,int maxTries) {
        
        Set<Integer> randomNumSet = new HashSet<Integer>();
        
        HashMap<Integer,Integer> guessScoreMap = new HashMap<Integer,Integer>();
        
        int initialGuess = 1122;
        
        randomNumSet.add(initialGuess);
        
        for(int i=0;i<1300;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);//
            randomNumSet.add(randomNum);
        }

        String[] arr = new String[secret];
        int attempt = 0;
        int guess = initialGuess;
        while(attempt <= maxTries){
           
           if(attempt>0 && randomNumSet.iterator().hasNext()) {
               guess = randomNumSet.iterator().next();
            }
           
            if(guess==secret) {
                System.out.println("=== Guessed the value == "+guess +"== attempt : "+attempt);
                return "correct guesss on attempt "+attempt + " Values " +randomNumSet;
                //break;
            }
           
           int score = getScore(guess,secret);
           
           if(score==40) {
                System.out.println("=== Guessed the value == "+guess +"== attempt : "+attempt);
                return "correct guesss on attempt "+attempt + " Values " +randomNumSet;
                
            }else if(score > 0) {
                guessScoreMap.put(guess, score);
            }else{
                System.out.println("Got No Score Attempting Again..");
                randomNumSet.remove(guess);
            }
            attempt++;
        }
        
        
        //System.out.println("random input array "+Arrays.asList(arr));
        //System.out.println("random numbers set input "+randomNumSet);
        
        
        //return "guesss sample"+randomNumSet;
        //Arrays.asList(arr)
        //return "Random input array "+randomNumSet +" "+ sortByType(randomNumSet.toArray(new String[randomNumSet.size()]), "GuessValue");
        return "testing..guessscoreMap"+guessScoreMap;
    }
    
    private int getScore(int guess,int secret){
        if(guess==secret) return 40;
        else if(guess==1122){
            return 1;
        }else if(guess<secret){
            return 2;            
        }else{
           return 0; 
        }
    }
    
}
