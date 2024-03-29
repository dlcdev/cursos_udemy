package com.example.curso.boot.web.conversor;


import com.example.curso.boot.domain.Cargo;
import com.example.curso.boot.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToStringToCargoConverter implements Converter<String, Cargo> {

    @Autowired
    private CargoService service;

    @Override
    public Cargo convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);

        return service.buscarPorId(id);
    }
}
