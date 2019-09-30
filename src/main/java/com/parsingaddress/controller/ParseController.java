package com.parsingaddress.controller;

import com.parsingaddress.dto.Address;
import com.parsingaddress.parser.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressParser")
public class ParseController {

    @Autowired
    ParserService parserService;

    @GetMapping
    public Address getParsedString(@RequestParam String address) {
        return parserService.parseTheAddress(address);
    }


    @GetMapping("/listOfAddress")
    public List<Address> getListOfParsedString(@RequestParam List<String> address){

        List<Address> sortedList = new ArrayList<>();
        address.forEach(list -> sortedList.add(parserService.parseTheAddress(list)));
        return sortedList;
    }

}
