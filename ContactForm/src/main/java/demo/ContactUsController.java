package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContactData;

@SpringBootApplication
@RestController
public class ContactUsController {

	private List<ContactData> dataArr = new ArrayList<ContactData>();

	@RequestMapping(value = "/contact-us", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactData> addContact(@RequestBody ContactData data) {
		try {
			if (!dataArr.contains(data)) {
				dataArr.add(data);
			}
		} catch (NullPointerException ex) {
			return new ResponseEntity<ContactData>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ContactData>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/contact-us", method = RequestMethod.GET)
	public ResponseEntity<List<ContactData>> listContacts() {
		return new ResponseEntity<List<ContactData>>(dataArr, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(ContactUsController.class, args);
	}

}