package hello.springboot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.JsonPath;

@RestController
public class APIController {

	/**
	 * 
	 * @param jsonattribute - e.g author
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/find")
	public List<String> find(String jsonattribute) throws IOException {

		String content;
		content = new String(Files.readAllBytes(Paths.get("src/main/resources/sample.json")));

		List<String> authors = JsonPath.read(content, "$.store.book[*]." + jsonattribute);

		return authors;
	}

}
