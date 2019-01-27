package com.example.game.controller;

import com.example.game.domain.pojo.Phase;
import com.example.game.service.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 * <p>Company:</p>
 *
 * @author luolin
 * @date 2019/1/27
 */
@RestController
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    @RequestMapping("/getWritePhase")
    public Phase getWritePhase(){
        Phase phase = phaseService.writeGetPahse();
        return phase;
    }

    @RequestMapping("/getReadPhase")
    public Phase getReadPhase(){
        Phase phase = phaseService.readGetPhase();
        return phase;
    }
}
