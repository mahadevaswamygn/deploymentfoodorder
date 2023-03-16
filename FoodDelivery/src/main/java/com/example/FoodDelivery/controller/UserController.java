package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.User;
import com.example.FoodDelivery.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController

public class UserController {
    @Autowired
    UserService userService;



    @PostMapping(value = "/addUser")
    public ResponseEntity<String> adduser(@RequestBody String userData)
    {
        User user = setUserData(userData);
        JSONArray jary=findVlaid(user);
        if(!jary.isEmpty())
        {
            return new ResponseEntity<String>(jary.toString(),HttpStatus.BAD_REQUEST);
        }

       int id= userService.saveUser(user);
        return new ResponseEntity<String>("user saved with id"+id,HttpStatus.CREATED);
    }

    private JSONArray findVlaid(User user) {
        JSONArray jsonArray=new JSONArray();
        String email=user.getEmail();
        if(!isValidEmail(email))
        {

            jsonArray.put("email is not valid");
        }
        String phoneNumber= user.getPhoneNumber();
        if(!isPhoneNumberValid(phoneNumber))
        {

            jsonArray.put("Phone number not valid");
        }
        return jsonArray;
    }
    public boolean isPhoneNumberValid(String s)
    {

        Pattern p=Pattern.compile("(0|91)?[6-9][0-9]{9}");

        Matcher m=p.matcher(s);

        return(m.find()&&m.group().equals(s));

    }

    private User setUserData(String userData) {

        JSONObject jobj = new JSONObject(userData);
        User user= new User();
        user.setUserName(jobj.getString("userName"));
        user.setAdminSate(jobj.getInt("adminState"));
        user.setEmail(jobj.getString("email"));
        user.setPhoneNumber(jobj.getString("phoneNumber"));
        return user;

    }

    public boolean isValidEmail(String email)

    {

        String emailRegex="^[a-zA-Z0-9_+&*-]+(?:\\."+

                "[a-zA-Z0-9_+&*-]+)*@"+

                "(?:[a-zA-Z0-9-]+\\.)+[a-z"+

                "A-Z]{2,7}$";

        Pattern pat= Pattern.compile(emailRegex);

        if(email==null)

            return false;

        return pat.matcher(email).matches();

    }



    public ResponseEntity<String> getUserById(@RequestParam String userId)
    {
        JSONArray jary=userService.getByIdthree(userId);
        return new ResponseEntity<String >(jary.toString(), HttpStatus.OK);
    }



}
