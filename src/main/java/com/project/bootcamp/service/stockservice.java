package com.project.bootcamp.service;

import com.project.bootcamp.exceptions.exceptions;
import com.project.bootcamp.exceptions.notfoundE;
import com.project.bootcamp.mapper.stockmapper;
import com.project.bootcamp.mode.dto.StockDTO;
import com.project.bootcamp.mode.stock;
import com.project.bootcamp.repository.stockrepository;
import com.project.bootcamp.util.messageutil;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.locale.provider.JRELocaleProviderAdapter;

import javax.transaction.Transactional;
import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class stockservice {

    @Autowired
    private stockmapper mapper;

    @Autowired
    private stockrepository repository;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<stock> optionalStock = repository.finByNameAndDate(dto.getName(), dto.getDate());
        if (optionalStock.isPresent()) {
            throw new exceptions(messageutil.Stock_Already_Exists);

        }
        stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<stock> optionalStock = repository.findSBytockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if (optionalStock.isPresent()) {
            throw new exceptions(messageutil.Stock_Already_Exists);
        }
        stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
         public List<StockDTO> findAll(){
        List<stock> list = repository.findAll();
        return mapper.toDTO(list);
    }

@Transactional
    public StockDTO findById(Long id) {
    return repository.findById(id).map(mapper::toDTO).orElseThrow(notfoundE::new);
    }
@Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(id);
        return dto;
    }

    public List<StockDTO> findByToday(){
        return repository.findByToday(LocalDate.now()).map(mapper::toDTO).orElseThrow(NoClassDefFoundError::new);
    }
}



