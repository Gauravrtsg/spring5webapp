package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Starting BootStrap");

		Publisher publisher = new Publisher();
		publisher.setName("Gaurav");
		publisher.setCity("Delhi");
		publisher.setState("Delhi");
		publisher.setZip("110053");

		publisherRepository.save(publisher);
		System.out.println("Publisher count"+ publisherRepository.count());
		
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "12321");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author gaurav = new Author("gaurav", "kya kre");
		Book hmm = new Book("gaurav design", "13321");
		gaurav.getBooks().add(hmm);
		hmm.getAuthors().add(gaurav);
		
		hmm.setPublisher(publisher);
		publisher.getBooks().add(hmm);

		authorRepository.save(gaurav);
		bookRepository.save(hmm);
		publisherRepository.save(publisher);
		
		System.out.println("Started in Bootstrap");
		System.out.println("No.of Books" + bookRepository.count());
		System.out.println("publisher no.of books"+publisher.getBooks().size());
	}

}
