package ru.gb.controllers;

import lombok.AllArgsConstructor;
import ru.gb.model.MyUser;
import ru.gb.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.services.MyUserDetailsService;
import ru.gb.services.NoteService;


import java.security.Principal;
import java.util.List;

/**
 * Страница заметок после авторизации
 */
@RestController
@AllArgsConstructor
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping()
    public ModelAndView notes(Principal principal, Model model)
    {
        MyUser user = (MyUser) myUserDetailsService.loadUserByUsername(principal.getName()).getUser();
        List<Note> notes = noteService.findByUserId(user.getId());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);

        return new ModelAndView("notes");
    }

    @GetMapping("/delete")
    public ModelAndView deleteNote(Long id){
        noteService.deleteNote(id);
        return new ModelAndView("redirect:/notes");
    }
    @PostMapping("/addnote")
    public ModelAndView addNote(Principal principal, String title, String note)
    {
        MyUser user = (MyUser) myUserDetailsService.loadUserByUsername(principal.getName()).getUser();

        Note newNote = new Note();
        newNote.setHeader(title);
        newNote.setBody(note);
        newNote.setUser(user);

        noteService.addNote(newNote);

        return new ModelAndView("redirect:/notes");

    }



   /* @GetMapping("/{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable("id") Long id){
        return new ResponseEntity<>(noteService.getNoteById(id).orElseThrow(), HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Note> editNote(@PathVariable Long id, @RequestBody Note note){
        return new ResponseEntity<>(noteService.editNote(id, note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        if (noteService.deleteNote(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }*/
}
