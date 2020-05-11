package com.app.pharmacy.service;

import com.app.pharmacy.dto.IngredientDTO;
import com.app.pharmacy.mapper.IngredientMapper;
import com.app.pharmacy.model.Ingredient;
import com.app.pharmacy.repository.IngredientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepo;

    @Autowired
    IngredientMapper ingredientMapper;

    @Override
    public List<IngredientDTO> findAll() {
        return ingredientMapper.entityToDTOList(ingredientRepo.findAll());
    }

    @Override
    @Transactional
    public void save(IngredientDTO dto) {
        ingredientRepo.save(ingredientMapper.dtoToEntity(dto));
    }

    @Override
    public IngredientDTO findById(Integer id) {
        Optional<Ingredient> result = ingredientRepo.findById(id);
        return result.isPresent() ? ingredientMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        ingredientRepo.deleteById(id);
    }

}

