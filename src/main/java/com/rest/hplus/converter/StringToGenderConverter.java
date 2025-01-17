package com.rest.hplus.converter;

import com.rest.hplus.beans.Gender;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenderConverter implements Converter<String, Gender> {


    @Override
    public Gender convert(String s) {
        if(s.equals("Male")) return Gender.MALE;
        else if (s.equals("Female")) return Gender.FEMALE;
        else  return Gender.OTHER;

    }
}


