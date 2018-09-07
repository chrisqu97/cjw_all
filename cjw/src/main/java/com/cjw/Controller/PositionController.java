package com.cjw.Controller;

import com.cjw.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Position")
public class PositionController {
    @Autowired
    private PositionService positionService;
}
