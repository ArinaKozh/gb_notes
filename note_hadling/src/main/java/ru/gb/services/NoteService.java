package ru.gb.services;

import lombok.AllArgsConstructor;
import ru.gb.model.Note;
import org.springframework.stereotype.Service;
import ru.gb.repository.NoteRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    /**
     * Сохранение заметки в репозиторий
     *
     * @param note заметка
     * @return note
     */public Note addNote(Note note){
        if(note.getCreationTime() == null) {
            note.setCreationTime(LocalDateTime.now());
        }
        return noteRepository.save(note);
    }

    /**
     * Получение всех заметок из репозитория
     *
     * @return список заметок
     */
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }


    /**
     * Получение заметки по id
     *
     * @param id id заметки
     * @return Optional<Note>
     */
    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

    /**
     * Редактирование заметки
     *
     * @param id id заметки
     * @param note отредактированная заметка
     * @return note
     */
    public Note editNote(Long id, Note note) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note oldNote = optionalNote.get();
            oldNote.setHeader(note.getHeader());
            oldNote.setBody(note.getBody());
            return noteRepository.save(oldNote);
        } else {
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }

    /**
     * Удаление заметки
     *
     * @param id id заметки
     * @return boolean
     */
    public boolean deleteNote(Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Поиск заметок по id пользователя
     *
     * @param id id пользователя
     * @return список заметок
     */
    public List<Note> findByUserId(Long id) {
        return noteRepository.findByUserId(id);
    }
}
