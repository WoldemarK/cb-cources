package ru.cources.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cources.service.CbrService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyRestController {

    private final CbrService cbrService;

    @GetMapping("/rate/{code}")
    public BigDecimal currencyRate(@PathVariable("code") String code) {
        return cbrService.requestByCurrencyCode(code);
    }
}
