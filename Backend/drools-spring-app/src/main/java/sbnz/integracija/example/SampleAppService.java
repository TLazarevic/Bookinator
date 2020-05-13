package sbnz.integracija.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.facts.Book;
import sbnz.integracija.example.facts.BookRating;
import sbnz.integracija.example.facts.BookTag;
import sbnz.integracija.example.facts.ReviewRequest;
import sbnz.integracija.example.facts.SearchRequest;
import sbnz.integracija.example.facts.Tag;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.repository.BookRatingRepository;
import sbnz.integracija.example.repository.BookRepository;
import sbnz.integracija.example.repository.BookTagRepository;
import sbnz.integracija.example.repository.TagRepository;
import sbnz.integracija.example.repository.userRepository;

@Service
public class SampleAppService {

	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);
	
	@Autowired
	private final BookRepository bookRepository;
	
	@Autowired
	BookTagRepository bookTagRepository;
	
	@Autowired
	BookRatingRepository ratingRepo;
	
	@Autowired
	userRepository userRepo;
	
	@Autowired 
	TagRepository tagRepo;

	private final KieContainer kieContainer;

	//Ovo sam zakucala zasad samo ovdje jer nisam nigdje na netu uspjela pronaci kako hesmapu insertovati u data.sql
	@PostConstruct
	public void insertBooksIntoDb() {
		
//		Book b = new Book();
//		b.setRating(0.0);
//		b.setAvaivableNo(1);
//		HashMap<String, String> tags = new HashMap<>();
//		tags.put("name", "Ubiti pticu rugalicu");
//		tags.put("author", "Harper Lee");
//		tags.put("description", "Američki dramski roman koji je 1960. napisala i objavila Harper Lee. Postigao je brzi uspeh i postao klasik američke književnosti. Radnja se labavo temelji na Leeinim opservacijama o svojoj porodici i komšijama, kao i na događaju koji se je odigrao u blizini njenog grada 1936., kada je imala 10 godina.\r\n" + 
//				"\r\n" + 
//				"Roman krasi toplina i humor, usprkos tome što se bavi ozbiljnim temama o silovanju i rasnoj diskriminaciji. ");
//		//b.setTags(tags);
//		bookRepository.save(b);
//		b = new Book();
//		b.setRating(0.0);
//		b.setAvaivableNo(1);
//		tags = new HashMap<>();
//		tags.put("name", "Za kim zvono zvoni");
//		tags.put("author", "Ernest Hemingvej");
//		tags.put("description", "Roman napisan 1939. na Kubi a objavljen 1940., jedno od piščevih najpopularnijih dela. To je istorijsko - ljubavni roman koji govori o doživljajima američkog profesora španskog jezika Roberta Jordana, koji učestvuje u Španskom građanskom ratu kao dobrovoljac protiv fašista Francisca Franca, a na strani komunista. Sam roman bazira se na Hemingwayevim iskustvima u Španiji tokom rata");
//		//b.setTags(tags);
//		bookRepository.save(b);
//		
//		Optional<Book> bo = bookRepository.findById(1L);
//		
//		System.out.println(bo.toString());
//		tags = new HashMap<>();
//		tags.put("name", "Proces");
//		tags.put("author", "Franz Kafka");
//		tags.put("description", "Proces je roman Franza Kafke, napisan između 1914. i 1915. godine i objavljen 1925. godine. Jedan od njegovih najpoznatijih radova, to je priča o čoveku koji je uhapšen i optužen od strane dalekog i nedostupnog organa vlasti, za zločin čija priroda ostaje do kraja nepoznata i njemu i čitaocu.");
//		bo.get().setTags(tags);
//		bookRepository.save(bo.get());

	}
	
	@Autowired
	public SampleAppService(KieContainer kieContainer, BookRepository bookRepository) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.bookRepository = bookRepository;
		
	}

//	public Item getClassifiedItem(Item i) {
//		KieSession kieSession = kieContainer.newKieSession();
//		kieSession.insert(i);
//		kieSession.fireAllRules();
//		kieSession.dispose();
//		return i;
//	}
	
	public ArrayList<Book> getFilteredBooks(SearchRequest searchRequest) {
		ArrayList<Book> books = (ArrayList<Book>) bookRepository.findAll();

		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(searchRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return books;
	}
	
	public void bookReview(ReviewRequest reviewRequest) {
		System.out.println(reviewRequest.toString());
		Book book = bookRepository.getOne(reviewRequest.getBookId());
		
		Iterator it = reviewRequest.getTags().entrySet().iterator();
	    while (it.hasNext()) {
	        HashMap.Entry pair = (HashMap.Entry)it.next();
	        //book.getTags().put(pair.getKey().toString(), pair.getValue().toString());
	        Tag tag = this.tagRepo.findByName(pair.getKey().toString());
	        if (tag==null) {
	        	tagRepo.save(new Tag(pair.getKey().toString()));
	        	 tag = this.tagRepo.findByName(pair.getKey().toString());
	        }
	        
	        this.bookTagRepository.save(new BookTag(reviewRequest.getBookId(), tag.getId(), pair.getValue().toString()));
	        it.remove(); // avoids a ConcurrentModificationException
	    }
		
		User user =  userRepo.findById(reviewRequest.getUserId()).get();
		BookRating rating=new BookRating(book,user,reviewRequest.getRate());
		this.ratingRepo.save(rating);
		
		List<BookRating> allRatings=ratingRepo.findByBookId(book.getId());
		float avg = 0;
		int count = allRatings.size();
		for (BookRating r:allRatings) {
			avg+=r.getRating();
		}
		float newRating = avg/count;
		book.setRating(newRating);
		
	    this.bookRepository.save(book);
	    System.out.println("Book updated!");
	}
}
