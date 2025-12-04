package nl.workingtalent.project.laas.services;

import nl.workingtalent.project.laas.models.Copy;
import nl.workingtalent.project.laas.repositories.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    public List<Copy> getCopiesForBook(Integer id) {
        return copyRepository.findByBookId(id);
    }
}
