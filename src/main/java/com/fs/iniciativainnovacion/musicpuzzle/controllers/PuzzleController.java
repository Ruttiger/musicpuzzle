package com.fs.iniciativainnovacion.musicpuzzle.controllers;

import com.fs.iniciativainnovacion.musicpuzzle.beans.Puzzle;
import com.fs.iniciativainnovacion.musicpuzzle.defs.PuzzleSolutions;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class PuzzleController {

    @GetMapping("/puzzle")
    public String puzzle(Model model) {
        model.addAttribute("puzzle", new Puzzle());
        return "puzzle";
    }

    @GetMapping("/yetanotherpuzzle")
    public String yetanotherpuzzle(Model model) {
        model.addAttribute("puzzle", new Puzzle());
        return "yetanotherpuzzle";
    }

    @GetMapping("/isthislastpuzzle")
    public String isthislastpuzzle(Model model) {
        model.addAttribute("puzzle", new Puzzle());
        return "isthislastpuzzle";
    }

    @PostMapping("/puzzle")
    public RedirectView puzzleSubmit(@ModelAttribute Puzzle puzzle, Model model) {
        if(PuzzleSolutions.PUZZLE_1_WORD_1.equalsIgnoreCase(puzzle.getWord1())
                && PuzzleSolutions.PUZZLE_1_WORD_2.equalsIgnoreCase(puzzle.getWord2())){

            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            Collection<SimpleGrantedAuthority> oldAuthorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("PUZZLE2");
            List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
            updatedAuthorities.add(authority);
            updatedAuthorities.addAll(oldAuthorities);

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                            SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                            updatedAuthorities)
            );
            return new RedirectView("puzzle1success");
        } else{
            model.addAttribute("message","oops! Parece que esa no era la solución. Inténtalo de nuevo!");
            return new RedirectView("puzzle");
        }
    }

    @GetMapping("/puzzle1success")
    public String puzzle1success(Model model) {

        model.addAttribute("greetingtext", PuzzleSolutions.PUZZLE_1_GREETING);

        return "puzzle1success";
    }


    @PostMapping("/yetanotherpuzzle")
    public RedirectView yetanotherpuzzleSubmit(@ModelAttribute Puzzle puzzle, Model model) {
        if(PuzzleSolutions.PUZZLE_2_WORD_1.equalsIgnoreCase(puzzle.getWord1())){

            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            Collection<SimpleGrantedAuthority> oldAuthorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("PUZZLE3");
            List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
            updatedAuthorities.add(authority);
            updatedAuthorities.addAll(oldAuthorities);

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                            SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                            updatedAuthorities)
            );
            return new RedirectView("puzzle2success");
        } else{
            model.addAttribute("message","oops! Parece que esa no era la solución. Inténtalo de nuevo! Psst! En qué película actuaba el tipo este...?");
            return new RedirectView("yetanotherpuzzle");
        }
    }

    @GetMapping("/puzzle2success")
    public String puzzle2success(Model model) {

        model.addAttribute("greetingtext", PuzzleSolutions.PUZZLE_2_GREETING);

        return "puzzle2success";
    }

}
