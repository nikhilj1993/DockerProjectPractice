package Practice;


import java.util.*;

public class PracticeTest {

//    @Test
    public void practice() throws InterruptedException {
       /*
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                "/src/main/java/Practice/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        */
        String word = "nikhil";
        HashMap<Character,Integer> hm  = new HashMap<>();

        for(int i=0;i<word.length();i++){
            if(hm.containsKey(word.charAt(i))){
                hm.put(word.charAt(i),hm.get(word.charAt(i))+1);
            }
            else {
                hm.put(word.charAt(i),1);
            }
        }

        System.out.println(hm);
        int largest=0;
        Character mostRecurring = null;
        Iterator<Map.Entry<Character,Integer>> it = hm.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Character,Integer> entry = it.next();
            int value = entry.getValue();
            char key = entry.getKey();
            if(value>largest){
                largest = value;
                mostRecurring=key;
            }
        }

        System.out.println("The most repeating character is  "+mostRecurring+"  which appears  "+
                hm.get(mostRecurring)+" times");
    }
}
