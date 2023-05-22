package kg.megalab.springhomework.controller;

import kg.megalab.springhomework.service.StorageService;
import kg.megalab.springhomework.service.imp.StorageServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class StorageController {

    @Autowired
    @Qualifier("catsService")
    private StorageService storageService;

    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String>getList(){return storageService.get();}
    @PostMapping(value = "/add")
    public void add(@RequestParam String str){storageService.add( str);}
    @DeleteMapping(value = "/delete/{str}")
    public boolean delete(@PathVariable String str){return storageService.delete(str);}
    @GetMapping(value = "/get/{str}")
    public boolean getStr(@PathVariable String str){return  storageService.isInList(str);}
    @GetMapping(value = "/cats",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> response(){
        try {
            return new ResponseEntity<>(storageService.getCats(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    }



