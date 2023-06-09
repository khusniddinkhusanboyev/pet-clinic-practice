package uz.brogrammer.petclinic.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import uz.brogrammer.petclinic.model.Speciality;
import uz.brogrammer.petclinic.model.Vet;
import uz.brogrammer.petclinic.service.SpecialityService;
import uz.brogrammer.petclinic.service.VetService;

import java.util.Set;

@Profile({"default", "map"})
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);

    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }
}
