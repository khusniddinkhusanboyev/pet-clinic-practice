package uz.brogrammer.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import uz.brogrammer.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
