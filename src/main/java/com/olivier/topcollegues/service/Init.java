/**
 * 
 */
package com.olivier.topcollegues.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivier.topcollegues.entite.Collegue;
import com.olivier.topcollegues.repository.CollegueRepository;

@Service
public class Init {

		@Autowired private CollegueRepository collegueRepo;
		
		public void initCollegue(){
			if(collegueRepo.count() == 0){
				Stream.of(new Collegue("Jo-Jo", "https://orig00.deviantart.net/861e/f/2016/100/9/6/_87974594_32be803c_efcf_47ef_9a17_197106074016_by_unlimitedblankworks-d9yh993.jpg", 70000000),
						  new Collegue("Benito", "http://afflictor.com/wp-content/uploads/2014/04/mussolini123.jpg", 500000),
						  new Collegue("Mao", "https://www.herodote.net/Images/Mao.jpg", 100000000),
						  new Collegue("Pol-Pot", "http://i.telegraph.co.uk/multimedia/archive/01381/pol_pot_1381980f.jpg", 3000000),
						  new Collegue("Kim", "https://upload.wikimedia.org/wikipedia/commons/5/5c/Kim_Il_Sung_Portrait-2.jpg", 3000000))
				.forEach(collegueRepo::save);
			}
		}
}
