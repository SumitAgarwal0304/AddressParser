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
    private ParserService parserService;

    /**
     * This method will take a single address
     * @param address
     * @return Json HouseNumber and Street
     */
    @GetMapping
    public Address getParsedString(@RequestParam String address) {
        return parserService.parseTheAddress(address);
    }


    /**
     * This method will take list of strings as address
     * @param address
     * @return list of Address object(HouseNumber and Street)
     */
    @GetMapping("/listOfAddress")
    public List<Address> getListOfParsedString(@RequestParam List<String> address){

        List<Address> sortedList = new ArrayList<>();
        address.forEach(list -> sortedList.add(parserService.parseTheAddress(list)));
        return sortedList;
    }

}
