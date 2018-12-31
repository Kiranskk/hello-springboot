package hello.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
