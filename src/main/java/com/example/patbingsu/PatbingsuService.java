import com.example.patbingsu.Patbingsu;
import com.example.patbingsu.PatbingsuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatbingsuService {

  private final PatbingsuRepository repository;

  public PatbingsuService(PatbingsuRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public void deleteById(Long id) {
    repository.deleteById(id); // 삭제 트랜잭션
  }

  @Transactional
  public void updatePrice(Long id, int price) {
    Patbingsu patbingsu = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Patbingsu ID:" + id));
    patbingsu.setPrice(price);
    repository.save(patbingsu); // 수정 트랜잭션
  }
}
