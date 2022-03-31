package net.roma.librarydemo.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.ExchangeRate;
import net.roma.librarydemo.service.ExchangeRateService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateImpl implements ExchangeRateService {

    private final RestTemplate restTemplate;

    @Override
    public List<ExchangeRate> getExchangeRate() {
        ExchangeRate[] exchangeRates = restTemplate.getForObject("http://api.nbp.pl/api/cenyzlota/?format=json", ExchangeRate[].class);
        return Arrays.stream(exchangeRates).map(this::mapFromExchangeRateSite).collect(Collectors.toList());
    }

    private ExchangeRate mapFromExchangeRateSite(ExchangeRate exchangeRate) {
        return new ExchangeRate(exchangeRate.getData(), exchangeRate.getCena());
    }

}
