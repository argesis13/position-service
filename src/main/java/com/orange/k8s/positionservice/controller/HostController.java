package com.orange.k8s.positionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(path = "/host")
public class HostController {

    @GetMapping()
    public @ResponseBody
    String getHost() throws UnknownHostException {
        return "Address: " + InetAddress.getLocalHost().getHostAddress() + " Host name: " + InetAddress.getLocalHost().getHostName();
    }

}
