package net.roma.librarydemo.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.ExchangeRate;
import net.roma.librarydemo.service.ExchangeRateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/exchangerate/")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping("")
    public List<ExchangeRate> getAllExchangeRates() {
        return this.exchangeRateService.getExchangeRate();
    }



}
