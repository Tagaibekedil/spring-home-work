package kg.megalab.springhomework.service.imp;

import kg.megalab.springhomework.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Qualifier("catsService")

public class CatServiceImpl implements StorageService {
    private final RestTemplate restTemplate;
    @Value("${cats.url}")
    private String catsUrl;

    @Override
    public List<String> get() {
        return null;
    }

    @Override
    public void add(String str) {

    }

    @Override
    public boolean delete(String str) {
        return false;
    }

    @Override
    public boolean isInList(String str) {
        return false;
    }

    @Override
    public String getCats() {
        ResponseEntity<String>response=
                restTemplate.exchange(catsUrl, HttpMethod.GET,null,String.class);
        return response.getBody();
    }
}
