/**
 * 
 */
package examples;

class AlienDictionary {

public static void main(String args[]){

String [] words = {"hello","leetcode"};
String order = "hlabcdefgijkmnopqrstuvwxyz";
boolean expected = true;
boolean result = isAlienSortedSol(words,order);

if(expected==result){
  System.out.println(" Test case Passed "+result);
}else{
  System.out.println(" Test case Failed! , Expected "+expected +" but as "+result);
 }


 String [] words1 = {"word","world","row"};
 String order1 = "worldabcefghijkmnpqstuvxyz";
 boolean expected1 = false;
 boolean result1 = isAlienSortedSol(words1,order1);

 if(expected1==result1){
   System.out.println(" Test case Passed "+result1);
 }else{
   System.out.println(" Test case Failed! , Expected "+expected1 +" but as "+result1);
  }

  String [] words2 = {"apple","app"};
  String order2 = "abcdefghijklmnopqrstuvwxyz";
  boolean expected2 = false;
  boolean result2 = isAlienSortedSol(words2,order2);

  if(expected2==result2){
    System.out.println(" Test case Passed "+result2);
  }else{
    System.out.println(" Test case Failed! , Expected "+expected2 +" but as "+result2);
   }

   String [] words3 = {"kuvp","q"};
   String order3 = "ngxlkthsjuoqcpavbfdermiywz";
   boolean expected3 = true;
   boolean result3 = isAlienSortedSol(words3,order3);

   if(expected3==result3){
     System.out.println(" Test case Passed "+result3);
   }else{
     System.out.println(" Test case Failed! , Expected "+expected3 +" but as "+result3);
    }


    String [] words4 = {"mtkwpj","wlaees"};
    String order4 = "evhadxsqukcogztlnfjpiymbwr";
    boolean expected4 = true;
    boolean result4 = isAlienSortedSol(words4,order4);

    if(expected4==result4){
      System.out.println(" Test case Passed "+result4);
    }else{
      System.out.println(" Test case Failed! , Expected "+expected4 +" but as "+result4);
     }
    
    
    String [] words5 = {"shr","jccni"};
    String order5 = "yhfztgrulbkapojcqvseixmdnw";
    boolean expected5 = false;
    boolean result5 = isAlienSortedSol(words5,order5);

    if(expected5==result5){
      System.out.println(" Test case Passed "+result5);
    }else{
      System.out.println(" Test case Failed! , Expected "+expected5 +" but as "+result5);
     }


}

public static boolean isAlienSorted(String[] words, String order) {

      if(order==null || order.length()==0) return false;
      if(words.length==0) return false;

      //int index = 25-order.indexOf('h');
      //System.out.println(" index h "+index+" z "+(25-order.indexOf('z'))+" m "+(25-order.indexOf('m')));

      for(int i=0;i<words.length-1;i++){
        int wt = 0;
        int nxtwt = 0;

        String word =  words[i];
        String nxtword =  words[i+1];
        int len = word.length();
        int nxtlen= nxtword.length();

        if(len>nxtlen) {
          //return false;

            if((25-order.indexOf(nxtword.charAt(0)))<(25-order.indexOf(word.charAt(0)))){
              if(word.indexOf(nxtword.charAt(0))==-1) return true;
            }else{
              return false;
            }
           

        }else{
          for(int j =0;j<len;j++){
               wt = wt + (25-order.indexOf(word.charAt(j)));
          }
          for(int k =0;k<len;k++){
               nxtwt = nxtwt + (25-order.indexOf(nxtword.charAt(k))) ;
          }

          if(nxtwt>wt){
        	  
        	  if( (25-order.indexOf(nxtword.charAt(0)))<(25-order.indexOf(word.charAt(0))) ) {
        		  return true;
        	  }else {
        		  
        		  return false;
        	  }
        	  
        }else {
        	return false;
        }

        }
      }

        return true;
    }

public static boolean isAlienSortedSol(String[] words, String order) {
    int[] index = new int[26];
    for (int i = 0; i < order.length(); ++i)
        index[order.charAt(i) - 'a'] = i;

    search: for (int i = 0; i < words.length - 1; ++i) {
        String word1 = words[i];
        String word2 = words[i+1];

        // Find the first difference word1[k] != word2[k].
        for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
            if (word1.charAt(k) != word2.charAt(k)) {
                // If they compare badly, it's not sorted.
                if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                    return false;
                continue search;
            }
        }

        // If we didn't find a first difference, the
        // words are like ("app", "apple").
        if (word1.length() > word2.length())
            return false;
    }

    return true;
}



}
