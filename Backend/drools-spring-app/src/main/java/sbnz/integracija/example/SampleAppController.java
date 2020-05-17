package sbnz.integracija.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import DTO.BookDTO;
import DTO.BookTagDTO;
import sbnz.integracija.example.facts.BookTag;
import sbnz.integracija.example.facts.BookTagStatus;
import sbnz.integracija.example.facts.ReviewRequest;
import sbnz.integracija.example.facts.SearchRequest;
import sbnz.integracija.example.facts.Tag;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.TagRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SampleAppController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final SampleAppService sampleService;

	@Autowired
	public SampleAppController(SampleAppService sampleService) {
		this.sampleService = sampleService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody  User u) {
		User user = sampleService.login(u);
		if(user != null) 
			return new ResponseEntity<>(user, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody  User u) {
		User user = sampleService.register(u);
		if(user != null) 
			return new ResponseEntity<>(user, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/allUsers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> user = sampleService.findAll();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody  User u) {
		User user = sampleService.saveUser(u);
		if(user != null) 
			return new ResponseEntity<>(user, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

//	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
//	public Item getQuestions(@RequestParam(required = true) String id, @RequestParam(required = true) String name,
//			@RequestParam(required = true) double cost, @RequestParam(required = true) double salePrice) {
//
//		Item newItem = new Item(Long.parseLong(id), name, cost, salePrice);
//
//		log.debug("Item request received for: " + newItem);
//
//		Item i2 = sampleService.getClassifiedItem(newItem);
//
//		return i2;
//	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<BookDTO>> bookSearch(@RequestBody  SearchRequest searchRequest) {
		//log.debug("Search request received for: " + searchRequest);
		ArrayList<BookDTO> retVal = sampleService.getFilteredBooks(searchRequest);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ResponseEntity bookReview(@RequestBody ReviewRequest reviewRequest) {
		System.out.println("reviewing...");
		this.sampleService.bookReview(reviewRequest);
		return new ResponseEntity(HttpStatus.OK);
	}
	

	@RequestMapping(value = "/manageTag", method = RequestMethod.POST)
	public ResponseEntity manageTag(@RequestBody BookTagDTO bookTagDTO) {
		if(bookTagDTO.isApproved()) {
			this.sampleService.approveTag(bookTagDTO.getId());

		} else {
			this.sampleService.deleteTag(bookTagDTO.getId());

		}
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/approveTag", method = RequestMethod.POST)
	public ResponseEntity<String> approveTag(@RequestBody String name) {
		
		sampleService.approveJustTag(name);
		return new ResponseEntity<>("", HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/deleteTag", method = RequestMethod.POST)
	public ResponseEntity<String> deleteTag(@RequestBody String name) {
		
		sampleService.deleteJustTag(name);
		return new ResponseEntity<>("", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getTags", method = RequestMethod.GET)
	public ResponseEntity<List<BookTag>> getTags() {
		List<BookTag> bookTag = sampleService.findAllTags();
		return new ResponseEntity<>(bookTag, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getRequestedTags", method = RequestMethod.GET)
	public ResponseEntity<List<BookTag>> getRequestedTags() {
		List<BookTag> bookTag = sampleService.findRequestedTags();
		return new ResponseEntity<>(bookTag, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getTagsPair", method = RequestMethod.GET)
	public ResponseEntity<List<Tag>> getTagss() {
		List<Tag> tag = sampleService.findTags();
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
	
}
